package org.seasar.golf.uexample.dao.cbean.cq.ciq;

import org.seasar.golf.uexample.dao.cbean.cq.bs.*;
import org.seasar.golf.uexample.dao.cbean.cq.*;

import org.seasar.golf.uexample.dao.allcommon.cbean.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.ckey.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.cvalue.ConditionValue;
import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClause;


/**
 * The condition-query of {table.Name}.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class CompanyCIQ extends AbstractBsCompanyCQ {

    protected BsCompanyCQ _myCQ;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     * 
     * @param childQuery Child query as abstract class. (Nullable: If null, this is base instance.)
     * @param sqlClause SQL clause instance. (NotNull)
     * @param aliasName My alias name. (NotNull)
     * @param nestLevel Nest level.
     */
    public CompanyCIQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel, BsCompanyCQ myCQ) {
        super(childQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
    }

    // =====================================================================================
    //                                                                                 Query
    //                                                                                 =====
    protected void registerQuery(ConditionKey key, Object value, ConditionValue cvalue
                                                             , String colName, String capPropName, String uncapPropName) {
        registerInlineQuery(key, value, cvalue, colName, capPropName, uncapPropName);
    }

      
    // /* * * * * * * * * * * * * * * * * * * * * * *
    //   MyTable = [company]
    // * * * * * * * * */

  
    protected ConditionValue getCValueCcode() {
        return _myCQ.getCcode();
    }

                                                        
    protected ConditionValue getCValueCat() {
        return _myCQ.getCat();
    }

                                                        
    protected ConditionValue getCValueShortname() {
        return _myCQ.getShortname();
    }

                                                        
    protected ConditionValue getCValueName() {
        return _myCQ.getName();
    }

                                                        
    protected ConditionValue getCValueTelephone() {
        return _myCQ.getTelephone();
    }

                                                            
    protected ConditionValue getCValueVersionno() {
        return _myCQ.getVersionno();
    }

                                                        
}
