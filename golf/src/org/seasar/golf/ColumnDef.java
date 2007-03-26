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
    /**
     * 
     * @param name 
     */
    public ColumnDef(String name) {
        this.name = name;
        
    }
    /**
     * 
     * @param name 
     * @param type 
     * @param canEdit 
     * @param hostName 
     */
    public ColumnDef(String name, Class type, boolean canEdit, String hostName ) {

        this.name = name;
        this.type = type;
        this.canEdit = canEdit;
        this.hostName = hostName;
    }
     /**
      * 
      * @param name 
      * @param type 
      * @param canEdit 
      * @param insertCheckColumn 
      * @param validatorDef 
      * @param hostName 
      */
     public ColumnDef(String name, Class type, boolean canEdit,boolean  insertCheckColumn, 
             ValidatorDef validatorDef, String hostName ) {
        this.name = name;
        this.type = type;
        this.canEdit = canEdit;
        this.validatorDef = validatorDef;
        this.insertCheckColumn = insertCheckColumn;
        this.hostName = hostName;
        
    }

    /**
     * 
     * @return 
     */
    public ValidatorDef getValidatorDef() {
        return validatorDef;
    }

    /**
     * 
     * @param validatorDef 
     */
    public void setValidatorDef(ValidatorDef validatorDef) {
        this.validatorDef = validatorDef;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public boolean getCanEdit() {
        return canEdit;
    }

    /**
     * 
     * @param canEdit 
     */
    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    /**
     * 
     * @return 
     */
    public Class getType() {
        return type;
    }

    /**
     * 
     * @param type 
     */
    public void setType(Class type) {
        this.type = type;
    }

    /**
     * 
     * @return 
     */
    public boolean getInsertCheckColumn() {
        return insertCheckColumn;
    }

    /**
     * 
     * @param insertCheckColumn 
     */
    public void setInsertCheckColumn(boolean insertCheckColumn) {
        this.insertCheckColumn = insertCheckColumn;
    }

    /**
     * 
     * @return 
     */
    public String getHostName() {
        return hostName;
    }

    /**
     * 
     * @param hostName 
     */
    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    
}
