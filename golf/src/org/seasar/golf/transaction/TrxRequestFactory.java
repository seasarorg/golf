/*
 * TrxRequestFactory.java
 *
 * Created on 2007/02/03, 11:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class TrxRequestFactory {
    
    /** Creates a new instance of TrxRequestFactory */
    private TrxRequestFactory() {
    }
    public static RequestData createTrxRequest(FormManager formManager){
        RequestData trxRequest = new RequestData();
        TrxUtil.setFieldDataToRequest(trxRequest, formManager);
        return trxRequest;
    } 


    
}
