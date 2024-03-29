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

import com.jgoodies.binding.value.ValueModel;
import org.seasar.golf.validation.ValidationMessage;
import org.seasar.golf.validation.ValidationResult;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.validator.FormValidationManager;
import org.seasar.golf.validator.JTableFieldInfo;
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
            result = requiredValidator.validate(data,  label, field, valueModel, formManager, requiredCheck);
        }

        if (result == null && validator != null) {
            result = validator.validate(data,  label, field, valueModel, formManager, requiredCheck);
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
    public static void updateValueModelWithoutValidation(FormManager formManager, 
                final ValueModel valueModel, final Object key, final String newDataS) {
        formManager.getFormValidationManager().setFireValidate(false);
        updateValueModel(valueModel, key,  newDataS);
        formManager.getFormValidationManager().setFireValidate(true);        
    }
    public static void updateValueModel(final ValueModel valueModel, final Object key, final String newDataS) {
        if (valueModel != null)    {
            valueModel.setValue(newDataS);
        } else if (key instanceof JTableFieldInfo) {
           JTable jt = ((JTableFieldInfo)key).getJtable();
           TableModel tm = jt.getModel();
           if (tm instanceof GolfTableModel) {
               ((GolfTableModel)tm).setValueAt(newDataS,  
                       ((JTableFieldInfo)key).getRow(), ((JTableFieldInfo)key).getColumn());
           }
        }
    }    
    
    public static int getRelativeToToday(Date date) {

        Date today = getToday().getTime();
        return Long.valueOf ((date.getTime() - today.getTime())/ (3600L * 24L*1000)).intValue();


        
    }
    public static Calendar getToday() {
       Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0); 
        return calendar;
    }
    public static Date getRelativeToToday(int rdate) {
        Calendar today = getToday();
        today.add(Calendar.DATE, rdate);
        return today.getTime();
        
    }
    public static void showErrorMessage(String text, FormManager formManager) {
        FormValidationManager validationManager = formManager.getFormValidationManager();
        ValidationResult result = new ValidationResult();
        result.addError(text);
        validationManager.setResult(result);
        
    }
        
}
