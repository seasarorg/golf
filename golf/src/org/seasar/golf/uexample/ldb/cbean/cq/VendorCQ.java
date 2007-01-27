package org.seasar.golf.uexample.ldb.cbean.cq;


import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionQuery;
import org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause.SqlClause;
import org.seasar.golf.uexample.ldb.cbean.cq.bs.BsVendorCQ;

/**
 * The condition-query of {table.Name}.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class VendorCQ extends BsVendorCQ {

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
    public VendorCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }
}
