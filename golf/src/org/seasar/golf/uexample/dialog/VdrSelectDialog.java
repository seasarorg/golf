/*
 * VdrSelectDialog.java
 *
 * Created on 2007/03/12, 20:46
 */

package org.seasar.golf.uexample.dialog;

import java.awt.Dialog;
import java.math.BigDecimal;
import java.util.HashMap;
import javax.swing.ListSelectionModel;
import org.seasar.golf.GolfDialog;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.data.DataUtil;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.form.DataSelect;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.transaction.RequestDataFactory;
import org.seasar.golf.transaction.TrxUtil;
import org.seasar.golf.util.TableUtil;
import org.seasar.golf.util.ValidationUtil;

/**
 *
 * @author  shimura
 */
public class VdrSelectDialog extends javax.swing.JDialog implements GolfDialog {
    
    /** Creates new form VdrSelectDialog */
    public VdrSelectDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }
    public VdrSelectDialog(Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }    

    private FormManager formManager = null;
    private GolfTableModel golfTableModel= new GolfTableModel();        
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelHeader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextShort = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonEnter = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 30));

        jLabel8.setFont(new java.awt.Font("ＭＳ Ｐ明朝", 1, 24));
        jLabel8.setText("Golf Example System");

        jLabelHeader.setFont(new java.awt.Font("ＭＳ Ｐ明朝", 1, 24));
        jLabelHeader.setForeground(java.awt.Color.blue);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(244, 244, 244)
                        .add(jLabelHeader))
                    .add(jLabel8))
                .addContainerGap(419, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabelHeader)
                    .add(jLabel8))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("\u7701\u7565\u540d");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        jButtonEnter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FormRunHS.png")));
        jButtonEnter.setToolTipText("Enter");
        jButtonEnter.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnterActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonEnter);

        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NavBack.png")));
        jButtonCancel.setToolTipText("Back");
        jButtonCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancel);

        jButtonSearch.setText("\u691c\u7d22");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jButtonSearch, 0, 0, Short.MAX_VALUE)
                            .add(jTextShort, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .add(12, 12, 12)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextShort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButtonSearch))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 337, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 8, Short.MAX_VALUE)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
    RequestData requestData = RequestDataFactory.createRequestData("vdrSelect",null,formManager);
    if (formManager.getFormData().containsKey("_action")) {
         if (formManager.getFormData().get("_action").equals("dataSelect")){
             DataUtil.copyParam(formManager.getFormData(), requestData.getParams(), "_dataSelect");
             DataUtil.copyParam(formManager.getFormData(), requestData.getParams(), "_action");
             DataUtil.copyParam(formManager.getFormData(), requestData.getParams(), "_cat");
         }
    }
    formManager.getSession().trxExecute(requestData, formManager);
   
}//GEN-LAST:event_jButtonSearchActionPerformed

private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
    dispose();
}//GEN-LAST:event_jButtonCancelActionPerformed

private void jButtonEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnterActionPerformed
    int row = jTable1.getSelectionModel().getMinSelectionIndex();
    if (row == -1) {
        ValidationUtil.showErrorMessage("行が選ばれていません", formManager);
        return;
    }
    BigDecimal ccode = (BigDecimal) golfTableModel.getValueAt(row,0);
    if (formManager.getFormData().containsKey("_action")) {
        if (formManager.getFormData().get("_action").equals("dataSelect")) {
            DataSelect select = (DataSelect) formManager.getFormData().get("_dataSelect");
            select.setSelectedDatum(ccode);
            formManager.getSession().processDataSelect(select);
            return;
        }
    }
}//GEN-LAST:event_jButtonEnterActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VdrSelectDialog dialog = new VdrSelectDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    public FormManager getFormManager() {
        return formManager;
    }

    public void setFormManger(FormManager formManager) {
        this.formManager = formManager;
    }

    public void initBinding(HashMap params) {
        this.setResizable(false);
        formManager.createReportList(jScrollPane1);
        formManager.setValidationFromCsvResource("VdrSelect_Bind.csv");        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formManager.setTableColumnFromCsvResource(
    			jTable1, "CompanyTable", "CompanyTable", golfTableModel, "Vdrsd_table.csv");
        TableUtil.SetPreferedColumnWIdth(jTable1, new int[]{15,40,60,150,80 });         
        if (params.containsKey("_action")) {
            initAction(params);
        }        
    }
    private void initAction(HashMap params){
        formManager.getFormData().put("_action", params.get("_action"));
        formManager.getFormData().put("_cat", params.get("_cat"));        
        if (params.get("_action").equals("dataSelect")) {
            formManager.getFormData().put("_dataSelect", params.get("_dataSelect"));
        }
        
    }    

    public void processAction(HashMap params) {
        TrxUtil.setTableDataFromResult( "CompanyTable", (ResultData)params.get("_resultData"), formManager);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEnter;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextShort;
    // End of variables declaration//GEN-END:variables
    
}
