/*
 * LoginInterface.java
 *
 * Created on 2007/01/17, 20:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.logic;

import java.util.HashMap;

/**
 *
 * @author shimura
 */
public interface LoginInterface {
    
    /** Creates a new instance of LoginInterface */
    public HashMap login(String userId, String password);
        
   
}
