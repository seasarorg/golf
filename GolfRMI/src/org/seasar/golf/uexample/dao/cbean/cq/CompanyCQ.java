package org.seasar.golf.uexample.dao.cbean.cq;


import org.seasar.golf.uexample.dao.allcommon.cbean.ConditionQuery;
import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClause;
import org.seasar.golf.uexample.dao.cbean.cq.bs.BsCompanyCQ;

/**
 * The condition-query of {table.Name}.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class CompanyCQ extends BsCompanyCQ {

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
    public CompanyCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }
}
