/*
 * ResultData.java
 *
 * Created on 2007/02/04, 8:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import com.jgoodies.validation.ValidationResult;
import java.io.Serializable;
import java.util.HashMap;
import org.seasar.golf.form.FormAction;

/**
 *
 * @author shimura
 */
public class ResultData implements Serializable  {
    private HashMap params = new HashMap();
    private HashMap fields = new HashMap();
    private HashMap <String, TableData> tables = new HashMap(); 
    private FormAction formAction = new FormAction();
    private ValidationResult validationResult = new ValidationResult();
    /** Creates a new instance of ResultData */
    public ResultData() {
        params.put("_resultData", this);
    }

    public HashMap getFields() {
        return fields;
    }
    public Object getField(String fld) {
        return getFields().get(fld);
    }
    public HashMap getTables() {
        return tables;
    }

    public FormAction getFormAction() {
        return formAction;
    }

    public ValidationResult getValidationResult() {
        return validationResult;
    }
    
    public void setValidationResult(ValidationResult validationResult) {
        this.validationResult = validationResult;
    }

    public HashMap getParams() {
        return params;
    }
    public Object getParam(String fld) {
        return getParams().get(fld);
    }        
}
