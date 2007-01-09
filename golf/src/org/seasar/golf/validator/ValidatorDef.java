/*
 * ValidatorDef.java
 *
 * Created on 2007/01/04, 7:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

/**
 *
 * @author shimura
 */
public class ValidatorDef {
    private GolfValidator validator = null;
    private String displayName = null;
    private boolean required = false;
    /** Creates a new instance of ValidatorDef */
    public ValidatorDef() {
    }
    public ValidatorDef(GolfValidator validator, String displayName,boolean required) {
        this.validator = validator;
        this.displayName = displayName;
        this.required = required;
    }

    public GolfValidator getValidator() {
        return validator;
    }

    public void setValidator(GolfValidator validator) {
        this.validator = validator;
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
