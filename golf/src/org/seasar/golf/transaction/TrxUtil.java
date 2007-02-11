/*
 * TrxUtil.java
 *
 * Created on 2007/02/03, 16:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import com.jgoodies.validation.ValidationMessage;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.message.SimpleValidationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.data.TableData;
import org.seasar.golf.validator.HostTableFieldInfo;
import org.seasar.golf.validator.JTableFieldInfo;

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
    public static ValidationResult updateValidationResult(FormManager formManager, ValidationResult validationResult){
        
        ValidationResult newResult = new ValidationResult();
        HashMap hostNameToColumnNo = null;
         for(  Object o: validationResult.getMessages()) {
             ValidationMessage msg = (ValidationMessage) o;
             Object MessageKey = null;
             String text = null;
             
             if (msg.key() != null ) {
                 text = msg.formattedText();
                 if (msg.key() instanceof String ) {

                     MessageKey = formManager.getFormTrxManager().getHostToField().get(msg.key());
                     
                 } else if (msg.key() instanceof HostTableFieldInfo ) {
                     GolfTableModel gtm = (GolfTableModel) formManager.getFormTrxManager().
                             getHostToTableModel().get((HostTableFieldInfo) msg.key());
                     if (hostNameToColumnNo == null) {
                         hostNameToColumnNo = createHostNameToColumnNo(gtm);
                     }
                     Integer column = (Integer) hostNameToColumnNo.get(((HostTableFieldInfo) msg.key()).getColumn());

                     MessageKey = new JTableFieldInfo(gtm.getJtable(), ((HostTableFieldInfo) msg.key()).getRow(),
                           column.intValue());
                     
                     text = gtm.getDisplayName(((HostTableFieldInfo) msg.key()).getRow() , column) +
                            ": " + text;
                 }
             }
             ValidationMessage newMsg = new SimpleValidationMessage(text, msg.severity(), MessageKey);
             newResult.add(newMsg);
         }
        
        return newResult;
    }
    
    private static HashMap createHostNameToColumnNo(GolfTableModel gtm) {
        HashMap map = new HashMap();
        for(int i=0; i <gtm.getColumnDefs().size(); i++) {
            ColumnDef def = (ColumnDef)gtm.getColumnDefs().get(i);
            if (def.getHostName() != null) {
                map.put(def.getHostName(), i);
            }
        }
        return map;
    }
}
