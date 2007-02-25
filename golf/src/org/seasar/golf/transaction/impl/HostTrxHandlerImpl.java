/*
 * HostTrxHandlerImpl.java
 *
 * Created on 2007/02/04, 10:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction.impl;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.transaction.*;

/**
 *
 * @author shimura
 */
public class HostTrxHandlerImpl implements HostTrxHandlerInterface{
    
    /** Creates a new instance of HostTrxHandlerImpl */
    public HostTrxHandlerImpl() {
    }
    
    public ResultData execute(RequestData requestData) {
       TransactionInterface transaction = 
               (TransactionInterface) SingletonS2ContainerFactory.getContainer().
               getComponent(requestData.getTransactionCode() + "TrxLogic");
       ResultData res = transaction.execute(requestData);
       
       return res;
    }

}
