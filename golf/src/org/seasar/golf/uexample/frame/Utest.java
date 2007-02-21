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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
//javax.swing.UIManager$LookAndFeelInfo[Metal javax.swing.plaf.metal.MetalLookAndFeel]
//javax.swing.UIManager$LookAndFeelInfo[CDE/Motif com.sun.java.swing.plaf.motif.MotifLookAndFeel]
//javax.swing.UIManager$LookAndFeelInfo[Windows com.sun.java.swing.plaf.windows.WindowsLookAndFeel]
//javax.swing.UIManager$LookAndFeelInfo[Windows Classic com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel]        
        try     {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            org.seasar.framework.container.factory.SingletonS2ContainerFactory.init();
            javax.swing.JFrame loginFrame = (javax.swing.JFrame) org.seasar.framework.container.factory.SingletonS2ContainerFactory.getContainer().getComponent("loginFrame");

            loginFrame.setVisible(true);
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                             ex.getMessage(), ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                             ex.getMessage(), ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                             ex.getMessage(), ex);
        }
        catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                             ex.getMessage(), ex);
        }
}
    
}
