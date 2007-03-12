/*
 * Example4ContainerFrame.java
 *
 * Created on 2007/01/08, 20:48
 */

package org.seasar.golf.example.frame;

import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.seasar.golf.GolfForm;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author  shimura
 */
public class Example42Frame extends javax.swing.JFrame implements GolfForm{
    private FormManager formManager = null;    
    
    /** Creates new form Example4ContainerFrame */
    public Example42Frame() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        ContensPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Example 4-2 Title");
        ContensPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setText("Example 4-2");

        jLabel2.setText("XXXXXX");

        org.jdesktop.layout.GroupLayout ContensPanelLayout = new org.jdesktop.layout.GroupLayout(ContensPanel);
        ContensPanel.setLayout(ContensPanelLayout);
        ContensPanelLayout.setHorizontalGroup(
            ContensPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ContensPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 46, Short.MAX_VALUE)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 415, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        ContensPanelLayout.setVerticalGroup(
            ContensPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ContensPanelLayout.createSequentialGroup()
                .add(ContensPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ContensPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(ContensPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel2)))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(353, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");
        jMenuItem1.setText("Close");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Example 4-2");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ContensPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(ContensPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                new Example4ContainerFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContensPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public FormManager getFormManager() {
        return null;
    }

    public JMenuBar getMenu() {
        return jMenuBar1;
    }

    public JPanel getContentPanel() {
        return ContensPanel;
    }

    public void initBinding(HashMap params) {
        formManager = new FormManager(this);
        formManager.init();
        formManager.createReportList(jScrollPane1);
        formManager.setValidationFromCsvResource("Example4_2_bind.csv");
        formManager.setBindFromCsvResource("Example4_2_bind2.csv"); 
    }

    public void processAction(HashMap params) {
    }
    public void setFormManger(FormManager formManager) {
        this.formManager = formManager;
    }    
}
