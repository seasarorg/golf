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

import org.seasar.framework.container.S2Container;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.form.FormAction.FormStack;
import org.seasar.golf.transaction.TransactionInterface;
import org.seasar.golf.uexample.dao.exbhv.CompanyBhv;
import org.seasar.golf.uexample.dao.exentity.Company;
import org.seasar.golf.validation.Severity;
import org.seasar.golf.validation.message.SimpleValidationMessage;

/**
 *
 * @author shimura
 */
public class VdrTrxLogic implements TransactionInterface{
    private CompanyBhv bhv;
    private S2Container container;
    /** Creates a new instance of VdrTransaction */
    public VdrTrxLogic() {
    }
    
    /* (non-Javadoc)
	 * @see org.seasar.golf.uexample.logic.impl.VdrTrxLogic#execute(org.seasar.golf.data.RequestData)
	 */
    public ResultData execute(RequestData requestData) {
        ResultData resultData = new ResultData();
        processMode(requestData, resultData);
        return resultData;
    }
    private void processMode(RequestData requestData, ResultData resultData){
    	String mode = (String) requestData.getParam("_mode");
    	String cat = (String) requestData.getParam("_cat");
    	String action = (String) requestData.getParam("_action");    	
    	if (action.equals("NextInq")){
    		nextInq(requestData, resultData, mode, cat);
    	}  else	if (action.equals("Save")){
    		save(requestData, resultData, mode, cat);
		}  else	if (action.equals("Delete")){
			delete(requestData, resultData, mode, cat);
		}    	
    }

	private void delete(RequestData requestData, ResultData resultData, String mode, String cat) {
		resultData.getFormAction().setFormStack(FormStack.RESULT);
		BigDecimal ccode = new BigDecimal((String)requestData.getField("ccode"));
		Company company = new Company();	
		company.setCcode(ccode);	
		company.setVersionno(new BigDecimal((String)requestData.getField("version")));				
		int no = bhv.getMyDao().delete(company);
		if (no == 1) {
			resultData.getFormAction().setFormStack(FormStack.BACK);			
			resultData.getValidationResult().add(
					new SimpleValidationMessage("Delete Completed", Severity.INFO,"ccode"));	
			resultData.getFormAction().setProcessAction(true);
			resultData.setParam("_action", "DeleteComple");
		}
	}

	private void save(RequestData requestData, ResultData resultData, String mode, String cat) {
		resultData.getFormAction().setFormStack(FormStack.RESULT);
		Company company = new Company();
		company.setCat((String) requestData.getField("cat"));
		company.setShortname((String) requestData.getField("shortname"));	
		company.setName((String) requestData.getField("name"));	
		BigDecimal ccode = null;
		if (requestData.getFields().containsKey("telephone")) {
			company.setTelephone((String) requestData.getField("telephone"));				
		}
		
		if (mode.equals("C")) {
			ccode = bhv.getMyDao().selectNextVal();
			company.setCcode(ccode);
			try {
				bhv.getMyDao().insert(company);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		} else if (mode.equals("U")) {
			ccode = new BigDecimal((String)requestData.getField("ccode"));
			company.setCcode(ccode);	
			company.setVersionno(new BigDecimal((String)requestData.getField("version")));			
			bhv.update(company);
		}
		getCompanyFromDb(ccode, resultData, mode, cat);
		resultData.getFormAction().setFormStack(FormStack.RESULT);
		if (!resultData.getValidationResult().hasMessages()){
			resultData.getValidationResult().add(
					new SimpleValidationMessage("Update Completed", Severity.INFO));
		}
		
	}

	private void nextInq(RequestData requestData, ResultData resultData, String mode, String cat) {
		BigDecimal ccode = (BigDecimal) requestData.getParam("ccode");
		getCompanyFromDb(ccode, resultData, mode, cat);
		if (!resultData.getValidationResult().hasMessages()) {
			resultData.getFormAction().setFormStack(FormStack.NEXT);		
		}
	}

	private void getCompanyFromDb(BigDecimal ccode, ResultData resultData, String mode, String cat) {
		Company comp = bhv.getMyDao().getEntity(ccode);
		if (comp == null){
		    resultData.getValidationResult().add(new SimpleValidationMessage(
			"CCode not found (" + ccode.toString()+")", Severity.ERROR));
		} else {
			resultData.getFormAction().setForm("vdr");
			resultData.setParam("_mode", mode);
			resultData.setParam("_cat", cat);   
			resultData.setParam("_action", "Result");     			
			resultData.setField("ccode",comp.getCcode().toString());
			resultData.setField("shortname",comp.getShortname());
			resultData.setField("name",comp.getName());
			resultData.setField("telephone",comp.getTelephone());
			resultData.setField("cat",comp.getCat());
			resultData.setField("version",comp.getVersionno().toString());
		}
	}

	public void setContainer(S2Container container) {
		this.container = container;
    	bhv = (CompanyBhv) container.getComponent("companyBhv");		
	}

}
