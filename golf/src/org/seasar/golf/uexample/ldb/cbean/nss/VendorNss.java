package org.seasar.golf.uexample.ldb.cbean.nss;


import org.seasar.golf.uexample.ldb.cbean.cq.VendorCQ;


/**
 * The nest select setupper.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class VendorNss {

    /** Base query. */
    protected VendorCQ _query;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     * 
     * @param query Base query. (NotNull)
     */
    public VendorNss(VendorCQ query) {
        _query = query;
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    public VendorCQ query() {
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
