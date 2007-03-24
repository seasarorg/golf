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

package org.seasar.golf.validator;

import com.jgoodies.binding.value.ValueModel;
import org.seasar.golf.validation.Severity;
import org.seasar.golf.validation.ValidationMessage;
import org.seasar.golf.validation.message.SimpleValidationMessage;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class StringValidator extends AbstractValidator{
    
    private Integer minLength = null;
    private Integer maxLength = null;
    
    public StringValidator() {
        messageKey = new String[] { "org.seasar.golf.validator.StringValidator.MINIMUM",
        "org.seasar.golf.validator.StringValidator.MAXIMUM"};        
    }

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck) {
     
        String dataS = getDataString(data);
        if (dataS.length() == 0) {
            return null;
        }
        String displayLabel = getDisplayLabel(label);
        if (minLength!=null && dataS.length() < minLength && dataS.length() > 0) {
            return new SimpleValidationMessage(displayLabel + getMessage(0, minLength, dataS), Severity.ERROR, key );
        }
        if (maxLength!=null && dataS.length() > maxLength) {
            return new SimpleValidationMessage(displayLabel + getMessage(1, maxLength, dataS), Severity.ERROR, key );          
        }        
        return null;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }
    
}
