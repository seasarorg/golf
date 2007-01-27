package org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause;


import java.util.Map;

import org.seasar.golf.uexample.ldb.allcommon.cbean.ckey.ConditionKey;
import org.seasar.golf.uexample.ldb.allcommon.cbean.cvalue.ConditionValue;

/**
 * The interface of SqlClause.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface SqlClause {

    // =====================================================================================
    //                                                                                Clause
    //                                                                                ======
    /**
     * Get clause string.
     * <p>
     * <pre>
     * EX.
     * # from [base-table] left outer join [fk-table] [fk-alias] on [join-condition]
     * # where [base-table].[column] = [value] and [fk-alias].[column] is null
     * # order by [base-table].[column] asc, [fk-alias].[column] desc
     * # for update
     * </pre>
     *
     * @return Clause string. (NotNull)
     */
    public String getClause();

    /**
     * Get select-hint. This is an internal method.
     * 
     * @return select-hint. {select [select-hint] * from table...} (NotNull)
     */
    public String getSelectHint();

    /**
     * Get included-select-column clause. This is an internal method.
     * 
     * @return Included-select-column clause. {select ... , [included-select-column clause] from table...} (NotNull)
     */
    public String getIncludedSelectColumnClause();

    /**
     * Get from clause. {from table left outer join foreign-table on ...}
     * 
     * @return From clause. (NotNull)
     */
    public String getFromClause();

    /**
     * Get from-base-table-hint. This is an internal method.
     * 
     * @return from-base-table-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    public String getFromBaseTableHint();

    /**
     * Get from-hint. This is an internal method.
     * 
     * @return from-hint. {select * from table left outer join ... on ... [from-hint] where ...} (NotNull)
     */
    public String getFromHint();

    /**
     * Get where clause. {where [base-table].[column] = [value] and [fk-alias].[column] is null}
     * 
     * @return Where clause. (NotNull)
     */
    public String getWhereClause();

    /**
     * Get order-by clause. {order by [base-table].[column] asc, [fk-alias].[column] desc}
     * 
     * @return Order-by clause. (NotNull)
     */
    public String getOrderByClause();

    /**
     * Get sql-suffix. This is an internal method.
     * 
     * @return sql-suffix. {select * from table where ... order by ... [sql-suffix]} (NotNull)
     */
    public String getSqlSuffix();

    // =====================================================================================
    //                                                                  IncludedSelectColumn
    //                                                                  ====================
    /**
     * Ignore included-select-column.
     */
    public void ignoreIncludedSelectColumn();

    /**
     * Make included-select-column effective.
     */
    public void makeIncludedSelectColumnEffective();

    /**
     * Register included-select-column.
     * 
     * @param aliasName Alias name. (NotNull)
     * @param realColumnName Real column name. (NotNull)
     */
    public void registerIncludedSelectColumn(String aliasName, String realColumnName);

    // =====================================================================================
    //                                                                             OuterJoin
    //                                                                             =========
    /**
     * Register outer join.
     * 
     * @param joinTableName Join table name(outer join [joinTableName]). (NotNull)
     * @param aliasName Alias name of join table. (NotNull and Unique per invoking method.)
     * @param joinOnMap Map that has conditions of 'on' clause. (NotNull)
     */
    public void registerOuterJoin(String joinTableName, String aliasName, Map<String, String> joinOnMap);

    // =====================================================================================
    //                                                                                 Where
    //                                                                                 =====
    /**
     * Register where clause.
     * 
     * @param columnFullName Column-full-name([table-name].[column-name]). (NotNull)
     * @param key Condition key. (NotNull)
     * @param value Condition value. (NotNull)
     */
    public void registerWhereClause(String columnFullName, ConditionKey key, ConditionValue value);

    /**
     * Register where clause.
     * 
     * @param clause Where-clause. (NotNull)
     */
    public void registerWhereClause(String clause);

    // =====================================================================================
    //                                                                           InlineWhere
    //                                                                           ===========
    public void registerBaseTableInlineWhereClause(String columnName, ConditionKey key, ConditionValue value);
    public void registerBaseTableInlineWhereClause(String value);
    public void registerOuterJoinInlineWhereClause(String aliasName, String columnName, ConditionKey key, ConditionValue value);
    public void registerOuterJoinInlineWhereClause(String aliasName, String value);

    // =====================================================================================
    //                                                                               OrderBy
    //                                                                               =======
    public OrderByClause getSqlComponentOfOrderByClause();

    /**
     * Clear order-by.
     * 
     * @return this. (NotNull)
     */
    public SqlClause clearOrderBy();

    /**
     * Ignore order-by.
     * 
     * @return this. (NotNull)
     */
    public SqlClause ignoreOrderBy();

    /**
     * Make order-by effective.
     * 
     * @return this. (NotNull)
     */
    public SqlClause makeOrderByEffective();

    public void registerOrderBy(String orderByProperty, String registeredOrderByProperty, boolean isAsc);

    public void reverseOrderBy_Or_OverrideOrderBy(String orderByProperty, String registeredOrderByProperty, boolean isAsc);

    // =====================================================================================
    //                                                                               Advance
    //                                                                               =======
    /**
     * Fetch first.
     * <p>
     * If you invoke this, your SQL returns [fetch-size] records from first.
     * If you invoke this, instance-variable[_fetchPageNumber] is initialized as one.
     * 
     * @param fetchSize Fetch-size. (NotMinus)
     * @return this. (NotNull)
     */
    public SqlClause fetchFirst(int fetchSize);

    /**
     * Fetch scope.
     * <p>
     * If you invoke this, your SQL returns [fetch-size] records from [fetch-start-index].
     * If you invoke this, instance-variable[_fetchPageNumber] is initialized as one.
     * 
     * @param fetchStartIndex Fetch-start-index. 0 origin. (NotMinus)
     * @param fetchSize Fetch-size. (NotMinus)
     * @return this. (NotNull)
     */
    public SqlClause fetchScope(int fetchStartIndex, int fetchSize);

    /**
     * Fetch page.
     * <p>
     * When you invoke this, it is normally necessary to invoke 'fetchFirst()' or 'fetchScope()' ahead of that.
     * But you also can use default-fetch-size without invoking 'fetchFirst()' or 'fetchScope()'.
     * If you invoke this, your SQL returns [fetch-size] records from [fetch-start-index] calculated by [fetch-page-number].
     * 
     * @param fetchPageNumber Fetch-page-number. 1 origin. (NotMinus & NotZero)
     * @return this. (NotNull)
     */
    public SqlClause fetchPage(int fetchPageNumber);

    /**
     * Get fetch start index.
     * 
     * @return Fetch start index.
     */
    public int getFetchStartIndex();

    /**
     * Get fetch size.
     * 
     * @return Fetch size.
     */
    public int getFetchSize();

    /**
     * Get fetch page number.
     * 
     * @return Fetch page number.
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

    /**
     * Ignore fetch-scope.
     * 
     * @return this. (NotNull)
     */
    public SqlClause ignoreFetchScope();

    /**
     * Make fetch-scope effective.
     * 
     * @return this. (NotNull)
     */
    public SqlClause makeFetchScopeEffective();

    /**
     * Is fetch start index supported?
     * 
     * @return Determination.
     */
    public boolean isFetchStartIndexSupported();

    /**
     * Is fetch size supported?
     * 
     * @return Determination.
     */
    public boolean isFetchSizeSupported();

    /**
     * Is fetch-narrowing effective?
     * 
     * @return Determiantion.
     */
    public boolean isFetchNarrowingEffective();

    /**
     * Get fetch-narrowing skip-start-index.
     * 
     * @return Skip-start-index.
     */
    public int getFetchNarrowingSkipStartIndex();

    /**
     * Get fetch-narrowing loop-count.
     * 
     * @return Loop-count.
     */
    public int getFetchNarrowingLoopCount();

    /**
     * Lock for update.
     * <p>
     * If you invoke this, your SQL lock target records for update.
     * It depends whether this method supports this on the database type.
     * 
     * @return this. (NotNull)
     */
    public SqlClause lockForUpdate();
}
