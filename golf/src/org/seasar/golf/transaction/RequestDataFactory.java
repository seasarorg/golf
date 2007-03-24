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

package org.seasar.golf.transaction;

import org.seasar.golf.SessionUtil;
import org.seasar.golf.data.RequestData;
import org.seasar.golf.form.FormManager;

/**
 *
 * @author shimura
 */
public class RequestDataFactory {
    
    /**
     * Creates a new instance of RequestDataFactory
     */
    private RequestDataFactory() {
    }
    public static RequestData createRequestData(FormManager formManager){
        return createRequestData(null, null, formManager); 
    } 

    public static RequestData createRequestData(
            String transactionCode, String params, FormManager formManager){
        RequestData requestData = new RequestData();
        TrxUtil.setFieldDataToRequest(requestData, formManager);
        requestData.setTransactionCode(transactionCode);
        if (params != null){
            requestData.setParams(SessionUtil.getActionParameter(params));
        }
        
        return requestData;
        
    }
    
}
