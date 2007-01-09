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
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.seasar.golf.GolfTableModel;

/**
 *
 * @author shimura
 */
public class TableBindHandler implements PropertyChangeListener, TableModelListener {
    private Hashtable srcColumnTable = new Hashtable();
    private Hashtable columnSrcTable = new Hashtable();
    private GolfTableModel golfTableModel = null;
    private int currentRow = 999999;
    /** Creates a new instance of DetailPropertyChangeListener */
    public TableBindHandler(GolfTableModel golfTableModel) {
        this.golfTableModel = golfTableModel;
    }
    public void addSrcAndColumn(Object src, String column) {
        srcColumnTable.put(src, column);
        columnSrcTable.put(golfTableModel.findColumn(column), src);
    }
    public void propertyChange(PropertyChangeEvent evt) {
        
        PropertyChangeEvent evtnew = evt;
        Object src = evt.getSource();
        String column = (String) srcColumnTable.get(src);
        int row = golfTableModel.getJtable().getSelectedRow();
        if (row != -1) {
            golfTableModel.setValueAt(evt.getNewValue(),
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
                Enumeration e = columnSrcTable.keys();
			while (e.hasMoreElements()){
				Integer column = (Integer) e.nextElement();  
                                ((ValueHolder)columnSrcTable.get(column)).setValue(
                                    golfTableModel.getValueAt(row, column));
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
}
