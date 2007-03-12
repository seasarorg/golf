/*
 * VdrFrame.java
 *
 * Created on 2007/01/27, 16:22
 */

package org.seasar.golf.uexample.frame;

import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.seasar.golf.GolfForm;
import org.seasar.golf.data.DataUtil;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.transaction.RequestDataFactory;

/**
 *
 * @author  shimura
 */
public class VdrsFrame extends javax.swing.JFrame implements GolfForm{
    private FormManager formManager = null;
    //private GolfTableModel golfTableModel= new GolfTableModel();    
    /** Creates new form VdrFrame */
    public VdrsFrame() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        contentPane = new javax.swing.JPanel();
        toolBar = new javax.swing.JPanel();
        jTextAction = new javax.swing.JTextField();
        jB_Enter = new javax.swing.JButton();
        jB_Save = new javax.swing.JButton();
        jB_Back = new javax.swing.JButton();
        jB_Menu = new javax.swing.JButton();
        jB_NewWindow = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextCode = new javax.swing.JTextField();
        jTextShort = new javax.swing.JTextField();
        jTextName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextCat = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelFooter = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabelHeader = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        contentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contentPane.setDoubleBuffered(false);
        toolBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

        toolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextAction.setPreferredSize(new java.awt.Dimension(80, 22));
        jTextAction.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextActionKeyReleased(evt);
            }
        });

        toolBar.add(jTextAction);

        jB_Enter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FormRunHS.png")));
        jB_Enter.setToolTipText("Enter");
        jB_Enter.setPreferredSize(new java.awt.Dimension(25, 25));
        jB_Enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_EnterActionPerformed(evt);
            }
        });

        toolBar.add(jB_Enter);

        jB_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/saveHS.png")));
        jB_Save.setToolTipText("Save");
        jB_Save.setEnabled(false);
        jB_Save.setPreferredSize(new java.awt.Dimension(25, 25));
        toolBar.add(jB_Save);

        jB_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/NavBack.png")));
        jB_Back.setToolTipText("Back");
        jB_Back.setPreferredSize(new java.awt.Dimension(25, 25));
        jB_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BackActionPerformed(evt);
            }
        });

        toolBar.add(jB_Back);

        jB_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/book_addressHS.png")));
        jB_Menu.setToolTipText("Menu");
        jB_Menu.setPreferredSize(new java.awt.Dimension(25, 25));
        jB_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_MenuActionPerformed(evt);
            }
        });

        toolBar.add(jB_Menu);

        jB_NewWindow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/WindowsHS.png")));
        jB_NewWindow.setToolTipText("New Window");
        jB_NewWindow.setPreferredSize(new java.awt.Dimension(25, 25));
        jB_NewWindow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_NewWindowActionPerformed(evt);
            }
        });

        toolBar.add(jB_NewWindow);

        jLabel1.setText("\u30b3\u30fc\u30c9");

        jLabel2.setText("\u7701\u7565\u540d");

        jLabel3.setText("\u540d\u79f0");

        jLabel4.setText("\u4e0b\u8a18\u9805\u76ee\u3067\u9078\u629e\u3067\u304d\u307e\u3059\uff08\u524d\u65b9\u4e00\u81f4\uff09");

        jTextCat.setEditable(false);
        jTextCat.setForeground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.borderLight"));
        jTextCat.setBorder(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(731, 29));
        jLabel5.setFont(new java.awt.Font("MS UI Gothic", 0, 14));
        jLabel5.setText("Status Information");

        jLabelFooter.setFont(new java.awt.Font("MS UI Gothic", 1, 12));
        jLabelFooter.setForeground(java.awt.Color.blue);

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 27, Short.MAX_VALUE)
                .add(jLabelFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 645, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(jLabelFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(jLabel5))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 30));
        jLabel6.setFont(new java.awt.Font("�l�r �o����", 1, 24));
        jLabel6.setText("Golf Example System");

        jLabelHeader.setFont(new java.awt.Font("�l�r �o����", 1, 24));
        jLabelHeader.setForeground(java.awt.Color.blue);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelHeader)
                .addContainerGap(548, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(jLabelHeader))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout contentPaneLayout = new org.jdesktop.layout.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel4)
                    .add(contentPaneLayout.createSequentialGroup()
                        .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel3)
                            .add(jLabel2))
                        .add(15, 15, 15)
                        .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jTextName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .add(jTextShort)
                            .add(jTextCode))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 196, Short.MAX_VALUE)
                .add(jTextCat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 308, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .add(toolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPaneLayout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(contentPaneLayout.createSequentialGroup()
                        .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextCat, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(jTextCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(jTextShort, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(jTextName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 386, Short.MAX_VALUE)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jB_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BackActionPerformed
     formManager.getSession().processBackAction();
}//GEN-LAST:event_jB_BackActionPerformed

private void jB_EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EnterActionPerformed
    RequestData requestData = RequestDataFactory.createRequestData("vdrs",null,formManager);
    if (formManager.getFormData().containsKey("_action")) {
         if (formManager.getFormData().get("_action").equals("dataSelect")){
             DataUtil.copyParam(formManager.getFormData(), requestData.getParams(), "_dataSelect");
             DataUtil.copyParam(formManager.getFormData(), requestData.getParams(), "_action");
         }
    }
    formManager.getSession().trxExecute(requestData, formManager);
}//GEN-LAST:event_jB_EnterActionPerformed

private void jB_NewWindowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_NewWindowActionPerformed
    formManager.getSession().processMenuAction("@MENU");
}//GEN-LAST:event_jB_NewWindowActionPerformed

private void jB_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_MenuActionPerformed
    formManager.getSession().processMenuAction("MENU");
}//GEN-LAST:event_jB_MenuActionPerformed

private void jTextActionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextActionKeyReleased
    formManager.getSession().processActionTextField(evt,jTextAction);
}//GEN-LAST:event_jTextActionKeyReleased
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VdrFrame().setVisible(true);
            }
        });
    }
  
    public FormManager getFormManager() {
        return formManager;
    }

    public JMenuBar getMenu() {
        return jMenuBar1;
    }

    public JPanel getContentPanel() {
        return contentPane;
    }

    public void initBinding(HashMap params) {
        formManager.createReportList(jScrollPane1);
        formManager.setValidationFromCsvResource("vdrs_bind.csv");
        formManager.setValue("jTextCat",(String)params.get("_cat") );
        setTitle();
        if (params.containsKey("_action")) {
            initAction(params);
        }
    }
    private void setTitle() {
         String hdr = (jTextCat.getText().equals("V"))
                ?"Vendor Selection":"Customer Selection";
         jLabelHeader.setText(hdr);
        FrameUtil.setTitle(hdr, formManager);       
    }
    
    private void initAction(HashMap params){
        formManager.getFormData().put("_action", params.get("_action"));
        if (params.get("_action").equals("dataSelect")) {
            formManager.getFormData().put("_dataSelect", params.get("_dataSelect"));
        }
        
    }
    
    public void processAction(HashMap params) {
    }
    public void setFormManger(FormManager formManager) {
        this.formManager = formManager;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton jB_Back;
    private javax.swing.JButton jB_Enter;
    private javax.swing.JButton jB_Menu;
    private javax.swing.JButton jB_NewWindow;
    private javax.swing.JButton jB_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelFooter;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAction;
    private javax.swing.JTextField jTextCat;
    private javax.swing.JTextField jTextCode;
    private javax.swing.JTextField jTextName;
    private javax.swing.JTextField jTextShort;
    private javax.swing.JPanel toolBar;
    // End of variables declaration//GEN-END:variables
    
}
