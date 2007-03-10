/*
 * DataRequest.java
 *
 * Created on 2007/03/10, 18:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.form;

/**
 *
 * @author shimura
 */
public class DataRequest {
    
    /** Creates a new instance of DataRequest */
    public DataRequest() {
    }
    public DataRequest(String form, String field) {
        this.requestForm = form;
        this.requestField = field;
    }    
    private String requestForm;
    private String requestField;

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
}
