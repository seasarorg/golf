/*
 * LoginImpl.java
 *
 * Created on 2007/01/17, 20:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.logic.impl;

import org.seasar.golf.uexample.logic.*;
import java.util.HashMap;

/**
 *
 * @author shimura
 */
public class LoginLogicImpl implements LoginLogic {
    
    /**
     * Creates a new instance of LoginImpl
     */
    public LoginLogicImpl() {
    }

    public HashMap login(String userId, String password) {
//        if (userId .equals("m")) {
            HashMap h = new HashMap();
            h.put("name","Mike Shimura");
            h.put("section","JPZ/E");
            h.put("role","std");
            return h;
//        } else {
//            return null;
//        }
    }
    
}
