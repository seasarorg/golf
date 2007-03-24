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
