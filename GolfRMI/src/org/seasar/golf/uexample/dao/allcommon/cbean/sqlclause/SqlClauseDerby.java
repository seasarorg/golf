package org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause;


/**
 * SqlClause for Default.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class SqlClauseDerby extends AbstractSqlClause {

    /** String of lock as sql-suffix. */
    protected String _lockSqlSuffix = "";

    /**
     * Constructor.
     * <p>
     * @param tableName Table name. (NotNull)
     **/
    public SqlClauseDerby(String tableName) {
        super(tableName);
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchFirst() {
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doFetchPage() {
    }

    /**
     * This method implements the method that is declared at super.
     */
    protected void doClearFetchPageClause() {
    }

    /**
     * This method overrides the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchStartIndexSupported() {
        return false; // Default
    }

    /**
     * This method overrides the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean isFetchSizeSupported() {
        return false; // Default
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
        return _lockSqlSuffix;
    }
}
