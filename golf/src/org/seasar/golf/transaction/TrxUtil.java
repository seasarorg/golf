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
import java.util.HashMap;
import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.data.TableData;

/**
 *
 * @author shimura
 */
public class TrxUtil {
    
    /** Creates a new instance of TrxUtil */
    private TrxUtil() {
    }
    public static void setFieldDataToRequest(RequestData requestData, FormManager formManager) {
        HashMap ht = formManager.getFormTrxManager().getHostToField();
        Object[] hosts = formManager.getFormTrxManager().getHostToField().keySet().toArray();
        for (Object host:hosts) {
//        for (Enumeration e = formManager.getFormTrxManager().getHostToField().keys();
//            e.hasMoreElements(); )   {
//            String host = (String) e.nextElement();
            Object field = formManager.getValue((String) formManager.getFormTrxManager().getHostToField().get(host));
            requestData.getFields().put(host, field);
        }
    }  
    public static void setTableDataToRequest(
            String tableHostName, RequestData requestData, FormManager formManager) {  
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

        for (int j = 0; j < tableModel.getRowCount(); j ++) {
            if (tableModel.effectiveRow(j)) {
                ArrayList row = new ArrayList();
                for (int i = 0; i < cols.size(); i ++) {
                    row.add(tableModel.getValueAt(j, ((Integer)cols.get(i)).intValue()));
                }
                td.addRow(row);
            }
        }
        requestData.getTables().put(tableHostName, td);
    }
    public static void setAllTableDataToRequest(RequestData requestData, FormManager formManager) {
        Object[] tableHostNames = formManager.getFormTrxManager().getHostToTableModel().keySet().toArray();
        for(Object tableHostName : tableHostNames) {
//        for (Enumeration e = formManager.getFormTrxManager().getHostToTableModel().keys();
//            e.hasMoreElements(); )   {   
//            String tableHostName = (String) e.nextElement();
            setTableDataToRequest((String)tableHostName, requestData, formManager);
        }    
    } 
}