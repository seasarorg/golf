/*
 * Session.java
 *
 * Created on 2007/01/17, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.containerFrame.ContainerManager;
import org.seasar.golf.uexample.frame.FormAction;

/**
 *
 * @author shimura
 */
public class Session {
    private JFrame containerFrame = null;
    private ContainerManager containerManager = null;
    private Connection connection = null;
    private JFrame menu = null;
    private ArrayList formManagers = new ArrayList();

    
    /** Creates a new instance of Session */
    public Session(Connection con) {
        this.connection = con;
        containerFrame = (JFrame) SingletonS2ContainerFactory.getContainer().
                getComponent("containerFrame");
        containerManager = new ContainerManager(containerFrame);
        containerFrame.pack();
        containerFrame.validate();
        containerFrame.setVisible(true);
//        menu=Factory.createFormFromAction("MENU");
//        //menu =Factory.createForm("menuFrame");
//        ((GolfFormInterface)menu).initBinding(connection.getLoginInfo());
//        containerManager.setForm((GolfFormInterface)menu);
    }
    public void init(){
        // ((GolfFormInterface)menu).getFormManager().setSession(this);
        FormAction menuaction = new FormAction();
        menuaction.setAction("MENU");
        menuaction.setFormStack(FormAction.FormStack.MENU);
        processAction(menuaction);
        
    }
    
    public void processAction(FormAction formAction) {
        SessionUtil.processAction(formAction, this);
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

    public JFrame getContainerFrame() {
        return containerFrame;
    }

    public ArrayList getFormManagers() {
        return formManagers;
    }

    public ContainerManager getContainerManager() {
        return containerManager;
    }
    
}
