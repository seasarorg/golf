package org.seasar.golf.uexample.ldb.allcommon.cbean;


import org.seasar.golf.uexample.ldb.allcommon.dbmeta.DBMeta;
import org.seasar.golf.uexample.ldb.allcommon.dbmeta.DBMetaInstanceHandler;
import org.seasar.golf.uexample.ldb.allcommon.helper.MapListString;
import org.seasar.golf.uexample.ldb.allcommon.helper.MapListStringImpl;
import org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause.OrderByClause;
import org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause.SqlClause;
import org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause.SqlClausePostgreSql;


/**
 * The condition-bean as abstract.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractConditionBean implements ConditionBean {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** SQL clause instance. */
    protected final SqlClause _sqlClause = new SqlClausePostgreSql(getTableDbName());

    // =====================================================================================
    //                                                                             SqlClause
    //                                                                             =========
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Sql clause. (NotNull)
     */
    public SqlClause getSqlClause() {
        return _sqlClause;
    }

    // =====================================================================================
    //                                                                    Accept Primary-Key
    //                                                                    ==================
    /**
     * This method implements the method that is declared at super.
     * 
     * @param primaryKeyMapString Primary-key map. (NotNull and NotEmpty)
     */
    public void acceptPrimaryKeyMapString(String primaryKeyMapString) {
        if (primaryKeyMapString == null) {
            String msg = "The argument[primaryKeyMapString] must not be null.";
            throw new IllegalArgumentException(msg);
        }
        final String prefix = MAP_STRING_MAP_MARK + MAP_STRING_START_BRACE;
        final String suffix = MAP_STRING_END_BRACE;
        if (!primaryKeyMapString.trim().startsWith(prefix)) {
            primaryKeyMapString = prefix + primaryKeyMapString;
        }
        if (!primaryKeyMapString.trim().endsWith(suffix)) {
            primaryKeyMapString = primaryKeyMapString + suffix;
        }
        MapListString mapListString = new MapListStringImpl();
        mapListString.setMapMark(MAP_STRING_MAP_MARK);
        mapListString.setListMark(MAP_STRING_LIST_MARK);
        mapListString.setDelimiter(MAP_STRING_DELIMITER);
        mapListString.setStartBrace(MAP_STRING_START_BRACE);
        mapListString.setEndBrace(MAP_STRING_END_BRACE);
        mapListString.setEqual(MAP_STRING_EQUAL);
        acceptPrimaryKeyMap(mapListString.generateMap(primaryKeyMapString));
    }

    protected void checkTypeString(Object value, String propertyName, String typeName) {
        if (value == null) {
            throw new IllegalArgumentException("The value should not be null: " + propertyName);
        }
        if (!(value instanceof String)) {
            String msg = "The value of " + propertyName + " should be " + typeName + " or String: ";
            msg = msg + "valueType=" + value.getClass() + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }

    protected long parseDateString(Object value, String propertyName, String typeName) {
        checkTypeString(value, propertyName, typeName);
        try {
            return getDateFormat().parse((String)value).getTime();
        } catch (java.text.ParseException e) {
            String msg = "The value of " + propertyName + " should be " + typeName + ". but: " + value;
            throw new RuntimeException(msg + " threw the exception: value=[" + value + "]", e);
        } catch (RuntimeException e) {
            String msg = "The value of " + propertyName + " should be " + typeName + ". but: " + value;
            throw new RuntimeException(msg + " threw the exception: value=[" + value + "]", e);
        }
    }

    protected java.text.DateFormat getDateFormat() {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    // =====================================================================================
    //                                                                        FetchNarrowing
    //                                                                        ==============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch start index.
     */
    public int getFetchNarrowingSkipStartIndex() {
        return getSqlClause().getFetchNarrowingSkipStartIndex();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch size.
     */
    public int getFetchNarrowingLoopCount() {
        return getSqlClause().getFetchNarrowingLoopCount();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchNarrowingSkipStartIndexEffective() {
        return !getSqlClause().isFetchStartIndexSupported();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchNarrowingLoopCountEffective() {
        return !getSqlClause().isFetchSizeSupported();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determiantion.
     */
    public boolean isFetchNarrowingEffective() {
        return getSqlClause().isFetchNarrowingEffective();
    }

    // =====================================================================================
    //                                                                                Paging
    //                                                                                ======
    /**
     * This method implements the method that is declared at super.
     * 
     * @param fetchSize Fetch-size. (NotMinus & NotZero)
     * @return this. (NotNUll)
     */
    public PagingBean fetchFirst(int fetchSize) {
        getSqlClause().fetchFirst(fetchSize);
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param fetchStartIndex Fetch-start-index. 0 origin. (NotMinus)
     * @param fetchSize Fetch-size. (NotMinus & NotZero)
     * @return this. (NotNUll)
     */
    public PagingBean fetchScope(int fetchStartIndex, int fetchSize) {
        getSqlClause().fetchScope(fetchStartIndex, fetchSize);
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param fetchPageNumber Fetch-page-number. 1 origin. (NotMinus & NotZero)
     * @return this. (NotNull)
     */
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
    //                                                                               OrderBy
    //                                                                               =======
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Sql component of order-by clause. (NotNull)
     */
    public OrderByClause getSqlComponentOfOrderByClause() {
        return getSqlClause().getSqlComponentOfOrderByClause();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Order-by clause. (NotNull)
     */
    public String getOrderByClause() {
        return _sqlClause.getOrderByClause();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public OrderByBean clearOrderBy() {
        getSqlClause().clearOrderBy();
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public OrderByBean ignoreOrderBy() {
        getSqlClause().ignoreOrderBy();
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public OrderByBean makeOrderByEffective() {
        getSqlClause().makeOrderByEffective();
        return this;
    }

    /**
     * Register order-by-asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean registerOrderByAsc(String orderByProperty) {
        getSqlClause().registerOrderBy(filterOrderByProperty(orderByProperty), orderByProperty, true);
        return this;
    }

    /**
     * Register order-by-desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean registerOrderByDesc(String orderByProperty) {
        getSqlClause().registerOrderBy(filterOrderByProperty(orderByProperty), orderByProperty, false);
        return this;
    }

    /**
     * Reverse order-by or Override order-by asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean reverseOrderBy_Or_OverrideOrderByAsc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(filterOrderByProperty(orderByProperty), orderByProperty, true);
        return this;
    }

    /**
     * Reverse order-by or Override order-by desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean reverseOrderBy_Or_OverrideOrderByDesc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(filterOrderByProperty(orderByProperty), orderByProperty, false);
        return this;
    }

    protected String filterOrderByProperty(String orderByProperty) {
        final java.util.List<String> orderBySlashList = new java.util.ArrayList<String>();
        {
            final java.util.StringTokenizer st = new java.util.StringTokenizer(orderByProperty, "/");
            while (st.hasMoreElements()) {
                orderBySlashList.add(st.nextToken());
            }
        }

        final StringBuffer sb = new StringBuffer();
        DBMeta dbmeta = DBMetaInstanceHandler.getInstanceByTableDbName(getTableDbName());
        ConditionQuery query = this.getConditionQueryAsInterface();
        for (final java.util.Iterator ite = orderBySlashList.iterator(); ite.hasNext(); ) {
            final String orderBySlashElement = (String)ite.next();
	        final java.util.List<String> orderByDotList = new java.util.ArrayList<String>();
	        {
	            final java.util.StringTokenizer st = new java.util.StringTokenizer(orderBySlashElement, "/");
	            while (st.hasMoreElements()) {
	                orderByDotList.add(st.nextToken());
	            }
	        }

            if (orderByDotList.size() == 1) {
                if (dbmeta.isExistMultiName(orderBySlashElement)) {
                    sb.append("/").append(query.getRealColumnName(dbmeta.getDbNameByMultiName(orderBySlashElement)));
                } else {
                    sb.append("/").append(orderBySlashElement);
                }
            } else {
                DBMeta foreignDBMeta = dbmeta;
                ConditionQuery foreignQuery = query;
                int count = 0;
                for (final java.util.Iterator ite2 = orderByDotList.iterator(); ite2.hasNext(); ) {
                    String orderByDotElement = (String)ite2.next();
                    count++;

                    if (orderByDotList.size() == count) {// Last Loop!
                        if (!foreignDBMeta.isExistMultiName(orderByDotElement)) {
                            String msg = "The name for order-by is not existing: name=" + orderByDotElement;
                            msg = msg + " orderBySlashElement=" + orderBySlashElement + " orderByProperty=" + orderByProperty;
                            throw new IllegalStateException(msg);
                        }
                        sb.append("/").append(foreignQuery.getRealColumnName(foreignDBMeta.getDbNameByMultiName(orderByDotElement)));
                        break;
                    }

                    foreignDBMeta = foreignDBMeta.getForeignDBMeta(orderByDotElement);
                    foreignQuery = foreignQuery.getForeignConditionQuery(orderByDotElement);
                }
            }
        }
        sb.delete(0, "/".length());
        return sb.toString();
    }

    // =====================================================================================
    //                                                                          Limit Select
    //                                                                          ============
    /** Is limit-select PK only? */
    protected boolean _isLimitSelectPKOnly;

    /**
     * Is limit-select PK only?
     * 
     * @return Determination.
     */
    public boolean isLimitSelect_PKOnly() {
        return _isLimitSelectPKOnly;
    }

    /**
     * Limit select PK only.
     *
     * @return this. (NotNull)
     */
    public ConditionBean limitSelect_PKOnly() {
        _isLimitSelectPKOnly = true;
        return this;
    }

    /**
     * Limit select off.
     *
     * @return this. (NotNull)
     */
    public ConditionBean limitSelect_Off() {
        _isLimitSelectPKOnly = false;
        return this;
    }

    // =====================================================================================
    //                                                                               Advance
    //                                                                               =======
    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public ConditionBean lockForUpdate() {
        getSqlClause().lockForUpdate();
        return this;
    }

    // =====================================================================================
    //                                                                        For SqlComment
    //                                                                        ==============
    /**
     * Get select-hint. {select [select-hint] * from table...}
     * 
     * @return select-hint. (NotNull)
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
     * Get from-hint. {select * from table left outer join ... on ... [from-hint] where ...}
     * 
     * @return from-hint. (NotNull)
     */
    public String getFromHint() {
        return getSqlClause().getFromHint();
    }

    /**
     * Get where clause.
     * 
     * @return Where clause. (NotNull)
     */
    public String getWhereClause() {
        return getSqlClause().getWhereClause();
    }

    /**
     * Get sql-suffix. {select * from table where ... order by ... [sql-suffix]}
     * 
     * @return Sql-suffix.  (NotNull)
     */
    public String getSqlSuffix() {
        return getSqlClause().getSqlSuffix();
    }

    // ------------------------------
    //                   for Internal
    //                   ------------
    /**
     * Set up various things for select-count-ignore-fetch-scope.
     * This method is for INTERNAL. Don't invoke this!
     * 
     * @return this. (NotNull)
     */
    public ConditionBean setupSelectCountIgnoreFetchScope() {
        _isSelectCountIgnoreFetchScope = true;
        getSqlClause().ignoreIncludedSelectColumn();
        getSqlClause().ignoreOrderBy();
        getSqlClause().ignoreFetchScope();
        return this;
    }

    /**
     * Do after-care for select-count-ignore-fetch-scope.
     * This method is for INTERNAL. Don't invoke this!
     * 
     * @return this. (NotNull)
     */
    public ConditionBean afterCareSelectCountIgnoreFetchScope() {
        _isSelectCountIgnoreFetchScope = false;
        getSqlClause().makeIncludedSelectColumnEffective();
        getSqlClause().makeOrderByEffective();
        getSqlClause().makeFetchScopeEffective();
        return this;
    }

    /** Is set up various things for select-count-ignore-fetch-scope? */
    protected boolean _isSelectCountIgnoreFetchScope;

    /**
     * Is set up various things for select-count-ignore-fetch-scope?
     * This method is for INTERNAL. Don't invoke this!
     * 
     * @return Determination.
     */
    public boolean isSelectCountIgnoreFetchScope() {
        return _isSelectCountIgnoreFetchScope;
    }

}
