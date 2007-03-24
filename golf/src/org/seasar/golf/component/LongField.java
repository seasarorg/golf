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

package org.seasar.golf.component;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author shimura
 */
public class LongField extends javax.swing.JTextField  {

    /** Creates a new instance of IntegerTextField */
    public LongField() {
        super(null, null, 10);
    }
        public LongField(String text) {
        this();
    }
    
    public void setText(String text){
        super.setText(null);
    }
    
    public void setValue(Long i) {
        super.setText(i.toString());
    }
    public Long getValue() {
        try {
            return Long.parseLong(super.getText());
        } catch (NumberFormatException e) {
            return null;
        }

    }  
    protected Document createDefaultModel() {
        return new LongDocument();
    }
    
    static class LongDocument extends PlainDocument {
         public void insertString(int offs, String str, AttributeSet a) throws BadLocationException 
 	           {
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
            Long i;
            try {
                i =  Long.parseLong(newStr);
                super.insertString(offs, str, a);
            }
            catch ( NumberFormatException e) {
                return ;

            } 
         

         }
     }
}

