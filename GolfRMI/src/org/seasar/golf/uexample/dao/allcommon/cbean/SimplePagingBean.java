package org.seasar.golf.uexample.dao.allcommon.cbean;

import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClause;
import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClausePostgreSql;

/// <summary>
/// The condition-bean as interface.
/// Author: DBFlute(AutoGenerator)
/// </summary>
public class SimplePagingBean extends SimpleOrderByBean implements PagingBean {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** SQL clause instance. */
    protected final SqlClause _sqlClause;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public SimplePagingBean() {
        _sqlClause = new SqlClausePostgreSql("Dummy");
    }

    // =====================================================================================
    //                                                                             SqlClause
    //                                                                             =========
    /**
     * Get sql-clause.
     * 
     * @return Sql clause. (NotNull)
     */
    protected SqlClause getSqlClause() {
        return _sqlClause;
    }

    // =====================================================================================
    //                                                                        FetchNarrowing
    //                                                                        ==============
    /**
     * Get fetch-narrowing start-index.
     * 
     * @return Fetch-narrowing start-index.
     */
    public int getFetchNarrowingSkipStartIndex() {
        return getSqlClause().getFetchNarrowingSkipStartIndex();
    }

    /**
     * Get fetch-narrowing size.
     * 
     * @return Fetch-narrowing size.
     */
    public int getFetchNarrowingLoopCount() {
        return getSqlClause().getFetchNarrowingLoopCount();
    }

    /**
     * Is fetch start index supported?
     * 
     * @return Determination.
     */
    public boolean isFetchNarrowingSkipStartIndexEffective() {
        return !getSqlClause().isFetchStartIndexSupported();
    }

    /**
     * Is fetch size supported?
     * 
     * @return Determination.
     */
    public boolean isFetchNarrowingLoopCountEffective() {
        return !getSqlClause().isFetchSizeSupported();
    }

    /**
     * Is fetch-narrowing effective?
     * 
     * @return Determiantion.
     */
    public boolean isFetchNarrowingEffective() {
        return getSqlClause().isFetchNarrowingEffective();
    }

    // =====================================================================================
    //                                                                                Paging
    //                                                                                ======
    /// <summary>
    /// Fetch first.
    /// If you invoke this, your SQL returns [fetch-size] records from first.
    /// </summary>
    /// <param name="fetchSize">Fetch-size. (NotMinus & NotZero)</param>
    /// <returns>this. (NotNull)</returns>
    public PagingBean fetchFirst(int fetchSize) {
        getSqlClause().fetchFirst(fetchSize);
        return this;
    }

    /// <summary>
    /// Fetch scope.
    /// If you invoke this, your SQL returns [fetch-size] records from [fetch-start-index].
    /// </summary>
    /// <param name="fetchStartIndex">Fetch-start-index. 0 origin. (NotMinus)</param>
    /// <param name="fetchSize">Fetch-size. (NotMinus & NotZero)</param>
    /// <returns>this. (NotNull)</returns>
    public PagingBean fetchScope(int fetchStartIndex, int fetchSize) {
        getSqlClause().fetchScope(fetchStartIndex, fetchSize);
        return this;
    }

    /// <summary>
    /// Fetch page.
    /// When you invoke this, it is normally necessary to invoke 'fetchFirst()' or 'fetchScope()' ahead of that.
    /// But you also can use default-fetch-size without invoking 'fetchFirst()' or 'fetchScope()'.
    /// If you invoke this, your SQL returns [fetch-size] records from [fetch-start-index] calculated by [fetch-page-number].
    /// </summary>
    /// <param name="fetchPageNumber">Fetch-page-number. 1 origin. (NotMinus & NotZero)</param>
    /// <returns>this. (NotNull)</returns>
    public PagingBean fetchPage(int fetchPageNumber) {
        getSqlClause().fetchPage(fetchPageNumber);
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch-start-index.
     */
    public int getFetchStartIndex() {
        return getSqlClause().getFetchStartIndex();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch-size.
     */
    public int getFetchSize() {
        return getSqlClause().getFetchSize();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch-page-number.
     */
    public int getFetchPageNumber() {
        return getSqlClause().getFetchPageNumber();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Page start index. 0 origin. (NotMinus)
     */
    public int getPageStartIndex() {
        return getSqlClause().getPageStartIndex();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Page end index. 0 origin. (NotMinus)
     */
    public int getPageEndIndex() {
        return getSqlClause().getPageEndIndex();
    }

    /**
     * Is fetch scope effective?
     * 
     * @return Determiantion.
     */
    public boolean isFetchScopeEffective() {
        return getSqlClause().isFetchScopeEffective();
    }

    // =====================================================================================
    //                                                                        For SqlComment
    //                                                                        ==============
    /**
     * Get select-hint. {select [select-hint] * from table...}
     * 
     * @return Select-hint. (NotNull)
     */
    public String getSelectHint() {
        return getSqlClause().getSelectHint();
    }

    /**
     * Get from-base-table-hint. {select * from table [from-base-table-hint] where ...}
     * 
     * @return from-base-table-hint. (NotNull)
     */
    public String getFromBaseTableHint() {
        return getSqlClause().getFromBaseTableHint();
    }

    /**
     * Get from-hint. {select * from table [from-hint] where ...}
     * 
     * @return From-hint. (NotNull)
     */
    public String getFromHint() {
        return getSqlClause().getFromHint();
    }

    /**
     * Get sql-suffix. {select * from table where ... order by ... [sql-suffix]}
     * 
     * @return Sql-suffix. (NotNull)
     */
    public String getSqlSuffix() {
        return getSqlClause().getSqlSuffix();
    }
}
