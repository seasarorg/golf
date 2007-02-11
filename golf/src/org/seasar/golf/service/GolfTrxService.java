/*
 * GolfTrxService.java
 *
 * Created on 2007/02/10, 11:10
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.service;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;

/**
 *
 * @author shimura
 */
public interface GolfTrxService {
    
    /** Creates a new instance of GolfTrxService */
    public ResultData execute(RequestData requestData);
    
}
