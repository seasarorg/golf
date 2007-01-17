/*
 * Connection.java
 *
 * Created on 2007/01/17, 20:57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author shimura
 */
public class Connection {
    private Hashtable loginInfo = null;
    private ArrayList <Session> sessions = new ArrayList <Session>();
    
    /** Creates a new instance of Connection */
    public Connection() {

    }

    public Hashtable getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(Hashtable loginInfo) {
        this.loginInfo = loginInfo;
    }
    public void addSession() {
        Session s = new Session();
        sessions.add(s);        
    }
    
}
