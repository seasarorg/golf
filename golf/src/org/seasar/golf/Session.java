/*
 * Session.java
 *
 * Created on 2007/01/17, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.form.ContainerManager;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.transaction.TrxDispatcherInterface;

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
    private HashMap sessionData = new HashMap();
    private TrxDispatcherInterface trxDispatcher = null;
    
    /** Creates a new instance of Session */
    public Session(Connection con) {
        this.connection = con;
        containerFrame = (JFrame) SingletonS2ContainerFactory.getContainer().
                getComponent("containerFrame");
        containerManager = new ContainerManager(containerFrame);
        containerFrame.pack();
        containerFrame.validate();
        containerFrame.setVisible(true);
    }
    public void init(){
        ((GolfFormInterface)containerFrame).initBinding(null);
        ((GolfFormInterface)containerFrame).getFormManager().setSession(this);
        processMenuAction("MENU");
        
    }
     public void processActionTextField(KeyEvent evt, JTextField textField) {
         if (evt.getKeyCode() == KeyEvent.VK_ENTER ){
           String action = textField.getText();
             if (processMenuAction(action)) {
                textField.setText("");             
             }       
         }
     }
    public void processAction(FormAction formAction, HashMap params) {
        SessionUtil.processAction(formAction, this, params);
    }
    
    public boolean processMenuAction(String action) {
        boolean newWindow = false;
        action = action.trim().toUpperCase();
        if (action.charAt(0)=='@'){
            newWindow = true;
            action = action.substring(1);
        }
        FormAction menuaction = new FormAction();
        if (menuaction.setAction(action) == false) {
            return false;
        }
        if (action.equals("MENU")) {
            if (newWindow) {
                menuaction.setFormStack(FormAction.FormStack.NEWMENU);                 
            } else {
                menuaction.setFormStack(FormAction.FormStack.MENU); 
            }
        } else {
            if (newWindow) {
                menuaction.setFormStack(FormAction.FormStack.NEWFIRST);                
            } else {
                menuaction.setFormStack(FormAction.FormStack.FIRST);
            }
        }
        processAction(menuaction, null);   
        return true;
    }
    public ResultData trxExecute(RequestData requestData) {
        ResultData resultData = trxDispatcher.execute(requestData);
        if (resultData.getFormAction().getFormStack() != FormAction.FormStack.RESULT){
            SessionUtil.processAction(resultData.getFormAction(), this, resultData.getParam());
        }
        return resultData;
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

    public HashMap getSessionData() {
        return sessionData;
    }

    public TrxDispatcherInterface getTrxDispatcher() {
        return trxDispatcher;
    }

    public void setTrxDispatcher(TrxDispatcherInterface trxDispatcher) {
        this.trxDispatcher = trxDispatcher;
    }
    
}
