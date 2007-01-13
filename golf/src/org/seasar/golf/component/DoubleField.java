/*
 * IntegerTextField.java
 *
 * Created on 2006/12/24, 16:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.component;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author shimura
 */
public class DoubleField extends javax.swing.JTextField  {

    
    public DoubleField() {
        super(null, null, 10);
    }
    public DoubleField(String text) {
        super(null, null, 10);
    }
    public void setText(String text){
        super.setText(null);
    }
    public void setValue(Double i) {
        super.setText(i.toString());
    }
    public Double getValue() {
        return Double.parseDouble(super.getText());
    }      
    protected Document createDefaultModel() {
        return new DoubleDocument();
    }
    static class DoubleDocument extends PlainDocument {
         public void insertString(int offs, String str, AttributeSet a) 
 	          throws BadLocationException {
            String cur = null;
            String newStr = "";
            cur = getContent().getString(0,getContent().length()-1);
            int l = 0;
            if (cur != null) {
                l = cur.length();
            }

            if (l > 0) {
                if (offs > 0) {
                   newStr=cur.substring(0, offs);
                }
                newStr = newStr + str;

                if (l > offs) {
                     newStr = newStr + cur.substring(offs, l);
                }
            } else {
               newStr = str;
            }
            Double i =null;
            try {
                i = Double.parseDouble(newStr);
            }
            catch ( NumberFormatException e) {
                return ;
            }           
            super.insertString(offs, str, a);
         }
    }
        
}

