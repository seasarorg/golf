/*
 * FrameUtil.java
 *
 * Created on 2007/02/17, 16:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.frame;

import org.seasar.golf.Session;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class FrameUtil {
    
    /** Creates a new instance of FrameUtil */
    private FrameUtil() {
    }
    static void setTitle(String text, FormManager formManager){
        formManager.getFrame().setTitle("Golf Example - " + text);
        formManager.getSession().getContainerFrame().setTitle("Golf Example - " + text);
    }
}
