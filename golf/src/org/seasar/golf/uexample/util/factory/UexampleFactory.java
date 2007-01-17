/*
 * UexampleFactory.java
 *
 * Created on 2007/01/17, 21:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.util.factory;

import javax.swing.JFrame;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.uexample.frame.ContainerFrame;
import org.seasar.golf.uexample.logic.LoginInterface;

/**
 *
 * @author shimura
 */
public class UexampleFactory {
    
    /** Creates a new instance of UexampleFactory */
    private UexampleFactory() {
    }
    public static LoginInterface getLogin() {
        return (LoginInterface) SingletonS2ContainerFactory.getContainer().getComponent(LoginInterface.class);
    }

    
}
