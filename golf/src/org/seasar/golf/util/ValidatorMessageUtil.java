/*
 * MessageUtil.java
 *
 * Created on 2007/01/01, 8:44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.framework.log.Logger;

/**
 *
 * @author shimura
 */
public class ValidatorMessageUtil {
    
    /** Creates a new instance of MessageUtil */
       private static final String BUNDLE_NAME = "org.seasar.golf.validator.Messages";
       private ValidationMessageLabel validationMessageLabel; 

    private static Logger logger_ = Logger.getLogger(ValidatorMessageUtil.class);
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
