/*
 * ResultData.java
 *
 * Created on 2007/02/04, 8:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.util.HashMap;
import org.seasar.golf.form.FormAction;

/**
 *
 * @author shimura
 */
public class ResultData {
    private HashMap fields = new HashMap();
    private HashMap tables = new HashMap(); 
    private FormAction formAction = new FormAction();
    /** Creates a new instance of ResultData */
    public ResultData() {
    }
    
}
