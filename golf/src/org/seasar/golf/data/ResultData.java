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

package org.seasar.golf.data;

import org.seasar.golf.validation.ValidationResult;
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
    public void setField(String fld, Object val){
        getFields().put(fld, val);
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
    public void setParam(String fld, Object val){
        getParams().put(fld, val);
    }
}
