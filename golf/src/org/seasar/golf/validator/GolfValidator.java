/*
 * Validator.java
 *
 * Created on 2007/01/01, 13:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import com.jgoodies.binding.value.ValueModel;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.validation.ValidationMessage;

/**
 *
 * @author shimura
 */
public interface GolfValidator {
    public ValidationMessage validate (Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck) ;
    public void setMessage(String[] msg);
    public void setMessageKey(String[] msg);

    
}
