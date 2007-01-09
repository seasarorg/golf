/*
 * FormData.java
 *
 * Created on 2007/01/03, 9:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.util.Hashtable;

/**
 *
 * @author shimura
 */
public class FormData {
    
    /** Creates a new instance of FormData */
    public FormData() {
    }
    enum Type {Window, Dialog} 
    enum Mode {Same, FirstTrans, BackTrans, NextTrans, BackWindow, NextWindow, Menu}
    private String form;
    private Type formType;
    private Mode formMode;
    private Hashtable params;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Type getFormType() {
        return formType;
    }

    public void setFormType(Type formType) {
        this.formType = formType;
    }

    public Mode getFormMode() {
        return formMode;
    }

    public void setFormMode(Mode formMode) {
        this.formMode = formMode;
    }

    public Hashtable getParams() {
        return params;
    }

    public void setParams(Hashtable params) {
        this.params = params;
    }
}
