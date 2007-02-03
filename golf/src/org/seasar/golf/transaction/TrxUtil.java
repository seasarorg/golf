/*
 * TrxUtil.java
 *
 * Created on 2007/02/03, 16:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import java.util.ArrayList;
import java.util.Enumeration;
import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.containerFrame.FormManager;
import org.seasar.golf.data.TableData;

/**
 *
 * @author shimura
 */
public class TrxUtil {
    
    /** Creates a new instance of TrxUtil */
    private TrxUtil() {
    }
    public static void setFieldDataToRequest(TrxRequest trxRequest, FormManager formManager) {
        for (Enumeration e = formManager.getFormTrxManager().getHostToField().keys();
            e.hasMoreElements(); )   {
            String host = (String) e.nextElement();
            trxRequest.getRequestData().getFields().put(host, 
                    formManager.getValue((String) formManager.getFormTrxManager().getHostToField().get(host)));
        }
    }  
    public static void setTableDataToRequest(
            String tableHostName, TrxRequest trxRequest, FormManager formManager) {  
        GolfTableModel tableModel = (GolfTableModel)formManager.getFormTrxManager().
                getHostToTableModel().get(tableHostName);
        ArrayList cols = new ArrayList();
        TableData td = new TableData();
        for(int i = 0; i < tableModel.getColumnCount(); i++) {
            if (((ColumnDef)tableModel.getColumnDefs().get(i)).getHostName() != null) {
                cols.add(i);
                td.addColumn(((ColumnDef)tableModel.getColumnDefs().get(i)).getHostName());
            }
        }
        if (cols.size() == 0) {
            return;
        }
        ArrayList row = new ArrayList();
        for (int j = 0; j < tableModel.getRowCount(); j ++) {
            for (int i = 0; i < cols.size(); i ++) {
                row.add(tableModel.getValueAt(j, i));
            }
            tableModel.addRow(row);
            row.clear();
        }
        trxRequest.getRequestData().getTables().put(tableHostName, td);
    }
    public static void setAllTableDataToRequest(TrxRequest trxRequest, FormManager formManager) {
        for (Enumeration e = formManager.getFormTrxManager().getHostToTableModel().keys();
            e.hasMoreElements(); )   {   
            String tableHostName = (String) e.nextElement();
            setTableDataToRequest(tableHostName, trxRequest, formManager);
        }    
    } 
}
