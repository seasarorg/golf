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
