/*
 * GolfFactory.java
 *
 * Created on 2007/01/17, 21:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.util;

import javax.swing.JFrame;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;


/**
 *
 * @author shimura
 */
public class GolfFactory {
    
    /** Creates a new instance of GolfFactory */
    private GolfFactory() {
    }
     public static JFrame getContainerFrame(){
        return (JFrame) SingletonS2ContainerFactory.getContainer().getComponent("containerFrame");
    }   
}
