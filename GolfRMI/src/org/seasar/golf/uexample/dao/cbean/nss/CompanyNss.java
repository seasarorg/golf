package org.seasar.golf.uexample.dao.cbean.nss;


import org.seasar.golf.uexample.dao.cbean.cq.CompanyCQ;


/**
 * The nest select setupper.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class CompanyNss {

    /** Base query. */
    protected CompanyCQ _query;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     * 
     * @param query Base query. (NotNull)
     */
    public CompanyNss(CompanyCQ query) {
        _query = query;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public CompanyCQ query() {
        return _query;
    }

    public boolean hasConditionQuery() {
        return _query != null;
    }

    // =====================================================================================
    //                                                                           SetupSelect
    //                                                                           ===========

    // =====================================================================================
    //                                                                                Helper
    //                                                                                ======
    protected void assertConditionQuery() {
        if (!hasConditionQuery()) {
            String msg = "The query should not be null.";
            throw new IllegalStateException(msg);
        }
    }
}
