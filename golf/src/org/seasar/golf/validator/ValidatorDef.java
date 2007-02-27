/*
 * ValidatorDef.java
 *
 * Created on 2007/01/04, 7:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import java.util.ArrayList;

/**
 *
 * @author shimura
 */
public class ValidatorDef {
    private ArrayList <GolfValidator> validators = new ArrayList <GolfValidator>();
    private String displayName = null;
    private boolean required = false;
    /** Creates a new instance of ValidatorDef */
    public ValidatorDef() {
    }
    public ValidatorDef(ArrayList <GolfValidator> validators, String displayName,boolean required) {
        this.validators = validators;
        this.displayName = displayName;
        this.required = required;
    }

    public ArrayList <GolfValidator> getValidators() {
        return validators;
    }
    public void setValidators(ArrayList <GolfValidator> validators) {
        this.validators = validators;
    }    

    public void addValidator(GolfValidator validator) {
        validators.add(validator);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
    
}
