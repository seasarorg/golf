/*
 * Session.java
 *
 * Created on 2007/01/17, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import javax.swing.JFrame;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.containerFrame.ContainerFrameSample;
import org.seasar.golf.containerFrame.ContainerManager;

/**
 *
 * @author shimura
 */
public class Session {
    private JFrame containerFrame = null;
    private ContainerManager containerManager = null;
    
    /** Creates a new instance of Session */
    public Session() {
        containerFrame = (JFrame) SingletonS2ContainerFactory.getContainer().
                getComponent("containerForm");
        containerManager = new ContainerManager(containerFrame);
        containerFrame.pack();
        containerFrame.validate();
        containerFrame.setVisible(true);

        
    }
    
}
