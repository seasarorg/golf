/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
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
