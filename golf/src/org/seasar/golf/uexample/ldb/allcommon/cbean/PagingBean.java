package org.seasar.golf.uexample.ldb.allcommon.cbean;

/**
 * The paging-bean as interface.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface PagingBean extends FetchNarrowingBean, OrderByBean {

    /**
     * Fetch first.
     * 
     * If you invoke this, your SQL returns [fetch-size] records from first.
     * 
     * @param fetchSize Fetch-size. (NotMinus & NotZero)
     * @return this. (NotNUll)
     */
    public PagingBean fetchFirst(int fetchSize);

    /**
     * Fetch scope.
     * 
     * If you invoke this, your SQL returns [fetch-size] records from [fetch-start-index].
     * 
     * @param fetchStartIndex Fetch-start-index. 0 origin. (NotMinus)
     * @param fetchSize Fetch-size. (NotMinus & NotZero)
     * @return this. (NotNUll)
     */
    public PagingBean fetchScope(int fetchStartIndex, int fetchSize);

    /**
     * Fetch page.
     * 
     * When you invoke this, it is normally necessary to invoke 'fetchFirst()' or 'fetchScope()' ahead of that.
     * But you also can use default-fetch-size without invoking 'fetchFirst()' or 'fetchScope()'.
     * If you invoke this, your SQL returns [fetch-size] records from [fetch-start-index] calculated by [fetch-page-number].
     * 
     * @param fetchPageNumber Fetch-page-number. 1 origin. (NotMinus & NotZero)
     * @return this. (NotNull)
     */
    public PagingBean fetchPage(int fetchPageNumber);

    /**
     * Get fetch-start-index.
     * 
     * @return Fetch-start-index.
     */
    public int getFetchStartIndex();

    /**
     * Get fetch-size.
     * 
     * @return Fetch-size.
     */
    public int getFetchSize();

    /**
     * Get fetch-page-number.
     * 
     * @return Fetch-page-number.
     */
    public int getFetchPageNumber();

    /**
     * Get page start index.
     * 
     * @return Page start index. 0 origin. (NotMinus)
     */
    public int getPageStartIndex();

    /**
     * Get page end index.
     * 
     * @return Page end index. 0 origin. (NotMinus)
     */
    public int getPageEndIndex();

    /**
     * Is fetch scope effective?
     * 
     * @return Determiantion.
     */
    public boolean isFetchScopeEffective();

    // =====================================================================================
    //                                                                        For SqlComment
    //                                                                        ==============
    /**
     * Get select-hint. {select [select-hint] * from table...}
     * 
     * @return Select-hint. (NotNull)
     */
    public String getSelectHint();

    /**
     * Get from-hint. {select * from table [from-hint] where ...}
     * 
     * @return From-hint. (NotNull)
     */
    public String getFromHint();

    /**
     * Get sql-suffix. {select * from table where ... order by ... [sql-suffix]}
     * 
     * @return Sql-suffix. (NotNull)
     */
    public String getSqlSuffix();
}
