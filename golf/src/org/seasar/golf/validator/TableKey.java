/*
 * TableKey.java
 *
 * Created on 2007/01/01, 15:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

/**
 *
 * @author shimura
 */
public class TableKey {
    
    /** Creates a new instance of TableKey */
    public TableKey() {
    }
    public TableKey(Object key, int row, int column ) {
        this.key = key;
        this.row = row;
        this.column = column;
    }
    private Object key = null;
    private int row;
    private int column;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
    
}
