/*
 * RequiredValidator.java
 *
 * Created on 2007/01/03, 11:07
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
public class RequiredValidator extends AbstractValidator {
    
    /** Creates a new instance of RequiredValidator */
    public RequiredValidator() {
        messageKey = new String[] { "org.seasar.golf.validator.RequiredValidator.REQUIRED"};  
    }

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck ) {
        String dataS = getDataString(data);
        if (dataS.length() > 0) {
            return null;
        }
        String displayLabel = getDisplayLabel(label);

        return new SimpleValidationMessage(displayLabel + getMessage(0, 0, dataS), Severity.ERROR, key );
              
    }



    
}
