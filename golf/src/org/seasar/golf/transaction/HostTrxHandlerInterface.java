/*
 * HostTrxHandlerInterface.java
 *
 * Created on 2007/02/04, 10:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;

/**
 *
 * @author shimura
 */
public interface HostTrxHandlerInterface {
    
    /** Creates a new instance of HostTrxHandlerInterface */

    public ResultData execute(RequestData requestData);  
}
