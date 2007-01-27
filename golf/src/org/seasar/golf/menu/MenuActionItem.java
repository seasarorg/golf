/*
 * MenuActionItem.java
 *
 * Created on 2007/01/16, 22:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.menu;

/**
 *
 * @author shimura
 */
public class MenuActionItem {
    private String form;
    private String parameter;
    /** Creates a new instance of MenuActionItem */
    public MenuActionItem() {
    }
    public MenuActionItem(String form, String parameter) {
        this.form = form;
        this.parameter = parameter;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
    
}
