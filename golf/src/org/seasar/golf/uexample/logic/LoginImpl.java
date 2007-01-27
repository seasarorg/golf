/*
 * LoginImpl.java
 *
 * Created on 2007/01/17, 20:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.logic;

import java.util.Hashtable;

/**
 *
 * @author shimura
 */
public class LoginImpl implements LoginInterface {
    
    /**
     * Creates a new instance of LoginImpl
     */
    public LoginImpl() {
    }

    public Hashtable login(String userId, String password) {
//        if (userId .equals("m")) {
            Hashtable h = new Hashtable();
            h.put("name","Mike Shimura");
            h.put("section","JPZ/E");
            h.put("role","std");
            return h;
//        } else {
//            return null;
//        }
    }
    
}
