
/*
 * VdrsFrame.java
 *
 * Created on 2007/01/28, 9:25
 */

package org.seasar.golf.uexample.frame;

import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.seasar.golf.GolfFormInterface;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author  shimura
 */
public class FrameTemplate extends javax.swing.JFrame implements GolfFormInterface{
    private FormManager formManager = null;
    /** Creates new form VdrsFrame */
    public FrameTemplate() {
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
        jB_Enter.setEnabled(false);
        jB_Enter.setPreferredSize(new java.awt.Dimension(25, 25));
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

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(497, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                new VdrsFrame().setVisible(true);
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
        formManager = new FormManager(this);
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextAction;
    private javax.swing.JPanel toolBar;
    // End of variables declaration//GEN-END:variables
    
}
