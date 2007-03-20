/*
 * RequestData.java
 *
 * Created on 2007/02/03, 11:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.io.Serializable;
import java.util.HashMap;


/**
 *
 * @author shimura
 */
public class RequestData implements Serializable {
    private String transactionCode;
    private HashMap params = new HashMap();
    private HashMap fields = new HashMap();
    private HashMap  <String, TableData> tables = new HashMap();
    private HashMap loginInfo = null;
    /** Creates a new instance of RequestData */
    public RequestData() {
    }

    public HashMap getFields() {
        return fields;
    }
    public Object getField(String fld) {
        return getFields().get(fld);
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

    public HashMap getParams() {
        return params;
    }
    public Object getParam(String fld) {
        return getParams().get(fld);
    }   
    
    public void setParam(String fld, Object val){
        getParams().put(fld, val);
    }    
    public void setParams(HashMap params) {
        this.params = params;
    }
    
}
