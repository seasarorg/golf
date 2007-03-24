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
import org.seasar.golf.form.FormManager;
import org.seasar.golf.validation.message.SimpleValidationMessage;
/**
 *
 * @author shimura
 */
public class DoubleValidator extends AbstractValidator{
    private Double minValue = null;
    private Double maxValue = null;
    public DoubleValidator() {
        messageKey = new String[] { "org.seasar.golf.validator.LongValidator.MINIMUM",
        "org.seasar.golf.validator.LongValidator.MAXIMUM",
        "org.seasar.golf.validator.DoubleValidator.INVALID"};        
    }

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck) {
        Double lValue  = null;
        String dataS = getDataString(data);
        if (dataS.length() == 0) {
            return null;
        }
        String displayLabel = getDisplayLabel(label);

        try {  lValue = Double.parseDouble(dataS);
         } catch (NumberFormatException ex) {
                    return new SimpleValidationMessage(displayLabel 
                                    + getMessage(2, dataS), Severity.ERROR, key );             
         }
    if ((minValue != null) &&  (lValue < minValue)) {
            return new SimpleValidationMessage(displayLabel + getMessage(0, minValue, dataS), Severity.ERROR, key );
        }
        if ((maxValue !=null ) && (lValue > maxValue))  {
            return new SimpleValidationMessage(displayLabel + getMessage(1, maxValue, dataS), Severity.ERROR, key );          
        }        
        return null;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    
}
