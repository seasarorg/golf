/*
 * TrxRequestFactory.java
 *
 * Created on 2007/02/03, 11:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class TrxRequestFactory {
    
    /** Creates a new instance of TrxRequestFactory */
    private TrxRequestFactory() {
    }
    public static TrxRequest createTrxRequest(FormManager formManager){
        TrxRequest trxRequest = new TrxRequest();
        TrxUtil.setFieldDataToRequest(trxRequest, formManager);
        return trxRequest;
    } 


    
}
