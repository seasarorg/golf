/*
 * HostTrxHandlerFactory.java
 *
 * Created on 2007/02/07, 20:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

/**
 *
 * @author shimura
 */
public class HostTrxHandlerFactory {
    
    /** Creates a new instance of HostTrxHandlerFactory */
    private static HostTrxHandlerInterface hostTrxHandler = null;
    private HostTrxHandlerFactory() {
    }
    public static HostTrxHandlerInterface getHostTrxHandler() {
        if (hostTrxHandler == null) {
            hostTrxHandler  = (HostTrxHandlerInterface) SingletonS2ContainerFactory
                    .getContainer().getComponent(HostTrxHandlerInterface.class);
        }
        return hostTrxHandler;
    }
    
}
