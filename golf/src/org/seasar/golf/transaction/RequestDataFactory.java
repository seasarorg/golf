/*
 * RequestDataFactory.java
 *
 * Created on 2007/02/03, 11:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import org.seasar.golf.SessionUtil;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class RequestDataFactory {
    
    /**
     * Creates a new instance of RequestDataFactory
     */
    private RequestDataFactory() {
    }
    public static RequestData createRequestData(FormManager formManager){
        return createRequestData(null, null, formManager); 
    } 

    public static RequestData createRequestData(
            String transactionCode, String params, FormManager formManager){
        RequestData requestData = new RequestData();
        TrxUtil.setFieldDataToRequest(requestData, formManager);
        requestData.setTransactionCode(transactionCode);
        if (params != null){
            requestData.setParam(SessionUtil.getActionParameter(params));
        }
        
        return requestData;
        
    }
    
}
