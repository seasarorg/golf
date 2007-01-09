/*
 * ValidationMessageLabelImpl.java
 *
 * Created on 2007/01/03, 12:50
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.util;

/**
 *
 * @author shimura
 */
public class ValidationMessageLabelImpl implements ValidationMessageLabel{
    
    /** Creates a new instance of ValidationMessageLabelImpl */
    public ValidationMessageLabelImpl() {
    }

    public String getMessageLabel(String label) {
                return (label == null) ? "":label+": ";
    }
    
}
