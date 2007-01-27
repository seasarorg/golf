package org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause;


/**
 * The paging-result-bean of OrderByClause.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class OrderByClause implements java.io.Serializable {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected java.util.List<OrderByElement> _orderByList = new java.util.ArrayList<OrderByElement>();

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public OrderByClause() {
    }

    // =====================================================================================
    //                                                                              Behavior
    //                                                                              ========
    public void addOrderByElement(OrderByElement value) {
        _orderByList.add(value);
    }

    public void reverseAll() {
        for (final java.util.Iterator ite = _orderByList.iterator(); ite.hasNext(); ) {
            final OrderByElement element = (OrderByElement)ite.next();
            element.reverse();
        }
    }

    /**
     * Get the value of allRecordCount.
     * 
     * @return The value of allRecordCount.
     */
    public java.util.List<OrderByElement> getOrderByList() {
        return _orderByList;
    }

    public String getOrderByClause() {
        if (_orderByList.isEmpty()) {
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        final String delimiter = ", ";
        for (final java.util.Iterator ite = _orderByList.iterator(); ite.hasNext(); ) {
            final OrderByElement element = (OrderByElement)ite.next();
            sb.append(delimiter).append(element.getElementClause());
        }
        sb.delete(0, delimiter.length()).insert(0, "order by ");
        return sb.toString();
    }

    public boolean isSameOrderByColumn(String orderByProperty) {
        final java.util.List<String> orderByList = new java.util.ArrayList<String>();
        {
            final java.util.StringTokenizer st = new java.util.StringTokenizer(orderByProperty, "/");
            while (st.hasMoreElements()) {
                orderByList.add(st.nextToken());
            }
        }
        if (_orderByList.size() != orderByList.size()) {
            return false;
        }
        int count = 0;
        for (final java.util.Iterator ite = orderByList.iterator(); ite.hasNext(); ) {
            final String columnFullName = (String)ite.next();
            final OrderByElement element = (OrderByElement)_orderByList.get(count);
            if (!element.getColumnFullName().equals(columnFullName)) {
                return false;
            }
            count++;
        }
        return true;
    }

    // =====================================================================================
    //                                                                         First Element
    //                                                                         =============
    /**
     * Is first element asc?
     * If order-by list is empty, throws exception.
     * 
     * @return Determination.
     */
    public boolean isFirstElementAsc() {
        if (isEmpty()) {
            String msg = "This order-by clause is empty: " + toString();
            throw new IllegalStateException(msg);
        }
        final OrderByElement element = (OrderByElement)_orderByList.get(0);
        return element.isAsc();
    }

    /**
     * Is first element desc?
     * If order-by list is empty, throws exception.
     * 
     * @return Determination.
     */
    public boolean isFirstElementDesc() {
        return !isFirstElementAsc();
    }

    /**
     * Is same as first element alias-name?
     * If order-by list is empty, throws exception.
     * 
     * @param expectedAliasName Expected alias-name. (Nullable)
     * @return Determination.
     */
    public boolean isSameAsFirstElementAliasName(String expectedAliasName) {
        if (isEmpty()) {
            String msg = "This order-by clause is empty: " + toString();
            throw new RuntimeException(msg);
        }
        OrderByElement element = (OrderByElement)_orderByList.get(0);
        String actualAliasName = element.getAliasName();
        if (actualAliasName != null && expectedAliasName != null) {
            return actualAliasName.equalsIgnoreCase(expectedAliasName);
        } else {
            return false;
        }
    }

    /**
     * Is same as first element column-name?
     * If order-by list is empty, throws exception.
     * 
     * @param expectedColumnName Expected column-name. (Nullable)
     * @return Determination.
     */
    public boolean isSameAsFirstElementColumnName(String expectedColumnName) {
        if (isEmpty()) {
            String msg = "This order-by clause is empty: " + toString();
            throw new RuntimeException(msg);
        }
        OrderByElement element = (OrderByElement)_orderByList.get(0);
        String actualColumnName = element.getColumnName();
        if (actualColumnName != null && expectedColumnName != null) {
            return actualColumnName.equalsIgnoreCase(expectedColumnName);
        } else {
            return false;
        }
    }

    /**
     * Is same as first element registered-alias-name?
     * If order-by list is empty, throws exception.
     * 
     * @param expectedAliasName Expected alias-name. (Nullable)
     * @return Determination.
     */
    public boolean isSameAsFirstElementRegisteredAliasName(String expectedAliasName) {
        if (isEmpty()) {
            String msg = "This order-by clause is empty: " + toString();
            throw new RuntimeException(msg);
        }
        OrderByElement element = (OrderByElement)_orderByList.get(0);
        String actualAliasName = element.getRegisteredAliasName();
        if (actualAliasName != null && expectedAliasName != null) {
            return actualAliasName.equalsIgnoreCase(expectedAliasName);
        } else {
            return false;
        }
    }

    /**
     * Is same as first element registered-column-name?
     * If order-by list is empty, throws exception.
     * 
     * @param expectedColumnName Expected column-name. (Nullable)
     * @return Determination.
     */
    public boolean isSameAsFirstElementRegisteredColumnName(String expectedColumnName) {
        if (isEmpty()) {
            String msg = "This order-by clause is empty: " + toString();
            throw new RuntimeException(msg);
        }
        OrderByElement element = (OrderByElement)_orderByList.get(0);
        String actualColumnName = element.getRegisteredColumnName();
        if (actualColumnName != null && expectedColumnName != null) {
            return actualColumnName.equalsIgnoreCase(expectedColumnName);
        } else {
            return false;
        }
    }

    // =====================================================================================
    //                                                                      Delegate of List
    //                                                                      ================
    /**
     * Is empty?
     * 
     * @return Determination.
     */
    public boolean isEmpty() {
        return _orderByList.isEmpty();
    }

    /**
     * Get iterator of order-by list.
     * 
     * @return Determination.
     */
    public java.util.Iterator iterator() {
        return _orderByList.iterator();
    }

    /**
     * Clear order-by list.
     */
    public void clear() {
        _orderByList.clear();
    }

    // =====================================================================================
    //                                                                 Basic-Override Method
    //                                                                 =====================
    /**
     * This method overrides the method that is declared at super.
     * 
     * @return View-string of all-columns value.
     */
    public String toString() {
        return _orderByList.toString();
    }
}
