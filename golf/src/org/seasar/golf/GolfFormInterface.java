/*
 * GolfForm.java
 *
 * Created on 2007/01/06, 7:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.util.HashMap;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import org.seasar.golf.containerFrame.FormManager;

/**
 *
 * @author shimura
 */
public interface GolfFormInterface {

    FormManager getFormManager();
    JMenuBar getMenu();
    JPanel getContentPanel();
    void initBinding(HashMap params);
    void processAction(HashMap params);    
}
