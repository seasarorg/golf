/*
 * TrxDispatcherLocalImpl.java
 *
 * Created on 2007/02/04, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction.impl;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.transaction.*;

/**
 *
 * @author shimura
 */
public class TrxDispatcherLocalImpl implements TrxDispatcherInterface {
    
    private HostTrxHandlerInterface hostTrxHandler = null;
    /** Creates a new instance of TrxDispatcherLocalImpl */
    public TrxDispatcherLocalImpl() {
    }
    
    public ResultData execute(RequestData requestData) {
        if (hostTrxHandler == null) {
            hostTrxHandler = HostTrxHandlerFactory.getHostTrxHandler();
        }
        return hostTrxHandler.execute(requestData);
    }

}
