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

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.DataUtil;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.data.TableData;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.form.FormAction.FormStack;
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
public class VdriTrxLogic implements TransactionInterface{
    private CompanyBhv bhv;
    private S2Container container;
    /** Creates a new instance of VdrTransaction */
    public VdriTrxLogic() {

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
        String sCcode = (String) requestData.getField("ccode");
        String mode = (String) requestData.getParam("_mode");
        String cat = (String) requestData.getParam("_cat");        
        if ((sCcode == null || sCcode.length()== 0) && !mode.equals("C")) {
        	resultData.getValidationResult().add(new SimpleValidationMessage(
            		"•K{€–Ú‚ª“ü—Í‚³‚ê‚Ä‚¢‚Ü‚¹‚ñ", Severity.ERROR, "ccode"));  
        	return;
        } else if (sCcode != null && sCcode.length() > 0 ){

        		BigDecimal ccode = null;
				try {
					ccode = new BigDecimal(sCcode);
				} catch (RuntimeException e) {
		        	resultData.getValidationResult().add(new SimpleValidationMessage(
			        		"ŠY“–Data‚ÍŒ©‚Â‚©‚è‚Ü‚¹‚ñ", Severity.ERROR, "ccode"));
		        	return;
				}

	        CompanyCB cb = new CompanyCB();
	        cb.query().setCat_Equal(cat);
	        cb.query().setCcode_Equal(ccode);
	        List <Company> compl = bhv.selectList(cb);
	        if (compl.size() == 0) {
	        	resultData.getValidationResult().add(new SimpleValidationMessage(
	        		"ŠY“–Data‚ÍŒ©‚Â‚©‚è‚Ü‚¹‚ñ", Severity.ERROR, "ccode"));
	        } else {      
	        	Company comp = compl.get(0);
    			resultData.getFormAction().setFormStack(FormStack.NEXT);
    			resultData.getFormAction().setForm("vdr");
    			resultData.setParam("_mode", mode);
    			resultData.setParam("_cat", cat);   
    			resultData.setParam("_action", "Result");   
    			if (!mode.equals("C")) {
    				resultData.setField("ccode",comp.getCcode().toString());
        			resultData.setField("version",comp.getVersionno().toString());	    				
    			}
    			resultData.setField("shortname",comp.getShortname());
    			resultData.setField("name",comp.getName());
    			resultData.setField("telephone",comp.getTelephone());
    			resultData.setField("cat",comp.getCat());
	        }
        } else {
			resultData.getFormAction().setFormStack(FormStack.NEXT);
			resultData.getFormAction().setForm("vdr");
			resultData.setParam("_mode", mode);
			resultData.setParam("_cat", cat);   
			resultData.setParam("_action", "Result"); 
			resultData.setField("cat",cat);
        }
    }

	public void setContainer(S2Container container) {
		this.container = container;
    	bhv = (CompanyBhv) container.getComponent("companyBhv");		
	}





}
