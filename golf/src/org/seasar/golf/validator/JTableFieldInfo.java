/*
 * JTableFieldInfo.java
 *
 * Created on 2007/01/04, 9:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import javax.swing.JTable;

/**
 *
 * @author shimura
 */
public class JTableFieldInfo {
    private JTable jtable;
    private int row;
    private int column;
    /** Creates a new instance of JTableFieldInfo */
    public JTableFieldInfo() {
    }
    public JTableFieldInfo(JTable jtable, int row, int column) {
        this.jtable = jtable;
        this.row = row;
        this.column = column;
    }

    public JTable getJtable() {
        return jtable;
    }

    public void setJtable(JTable jtable) {
        this.jtable = jtable;
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
