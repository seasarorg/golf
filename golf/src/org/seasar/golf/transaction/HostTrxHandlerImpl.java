/*
 * HostTrxHandlerImpl.java
 *
 * Created on 2007/02/04, 10:18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;

/**
 *
 * @author shimura
 */
public class HostTrxHandlerImpl implements HostTrxHandlerInterface{
    
    /** Creates a new instance of HostTrxHandlerImpl */
    public HostTrxHandlerImpl() {
    }
    
    public ResultData execute(RequestData requestData) {
        S2Container cont = SingletonS2ContainerFactory.getContainer();
       TransactionInterface transaction = 
               (TransactionInterface) SingletonS2ContainerFactory.getContainer().
               getComponent(requestData.getTransactionCode() + "Transaction");
       ResultData res = transaction.execute(requestData);
       
       return res;
    }

}
