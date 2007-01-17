/*
 * LoginInterface.java
 *
 * Created on 2007/01/17, 20:58
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
public interface LoginInterface {
    
    /** Creates a new instance of LoginInterface */
    public Hashtable login(String userId, String password);
        
   
}
