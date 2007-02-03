/*
 * FormTrxManager.java
 *
 * Created on 2007/01/28, 20:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import java.util.HashMap;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.containerFrame.FormManager;

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
