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
    public DataSelect(FormManager formManager, String field) {
        this.requestForm = formManager.getForm();
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
