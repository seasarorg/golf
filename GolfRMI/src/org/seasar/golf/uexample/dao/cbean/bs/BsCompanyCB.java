package org.seasar.golf.uexample.dao.cbean.bs;


import org.seasar.golf.uexample.dao.allcommon.cbean.AbstractConditionBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.ConditionQuery;

import org.seasar.golf.uexample.dao.cbean.cq.*;
import org.seasar.golf.uexample.dao.cbean.nss.*;

/**
 * The condition-bean of company.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class BsCompanyCB extends AbstractConditionBean {

    // =====================================================================================
    //                                                                            Annotation
    //                                                                            ==========
    /** TABLE-Annotation */
    public static final String TABLE = "company";

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Condition query. */
    protected CompanyCQ _conditionQuery;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public BsCompanyCB() {
    }

    // /* * * * * * * * * * * * * * * * * * * * * * *
    //   MyTable = [company]
    // * * * * * * * * */

    // =====================================================================================
    //                                                                            Table name
    //                                                                            ==========
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table db-name. (NotNull)
     */
    final public String getTableDbName() {
        return "company";
    }

    // =====================================================================================
    //                                                                    Accept Primary-Key
    //                                                                    ==================
    /**
     * This method implements the method that is declared at super.
     * 
     * @param primaryKeyMap Primary key map. (NotNull and NotEmpty)
     */
    public void acceptPrimaryKeyMap(java.util.Map<String, ? extends Object> primaryKeyMap) {
        if (primaryKeyMap == null) {
            String msg = "The argument[primaryKeyMap] must not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (primaryKeyMap.isEmpty()) {
            String msg = "The argument[primaryKeyMap] must not be empty.";
            throw new IllegalArgumentException(msg);
        }
  
        if (!primaryKeyMap.containsKey("ccode")) {
            String msg = "The primaryKeyMap must have the value of ccode";
            throw new IllegalStateException(msg + ": primaryKeyMap --> " + primaryKeyMap);
        }
        {
            Object obj = primaryKeyMap.get("ccode");
            if (obj instanceof java.math.BigDecimal) {
                query().setCcode_Equal((java.math.BigDecimal)obj);
            } else {
                  
                if (obj instanceof java.math.BigDecimal) {
                    query().setCcode_Equal((java.math.BigDecimal)obj);
                } else {
                    try {
                        query().setCcode_Equal(new java.math.BigDecimal((String)obj));
                    } catch (RuntimeException e) {
                        String msg = "setCcode(new java.math.BigDecimal((String)obj))";
                        throw new RuntimeException(msg + " threw the exception: value=[" + obj + "]", e);
                    }
                }
            }
        }
                    
    }

    // =====================================================================================
    //                                                                 Add-OrderBy-PK Method
    //                                                                 =====================
    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public ConditionBean addOrderBy_PK_Asc() {
  
        query().addOrderBy_Ccode_Asc();
  
        return this;

    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public ConditionBean addOrderBy_PK_Desc() {
  
        query().addOrderBy_Ccode_Desc();
  
        return this;

    }

    // =====================================================================================
    //                                                                                 Query
    //                                                                                 =====
    /**
     * Query.
     * 
     * @return Instance of query. (NotNull)
     */
    public CompanyCQ query() {
        return getConditionQuery();
    }

    /**
     * Get condition query. {Internal method for s2dao}
     * 
     * @return Instance of condition query. (NotNull)
     */
    public CompanyCQ getConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = new CompanyCQ(null, getSqlClause(), getTableDbName(), 0);
        }
        return _conditionQuery;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Instance of query as interface. (NotNull)
     */
    public ConditionQuery getConditionQueryAsInterface() {
        return getConditionQuery();
    }

    // =====================================================================================
    //                                                                          Setup Select
    //                                                                          ============
    
    // =====================================================================================
    //                                                                 Basic-Override Method
    //                                                                 =====================
    /**
     * This method overrides the method that is declared at super.
     * 
     * @return Clause string. (NotNull)
     */
    public String toString() {
        return getSqlClause().getClause();
    }
}
