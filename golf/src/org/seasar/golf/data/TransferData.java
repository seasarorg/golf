/*
 * TransferData.java
 *
 * Created on 2007/01/03, 8:54
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
public class TransferData {
    
    /** Creates a new instance of TransferData */
    private Hashtable data = new Hashtable();
    private String transaction = null;
    private FormData formData = null;
    
    public TransferData() {
    }

    public Hashtable getData() {
        return data;
    }

    public void setData(Hashtable data) {
        this.data = data;
    }
    public void setElement (String key, Object element) {
        data.put(key, element);
    }
    
    public Object getElement(String key) {
        return data.get(key);
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public FormData getFormData() {
        return formData;
    }

    public void setFormData(FormData formData) {
        this.formData = formData;
    }
}
