package org.seasar.golf.uexample.ldb.allcommon.cbean;

import org.seasar.golf.uexample.ldb.allcommon.cbean.cvalue.ConditionValue;
import org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause.SqlClause;

/**
 * The condition-query as interface.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface ConditionQuery {

    /**
     * Get table db-name.
     * 
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName();

    /**
     * Get real alias name(that has nest level mark).
     * 
     * @return Real alias name.
     */
    public String getRealAliasName();

    /**
     * Get real column name(with real alias name).
     * 
     * @param columnName Column name without alias name.
     * @return Real column name.
     */
    public String getRealColumnName(String columnName);

    /**
     * Get child query.
     * 
     * @return Child query. (Nullable)
     */
    public ConditionQuery getChildQuery();

    /**
     * Get sql clause.
     * 
     * @return Sql clause. (NotNull)
     */
    public SqlClause getSqlClause();

    /**
     * Get alias name.
     * 
     * @return Alias name. (NotNull)
     */
    public String getAliasName();

    /**
     * Get nest level.
     * 
     * @return Nest level.
     */
    public int getNestLevel();

    /**
     * Get next nest level.
     * 
     * @return Next nest level.
     */
    public int getNextNestLevel();

    /**
     * Is base query?
     * 
     * @param query Condition query. (NotNull)
     * @return Determination.
     */
    public boolean isBaseQuery(ConditionQuery query);

    // =====================================================================================
    //                                                                                Invoke
    //                                                                                ======
    public ConditionValue invokeGetter(String columnMultiName);

    public void invokeSetterEqual(String columnMultiName, Object value);
    public void invokeSetterNotEqual(String columnMultiName, Object value);
    public void invokeSetterGreaterThan(String columnMultiName, Object value);
    public void invokeSetterLessThan(String columnMultiName, Object value);
    public void invokeSetterGreaterEqual(String columnMultiName, Object value);
    public void invokeSetterLessEqual(String columnMultiName, Object value);

    public void invokeAddOrderByAsc(String columnMultiName);
    public void invokeAddOrderByDesc(String columnMultiName);

    // =====================================================================================
    //                                                                         Foregin Query
    //                                                                         =============
    /// <summary>
    /// Get foreign condition-query.
    /// </summary>
    /// <param name="foreignPropertyName">Foreign-property-name(Both OK - InitCap or not). (NotNull)</param>
    /// <returns>Foreign condition-query as interface.</returns>
    public ConditionQuery getForeignConditionQuery(String foreignPropertyName);
}
