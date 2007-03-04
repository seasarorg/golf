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

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.form.FormAction.FormStack;
import org.seasar.golf.transaction.TransactionInterface;
import org.seasar.golf.uexample.dao.exdao.CompanyDao;
import org.seasar.golf.uexample.dao.exentity.Company;
import org.seasar.golf.validation.Severity;
import org.seasar.golf.validation.message.SimpleValidationMessage;
import org.seasar.golf.validator.HostTableFieldInfo;

/**
 *
 * @author shimura
 */
public class VdrTrxLogic implements TransactionInterface{
    private CompanyDao companyDao;
    /** Creates a new instance of VdrTransaction */
    public VdrTrxLogic() {
    }
    
    /* (non-Javadoc)
	 * @see org.seasar.golf.uexample.logic.impl.VdrTrxLogic#execute(org.seasar.golf.data.RequestData)
	 */
    public ResultData execute(RequestData requestData) {
        ResultData resultData = new ResultData();
        processMode(requestData, resultData);
//        resultData.getFormAction().setFormStack(FormAction.FormStack.RESULT);
//        resultData.getValidationResult().add(new SimpleValidationMessage(
//        		"Text:ERROR DAYO", Severity.ERROR, "Text1"));
//        resultData.getValidationResult().add(new SimpleValidationMessage(
//        		"Table ERROR HOT DAYOoo", Severity.ERROR, new HostTableFieldInfo("TestTable",1,"qty")));        
        return resultData;
    }
    private void processMode(RequestData requestData, ResultData resultData){
    	String mode = (String) requestData.getParams().get("mode");
    	if (mode.equals("NextInq")){
    		BigDecimal ccode = (BigDecimal) requestData.getParams().get("ccode");
    		Company comp = companyDao.getEntity(ccode);
    		if (comp == null){
    	        resultData.getValidationResult().add(new SimpleValidationMessage(
        		"CCode not found (" + ccode.toString()+")", Severity.ERROR));
    		} else {
    			resultData.getFormAction().setFormStack(FormStack.NEXT);
    			resultData.getFormAction().setForm("vdr");
    			resultData.getParams().put("mode", "ref");
    			resultData.getFields().put("ccode",comp.getCcode().toString());
    			resultData.getFields().put("shortname",comp.getShortname());
    			resultData.getFields().put("name",comp.getName());
    			resultData.getFields().put("telephone",comp.getTelephone());
    			resultData.getFields().put("cat",comp.getCat());
    			resultData.getFields().put("version",comp.getVersionno().toString());
    		}
    	}
    }

	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

}
