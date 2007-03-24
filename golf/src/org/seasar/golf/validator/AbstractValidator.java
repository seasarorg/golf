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
import org.seasar.golf.validation.ValidationMessage;
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
