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
import org.seasar.golf.containerFrame.FormManager;

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

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, FormManager formManager) {
     
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
