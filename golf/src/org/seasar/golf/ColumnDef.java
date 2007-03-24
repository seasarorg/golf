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

package org.seasar.golf;

import org.seasar.golf.validator.ValidatorDef;

/**
 *
 * @author shimura
 */
public class ColumnDef {
    private ValidatorDef validatorDef = new ValidatorDef();
    private String name = null;
    private boolean canEdit = false;
    private Class type = Object.class;
    private boolean insertCheckColumn = false;
    private String hostName = null;
    
    /** Creates a new instance of ColumnDef */
    public ColumnDef() {
        
    }
    public ColumnDef(String name) {
        this.name = name;
        
    }
    public ColumnDef(String name, Class type, boolean canEdit, String hostName ) {

        this.name = name;
        this.type = type;
        this.canEdit = canEdit;
        this.hostName = hostName;
    }
     public ColumnDef(String name, Class type, boolean canEdit,boolean  insertCheckColumn, 
             ValidatorDef validatorDef, String hostName ) {
        this.name = name;
        this.type = type;
        this.canEdit = canEdit;
        this.validatorDef = validatorDef;
        this.insertCheckColumn = insertCheckColumn;
        this.hostName = hostName;
        
    }

    public ValidatorDef getValidatorDef() {
        return validatorDef;
    }

    public void setValidatorDef(ValidatorDef validatorDef) {
        this.validatorDef = validatorDef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public boolean getInsertCheckColumn() {
        return insertCheckColumn;
    }

    public void setInsertCheckColumn(boolean insertCheckColumn) {
        this.insertCheckColumn = insertCheckColumn;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    
}
