/*
 * UexampleFactory.java
 *
 * Created on 2007/01/17, 21:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.util.factory;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.uexample.logic.LoginLogic;

/**
 *
 * @author shimura
 */
public class UexampleFactory {
    
    /** Creates a new instance of UexampleFactory */
    private UexampleFactory() {
    }
    public static LoginLogic getLogin() {
        return (LoginLogic) SingletonS2ContainerFactory.getContainer().getComponent(LoginLogic.class);
    }

    
}
