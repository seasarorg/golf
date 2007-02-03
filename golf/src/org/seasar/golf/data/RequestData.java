/*
 * RequestData.java
 *
 * Created on 2007/02/03, 11:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.util.Hashtable;

/**
 *
 * @author shimura
 */
public class RequestData {
    private Hashtable fields = new Hashtable();
    private Hashtable tables = new Hashtable();
    private Hashtable  loginInfo = null;
    /** Creates a new instance of RequestData */
    public RequestData() {
    }

    public Hashtable getFields() {
        return fields;
    }

    public Hashtable getTables() {
        return tables;
    }

    public Hashtable getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(Hashtable loginInfo) {
        this.loginInfo = loginInfo;
    }
    
}
