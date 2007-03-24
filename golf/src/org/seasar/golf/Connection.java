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
