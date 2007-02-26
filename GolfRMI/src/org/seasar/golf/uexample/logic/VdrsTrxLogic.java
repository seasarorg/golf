/*
 * VdrTransaction.java
 *
 * Created on 2007/02/04, 10:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.logic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.data.TableData;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.transaction.TransactionInterface;
import org.seasar.golf.uexample.dao.cbean.CompanyCB;
import org.seasar.golf.uexample.dao.exdao.CompanyDao;
import org.seasar.golf.uexample.dao.exentity.Company;
import org.seasar.golf.validation.Severity;
import org.seasar.golf.validation.message.SimpleValidationMessage;

/**
 *
 * @author shimura
 */
public class VdrsTrxLogic implements TransactionInterface{
    private CompanyDao dao;
    /** Creates a new instance of VdrTransaction */
    public VdrsTrxLogic() {
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
       	cb.query().setCat_Equal((String)requestData.getField("cat"));
        if (requestData.getField("ccode") != null) {
        	String sCcode = (String) requestData.getField("ccode");
        	long lmax = Long.parseLong((sCcode+"99999").substring(0, 5));
        	long lmin = Long.parseLong((sCcode+"00000").substring(0, 5));
        	BigDecimal bmax = BigDecimal.valueOf(lmax);
        	BigDecimal bmin = BigDecimal.valueOf(lmin);
        	cb.query().setCcode_GreaterEqual(bmin);
        	cb.query().setCcode_LessEqual(bmax);
        }
        if (requestData.getField("shortname") != null) {
        	cb.query().setShortname_PrefixSearch((String) requestData.getField("shortname"));
        }     
        if (requestData.getField("name") != null) {
        	cb.query().setShortname_PrefixSearch((String) requestData.getField("name"));
        }         
        List <Company> compl = dao.selectList(cb);
        if (compl.size() == 0) {
        	resultData.getValidationResult().add(new SimpleValidationMessage(
        		"ŠY“–Data‚ÍŒ©‚Â‚©‚è‚Ü‚¹‚ñ", Severity.WARNING, null));
        } else {
        	 resultData.getFormAction().setFormStack(FormAction.FormStack.NEXT);
        	 resultData.getFormAction().setForm("vdrsd");
 //       	 resultData.getFormAction().setParams(new HashMap());
        	 resultData.getParams().put("cat", requestData.getField("cat"));
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

	public CompanyDao getDao() {
		return dao;
	}

	public void setDao(CompanyDao dao) {
		this.dao = dao;
	}

}
