/*
 * DataUtil.java
 *
 * Created on 2007/03/10, 19:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.data;

import java.util.HashMap;

/**
 *
 * @author shimura
 */
public class DataUtil {
    
    /** Creates a new instance of DataUtil */
    private DataUtil() {
    }
    public static void copyParam(HashMap from, HashMap to, String key) {
        to.put(key, from.get(key));
        
    }
}
