/*
 * VdrTransaction.java
 *
 * Created on 2007/02/04, 10:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.uexample.Transaction;

import org.seasar.golf.data.RequestData;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.transaction.TransactionInterface;

/**
 *
 * @author shimura
 */
public class VdrTransaction implements TransactionInterface{
    
    /** Creates a new instance of VdrTransaction */
    public VdrTransaction() {
    }
    
    public ResultData execute(RequestData requestData) {
        ResultData resultData = new ResultData();
        return resultData;
    }

}