/*
 * VdrFrame.java
 *
 * Created on 2007/01/27, 16:22
 */

package org.seasar.golf.uexample.frame;

import com.jgoodies.binding.list.SelectionInList;
import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import org.seasar.golf.GolfFormInterface;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.util.TableUtil;
import org.seasar.golf.transaction.RequestDataFactory;
import org.seasar.golf.transaction.TrxUtil;

/**
 *
 * @author  shimura
 */
public class VdrFrame extends javax.swing.JFrame implements GolfFormInterface{
    private FormManager formManager = null;
    private GolfTableModel golfTableModel= new GolfTableModel();    
    /** Creates new form VdrFrame */
    public VdrFrame() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        longField1 = new org.seasar.golf.component.LongField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        longField2 = new org.seasar.golf.component.LongField();
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

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
        jB_Back.setEnabled(false);
        jB_Back.setPreferredSize(new java.awt.Dimension(25, 25));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        longField1.setText("longField1");

        jLabel2.setText("TextField MIN \uff13\u6841 MAX\u3000\uff16\u6841");

        jLabel4.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel4.setText("IntegerField MIN 1 MAX\u300010");

        longField2.setText("longField1");

        jLabel7.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel7.setText("Short Date");

        jLabel5.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel5.setText("Long Date \u5fc5\u9808");

        jLabel3.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel3.setText("ComboBox \u5fc5\u9808");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBox1.setText("CheckBoxTest");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jRadioButton1.setText("test1");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(longField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel4)
                    .add(jLabel2)
                    .add(jLabel7)
                    .add(jLabel5)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jRadioButton1)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jComboBox1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jTextField4)
                        .add(jTextField3)
                        .add(longField1, 0, 0, Short.MAX_VALUE)
                        .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                        .add(jCheckBox1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(longField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(longField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel5)
                            .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jCheckBox1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jRadioButton1)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout contentPaneLayout = new org.jdesktop.layout.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPaneLayout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 424, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(toolBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(contentPaneLayout.createSequentialGroup()
                .add(toolBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(contentPaneLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(109, 109, 109))
        );

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(contentPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(contentPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 482, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jB_EnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EnterActionPerformed
    RequestData requestData = RequestDataFactory.createRequestData("vdr","mode=test",formManager);
    TrxUtil.setAllTableDataToRequest(requestData, formManager);
    formManager.getSession().trxExecute(requestData);
}//GEN-LAST:event_jB_EnterActionPerformed

private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
    if (TableUtil.checkRowDownEvent(evt)) {
        addNewRowWhenCursorLastRow();
    }
}//GEN-LAST:event_jTable1KeyPressed

private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    addNewRowWhenCursorLastRow();
}//GEN-LAST:event_jTable1MouseClicked

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
    private void addNewRow() {
                //TableUtil.addNewRow(golfTableModel);
                TableUtil.addNewRowWithItemNo (golfTableModel,1,10,5);
    }
                                  

    private void addNewRowWhenCursorLastRow() {
        if (jTable1.getSelectedRow() == jTable1.getRowCount() -1) {
            addNewRow();
        }
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
        formManager = new FormManager(this); 
        formManager.init();
        formManager.createReportList(jScrollPane1);
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        formManager.SetTableColumnFromCsvResource(
    			jTable1, "Test Table", "TestTable", golfTableModel, "Example2_table1.csv");
        for (int i=0; i < 5; i++) {
            addNewRow();
        }
        TableUtil.SetPreferedColumnWIdth(jTable1, new int[]{15,40,60,150,40,80 });  
        formManager.setValidationFromCsvResource("Example1_bind.csv");
        ((SelectionInList )formManager.getFormBindingManager().getValueModel("jComboBox1")).setListModel(
            new javax.swing.DefaultComboBoxModel(new String[] {"", "Item 11", "Item 22", "Item 33", "Item 44" }));        
    }

    public void processAction(HashMap params) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JButton jB_Back;
    private javax.swing.JButton jB_Enter;
    private javax.swing.JButton jB_Menu;
    private javax.swing.JButton jB_NewWindow;
    private javax.swing.JButton jB_Save;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextAction;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private org.seasar.golf.component.LongField longField1;
    private org.seasar.golf.component.LongField longField2;
    private javax.swing.JPanel toolBar;
    // End of variables declaration//GEN-END:variables
    
}
