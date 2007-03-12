/*
 * GolfDialogInterface.java
 *
 * Created on 2007/03/12, 19:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.util.HashMap;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public interface GolfDialog {
    FormManager getFormManager();
    void setFormManger(FormManager formManager);
    void initBinding(HashMap params);
    void processAction(HashMap params);      
}
