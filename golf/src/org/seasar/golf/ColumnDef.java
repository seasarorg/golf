/*
 * ColumnDef.java
 *
 * Created on 2007/01/04, 8:06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
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
    
    /** Creates a new instance of ColumnDef */
    public ColumnDef() {
        
    }
    public ColumnDef(String name) {
        this.name = name;
        
    }
    public ColumnDef(String name, Class type, boolean canEdit) {
        this.name = name;
        this.type = type;
        this.canEdit = canEdit;
        
    }
     public ColumnDef(String name, Class type, boolean canEdit,boolean  insertCheckColumn, ValidatorDef validatorDef ) {
        this.name = name;
        this.type = type;
        this.canEdit = canEdit;
        this.validatorDef = validatorDef;
        this.insertCheckColumn = insertCheckColumn;
        
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
    
}
