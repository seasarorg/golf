/*
 * ContainerUtil.java
 *
 * Created on 2007/01/08, 21:14
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.containerFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.layout.GroupLayout;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.GolfFrameInterface;
import org.seasar.golf.example.frame.Example4ContainerFrame;

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

    public JFrame setForm(String newForm) {
        GolfFrameInterface newFrame = null;
        newFrame = (GolfFrameInterface) SingletonS2ContainerFactory.getContainer()
            .getComponent(newForm);
        container.getRootPane().setJMenuBar(newFrame.getMenu());
        String title = ((JFrame)newFrame).getTitle();
        if (title != null && title.length() > 0) {
            container.setTitle(title);
        } else {
            container.setTitle(container.getTitle());
        }
        GroupLayout layout = (GroupLayout)container.getContentPane().getLayout();
        if (currentPanel == null) {
            currentPanel = ((GolfFrameInterface)container).getContentPanel();
        }
        layout.replace(currentPanel, newFrame.getContentPanel());
        currentPanel = newFrame.getContentPanel();
        newFrame.setContainerFrame(container);
        newFrame.initBinding();
        return (JFrame)newFrame;
    }
    
}
