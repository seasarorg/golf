/*
 * SimpleTableData.java
 *
 * Created on 2006/12/31, 18:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author shimura
 */
public class TableData {
    
    /** Creates a new instance of SimpleTableData */
    public TableData() {
    }
    
    protected ArrayList    dataArray = new ArrayList();
    protected ArrayList    columnIdentifiers = new ArrayList();
    protected Hashtable columnNameToNo = new Hashtable();
    public void setDataArray(ArrayList dataArray, ArrayList columnIdentifires) {
        this.dataArray = nonNullArray(dataArray);
        this.columnIdentifiers = nonNullArray(columnIdentifires);
        justifyRows(0, getRowCount());
        refreshColumnNameToNo();
    }
    public int getRowCount() {
        return dataArray.size();
    }

    public int getColumnCount() {
        return columnIdentifiers.size();
    }
    
    public int getColumnNo(String columnName) {
    	Integer i = (Integer) columnNameToNo.get(columnName.toLowerCase());
    	if (i == null) {
    		return -1;
    	}
    	return ((Integer) columnNameToNo.get(columnName.toLowerCase())).intValue();
    }
    public void refreshColumnNameToNo(){
        columnNameToNo.clear();
        for (int i = 0; i < getColumnCount(); i++ ) {
            columnNameToNo.put(
            		columnIdentifiers.get(i).toString().trim().toLowerCase(),i);
        }
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList rowArray = (ArrayList)dataArray.get(rowIndex);
        if (columnIndex >= rowArray.size()) {
            return null;
        } else {
            return rowArray.get(columnIndex);
        }
    }
    public Object getValueAt(int rowIndex, String columnName) {
        ArrayList rowArray = (ArrayList)dataArray.get(rowIndex);
        int columnNo = getColumnNo(columnName.trim());
        return (columnNo == -1 || columnNo >= rowArray.size() ) ? null:
        	rowArray.get(getColumnNo(columnName.trim()));
    }
    public String getTextAt(int rowIndex, String columnName){
        String s = null;
        Object O = getValueAt(rowIndex, columnName);
        if (O != null) {
            s = getValueAt(rowIndex, columnName).toString();
        }
    	return (s == null) ? null:s.trim();
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ArrayList rowArray = (ArrayList)dataArray.get(rowIndex);
        rowArray.set(columnIndex, aValue);
    }

    public ArrayList getDataArray() {
        return dataArray;
    }
    
    private static ArrayList nonNullArray(ArrayList a) {
        return (a != null) ? a: new ArrayList();
    }
    
    public void addRow (ArrayList rowData) {
        insertRow(getRowCount(), rowData);
    }

    public void addRow (Object[] rowData) {
        addRow(convertToArray(rowData));
    }
    public void insertRow(int row, ArrayList rowData) {
        dataArray.add(row, rowData);
    }

    public void insertRow(int row, Object[] rowData) {
        insertRow(row, convertToArray(rowData));
    }
    
    public void removeRow(int row) {
        dataArray.remove(row);
    }
    
    public ArrayList getColumnIdentifires() {
        return columnIdentifiers;
    }
    public void setColumnIdentifires ( ArrayList columnIdentifires) {
        setDataArray(dataArray, columnIdentifires);
    }
    public void setColumnIdentifires (Object[] newIdentifires) {
        setColumnIdentifires(convertToArray(newIdentifires));
    }
    
    public void setColumnCount(int columnCount) {
        for (int i = getColumnCount()-1; i >=columnCount; i--) {
            columnIdentifiers.remove(i);
        }
        for (int i = getColumnCount(); i < columnCount; i++) {
            columnIdentifiers.add(i,"");
        }
        justifyRows(0, getRowCount());
        refreshColumnNameToNo();
    }
    
    public void addColumn(Object columnName) {
        columnIdentifiers.add(columnName);
        justifyRows(0, getRowCount());
        refreshColumnNameToNo();
    }
    
    public String getColumnName(int column) {
        Object id = null;
        if (column < columnIdentifiers.size() && column >= 0) {
            id = columnIdentifiers.get(column);
        }
        return id.toString();
    }
        
    
    private ArrayList convertToArray(Object[] rowData) {
        if (rowData == null) {
            return null;
        }
        ArrayList a = new ArrayList(rowData.length);
        for (int i=0; i < rowData.length; i++) {
            a.add(rowData[i]);
        }
        return a;
    }

    private void justifyRows(int from, int to) {
        for (int i = getRowCount()-1; i >= to; i--) {
            dataArray.remove(i);
        }
        for (int i = from ; i < to; i ++) {
            if (dataArray.get(i) == null) {
                dataArray.add(i, new ArrayList());
            }
            ArrayList row = (ArrayList) dataArray.get(i);
            if (row.size() > getColumnCount()) {
                for (int j = row.size() -1; j >= getColumnCount(); j--) {
                    row.remove(j);
                }
            }
            else {
                for (int j =row.size(); j < getColumnCount(); j++) {
                    if (row.get(j) == null ) {
                        row.add(j, null);
                    }
                }
            }
                    
        }
    }

}
