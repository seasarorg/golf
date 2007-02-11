/*
 * JTableFieldInfo.java
 *
 * Created on 2007/01/04, 9:52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

/**
 *
 * @author shimura
 */
public class HostTableFieldInfo {
    private String hostTtable;
    private int row;
    private String column;

    public  HostTableFieldInfo() {
    }
    public HostTableFieldInfo (
    String hostTtable,
    int row,
    String column)
    {
        this.hostTtable = hostTtable;
        this.row = row;
        this.column = column;
    }

    public String getHostTtable() {
        return hostTtable;
    }

    public void setHostTtable(String hostTtable) {
        this.hostTtable = hostTtable;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
   
}
