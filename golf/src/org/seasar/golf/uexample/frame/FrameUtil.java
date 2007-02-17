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
    static void setHeaderText(String text, FormManager formManager){
        setHeaderText(text, formManager.getSession());
        formManager.getFrame().setTitle("Golf Example - " + text);
        
    }
    static void setHeaderText(String text, Session session){
        ((ContainerFrame)session.getContainerFrame()).getLabelHeader().setText(text);  
        ((ContainerFrame)session.getContainerFrame()).getLabelFooter().setText("");
    }    
}
