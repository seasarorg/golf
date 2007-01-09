
/*
 * GolfTableModel.java
 *
 * Created on 2006/12/30, 22:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import com.jgoodies.validation.ValidationResult;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import org.seasar.golf.util.ValidationUtil;
import org.seasar.golf.validator.ComponentValidator;
import org.seasar.golf.validator.FormValidationManager;
import org.seasar.golf.validator.JTableFieldInfo;
import org.seasar.golf.validator.ValidatorDef;

/**
 *
 * @author shimura
 */
public class GolfTableModel extends AbstractTableModel implements ComponentValidator{
    protected ArrayList    dataArray = new ArrayList();
    protected  ArrayList <ColumnDef>   columnDefs = new ArrayList <ColumnDef> ();
    private JTable jtable;
    private String tableDisplayName = "";
    private String rowDisplay = "çs";
    private boolean rowDisplayPre = false;
    private FormValidationManager formValidationManager= null;
    
    /** Creates a new instance of GolfTableModel */
    public GolfTableModel() {
        
    }
    
    public void setDataArray(ArrayList dataArray, ArrayList <ColumnDef> columnDefs) {
        this.dataArray = nonNullArray(dataArray);
        this.columnDefs = columnDefs;
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }

    public int getRowCount() {
        return dataArray.size();
    }

    public int getColumnCount() {
        return columnDefs.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        ArrayList rowArray = (ArrayList)dataArray.get(rowIndex);
        return rowArray.get(columnIndex);
    }
      public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
          setValueAt(aValue, rowIndex, columnIndex, false);
      }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex, boolean batch) {
        ArrayList rowArray = (ArrayList)dataArray.get(rowIndex);
        rowArray.set(columnIndex, aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
        if ( !batch && formValidationManager != null) {
            formValidationManager.Validate(false);
        }
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
        fireTableRowsInserted(row, row);
    }

    public void insertRow(int row, Object[] rowData) {
        insertRow(row, convertToArray(rowData));
    }
    
    public void removeRow(int row) {
        dataArray.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public void setColumnDefs ( ArrayList <ColumnDef> columnDefs) {
        setDataArray(dataArray, columnDefs);
    }
    public void setColumnDefs (ColumnDef [] newColumnDefs) {
        setColumnDefs(convertToArray(newColumnDefs));
    }
    
    public void setColumnCount(int columnCount) {
        for (int i = getColumnCount()-1; i >=columnCount; i--) {
            columnDefs.remove(i);
        }
        for (int i = getColumnCount(); i < columnCount; i++) {
            columnDefs.add(i, new ColumnDef());
        }
        justifyRows(0, getRowCount());
        fireTableStructureChanged();
    }
    
    public void addColumn(ColumnDef columnDef) {
        columnDefs.add(columnDef);
        justifyRows(0, getRowCount());
        fireTableStructureChanged();       
    }
    
    public String getColumnName(int column) {
        return columnDefs.get(column).getName();
    }
        
    public boolean isCellEditable(int row, int column) {
        return columnDefs.get(column).getCanEdit();
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
    public Class getColumnClass(int columnIndex)  {
        return columnDefs.get(columnIndex).getType();
    }
    
    public void setValidatorDef(int column, ValidatorDef validatorDef) {
        columnDefs.get(column).setValidatorDef(validatorDef);
        
    }
    public ValidatorDef getValidatorDef(int column) {
        return columnDefs.get(column).getValidatorDef();
    }
    public ValidationResult validate(ValidationResult validationResult, boolean requiredCheck) {
        ValidationResult vr = (validationResult == null) ? new ValidationResult() : validationResult;
        for (int row = 0; row < getRowCount(); row ++) {
            if (effectiveRow(row)) {
                for (int column = 0; column < getColumnCount(); column ++) {
                    ValidatorDef vd = getColumnDef(column).getValidatorDef();
                    if (vd.getValidator() != null || (vd.getRequired() && requiredCheck)) {
                        vr = ValidationUtil.validate(vr, vd.getValidator(),  getValueAt(row, column), 
                                "", getDisplayName(row, column),
                                new JTableFieldInfo(getJtable(), row, column), vd.getRequired() && requiredCheck,
                                null, formValidationManager.getFrameManager());
                    }
                }
            }
        }
        return vr;
    }

    private boolean effectiveRow(int row) {
        boolean effective = false;
        for (int column = 0; column < getColumnCount(); column ++) {
            if (getColumnDef(column).getInsertCheckColumn() == true
                    && getValueAt(row, column) != null 
                    && getValueAt(row, column).toString().length() > 0) {
                effective = true;
            }
        }
        return effective; 
    }

    public ArrayList<ColumnDef> getColumnDefs() {
        return columnDefs;
    }
    public ColumnDef getColumnDef(int column) {
        return columnDefs.get(column);
    }

    public JTable getJtable() {
        return jtable;
    }

    public void setJtable(JTable jtable, String tableDisplayName) {
        this.jtable = jtable;
        this.tableDisplayName = tableDisplayName;
        jtable.setModel(this);
    }

    private String getDisplayName(int row, int column) {
        String col = getColumnDef(column).getValidatorDef().getDisplayName() == null ?
            getColumnDef(column).getName() : getColumnDef(column).getValidatorDef().getDisplayName() ;
        
        String displayName = tableDisplayName+ " " +
               ( (rowDisplayPre) ? rowDisplay + " "+String.valueOf(row + 1)+" ":
                    String.valueOf(row + 1)+" "+rowDisplay + " ")
                +col;
        
        return displayName;
    }

    public String getTableDisplayName() {
        return tableDisplayName;
    }

    public void setTableDisplayName(String tableDisplayName) {
        this.tableDisplayName = tableDisplayName;
    }

    public String getRowDisplay() {
        return rowDisplay;
    }

    public void setRowDisplay(String rowDisplay) {
        this.rowDisplay = rowDisplay;
    }

    public boolean isRowDisplayPre() {
        return rowDisplayPre;
    }

    public void setRowDisplayPre(boolean rowDisplayPre) {
        this.rowDisplayPre = rowDisplayPre;
    }

    public FormValidationManager getFormValidationManager() {
        return formValidationManager;
    }

    public void setFormValidationManager(FormValidationManager formValidationManager) {
        this.formValidationManager = formValidationManager;
        formValidationManager.addValidator(this);
    }
    
    public void forceTableEditEnd() {
         if (jtable != null ) {
                if (jtable.getEditingRow() != -1) {
                    jtable.getCellEditor(jtable.getEditingRow(), jtable.getEditingColumn()).stopCellEditing();          
                }
       }       
    }
    
}
