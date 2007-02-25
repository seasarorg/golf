/*
 * DetailPropertyChangeListener.java
 *
 * Created on 2007/01/08, 11:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.binding;

import com.jgoodies.binding.value.ValueHolder;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfTableModel;

/**
 *
 * @author shimura
 */
public class TableBindHandler 
        implements PropertyChangeListener, TableModelListener, ListSelectionListener {
    private HashMap srcColumnTable = new HashMap();
    //private HashMap srcClassTable = new HashMap();
    private HashMap columnSrcTable = new HashMap();
    private GolfTableModel golfTableModel = null;
    private int currentRow = 999999;
    /** Creates a new instance of DetailPropertyChangeListener */
    public TableBindHandler(GolfTableModel golfTableModel) {
        this.golfTableModel = golfTableModel;
        golfTableModel.getJtable().getSelectionModel().addListSelectionListener(this);
    }
    public void addSrcAndColumn(Object src, String column) {
        srcColumnTable.put(src, column);
        columnSrcTable.put(golfTableModel.findColumn(column), src);
    }
    public void propertyChange(PropertyChangeEvent evt) {
        
        Object src = evt.getSource();
        String column = (String) srcColumnTable.get(src);
        int row = golfTableModel.getJtable().getSelectedRow();
        Object newValue = evt.getNewValue();
        int columnNo =  golfTableModel.findColumn(column);
        Class srcClass= ((ColumnDef)golfTableModel.getColumnDef(columnNo
              )).getType();
        if (row != -1) {
            if (Double.class .isAssignableFrom(srcClass) ) {
                if (newValue instanceof String) {
                    newValue = Double.parseDouble((String) newValue);
                }
            }
             if (Integer.class .isAssignableFrom(srcClass) ) {
                if (newValue instanceof String) {
                    newValue = Integer.parseInt((String) newValue);
                }
            }
            golfTableModel.setValueAt(newValue,
                row,golfTableModel.findColumn(column));
        }
    }

    public GolfTableModel getGolfTableModel() {
        return golfTableModel;
    }

    public void setGolfTableModel(GolfTableModel golfTableModel) {
        this.golfTableModel = golfTableModel;
    }

    public void tableChanged(TableModelEvent e) {
        int column = e.getColumn();
        if (column == TableModelEvent.ALL_COLUMNS || columnSrcTable.containsKey(column)) {
            selectedRowChanged();
        }
    }
    public void selectedRowChanged() {
        int row = golfTableModel.getJtable().getSelectedRow();  
        selectedRowChanged(row); 
    }
    public void selectedRowChanged(int row) {
            if (row != -1) {
                Object[] columns = columnSrcTable.keySet().toArray();
                for(Object column: columns) {
                        Object o = golfTableModel.getValueAt(row, (Integer)column);
                        if (o  != null) {
                            ((ValueHolder)columnSrcTable.get(column)).setValue(
                                golfTableModel.getValueAt(row, (Integer)column).toString());
                        } else {
                             ((ValueHolder)columnSrcTable.get((Integer)column)).setValue(null);
                        }
                }
                currentRow = row;
            }    
    }
    public Integer getTableRow(KeyEvent evt){
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_UP ||
               keyCode == KeyEvent.VK_KP_DOWN || keyCode ==KeyEvent.VK_KP_UP ||
               keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_TAB ) {  
            JTable jt = (JTable) evt.getSource();
            return Integer.valueOf(jt.getSelectedRow());                   
        }  else {
            return null;
        }  
    }

    public void mouseReleased(MouseEvent evt) {
        int row = golfTableModel.getJtable().getSelectedRow();
        if (row  != currentRow) {
            selectedRowChanged(row);
        }
    }

    public void keyReleased(KeyEvent evt) {
        Integer row = getTableRow(evt);
        if (row == null) {
            return;
        }
        if (row != currentRow) {
            selectedRowChanged(row);
        }
        return;
    }

    public void valueChanged(ListSelectionEvent e) {
        selectedRowChanged(golfTableModel.getJtable().getSelectedRow());
    }
}
