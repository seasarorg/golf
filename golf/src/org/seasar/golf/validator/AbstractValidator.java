/*
 * AbstractValidator.java
 *
 * Created on 2007/01/01, 13:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.ValidationMessage;
import java.text.MessageFormat;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.util.ValidatorMessageUtil;

/**
 *
 * @author shimura
 */
public abstract class AbstractValidator implements GolfValidator{
    
    /** Creates a new instance of AbstractValidator */
    protected String[] messages = null;
    protected  String[] messageKey = null;
    
    abstract public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck) ;


    public void setMessage(String[] msg) {
        messages = msg;
    }

    public void setMessageKey(String[] msgKey) {
        
        messageKey = msgKey;
    }
    public String getMessage(int no, Object ... rules) {
        String message = null;
        if (messages!=null && no < messages.length) {
            message = messages[no];
        }
        else {
            message = ValidatorMessageUtil.getMessage(messageKey[no]);
        }
        return MessageFormat.format(message, rules);
        
    }
    protected String getDataString(Object data) {
        return  ( data == null  ) ? "": data.toString().trim();
    }
    protected String getDisplayLabel(final String label) {
        String displayLabel = (label == null) ? "":label+": ";
        return displayLabel;
    }
}
