/*
 * ContainerUtil.java
 *
 * Created on 2007/01/08, 21:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.form;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.layout.GroupLayout;
import org.seasar.golf.Factory;
import org.seasar.golf.GolfFormInterface;

/**
 *
 * @author shimura
 */
public class ContainerManager {
    private JFrame container;
    private JPanel currentPanel = null;
    
    /** Creates a new instance of ContainerUtil */
    public ContainerManager(JFrame container) {
        this.container = container;
    }

    public JFrame createFormAndSetForm(String newForm) {
        GolfFormInterface newFrame = null;
        newFrame = (GolfFormInterface)Factory.createForm(newForm);
        newFrame.initBinding(null);
        return setForm(newFrame);
    }
    
    public JFrame setForm(GolfFormInterface newFrame) {
        container.getRootPane().setJMenuBar(newFrame.getMenu());
        String title = ((JFrame)newFrame).getTitle();
        if (title != null && title.length() > 0) {
            container.setTitle(title);
        } else {
            container.setTitle(container.getTitle());
        }
        GroupLayout layout = (GroupLayout)container.getContentPane().getLayout();
        if (currentPanel == null) {
            currentPanel = ((GolfFormInterface)container).getContentPanel();
        }
        layout.replace(currentPanel, newFrame.getContentPanel());
        currentPanel = newFrame.getContentPanel();
        //newFrame.setContainerFrame(container);
        return (JFrame)newFrame;        
    }
    
}
