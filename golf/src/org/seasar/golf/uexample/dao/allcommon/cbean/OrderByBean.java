package org.seasar.golf.uexample.dao.allcommon.cbean;

import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.OrderByClause;

/**
 * The order-by-bean as interface.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface OrderByBean extends SelectResource {

    /**
     * Get sql component of order-by clause.
     * 
     * @return Sql component of order-by clause. (NotNull)
     */
    public OrderByClause getSqlComponentOfOrderByClause();

    /**
     * Get order-by clause.
     * 
     * @return Order-by clause. (NotNull)
     */
    public String getOrderByClause();

    /**
     * Clear order-by.
     * 
     * @return this. (NotNull)
     */
    public OrderByBean clearOrderBy();

    /**
     * Ignore order-by.
     * 
     * @return this. (NotNull)
     */
    public OrderByBean ignoreOrderBy();

    /**
     * Make order-by effective.
     * 
     * @return this. (NotNull)
     */
    public OrderByBean makeOrderByEffective();

    /**
     * Register order-by-asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean registerOrderByAsc(String orderByProperty);

    /**
     * Register order-by-desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean registerOrderByDesc(String orderByProperty);

    /**
     * Reverse order-by or Override order-by asc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean reverseOrderBy_Or_OverrideOrderByAsc(String orderByProperty);

    /**
     * Reverse order-by or Override order-by desc.
     * 
     * @param orderByProperty Order-by-property. 'aliasName.columnName/aliasName.columnName/...' (NotNull)
     * @return this. (NotNull)
     */
    public OrderByBean reverseOrderBy_Or_OverrideOrderByDesc(String orderByProperty);
}
