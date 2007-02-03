/*
 * TrxRequest.java
 *
 * Created on 2007/02/03, 10:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import java.util.HashMap;
import org.seasar.golf.data.RequestData;

/**
 *
 * @author shimura
 */
public class TrxRequest {
    private String transactionCode;
    private HashMap param = new HashMap();
    private RequestData requestData = new RequestData();
    
    /** Creates a new instance of TrxRequest */
    public TrxRequest() {
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public HashMap getParam() {
        return param;
    }

    public void setParam(HashMap param) {
        this.param = param;
    }

    public RequestData getRequestData() {
        return requestData;
    }
    
}
