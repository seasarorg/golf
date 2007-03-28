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
package org.seasar.golf.service.impl;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.service.GolfTrxService;
import org.seasar.golf.transaction.TransactionInterface;

public class GolfTrxServiceImpl implements GolfTrxService {

	public ResultData execute(RequestData requestData) {
        TransactionInterface transaction = 
                (TransactionInterface) SingletonS2ContainerFactory.getContainer().
                getComponent(requestData.getTransactionCode() + "TrxLogic");
        ResultData res = transaction.execute(requestData);
         return res;		
	}

}
