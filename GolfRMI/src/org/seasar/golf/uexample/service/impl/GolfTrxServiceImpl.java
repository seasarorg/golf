package org.seasar.golf.service.impl;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.service.GolfTrxService;
import org.seasar.golf.transaction.TransactionInterface;

public class GolfTrxServiceImpl implements GolfTrxService {

	public ResultData execute(RequestData requestData) {
        //S2Container cont = SingletonS2ContainerFactory.getContainer();
        TransactionInterface transaction = 
                (TransactionInterface) SingletonS2ContainerFactory.getContainer().
                getComponent(requestData.getTransactionCode() + "TrxLogic");
        ResultData res = transaction.execute(requestData);
         return res;		
//		ResultData resultData = new ResultData();
//		resultData.getFormAction().setFormStack(FormAction.FormStack.RESULT);
//		return resultData;
	}

}
