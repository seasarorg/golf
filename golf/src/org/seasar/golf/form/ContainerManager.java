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

package org.seasar.golf.form;

import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jdesktop.layout.GroupLayout;
import org.seasar.golf.Factory;
import org.seasar.golf.GolfForm;

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
        GolfForm newFrame = null;
        newFrame = (GolfForm)Factory.createForm(newForm);
        newFrame.initBinding(null);
        return setForm(newFrame);
    }
    
    public JFrame setForm(GolfForm newFrame) {
        container.getRootPane().setJMenuBar(newFrame.getMenu());
        String title = ((JFrame)newFrame).getTitle();
        if (title != null && title.length() > 0) {
            container.setTitle(title);
        } else {
            container.setTitle(container.getTitle());
        }
        GroupLayout layout = (GroupLayout)container.getContentPane().getLayout();
        if (currentPanel == null) {
            currentPanel = ((GolfForm)container).getContentPanel();
        }
        layout.replace(currentPanel, newFrame.getContentPanel());
        currentPanel = newFrame.getContentPanel();
        //newFrame.setContainerFrame(container);
        return (JFrame)newFrame;        
    }
    
}
