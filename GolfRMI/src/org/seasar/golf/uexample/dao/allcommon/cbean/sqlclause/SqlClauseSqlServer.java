package org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause;


/**
 * SqlClause for MSSQL.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class SqlClauseSqlServer extends AbstractSqlClause {

    /** String of fetch-first as select-hint. */
    protected String _fetchFirstSelectHint = "";

    /** String of lock as from-hint. */
    protected String _lockFromHint = "";

    /**
     * Constructor.
     * 
     * @param tableName Table name. (NotNull)
     **/
    public SqlClauseSqlServer(String tableName) {
        super(tableName);
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchFirst() {
        if (isFetchSizeSupported()) {
            _fetchFirstSelectHint = " top " + getFetchSize();
        }
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchPage() {
        if (isFetchSizeSupported()) {
            if (isFetchStartIndexSupported()) {
                _fetchFirstSelectHint = " top " + getFetchSize();
            } else {
                _fetchFirstSelectHint = " top " + getPageEndIndex();
            }
        }
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doClearFetchPageClause() {
        _fetchFirstSelectHint = "";
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
     * This method implements the method that is declared at super. {Implement}
     * 
     * @return this. (NotNull)
     */
    public SqlClause lockForUpdate() {
        _lockFromHint = " with (updlock)";
        return this;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Select-hint. (NotNull)
     */
    protected String createSelectHint() {
        return _fetchFirstSelectHint;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return From-base-table-hint. {select * from table [from-base-table-hint] where ...} (NotNull)
     */
    protected String createFromBaseTableHint() {
        return _lockFromHint;
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
        return "";
    }
}
