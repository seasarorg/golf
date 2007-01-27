package org.seasar.golf.uexample.ldb.cbean.bs;


import org.seasar.golf.uexample.ldb.allcommon.cbean.AbstractConditionBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionQuery;

import org.seasar.golf.uexample.ldb.cbean.cq.*;
import org.seasar.golf.uexample.ldb.cbean.nss.*;

/**
 * The condition-bean of vendor.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class BsVendorCB extends AbstractConditionBean {

    // =====================================================================================
    //                                                                            Annotation
    //                                                                            ==========
    /** TABLE-Annotation */
    public static final String TABLE = "vendor";

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Condition query. */
    protected VendorCQ _conditionQuery;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public BsVendorCB() {
    }

    // /* * * * * * * * * * * * * * * * * * * * * * *
    //   MyTable = [vendor]
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
        return "vendor";
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
  
        if (!primaryKeyMap.containsKey("id")) {
            String msg = "The primaryKeyMap must have the value of id";
            throw new IllegalStateException(msg + ": primaryKeyMap --> " + primaryKeyMap);
        }
        {
            Object obj = primaryKeyMap.get("id");
            if (obj instanceof java.math.BigDecimal) {
                query().setId_Equal((java.math.BigDecimal)obj);
            } else {
                  
                if (obj instanceof java.math.BigDecimal) {
                    query().setId_Equal((java.math.BigDecimal)obj);
                } else {
                    try {
                        query().setId_Equal(new java.math.BigDecimal((String)obj));
                    } catch (RuntimeException e) {
                        String msg = "setId(new java.math.BigDecimal((String)obj))";
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
  
        query().addOrderBy_Id_Asc();
  
        return this;

    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return this. (NotNull)
     */
    public ConditionBean addOrderBy_PK_Desc() {
  
        query().addOrderBy_Id_Desc();
  
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
    public VendorCQ query() {
        return getConditionQuery();
    }

    /**
     * Get condition query. {Internal method for s2dao}
     * 
     * @return Instance of condition query. (NotNull)
     */
    public VendorCQ getConditionQuery() {
        if (_conditionQuery == null) {
            _conditionQuery = new VendorCQ(null, getSqlClause(), getTableDbName(), 0);
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
