/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.seasar.golf.uexample.frame;

import java.math.BigDecimal;
import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.seasar.golf.GolfForm;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.form.DataSelect;
import org.seasar.golf.form.FormAction;
import org.seasar.golf.form.FormAction.FormStack;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.transaction.RequestDataFactory;
import org.seasar.golf.transaction.TrxUtil;

/**
 *
 * @author  shimura
 */
public class VdriFrame extends javax.swing.JFrame implements GolfForm{
    private FormManager formManager = null;
    private String cat="";
 //   private GolfTableModel golfTableModel= new GolfTableModel();    
    /** Creates new form VdrFrame */
    public VdriFrame() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        toolBar = new javax.swing.JPanel();
        jTextAction = new javax.swing.JTextField();
        jB_Enter = new javax.swing.JButton();
        jB_Save = new javax.swing.JButton();
        jB_Back = new javax.swing.JButton();
        jB_Menu = new javax.swing.JButton();
        jB_NewWindow = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabelHeader = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelFooter = new javax.swing.JLabel();
        jTextCcode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelCopyFrom = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuCreate = new javax.swing.JMenuItem();
        jMenuUpdate = new javax.swing.JMenuItem();
        jMenuDisplay = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        toolBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        toolBar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0));

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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(731, 29));

        jLabel6.setFont(new java.awt.Font("MS UI Gothic", 0, 14));
        jLabel6.setText("Status Information");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jLabel6)
                .addContainerGap(684, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jLabel6)
        );

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
                .addContainerGap()
                .add(jLabel8)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelHeader)
                .addContainerGap(546, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jLabelHeader))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelFooter.setFont(new java.awt.Font("MS UI Gothic", 1, 12));
        jLabelFooter.setForeground(java.awt.Color.blue);

        jLabel2.setText("\u30b3\u30fc\u30c9");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FindHS.png")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelCopyFrom.setText("Copy From");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/FindHS.png")));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout contentPaneLayout = new org.jdesktop.layout.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPaneLayout.createSequentialGroup()
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 796, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelFooter, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .add(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabelCopyFrom)
                .add(3, 3, 3)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextCcode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 215, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 332, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(28, 28, 28))
            .add(contentPaneLayout.createSequentialGroup()
                .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, toolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPaneLayout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jTextCcode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jLabel2)
                        .add(jLabelCopyFrom))
                    .add(jButton1)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 397, Short.MAX_VALUE)
                .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(contentPaneLayout.createSequentialGroup()
                        .add(jLabelFooter, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Mode");

        jMenuCreate.setText("\u65b0\u898f");
        jMenuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCreateActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuCreate);

        jMenuUpdate.setText("\u66f4\u65b0");
        jMenuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUpdateActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUpdate);

        jMenuDisplay.setText("\u8868\u793a");
        jMenuDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDisplayActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuDisplay);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 799, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   FormAction formAction = new FormAction();
   formAction.setFormStack(FormStack.DIALOG);
   formAction.setForm("vdrSelect");
   formAction.getParams().put("_cat", cat);
   formAction.getParams().put("_action","dataSelect");
   formAction.getParams().put("_dataSelect",new DataSelect(formManager,"ccode"));
   formManager.getSession().processAction(formAction, null);
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   FormAction formAction = new FormAction();
   formAction.setFormStack(FormStack.NEXT);
   formAction.setForm("vdrs");
   formAction.getParams().put("_cat", cat);
   formAction.getParams().put("_action","dataSelect");
   formAction.getParams().put("_dataSelect",new DataSelect(formManager,"ccode"));
   formManager.getSession().processAction(formAction, null);
}//GEN-LAST:event_jButton1ActionPerformed

private void jMenuDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDisplayActionPerformed
    setMode("R");
}//GEN-LAST:event_jMenuDisplayActionPerformed

private void jMenuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUpdateActionPerformed
    setMode("U");
}//GEN-LAST:event_jMenuUpdateActionPerformed

private void jMenuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCreateActionPerformed
    formManager.setValue("jTextCcode", "");
    setMode("C");
}//GEN-LAST:event_jMenuCreateActionPerformed

private void jB_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BackActionPerformed
     formManager.getSession().processBackAction();
}//GEN-LAST:event_jB_BackActionPerformed

private void jB_EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EnterActionPerformed
    RequestData requestData = RequestDataFactory.createRequestData("vdri",null,formManager);
    requestData.setParam("_cat",cat);
    requestData.setParam("_mode", formManager.getMode());
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
        formManager.setValidationFromCsvResource("vdri_bind.csv");   
        formManager.setModeControlFromCsvResource("vdri_mode.csv");
        cat = (String)params.get("_cat");
        if (params.containsKey("_mode")) {
            setMode((String)params.get("_mode"));
        } else {
            setMode("R");
        }
    }

    public void processAction(HashMap params) {
         if (params.containsKey("_dataSelect")) {
            DataSelect select = (DataSelect)params.get("_dataSelect");
            if (select.getRequestField().equals("ccode")) {
                formManager.setValue("jTextCcode", ((BigDecimal)select.getSelectedDatum()).toString());
            }
        }
         else if (params.containsKey("_action")) {
             String action = (String)params.get("_action");
             ResultData resultData = (ResultData)params.get("_resultData");
             if (action.equals("DeleteComple")) {
                formManager.setValue("jTextCcode", "");   
                formManager.getFormValidationManager().setHostResult(resultData);
             }

        }             

    }
    public void setFormManger(FormManager formManager) {
        this.formManager = formManager;
    }

    private void setMode(String mode) {
        formManager.setMode(mode);
        setTitle();
    }
    private void setTitle() {
        String title = (cat.equals("V")) ? "Vendor ":"Customer";
        if (formManager.getMode().equals("R")) {
            title = title +  "�\��";
        }
        if (formManager.getMode().equals("U")) {
            title = title +  "�X�V";
        }
        if (formManager.getMode().equals("C")) {
            title = title +  "�V�K";
        }   
        jLabelHeader.setText(title);        
        FrameUtil.setTitle(title, formManager);        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton jB_Back;
    private javax.swing.JButton jB_Enter;
    private javax.swing.JButton jB_Menu;
    private javax.swing.JButton jB_NewWindow;
    private javax.swing.JButton jB_Save;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCopyFrom;
    private javax.swing.JLabel jLabelFooter;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCreate;
    private javax.swing.JMenuItem jMenuDisplay;
    private javax.swing.JMenuItem jMenuUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextAction;
    private javax.swing.JTextField jTextCcode;
    private javax.swing.JPanel toolBar;
    // End of variables declaration//GEN-END:variables
    
}
