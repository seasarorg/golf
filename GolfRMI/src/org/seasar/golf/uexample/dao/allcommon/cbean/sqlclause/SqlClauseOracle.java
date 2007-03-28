package org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause;


/**
 * SqlClause for Oracle.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class SqlClauseOracle extends AbstractSqlClause {

    /** String of fetch-scope as select-hint. */
    protected String _fetchScopeSelectHint = "";

    /** String of fetch-scope as sql-suffix. */
    protected String _fetchScopeSqlSuffix = "";

    /** String of lock as sql-suffix. */
    protected String _lockSqlSuffix = "";

    /**
     * Constructor.
     * 
     * @param tableName Table name. (NotNull)
     **/
    public SqlClauseOracle(String tableName) {
        super(tableName);
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchFirst() {
        if (isFetchSizeSupported()) {
            _fetchScopeSelectHint = " * from (select";
            _fetchScopeSqlSuffix = ") where rownum <= " + getFetchSize();
        }
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchPage() {
        if (!isFetchStartIndexSupported() && !isFetchSizeSupported()) {
            return;
        }
        _fetchScopeSelectHint = " * from (select base.*, rownum as rn from (select";
        _fetchScopeSqlSuffix = "";
        if (isFetchStartIndexSupported()) {
            _fetchScopeSqlSuffix = ") base ) where rn > " + getPageStartIndex();
        }
        if (isFetchSizeSupported()) {
            if (isFetchStartIndexSupported()) {
                _fetchScopeSqlSuffix = _fetchScopeSqlSuffix + " and rn <= " + getPageEndIndex();
            } else {
                _fetchScopeSqlSuffix = ") base ) where rn <= " + getPageEndIndex();
            }
        }
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doClearFetchPageClause() {
        _fetchScopeSelectHint = "";
        _fetchScopeSqlSuffix = "";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public SqlClause lockForUpdate() {
        _lockSqlSuffix = " for update";
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Select-hint. (NotNull)
     */
    protected String createSelectHint() {
        return _fetchScopeSelectHint;
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
        return _fetchScopeSqlSuffix + _lockSqlSuffix;
    }
}
