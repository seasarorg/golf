/*
 * Example1Frame.java
 *
 * Created on 2007/01/07, 9:49
 */

package org.seasar.golf.example.frame;

import com.jgoodies.binding.list.SelectionInList;
import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.seasar.golf.GolfFormInterface;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author  shimura
 */
public class Example1Frame extends javax.swing.JFrame  implements GolfFormInterface {
    private FormManager formManager = null;
    
    /** Creates new form Example1Frame */
    public Example1Frame() {
        initComponents();
 }
    public void initBinding(HashMap params) {
        formManager = new FormManager(this);
        formManager.init();
        formManager.createReportList(jScrollPane1);
        formManager.setValidationFromCsvResource("Example1_bind.csv");
        formManager.setBindFromCsvResource("Example1_bind2.csv");
        ((SelectionInList )formManager.getFormBindingManager().getValueModel("jComboBox1")).setListModel(
            new javax.swing.DefaultComboBoxModel(new String[] {"", "Item 11", "Item 22", "Item 33", "Item 44" }));

}
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel6 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelS = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelI = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabelCombo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabelDS = new javax.swing.JLabel();
        jLabelDL = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        longField1 = new org.seasar.golf.component.LongField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextFieldRadio = new javax.swing.JTextField();

        jLabel6.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel6.setText("ComboBox \u5fc5\u9808");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("�l�r �S�V�b�N", 0, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Golf Example 1");

        jLabel2.setText("TextField MIN \uff13\u6841 MAX\u3000\uff16\u6841");

        jLabelS.setText("XXXXXX");

        jLabel4.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel4.setText("IntegerField MIN 1 MAX\u300010");

        jLabelI.setText("XXXXXX");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel3.setText("ComboBox \u5fc5\u9808");

        jLabelCombo.setText("XXXXXX");

        jButton1.setText("\u3053\u306e\u30dc\u30bf\u30f3\u3092\u62bc\u3059\u3068\u5fc5\u9808\u30c1\u30a7\u30c3\u30af");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelDS.setText("XXXXXX");

        jLabelDL.setText("XXXXXX");

        jLabel5.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel5.setText("Long Date \u5fc5\u9808");

        jLabel7.setFont(new java.awt.Font("�l�r �o�S�V�b�N", 0, 12));
        jLabel7.setText("Short Date");

        longField1.setText("longField1");

        jCheckBox1.setText("CheckBoxTest");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jCheckBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("test1");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("test2");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("test3");
        jRadioButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton3.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(181, 181, 181)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                            .add(jLabel1)))
                    .add(layout.createSequentialGroup()
                        .add(147, 147, 147)
                        .add(jButton1))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel2)
                                    .add(jLabel4)
                                    .add(jLabel5)
                                    .add(jLabel7)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel3)
                                        .add(13, 13, 13)))
                                .add(28, 28, 28)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(longField1, 0, 0, Short.MAX_VALUE)
                                    .add(jComboBox1, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jTextField1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                    .add(jTextField4)
                                    .add(jTextField3)
                                    .add(jCheckBox1)))
                            .add(layout.createSequentialGroup()
                                .add(47, 47, 47)
                                .add(jRadioButton1)
                                .add(19, 19, 19)
                                .add(jRadioButton2)
                                .add(21, 21, 21)
                                .add(jRadioButton3)))
                        .add(28, 28, 28)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabelS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .add(jLabelI, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .add(jLabelCombo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .add(jLabelDS, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .add(jLabelDL, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .add(jCheckBox2)
                            .add(jTextFieldRadio))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelS))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelI)
                    .add(jLabel4)
                    .add(longField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(jLabelDL))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabelDS)
                            .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel7))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelCombo)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jCheckBox1)
                    .add(jCheckBox2))
                .add(25, 25, 25)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButton1)
                    .add(jRadioButton2)
                    .add(jRadioButton3)
                    .add(jTextFieldRadio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(30, 30, 30)
                .add(jButton1)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        formManager.getFormValidationManager().Validate(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Example1Frame().setVisible(true);
            }
        });
    }

    public FormManager getFormManager() {
        return formManager;
    }

    public JMenuBar getMenu() {
        return null;
    }

    public JPanel getContentPanel() {
        return null;
    }

    public void processAction(HashMap params) {
    }

    public void setFormManger(FormManager formManager) {
        this.formManager = formManager;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCombo;
    private javax.swing.JLabel jLabelDL;
    private javax.swing.JLabel jLabelDS;
    private javax.swing.JLabel jLabelI;
    private javax.swing.JLabel jLabelS;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldRadio;
    private org.seasar.golf.component.LongField longField1;
    // End of variables declaration//GEN-END:variables
    
}
