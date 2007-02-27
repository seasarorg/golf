/*
 * ValueModelAndValidatorConnector.java
 *
 * Created on 2007/01/01, 21:19
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.binding;

import com.jgoodies.binding.value.ValueModel;
import java.util.ArrayList;
import org.seasar.golf.validator.GolfValidator;
import org.seasar.golf.validator.ValidatorDef;

/**
 *
 * @author shimura
 */
public class ValueModelAndValidatorConnector {
 
    private ValueModel valueModel = null;
    private ValidatorDef validatorDef = new ValidatorDef (); 
    public ValueModelAndValidatorConnector() {
    }
    public ValueModelAndValidatorConnector(ValueModel valueModel) {
        this.valueModel = valueModel;

    }
        public ValueModelAndValidatorConnector(ValueModel valueModel, 
                ArrayList <GolfValidator> validators, String displayName, boolean required) {
        this.valueModel = valueModel;
        validatorDef.setValidators(validators);
        validatorDef.setDisplayName(displayName);
        validatorDef.setRequired (required);

    }
    public void addValidator(ArrayList <GolfValidator> validators, String displayName ) { 
        validatorDef.setValidators(validators);
        validatorDef.setDisplayName(displayName);
    }
    public void addValidator(ArrayList <GolfValidator> validators, String displayName, boolean required  ) {
        validatorDef.setValidators(validators);
        validatorDef.setDisplayName(displayName);
        validatorDef.setRequired(required);
    }
    public ValueModel getValueModel() {
        return valueModel;
    }

    public void setValueModel(ValueModel valueModel) {
        this.valueModel = valueModel;
    }

    public ValidatorDef getValidatorDef() {
        return validatorDef;
    }
    
}
