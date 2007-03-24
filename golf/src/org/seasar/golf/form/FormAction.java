/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
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
