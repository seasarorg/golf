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

package org.seasar.golf.transaction;

import java.util.HashMap;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class FormTrxManager {
    
    /** Creates a new instance of FormTrxManager */
    private HashMap fieldToHost = new HashMap();
    private HashMap hostToField = new HashMap();    
    private HashMap hostToTableModel = new HashMap();  
    private FormManager formManager = null;
    public FormTrxManager(FormManager formManager) {
        this.formManager = formManager;
    }
    public void initField(String field, String host) {
        fieldToHost.put(field, host);
        hostToField.put(host, field);        
    }
    public void initTable(String hostName, GolfTableModel gtm){
        if (hostName != null) {
            getHostToTableModel().put( hostName, gtm);
        }
    }
    public FormManager getFormManager() {
        return formManager;
    }

    public HashMap getFieldToHost() {
        return fieldToHost;
    }

    public HashMap getHostToField() {
        return hostToField;
    }

    public HashMap getHostToTableModel() {
        return hostToTableModel;
    }
    
}
