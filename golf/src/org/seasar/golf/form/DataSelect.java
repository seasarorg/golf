/*
 * DataSelect.java
 *
 * Created on 2007/03/10, 18:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.form;

import java.io.Serializable;

/**
 *
 * @author shimura
 */
public class DataSelect implements Serializable{
    
    /** Creates a new instance of DataSelect */
    public DataSelect() {
    }
    public DataSelect(String form, String field) {
        this.requestForm = form;
        this.requestField = field;
    }    
    private String requestForm;
    private String requestField;
    private Object[] selectedData;
    private Object selectedDatum;
    

    public String getRequestForm() {
        return requestForm;
    }

    public void setRequestForm(String requestForm) {
        this.requestForm = requestForm;
    }

    public String getRequestField() {
        return requestField;
    }

    public void setRequestField(String requestField) {
        this.requestField = requestField;
    }

    public Object[] getSelectedData() {
        return selectedData;
    }

    public void setSelectedData(Object[] selectedData) {
        this.selectedData = selectedData;
    }

    public Object getSelectedDatum() {
        return selectedDatum;
    }

    public void setSelectedDatum(Object selectedDatum) {
        this.selectedDatum = selectedDatum;
    }
}
