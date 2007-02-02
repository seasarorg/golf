/*
 * FormTrxManager.java
 *
 * Created on 2007/01/28, 20:43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import java.util.Hashtable;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.containerFrame.FormManager;

/**
 *
 * @author shimura
 */
public class FormTrxManager {
    
    /** Creates a new instance of FormTrxManager */
    private Hashtable fieldToHost = new Hashtable();
    private Hashtable hostToField = new Hashtable();    
    private Hashtable hostToTableModel = new Hashtable();  
    private FormManager formManager = null;
    public FormTrxManager(FormManager formManager) {
        this.formManager = formManager;
    }
    public void initField(String field, String host) {
        fieldToHost.put(field, host);
        fieldToHost.put(host, field);        
    }
    public void initTable(String hostName, GolfTableModel gtm){
        if (hostName != null) {
            hostToTableModel.put( hostName, gtm);
        }
    }
    public FormManager getFormManager() {
        return formManager;
    }
    
}
