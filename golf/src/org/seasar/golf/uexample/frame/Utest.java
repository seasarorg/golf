/*
 * Utest.java
 *
 * Created on 2007/01/27, 8:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.frame;

import org.seasar.golf.util.GolfSetting;


/**
 *
 * @author shimura
 */
public class Utest {
    
    /** Creates a new instance of Utest */
    public Utest() {
    }
    public static void main(String args[]) {
        GolfSetting.setLookAndFeel();
        org.seasar.framework.container.factory.SingletonS2ContainerFactory.init();
        javax.swing.JFrame loginFrame = (javax.swing.JFrame) org.seasar.framework.container.factory.SingletonS2ContainerFactory.getContainer().getComponent("loginFrame");
        loginFrame.setVisible(true);
    }
    
}
