/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.seasar.golf.uexample.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.DataUtil;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.data.TableData;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.transaction.TransactionInterface;
import org.seasar.golf.uexample.dao.cbean.CompanyCB;
import org.seasar.golf.uexample.dao.exbhv.CompanyBhv;
import org.seasar.golf.uexample.dao.exdao.CompanyDao;
import org.seasar.golf.uexample.dao.exentity.Company;
import org.seasar.golf.validation.Severity;
import org.seasar.golf.validation.message.SimpleValidationMessage;

/**
 *
 * @author shimura
 */
public class VdrSelectTrxLogic implements TransactionInterface{
    private CompanyBhv bhv;
    private S2Container container;
    /** Creates a new instance of VdrTransaction */
    public VdrSelectTrxLogic() {

    }
    
    /* (non-Javadoc)
	 * @see org.seasar.golf.uexample.logic.impl.VdrTrxLogic#execute(org.seasar.golf.data.RequestData)
	 */
    public ResultData execute(RequestData requestData) {

        ResultData resultData = new ResultData();
        selectProcess(requestData, resultData);
        return resultData;
    }
    private void selectProcess(RequestData requestData, ResultData resultData) {
        resultData.getFormAction().setFormStack(FormAction.FormStack.RESULT);
        CompanyCB cb = new CompanyCB();
       	cb.query().setCat_Equal((String)requestData.getParam("_cat"));
        if (requestData.getField("shortname") != null) {
        	cb.query().setShortname_PrefixSearch((String) requestData.getField("shortname"));
        }     
       
        List <Company> compl = bhv.selectList(cb);
        if (compl.size() == 0) {
        	resultData.getValidationResult().add(new SimpleValidationMessage(
        		"該当Dataは見つかりません", Severity.WARNING, null));
        } else {
        	 if (requestData.getParams().containsKey("_action")) {
        		 DataUtil.copyParam(requestData.getParams(), resultData.getParams(), "_action");
        		 if (requestData.getParams().containsKey("_dataSelect")) {
            		 DataUtil.copyParam(requestData.getParams(), resultData.getParams(), "_dataSelect"); 
        		 }
        	 }
        	 resultData.getFormAction().setProcessAction(true);
        	 TableData td = new TableData();
        	 td.setColumnIdentifires(new Object[]{"ccode","shortname","name","telephone","cat","versionno" });
        	 for(Company comp:compl) {
        		 ArrayList row = new ArrayList();
        		 row.add(comp.getCcode());
        		 row.add(comp.getShortname());
        		 row.add(comp.getName());
        		 row.add(comp.getTelephone());
        		 row.add(comp.getCat());        		 
        		 row.add(comp.getVersionno().intValue());        			 
        		 td.addRow(row);
        	 }
        	 resultData.getTables().put("CompanyTable",td);
        }
    }

	public void setContainer(S2Container container) {
		this.container = container;
    	bhv = (CompanyBhv) container.getComponent("companyBhv");		
	}





}
