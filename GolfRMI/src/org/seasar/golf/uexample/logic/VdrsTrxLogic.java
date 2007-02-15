/*
 * VdrTransaction.java
 *
 * Created on 2007/02/04, 10:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.logic;

import java.util.ArrayList;
import java.util.List;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.data.TableData;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.transaction.TransactionInterface;
import org.seasar.golf.uexample.dao.cbean.VendorCB;
import org.seasar.golf.uexample.dao.exdao.VendorDao;
import org.seasar.golf.uexample.dao.exentity.Vendor;
import org.seasar.golf.validator.HostTableFieldInfo;

import com.jgoodies.validation.Severity;
import com.jgoodies.validation.message.SimpleValidationMessage;

/**
 *
 * @author shimura
 */
public class VdrsTrxLogic implements TransactionInterface{
    private VendorDao dao;
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
        VendorCB cb = new VendorCB();
        cb.query().setShortname_PrefixSearch((String) requestData.getFields().get("shortname"));
        List <Vendor> vdrl = dao.selectList(cb);
        if (vdrl.size() == 0) {
        	resultData.getValidationResult().add(new SimpleValidationMessage(
        		"ŠY“–Data‚ÍŒ©‚Â‚©‚è‚Ü‚¹‚ñ", Severity.WARNING, null));
        } else {
        	 resultData.getFormAction().setFormStack(FormAction.FormStack.FIRST);
        	 resultData.getFormAction().setForm("vdrsd");
        	 TableData td = new TableData();
        	 td.setColumnIdentifires(new Object[]{"id","vcode","shortname","name","telephone","versionno" });
        	 for(Vendor vdr:vdrl) {
        		 ArrayList row = new ArrayList();
        		 row.add(vdr.getId().intValue());
        		 row.add(vdr.getVcode());
        		 row.add(vdr.getShortname());
        		 row.add(vdr.getName());
        		 row.add(vdr.getTelephone());
        		 row.add(vdr.getVersionno().intValue());        			 
        		 td.addRow(row);
        	 }
        	 resultData.getTables().put("VendorTable",td);
        	 resultData.getParam().put("resultData", resultData);
        }
    }

	public VendorDao getDao() {
		return dao;
	}

	public void setDao(VendorDao dao) {
		this.dao = dao;
	}

}
