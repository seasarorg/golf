/*
 * Utest.java
 *
 * Created on 2007/01/27, 8:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.frame;

import javax.swing.JFrame;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

/**
 *
 * @author shimura
 */
public class Utest {
    
    /** Creates a new instance of Utest */
    public Utest() {
    }
    public static void main(String args[]) {
        SingletonS2ContainerFactory.init();
        JFrame loginFrame = (JFrame) SingletonS2ContainerFactory.getContainer().getComponent("loginFrame");
        loginFrame .setVisible(true);
    }
    
}
