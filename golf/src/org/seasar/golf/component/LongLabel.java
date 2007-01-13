/*
 * LongLable.java
 *
 * Created on 2007/01/13, 10:54
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.component;

import javax.swing.JLabel;

/**
 *
 * @author shimura
 */
public class LongLabel extends JLabel {
    
    /** Creates a new instance of LongLable */
    public LongLabel() {
    }
    public void setValue(String t) {
           this.setText(t);
    }
    public void setValue (Long v) {
        if (v!= null) {
            this.setText(v.toString());
        } else {
            this.setText(null);
        }
    }
}
