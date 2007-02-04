/*
 * TrxDispatcherInterface.java
 *
 * Created on 2007/02/04, 9:46
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
public interface TrxDispatcherInterface {
    
    /** Creates a new instance of TrxDispatcherInterface */
    public ResultData execute(RequestData requestData);

}
