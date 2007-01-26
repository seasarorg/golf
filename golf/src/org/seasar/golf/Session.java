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
import org.seasar.golf.Factory;
import org.seasar.golf.containerFrame.FormManager;

/**
 *
 * @author shimura
 */
public class Session {
    private JFrame containerFrame = null;
    private ContainerManager containerManager = null;
    private Connection connection = null;
    private JFrame menu = null;
    
    /** Creates a new instance of Session */
    public Session(Connection con) {
        this.connection = con;
        containerFrame = (JFrame) SingletonS2ContainerFactory.getContainer().
                getComponent("containerForm");
        containerManager = new ContainerManager(containerFrame);
        containerFrame.pack();
        containerFrame.validate();
        containerFrame.setVisible(true);
        menu = (JFrame) SingletonS2ContainerFactory.getContainer().getComponent("menuForm");
        containerManager.setForm((GolfFormInterface)menu, connection.getLoginInfo() );
    }
    public void init(){
         ((GolfFormInterface)menu).getFormManager().setSession(this);
    }
    public void closeFrame() {
        containerFrame.setVisible(false);
        containerFrame.dispose();
        
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
}
