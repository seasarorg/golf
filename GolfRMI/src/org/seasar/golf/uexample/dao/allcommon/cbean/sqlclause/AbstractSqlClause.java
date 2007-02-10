package org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause;


import org.seasar.golf.uexample.dao.allcommon.cbean.ckey.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.cvalue.ConditionValue;

/**
 * The abstract class of SqlClause.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractSqlClause implements SqlClause {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Target table name. */
    protected final String _tableName;

    /** Included select column map. */
    protected java.util.Map<String, String> _includedSelectColumnMap = new java.util.LinkedHashMap<String, String>();

    /** Outer join map. */
    protected java.util.Map<String, LeftOuterJoinInfo> _outerJoinMap = new java.util.LinkedHashMap<String, LeftOuterJoinInfo>();

    /** Where list. */
    protected java.util.List<String> _whereList = new java.util.ArrayList<String>();

    /** Inline where list for BaseTable. */
    protected java.util.List<String> _baseTableInlineWhereList = new java.util.ArrayList<String>();

    /** Order-by clause. */
    protected final OrderByClause _orderByClause = new OrderByClause();

    /** Is incoluded-select-column effective? Default value is false. */
    protected boolean _isIncludedSelectColumnEffective = false;

    /** Is order-by effective? Default value is false. */
    protected boolean _isOrderByEffective = false;

    /** Fetch start index. (for fetchXxx()) */
    protected int _fetchStartIndex = 0;

    /** Fetch size. (for fetchXxx()) */
    protected int _fetchSize = 0;

    /** Fetch page number. (for fetchXxx()) This value should be plus. */
    protected int _fetchPageNumber = 1;

    /** Is fetch-narrowing effective? Default value is false. */
    protected boolean _isFetchScopeEffective = false;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     * 
     * @param tableName Table name. (NotNull)
     **/
    public AbstractSqlClause(String tableName) {
        if (tableName == null) {
            String msg = "Argument[tableName] must not be null.";
            throw new IllegalArgumentException(msg);
        }
        _tableName = tableName;
    }

    // =====================================================================================
    //                                                                                Clause
    //                                                                                ======
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Clause string. (NotNull)
     */
    public String getClause() {
        final StringBuffer sb = new StringBuffer(128);
        if (_isIncludedSelectColumnEffective && !_includedSelectColumnMap.isEmpty()) {
            sb.append(" ").append(getIncludedSelectColumnClause());
        }
        sb.append(" ");
        sb.append(getFromClause());
        sb.append(" ");
        sb.append(getFromHint());
        sb.append(" ");
        sb.append(getWhereClause());

        if (_isOrderByEffective && !_orderByClause.isEmpty()) {
            sb.append(" ");
            sb.append(getOrderByClause());
        }
        sb.append(" ");
        sb.append(getSqlSuffix());
        return sb.toString();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return select-hint. {select [select-hint] * from table...} (NotNull)
     */
    public String getSelectHint() {
        return createSelectHint();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Included-select-column clause. {select ... , [included-select-column clause] from table...} (NotNull)
     */
    public String getIncludedSelectColumnClause() {
        final StringBuffer sb = new StringBuffer();
        int count = 0;
        for (final java.util.Iterator ite = _includedSelectColumnMap.keySet().iterator(); ite.hasNext(); count++) {
            final String aliasName = (String)ite.next();
            final String realColumnName = (String)_includedSelectColumnMap.get(aliasName);
            sb.append(", ").append(realColumnName).append(" as ").append(aliasName);
        }
        return sb.toString();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return From clause. (NotNull)
     */
    public String getFromClause() {
        final StringBuffer sb = new StringBuffer();
        sb.append("from ");
        if (_baseTableInlineWhereList.isEmpty()) {
            sb.append(_tableName);
        } else {
            sb.append(getInlineViewClause(_tableName, _baseTableInlineWhereList)).append(" ").append(_tableName);
        }
        sb.append(getFromBaseTableHint());
        sb.append(getLeftOuterJoinClause());
        return sb.toString();
    }

    protected String getLeftOuterJoinClause() {
        final StringBuffer sb = new StringBuffer();
        for (final java.util.Iterator ite = _outerJoinMap.keySet().iterator(); ite.hasNext(); ) {
            final String aliasName = (String)ite.next();
            final LeftOuterJoinInfo joinInfo = (LeftOuterJoinInfo)_outerJoinMap.get(aliasName);
            final String joinTableName = joinInfo.getJoinTableName();
            final java.util.List<String> inlineWhereClauseList = joinInfo.getInlineWhereClauseList();
            final java.util.Map<String, String> joinOnMap = joinInfo.getJoinOnMap();
            assertJoinOnMapNotEmpty(joinOnMap, aliasName);

            sb.append(" left outer join ");
            if (inlineWhereClauseList.isEmpty()) {
                sb.append(joinTableName);
            } else {
                sb.append(getInlineViewClause(joinTableName, inlineWhereClauseList));
            }
            sb.append(" ").append(aliasName).append(" on ");
            int count = 0;
            for (final java.util.Iterator joinOnMapIte = joinOnMap.keySet().iterator(); joinOnMapIte.hasNext(); count++) {
                final String localColumnName = (String)joinOnMapIte.next();
                final String foreignColumnName = (String)joinOnMap.get(localColumnName);
                if (count != 0) {
                    sb.append(" and ");
                }
                sb.append(localColumnName).append(" = ").append(foreignColumnName);
            }
        }
        return sb.toString();
    }

    protected String getInlineViewClause(String joinTableName, java.util.List<String> inlineWhereClauseList) {
        final StringBuffer sb = new StringBuffer();
        sb.append("(select * from ").append(joinTableName).append(" where ");
        int count = 0;
        for (final java.util.Iterator ite = inlineWhereClauseList.iterator(); ite.hasNext(); ) {
            final String whereClause = (String)ite.next();
            if (count > 0) {
                sb.append(" and ");
            }
            sb.append(whereClause);
            ++count;
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return from-base-table-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    public String getFromBaseTableHint() {
        return createFromBaseTableHint();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return from-hint. {select * from table left outer join ... on ... [from-hint] where ...} (NotNull)
     */
    public String getFromHint() {
        return createFromHint();
    }

    public String getWhereClause() {
        final StringBuffer sb = new StringBuffer();
        int count = 0;
        for (final java.util.Iterator ite = _whereList.iterator(); ite.hasNext(); count++) {
            if (count == 0) {
                sb.append("where ").append((String)ite.next());
            } else {
                sb.append(" and ").append((String)ite.next());
            }
        }
        return sb.toString();
    }

    public String getOrderByClause() {
        return _orderByClause.getOrderByClause();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return sql-suffix. {select * from table where ... order by ... [sql-suffix]} (NotNull)
     */
    public String getSqlSuffix() {
        return createSqlSuffix();
    }

    // =====================================================================================
    //                                                                  IncludedSelectColumn
    //                                                                  ====================
    /**
     * Ignore included-select-column.
     */
    public void ignoreIncludedSelectColumn() {
        _isIncludedSelectColumnEffective = false;
    }

    /**
     * Make included-select-column effective.
     */
    public void makeIncludedSelectColumnEffective() {
        if (!_includedSelectColumnMap.isEmpty()) {
            _isIncludedSelectColumnEffective = true;
        }
    }

    /**
     * Register included-select-column.
     * 
     * @param aliasName Alias name. (NotNull)
     * @param realColumnName Real column name. (NotNull)
     */
    public void registerIncludedSelectColumn(String aliasName, String realColumnName) {
        _isIncludedSelectColumnEffective = true;
        _includedSelectColumnMap.put(aliasName, realColumnName);
    }

    // =====================================================================================
    //                                                                             OuterJoin
    //                                                                             =========
    /**
     * This method implements the method that is declared at super.
     * 
     * @param joinTableName Join table name(outer join [joinTableName]). (NotNull)
     * @param aliasName Alias name of join table. (NotNull and Unique per invoking method.)
     * @param joinOnMap Map that has conditions of 'on' clause. (NotNull)
     */
    public void registerOuterJoin(String joinTableName, String aliasName, java.util.Map<String, String> joinOnMap) {
        assertAlreadyOuterJoin(aliasName);
        assertJoinOnMapNotEmpty(joinOnMap, aliasName);
        final LeftOuterJoinInfo joinInfo = new LeftOuterJoinInfo();
        joinInfo.setAliasName(aliasName);
        joinInfo.setJoinTableName(joinTableName);
        joinInfo.setJoinOnMap(joinOnMap);
        _outerJoinMap.put(aliasName, joinInfo);
    }

    protected static class LeftOuterJoinInfo {
        protected String _aliasName;
        protected String _joinTableName;
        protected java.util.List<String> _inlineWhereClauseList = new java.util.ArrayList<String>();
        protected java.util.Map<String, String> _joinOnMap;
        public String getAliasName() {
            return _aliasName;
        }
        public void setAliasName(String value) {
            _aliasName = value;
        }
        public String getJoinTableName() {
            return _joinTableName;
        }
        public void setJoinTableName(String value) {
            _joinTableName = value;
        }
        public java.util.List<String> getInlineWhereClauseList() {
            return _inlineWhereClauseList;
        }
        public void addInlineWhereClause(String value) {
            _inlineWhereClauseList.add(value);
        }
        public java.util.Map<String, String> getJoinOnMap() {
            return _joinOnMap;
        }
        public void setJoinOnMap(java.util.Map<String, String> value) {
            _joinOnMap = value;
        }
    }

    /**
     * Assert whether the alias name have already registered in outer join.
     * 
     * @param aliasName Alias name.
     */
    protected void assertAlreadyOuterJoin(String aliasName) {
        if (_outerJoinMap.containsKey(aliasName)) {
            String msg = "The alias name have already registered in outer join: " + aliasName;
            throw new IllegalStateException(msg);
        }
    }

    /**
     * Assert whether the joinOnMap should not be empty.
     * 
     * @param joinOnMap Map that has conditions of 'on' clause. (NotNull)
     * @param aliasName Alias name.
     */
    protected void assertJoinOnMapNotEmpty(java.util.Map<String, String> joinOnMap, String aliasName) {
        if (joinOnMap.isEmpty()) {
            String msg = "The joinOnMap should not be empty: aliasName=" + aliasName;
            throw new IllegalStateException(msg);
        }
    }

    // =====================================================================================
    //                                                                                 Where
    //                                                                                 =====
    /**
     * This method implements the method that is declared at super.
     * 
     * @param readColumnName Real-column-name([table-name].[column-name]). (NotNull)
     * @param key Condition key. (NotNull)
     * @param value Condition value. (NotNull)
     */
    public void registerWhereClause(String readColumnName, ConditionKey key, ConditionValue value) {
        assertStringNotNullAndNotTrimmedEmpty("readColumnName", readColumnName);
        key.addWhereClause(_whereList, readColumnName, value);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param clause Where-clause. (NotNull)
     */
    public void registerWhereClause(String clause) {
        assertStringNotNullAndNotTrimmedEmpty("clause", clause);
        _whereList.add(clause);
    }

    // =====================================================================================
    //                                                                           InlineWhere
    //                                                                           ===========
    public void registerBaseTableInlineWhereClause(String columnName, ConditionKey key, ConditionValue value) {
        registerWhereClause(columnName, key, value);
        final String inlineWhereClause = (String)_whereList.remove(_whereList.size()-1);
        _baseTableInlineWhereList.add(inlineWhereClause);
    }

    public void registerBaseTableInlineWhereClause(String value) {
        _baseTableInlineWhereList.add(value);
    }

    public void registerOuterJoinInlineWhereClause(String aliasName, String columnName, ConditionKey key, ConditionValue value) {
        assertNotYetOuterJoin(aliasName);
        final LeftOuterJoinInfo joinInfo = (LeftOuterJoinInfo)_outerJoinMap.get(aliasName);
        registerWhereClause(columnName, key, value);
        final String inlineWhereClause = (String)_whereList.remove(_whereList.size()-1);
        joinInfo.addInlineWhereClause(inlineWhereClause);
    }

    public void registerOuterJoinInlineWhereClause(String aliasName, String value) {
        assertNotYetOuterJoin(aliasName);
        final LeftOuterJoinInfo joinInfo = (LeftOuterJoinInfo)_outerJoinMap.get(aliasName);
        joinInfo.addInlineWhereClause(value);
    }

    /**
     * Assert whether the alias name have already registered in outer join.
     * 
     * @param aliasName Alias name.
     */
    protected void assertNotYetOuterJoin(String aliasName) {
        if (!_outerJoinMap.containsKey(aliasName)) {
            String msg = "The alias name have not registered in outer join yet: " + aliasName;
            throw new IllegalStateException(msg);
        }
    }

    // =====================================================================================
    //                                                                               OrderBy
    //                                                                               =======
    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public OrderByClause getSqlComponentOfOrderByClause() {
        return _orderByClause;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause clearOrderBy() {
        _isOrderByEffective = false;
        _orderByClause.clear();
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause ignoreOrderBy() {
        _isOrderByEffective = false;
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause makeOrderByEffective() {
        if (!_orderByClause.isEmpty()) {
            _isOrderByEffective = true;
        }
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @param registeredOrderByProperty Registered-order-by-property. ([table-name].[column-name]) (Nullable)
     * @param isAsc Is asc?
     */
    public void reverseOrderBy_Or_OverrideOrderBy(String orderByProperty, String registeredOrderByProperty, boolean isAsc) {
        _isOrderByEffective = true;
        if (!_orderByClause.isSameOrderByColumn(orderByProperty)) {
            clearOrderBy();
            registerOrderBy(orderByProperty, registeredOrderByProperty, isAsc);
        } else {
            _orderByClause.reverseAll();
        }
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @param registeredOrderByProperty Registered-order-by-property. ([table-name].[column-name]) (Nullable)
     * @param isAsc Is asc?
     */
    public void registerOrderBy(String orderByProperty, String registeredOrderByProperty, boolean isAsc) {
        try {
            _isOrderByEffective = true;
            final java.util.List<String> orderByList = new java.util.ArrayList<String>();
            {
                final  java.util.StringTokenizer st = new java.util.StringTokenizer(orderByProperty, "/");
                while (st.hasMoreElements()) {
                    orderByList.add(st.nextToken());
                }
            }

            if (registeredOrderByProperty == null || registeredOrderByProperty.trim().length() ==0) {
                registeredOrderByProperty = orderByProperty;
            }

            final java.util.List<String> registeredOrderByList = new java.util.ArrayList<String>();
            {
                final java.util.StringTokenizer st = new java.util.StringTokenizer(registeredOrderByProperty, "/");
                while (st.hasMoreElements()) {
                    registeredOrderByList.add(st.nextToken());
                }
            }

            int count = 0;
            for (final java.util.Iterator ite = orderByList.iterator(); ite.hasNext(); ) {
                String orderBy = (String)ite.next();
                String registeredOrderBy = (String)registeredOrderByList.get(count);

                _isOrderByEffective = true;
                String aliasName = null;
                String columnName = null;
                String registeredAliasName = null;
                String registeredColumnName = null;

                if (orderBy.indexOf(".") < 0) {
                    columnName = orderBy;
                } else {
                    aliasName = orderBy.substring(0, orderBy.lastIndexOf("."));
                    columnName = orderBy.substring(orderBy.lastIndexOf(".") + 1);
                }

                if (registeredOrderBy.indexOf(".") < 0) {
                    registeredColumnName = registeredOrderBy;
                } else {
                    registeredAliasName = registeredOrderBy.substring(0, registeredOrderBy.lastIndexOf("."));
                    registeredColumnName = registeredOrderBy.substring(registeredOrderBy.lastIndexOf(".") + 1);
                }

                OrderByElement element = new OrderByElement();
                element.setAliasName(aliasName);
                element.setColumnName(columnName);
                element.setRegisteredAliasName(registeredAliasName);
                element.setRegisteredColumnName(registeredColumnName);
                if (isAsc) {
                    element.setupAsc();
                } else {
                    element.setupDesc();
                }
                _orderByClause.addOrderByElement(element);

                count++;
            }
        } catch (RuntimeException e) {
            String msg = "registerOrderBy() threw the exception: orderByProperty=" + orderByProperty;
            msg = msg + " registeredColumnFullName=" + registeredOrderByProperty;
            msg = msg + " isAsc=" + isAsc;
            msg = msg + " sqlClause=" + this.toString();
            throw new RuntimeException(msg, e);
        }
    }

    // =====================================================================================
    //                                                                               Advance
    //                                                                               =======
    /**
     * This method implements the method that is declared at super.
     * 
     * @param fetchSize Fetch-size. (NotMinus & NotZero)
     * @return this. (NotNull)
     */
    public SqlClause fetchFirst(int fetchSize) {
        _isFetchScopeEffective = true;
        if (fetchSize <= 0) {
            String msg = "Argument[fetchSize] must be plus: " + fetchSize;
            throw new IllegalArgumentException(msg);
        }
        _fetchStartIndex = 0;
        _fetchSize = fetchSize;
        _fetchPageNumber = 1;
        doClearFetchPageClause();
        doFetchFirst();
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param fetchStartIndex Fetch-start-index. 0 origin. (NotMinus)
     * @param fetchSize Fetch size. (NotMinus)
     * @return this. (NotNull)
     */
    public SqlClause fetchScope(int fetchStartIndex, int fetchSize) {
        _isFetchScopeEffective = true;
        if (fetchStartIndex < 0) {
            String msg = "Argument[fetchStartIndex] must be plus or zero: " + fetchStartIndex;
            throw new IllegalArgumentException(msg);
        }
        if (fetchSize <= 0) {
            String msg = "Argument[fetchSize] must be plus: " + fetchSize;
            throw new IllegalArgumentException(msg);
        }
        _fetchStartIndex = fetchStartIndex;
        _fetchSize = fetchSize;
        return fetchPage(1);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param fetchPageNumber Page-number. 1 origin. (NotMinus & NotZero)
     * @return this. (NotNull)
     */
    public SqlClause fetchPage(int fetchPageNumber) {
        _isFetchScopeEffective = true;
        if (fetchPageNumber <= 0) {
            String msg = "Argument[fetchPageNumber] must be plus: " + fetchPageNumber;
            throw new IllegalArgumentException(msg);
        }
        if (_fetchSize <= 0) {
            String msg = "Fetch size must not be minus or zero when you invoke this method. ";
            msg = msg + "When you invoke this, it is necessary to invoke 'fetchFirst()' or 'fetchScope()' ahead of that. ";
            msg = msg + ": fetchPageNumber=" + fetchPageNumber + " _fetchSize=" + _fetchSize;
            throw new IllegalStateException(msg);
        }
        _fetchPageNumber = fetchPageNumber;
        if (_fetchPageNumber == 1 && _fetchStartIndex == 0) {
            return fetchFirst(_fetchSize);
        }
        doClearFetchPageClause();
        doFetchPage();
        return this;
    }

    /**
     * Do fetch first.
     */
    abstract protected void doFetchFirst();

    /**
     * Do fetch page.
     */
    abstract protected void doFetchPage();

    /**
     * Do clear fetch-page clause.
     */
    abstract protected void doClearFetchPageClause();

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch start index.
     */
    public int getFetchStartIndex() {
        return _fetchStartIndex;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch size.
     */
    public int getFetchSize() {
        return _fetchSize;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch page number.
     */
    public int getFetchPageNumber() {
        return _fetchPageNumber;
    }

    /**
     * Get page start index.
     * 
     * @return Page start index. 0 origin. (NotMinus)
     */
    public int getPageStartIndex() {
        if (_fetchPageNumber <= 0) {
            String msg = "_fetchPageNumber must be plus: " + _fetchPageNumber;
            throw new IllegalStateException(msg);
        }
        return _fetchStartIndex + (_fetchSize * (_fetchPageNumber - 1));
    }

    /**
     * Get page end index.
     * 
     * @return Page end index. 0 origin. (NotMinus)
     */
    public int getPageEndIndex() {
        if (_fetchPageNumber <= 0) {
            String msg = "_fetchPageNumber must be plus: " + _fetchPageNumber;
            throw new IllegalStateException(msg);
        }
        return _fetchStartIndex + (_fetchSize * _fetchPageNumber);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determiantion.
     */
    public boolean isFetchScopeEffective() {
        return _isFetchScopeEffective;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause ignoreFetchScope() {
        _isFetchScopeEffective = false;
        doClearFetchPageClause();
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause makeFetchScopeEffective() {
        if (getFetchSize() > 0 && getFetchPageNumber() > 0) {
            fetchPage(getFetchPageNumber());
        }
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchStartIndexSupported() {
        return true; // Default
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchSizeSupported() {
        return true; // Default
    }

    /**
     * Create select-hint.
     * 
     * @return Select-hint. {select [select-hint] * from table...} (NotNull)
     */
    abstract protected String createSelectHint();

    /**
     * Create from-base-table-hint.
     * 
     * @return From-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    abstract protected String createFromBaseTableHint();

    /**
     * Create from-hint.
     * 
     * @return From-hint. {select * from table left outer join ... on ... [from-hint] where ...} (NotNull)
     */
    abstract protected String createFromHint();

    /**
     * Create sql-suffix.
     * 
     * @return Sql-suffix. {select * from table where ... order by ... [sql-suffix]} (NotNull)
     */
    abstract protected String createSqlSuffix();

    // =====================================================================================
    //                                                                        FetchNarrowing
    //                                                                        ==============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch-narrowing start-index.
     */
    public int getFetchNarrowingSkipStartIndex() {
        if (isFetchStartIndexSupported()) {
            return 0;
        } else {
            return getPageStartIndex();
        }
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Fetch-narrowing size.
     */
    public int getFetchNarrowingLoopCount() {
        return getFetchSize();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determiantion.
     */
    public boolean isFetchNarrowingEffective() {
        return _isFetchScopeEffective;
    }

    // =====================================================================================
    //                                                                         Helper Method
    //                                                                         =============
    // ----------------------------------------------------------------
    //                                                    Assert Object
    //                                                    -------------
    /**
     * Assert that the object is not null.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }

    // ----------------------------------------------------------------
    //                                                    Assert String
    //                                                    -------------
    /**
     * Assert that the entity is not null and not trimmed empty.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        assertObjectNotNull("variableName", variableName);
        assertObjectNotNull("value", value);
        if (value.trim().length() ==0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }
}
