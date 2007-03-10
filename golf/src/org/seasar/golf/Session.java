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
import org.seasar.golf.form.DataSelect;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.form.FormAction.FormStack;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.menu.MenuAction;
import org.seasar.golf.menu.MenuActionItem;
import org.seasar.golf.transaction.TrxDispatcherInterface;
import org.seasar.golf.transaction.TrxUtil;

/**
 *
 * @author shimura
 */
public class Session {
    private JFrame containerFrame = null;
    private ContainerManager containerManager = null;
    private Connection connection = null;
    private ArrayList <FormManager> formManagers = new  ArrayList<FormManager>();
    private HashMap sessionData = new HashMap();
    private TrxDispatcherInterface trxDispatcher = null;
    
    /** Creates a new instance of Session */
    public Session(Connection con) {
        this.connection = con;
        containerFrame = SessionUtil.createForm("container", this);
        containerManager = new ContainerManager(containerFrame);
        containerFrame.pack();
        containerFrame.validate();
        containerFrame.setVisible(true);
        trxDispatcher = (TrxDispatcherInterface) SingletonS2ContainerFactory.
                getContainer().getComponent(TrxDispatcherInterface.class);
    }
    public void init(){
        ((GolfFormInterface)containerFrame).initBinding(null);
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
    public void processDataSelect(DataSelect dataSelect) {
        FormAction formAction = new FormAction();
        formAction.setForm(dataSelect.getRequestForm());
        formAction.setFormStack(FormStack.SELECTED);
        formAction.getParams().put("_dataSelect", dataSelect);
        processAction(formAction, null);
    }
    public void processBackAction() {
        FormAction formAction = new FormAction();
        formAction.setFormStack(FormStack.BACK);
        processAction(formAction, null);        
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
        
        MenuActionItem actionItem = MenuAction.getMenuAction(action);
        if (actionItem ==null) {
            return false;
        }
        String form = actionItem.getForm();
        HashMap actionParam = SessionUtil.getActionParameter(actionItem.getParameter());
        FormAction formAction = new FormAction();
        formAction.setForm(form);
        formAction.setParams(actionParam);
        if (action.equals("MENU")) {
            if (newWindow) {
                formAction.setFormStack(FormAction.FormStack.NEWMENU);
            } else {
                formAction.setFormStack(FormAction.FormStack.MENU);
            }
        } else {
            if (newWindow) {
                formAction.setFormStack(FormAction.FormStack.NEWFIRST);
            } else {
                formAction.setFormStack(FormAction.FormStack.FIRST);
            }
        }
        processAction(formAction, null);
        return true;
    }
    public ResultData trxExecute(RequestData requestData, FormManager formManager) {
        ResultData resultData = trxDispatcher.execute(requestData);
        if (resultData.getFormAction().getFormStack() != FormAction.FormStack.RESULT){
            SessionUtil.processAction(resultData.getFormAction(), this, resultData.getParams());
        }
//        if (resultData.getValidationResult().hasMessages()) {
            resultData.setValidationResult(
                    TrxUtil.updateValidationResult( formManager, resultData.getValidationResult()));
            formManager.getFormValidationManager().setResult(resultData.getValidationResult());
//        }
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
