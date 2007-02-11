/*
 * TrxDispatcherLocalImpl.java
 *
 * Created on 2007/02/04, 10:17
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.transaction.impl;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.service.GolfTrxService;
import org.seasar.golf.transaction.*;

/**
 *
 * @author shimura
 */
public class TrxDispatcherRmilImpl implements TrxDispatcherInterface {
    
    /** Creates a new instance of TrxDispatcherLocalImpl */
    public TrxDispatcherRmilImpl() {
    }
    private GolfTrxService golfTrxService; 
    
    public ResultData execute(RequestData requestData) {
        if (golfTrxService == null) {
            golfTrxService = (GolfTrxService) SingletonS2ContainerFactory.getContainer().getComponent("golfTrxService");
        }
        return golfTrxService.execute(requestData);
    }

    public GolfTrxService getGolfTrxService() {
        return golfTrxService;
    }

    public void setGolfTrxService(GolfTrxService golfTrxService) {
        this.golfTrxService = golfTrxService;
    }

}
