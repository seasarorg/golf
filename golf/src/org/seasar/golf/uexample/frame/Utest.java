/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.seasar.golf.uexample.frame;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.transaction.TrxDispatcherInterface;
import org.seasar.golf.util.GolfSetting;


/**
 *
 * @author shimura
 */
public class Utest {
    
    /** Creates a new instance of Utest */
    public Utest() {
    }

    public static void main(String args[]) {

        GolfSetting.setLookAndFeel();
        org.seasar.framework.container.factory.SingletonS2ContainerFactory.init();
        TrxDispatcherInterface trxDispatcher = (TrxDispatcherInterface) SingletonS2ContainerFactory.getContainer().getComponent(TrxDispatcherInterface.class );
        RequestData requestData = new RequestData();
        requestData.setTransactionCode("dummy");
        ResultData resultData = trxDispatcher.execute(requestData);  
        javax.swing.JFrame loginFrame = (javax.swing.JFrame) org.seasar.framework.container.factory.SingletonS2ContainerFactory.getContainer().getComponent("loginFrame");
        loginFrame.setVisible(true);
    }
    
}
