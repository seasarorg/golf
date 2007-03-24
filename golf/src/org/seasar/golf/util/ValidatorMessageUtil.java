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

package org.seasar.golf.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

/**
 *
 * @author shimura
 */
public class ValidatorMessageUtil {
    
    /** Creates a new instance of MessageUtil */
       private static final String BUNDLE_NAME = "org.seasar.golf.validator.Messages";
       private ValidationMessageLabel validationMessageLabel; 

//    private static Logger logger_ = Logger.getLogger(ValidatorMessageUtil.class);
    private ValidatorMessageUtil() {
    }
    private static ResourceBundle bundle = null;
    public static ResourceBundle getBundle(){
        return (bundle != null) ? bundle : ResourceBundle.getBundle(BUNDLE_NAME,Locale.getDefault(), Thread
                    .currentThread().getContextClassLoader());
    }
       public static String getBundleString(ResourceBundle bundle, String key) {
        try {
            return bundle == null ? null : bundle.getString(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }
      public static String getMessage(String key) {
          return getBundleString(getBundle(),key);
      }
     String getMessageLabel(String label) {
         getValidationMessageLabel(); 
         return validationMessageLabel.getMessageLabel(label);
     }

    private void getValidationMessageLabel() {
        if (validationMessageLabel !=null) {
            return;
        }
        try {
            validationMessageLabel = (ValidationMessageLabel) SingletonS2ContainerFactory.getContainer().getComponent(ValidationMessageLabel.class);
        }
        catch (Exception e) {
            
        }
        if (validationMessageLabel ==null) {
            validationMessageLabel = new ValidationMessageLabelImpl();
        }
    }
}
