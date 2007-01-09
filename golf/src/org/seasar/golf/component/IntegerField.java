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
public class IntegerField extends javax.swing.JTextField  {
    
    /** Creates a new instance of IntegerTextField */
    public IntegerField() {
        super(null, null, 10);
    }
        public IntegerField(String text) {
        super(null, null, 10);
    }
    
    public void setText(String text){
        super.setText(null);
    }
      
    protected Document createDefaultModel() {
        return new IntegerDocument();
    }
    static class IntegerDocument extends PlainDocument {
         public void insertString(int offs, String str, AttributeSet a) 
 	          throws BadLocationException {
 
 	          if (str == null) {
 		      return;
                 }
                  StringBuffer sb = new StringBuffer();
 	          for (int i = 0; i < str.length(); i++) {
                      if (str.charAt(i) >= '0' && str.charAt(i) <= '9'  ) {
                         sb.append(str.charAt(i));
                      } 
 	 	  }
 	          super.insertString(offs, sb.toString(), a);
 	      }
     }
        
}

