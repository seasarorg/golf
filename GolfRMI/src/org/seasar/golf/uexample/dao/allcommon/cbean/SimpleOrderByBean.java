package org.seasar.golf.uexample.dao.allcommon.cbean;

import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.OrderByClause;
import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClause;

/// <summary>
/// The order-by-bean as simple implemetation.
/// Author: DBFlute(AutoGenerator)
/// </summary>
public class SimpleOrderByBean implements OrderByBean {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** SQL clause instance. */
    protected final SqlClause _sqlClause;
    {
        _sqlClause = ConditionBeanContext.createSqlClause("Dummy");
    }

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public SimpleOrderByBean() {
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
        return getSqlClause().getOrderByClause();
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
        getSqlClause().registerOrderBy(orderByProperty, orderByProperty, true);
        return this;
    }

    /**
     * Register order-by-desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean registerOrderByDesc(String orderByProperty) {
        getSqlClause().registerOrderBy(orderByProperty, orderByProperty, false);
        return this;
    }

    /**
     * Reverse order-by or Override order-by asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean reverseOrderBy_Or_OverrideOrderByAsc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(orderByProperty, orderByProperty, true);
        return this;
    }

    /**
     * Reverse order-by or Override order-by desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean reverseOrderBy_Or_OverrideOrderByDesc(String orderByProperty) {
        getSqlClause().reverseOrderBy_Or_OverrideOrderBy(orderByProperty, orderByProperty, false);
        return this;
    }
}
