/*
 * ValidationUtil.java
 *
 * Created on 2007/01/01, 21:48
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.util;

import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.ValidationMessage;
import com.jgoodies.validation.ValidationResult;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.containerFrame.FormManager;
import org.seasar.golf.validator.RequiredValidator;
import org.seasar.golf.validator.GolfValidator;

/**
 *
 * @author shimura
 */
public class ValidationUtil {
    
    /** Creates a new instance of ValidationUtil */
    private static RequiredValidator requiredValidator = null;
    private ValidationUtil() {
    }
       public  static ValidationResult validate(ValidationResult validationResult, GolfValidator validator, 
               Object data, String name, String displayName, Object field, boolean requiredCheck, 
                ValueModel valueModel, FormManager formManager) {
           String label = (displayName == null) ? name: displayName;
           ValidationMessage result = null;
        if (requiredCheck) {
            getRequiredValidator();
            result = requiredValidator.validate(data,  label, field, valueModel, formManager);
        }

        if (result == null && validator != null) {
            result = validator.validate(data,  label, field, valueModel, formManager);
        }

        if (result != null ) { 
            validationResult.add(result);
        }
        return validationResult;
    }
    
    public  static void getRequiredValidator() {
        if (requiredValidator != null) {
            return; 
        }
            
        try {
             requiredValidator = (RequiredValidator) SingletonS2ContainerFactory.getContainer().getComponent(RequiredValidator.class);
        }
        catch (Exception  e){
            
        }
        if (requiredValidator == null) {
            requiredValidator = new RequiredValidator();
        }
  
        
    }
    public static GolfValidator getValidator(String validatorName) {
        return (GolfValidator)SingletonS2ContainerFactory.getContainer().getComponent(validatorName.trim());
    }
        
}
