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
