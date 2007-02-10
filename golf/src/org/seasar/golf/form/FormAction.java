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
import org.seasar.golf.menu.MenuAction;
import org.seasar.golf.menu.MenuActionItem;

/**
 *
 * @author shimura
 */
public class FormAction implements Serializable {
    public enum FormStack {
        MENU, FIRST, SAME, NEXT, BACK, DIALOG, NEWMENU, NEWFIRST, RESULT}  
    private FormStack formStack = null;
    private MenuActionItem actionItem = null;
    /** Creates a new instance of FormAction */
    public FormAction() {
    }
    
    public MenuActionItem getActionItem() {
        return actionItem;
    }

    public void setActionItem(MenuActionItem actionItem) {
        this.actionItem = actionItem;
    }
    public boolean setAction(String  menuAction) {
        actionItem = MenuAction.getMenuAction(menuAction);
        if (actionItem == null) {
            return false;
        } else {
            return true;
        }
    }
    public FormStack getFormStack() {
        return formStack;
    }

    public void setFormStack(FormStack formStack) {
        this.formStack = formStack;
    }
    
}
