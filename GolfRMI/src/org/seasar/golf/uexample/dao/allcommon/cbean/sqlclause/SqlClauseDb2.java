package org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause;


/**
 * SqlClause for DB2.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class SqlClauseDb2 extends AbstractSqlClause {

    /** String of fetch-first as sql-suffix. */
    protected String _fetchFirstSqlSuffix = "";

    /** String of lock as from-hint. */
    protected String _lockSqlSuffix = "";

    /**
     * Constructor.
     * 
     * @param tableName Table name. (NotNull)
     **/
    public SqlClauseDb2(String tableName) {
        super(tableName);
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchFirst() {
        if (isFetchSizeSupported()) {
            _fetchFirstSqlSuffix = " fetch first " + getFetchSize() + " rows only";
        }
    }

    /**
     * This method implements the method that is declared at super. {Unsupported!}
     */
    protected void doFetchPage() {
        if (isFetchSizeSupported()) {
            if (isFetchStartIndexSupported()) {
                _fetchFirstSqlSuffix = " fetch first " + getFetchSize() + " rows only";
            } else {
                _fetchFirstSqlSuffix = " fetch first " + getPageEndIndex() + " rows only";
            }
        }
    }

    /**
     * This method implements the method that is declared at super. {Unsupported!}
     */
    protected void doClearFetchPageClause() {
        _fetchFirstSqlSuffix = "";
    }

    /**
     * This method overrides the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchStartIndexSupported() {
        return false;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause lockForUpdate() {
        _lockSqlSuffix = " for update with RS";
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Select-hint. (NotNull)
     */
    protected String createSelectHint() {
        return "";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return From-base-table-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    protected String createFromBaseTableHint() {
        return "";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return From-hint. (NotNull)
     */
    protected String createFromHint() {
        return "";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Sql-suffix. (NotNull)
     */
    protected String createSqlSuffix() {
        return _fetchFirstSqlSuffix + _lockSqlSuffix;
    }
}
