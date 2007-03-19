/*
 * FormAction.java
 *
 * Created on 2007/01/27, 10:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.form;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author shimura
 */
public class FormAction implements Serializable {
    public enum FormStack {
        MENU, FIRST, SAME, NEXT, BACK, DIALOG, NEWMENU, 
            NEWFIRST, RESULT, SELECTED}  
    private FormStack formStack = FormStack.RESULT;
    private String form = null;
    private HashMap params = new HashMap();
    private boolean processAction = false;
    
    public void setProcessAction(boolean processAction) {
        this.processAction = processAction;
    }

    public boolean isProcessAction() {
        return processAction;
    }
/** Creates a new instance of FormAction */
    public FormAction() {
    }
    

    public FormStack getFormStack() {
        return formStack;
    }

    public void setFormStack(FormStack formStack) {
        this.formStack = formStack;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public HashMap getParams() {
        return params;
    }
    
    public void setParams(HashMap params) {
        this.params = params;
    }
    
}
