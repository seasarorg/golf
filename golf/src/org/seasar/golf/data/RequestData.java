/*
 * RequestData.java
 *
 * Created on 2007/02/03, 11:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.util.HashMap;
import java.util.HashMap;


/**
 *
 * @author shimura
 */
public class RequestData {
    private String transactionCode;
    private HashMap param = new HashMap();
    private HashMap fields = new HashMap();
    private HashMap tables = new HashMap();
    private HashMap loginInfo = null;
    /** Creates a new instance of RequestData */
    public RequestData() {
    }

    public HashMap getFields() {
        return fields;
    }

    public HashMap getTables() {
        return tables;
    }

    public HashMap getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(HashMap loginInfo) {
        this.loginInfo = loginInfo;
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
    
    public void setParam(HashMap params) {
        this.param = params;
    }
    
}
