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
import java.util.HashMap;

/**
 *
 * @author shimura
 */
public class Connection {
    private HashMap loginInfo = null;
    private ArrayList <Session> sessions = new ArrayList <Session>();
    private int maxSession = 6;
    
    /** Creates a new instance of Connection */
    public Connection() {

    }

    public HashMap getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(HashMap loginInfo) {
        this.loginInfo = loginInfo;
    }
    public Session  addSession() {
        if (sessions.size() < maxSession) {
            Session s = Factory.createSession(this);
            sessions.add(s);
            return s;
        } else {
            return null;
        }
    }
    
    public void removeSession(Session s) {
        for (int i =0; i < sessions.size(); i ++) {
            if (sessions.get(i) == s) {
                s.closeFrame();
                sessions.remove( i ) ;
                if (sessions.size() == 0) {
                    Runtime.getRuntime().exit(0);
                }
                return ;
            }
        }
    }

    public int getMaxSession() {
        return maxSession;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }
    
}
