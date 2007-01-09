/*
 * UnsupportedBindingClassException.java
 *
 * Created on 2007/01/04, 13:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.binding;

/**
 *
 * @author shimura
 */
public class UnsupportedBindingClassException extends RuntimeException{
    
    /** Creates a new instance of UnsupportedBindingClassException */
    public UnsupportedBindingClassException() {
        super();
    }
        public UnsupportedBindingClassException(String message) {
        super(message);
    }
    
}
