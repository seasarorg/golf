/*
 * FormValidationManager.java
 *
 * Created on 2007/01/01, 16:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import java.util.ArrayList;
import javax.swing.JComponent;
import org.seasar.golf.validation.ValidationMessage;
import org.seasar.golf.validation.ValidationResult;
import org.seasar.golf.validation.util.AbstractValidationResultModel;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class FormValidationManager extends AbstractValidationResultModel {
    
    /** Creates a new instance of FormValidationManager */
    public FormValidationManager() {
    }
    private ArrayList <ComponentValidator> validators = new ArrayList<ComponentValidator>();
    private ValidationResult validationResult = new ValidationResult();
    private FormManager formManager = null;
    private boolean fireValidate = true;    
    public void addValidator(ComponentValidator validator) {
        validators.add(validator);
    }
    
 
    public void Validate(boolean requiredCehck) {
        ValidationResult oldResult = validationResult;
        validationResult = new ValidationResult();
        ValidationResult validationResultTemp = new ValidationResult();        
        for (int i = 0; i < validators.size(); i++) {
            ComponentValidator  componentValidator = validators.get(i);
            validationResultTemp = componentValidator.validate(validationResultTemp ,requiredCehck);
        }
        validationResult.addAll(validationResultTemp.getErrors());    
        validationResult.addAll(validationResultTemp.getWarnings());
        validationResult.addAll(validationResultTemp.getInfos());
        setFocus();
        firePropertyChanges(oldResult, validationResult);
    }

    private void setFocus() {
        if (validationResult.hasMessages()) {
            Object errorKey = ((ValidationMessage)validationResult.getMessages().get(0)).key();
            if (errorKey instanceof TableKey) {
                errorKey = ((TableKey)errorKey).getKey();
            }
            if (errorKey instanceof JComponent) {
                JComponent jc = (JComponent) ((ValidationMessage)validationResult.getMessages().get(0)).key();
                if (jc.isFocusable()) {
                    jc.requestFocusInWindow();
                }
            }
        }
    }

    public ValidationResult getResult() {
        return validationResult;
    }

    public void setResult(ValidationResult newResult) {
        ValidationResult oldResult = validationResult;
        validationResult = newResult;
        setFocus();
        firePropertyChanges(oldResult, validationResult);
    }

    public FormManager getFormManager() {
        return formManager;
    }

    public void setFormManager(FormManager formManager) {
        this.formManager = formManager;
    }

    public void setFireValidate(boolean fireValidate) {
        this.fireValidate = fireValidate;
    }    

    public boolean isFireValidate() {
        return fireValidate;
    }
}
