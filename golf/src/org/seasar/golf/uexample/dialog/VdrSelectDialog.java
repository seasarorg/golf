/*
 * VdrSelectDialog.java
 *
 * Created on 2007/03/12, 20:46
 */

package org.seasar.golf.uexample.dialog;

import java.awt.Dialog;
import java.util.HashMap;
import javax.swing.JRootPane;
import org.seasar.golf.GolfDialog;
import org.seasar.golf.form.FormManager;

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
 //   private GolfTableModel golfTableModel= new GolfTableModel();        
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelHeader = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextShort = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonSelect = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 30));
        jLabel8.setFont(new java.awt.Font("�l�r �o����", 1, 24));
        jLabel8.setText("Golf Example System");

        jLabelHeader.setFont(new java.awt.Font("�l�r �o����", 1, 24));
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
                .addContainerGap(201, Short.MAX_VALUE))
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

        jButtonSelect.setText("Select");
        jButtonSelect.setMargin(new java.awt.Insets(2, 2, 2, 2));

        jButtonCancel.setText("Cancel");
        jButtonCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jButtonSelect)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTextShort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 72, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButtonCancel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 449, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 424, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButtonSelect)
                            .add(jButtonCancel)))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 203, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    }

    public void processAction(HashMap params) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextShort;
    // End of variables declaration//GEN-END:variables
    
}