/*
 * StringValidator.java
 *
 * Created on 2007/01/01, 13:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.Severity;
import com.jgoodies.validation.ValidationMessage;
import com.jgoodies.validation.message.SimpleValidationMessage;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class LongValidator extends AbstractValidator{
    
    private Long minValue = null;
    private Long maxValue = null;
    public LongValidator() {
        messageKey = new String[] { "org.seasar.golf.validator.LongValidator.MINIMUM",
        "org.seasar.golf.validator.LongValidator.MAXIMUM",
        "org.seasar.golf.validator.LongValidator.INVALID"};        
    }

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck) {
        Long lValue  = null;
     
        String dataS = getDataString(data);
        if (dataS.length() == 0) {
            return null;
        }
        String displayLabel = getDisplayLabel(label);
        try {
            lValue = Long.parseLong(dataS);
        } catch (NumberFormatException ex) {
              return new SimpleValidationMessage(displayLabel + getMessage(2, dataS), Severity.ERROR, key );
        }
        if ((minValue != null) &&  (lValue < minValue)) {
            return new SimpleValidationMessage(displayLabel + getMessage(0, minValue, dataS), Severity.ERROR, key );
        }
        if ((maxValue !=null ) && (lValue > maxValue))  {
            return new SimpleValidationMessage(displayLabel + getMessage(1, maxValue, dataS), Severity.ERROR, key );          
        }        
        return null;
    }

    public Long getMinValue() {
        return minValue;
    }

    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    
}
