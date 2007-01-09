/*
 * ComponentValidator.java
 *
 * Created on 2007/01/01, 15:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import com.jgoodies.validation.ValidationResult;

/**
 *
 * @author shimura
 */
public interface ComponentValidator {
    
    public ValidationResult validate(ValidationResult  validationResult, boolean requiredCheck);
    
}
