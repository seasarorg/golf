package org.seasar.golf.uexample.ldb.allcommon.cbean.sqlclause;


/**
 * The paging-result-bean of OrderByElement.
 * 
 * <pre>
 *   For example, if you make order-by 'order BOOK.BOOK_ID asc', the way is as follows:
 *       /-----------------------------------------------------
 *       OrderByElement orderByElement = new OrderByElement();
 *       orderByElement.AliasName = "BOOK";
 *       orderByElement.ColumnName = "BOOK_ID";
 *       orderByElement.SetupAsc();
 *       -------------/
 * </pre>
 * 
 * @author DBFlute(AutoGenerator)
 */
public class OrderByElement implements java.io.Serializable {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** The value of alias name. */
    protected String _aliasName;

    /** The value of column name. */
    protected String _columnName;

    /** The value of registered alias name. */
    protected String _registeredAliasName;

    /** The value of registered column name. */
    protected String _registeredColumnName;

    /** The value of ascDesc. */
    protected String _ascDesc = "asc";

    // =====================================================================================
    //                                                                          GetterSetter
    //                                                                          ============
    public String getAliasName() {
        return _aliasName;
    }
    public String getColumnName() {
        return _columnName;
    }
    public String getRegisteredAliasName() {
        return _registeredAliasName;
    }
    public String getRegisteredColumnName() {
        return _registeredColumnName;
    }
    public String getAscDesc() {
        return _ascDesc;
    }
    public void setAliasName(String value) {
        _aliasName = value;
    }
    public void setColumnName(String value) {
        _columnName = value;
    }
    public void setRegisteredAliasName(String value) {
        _registeredAliasName = value;
    }
    public void setRegisteredColumnName(String value) {
        _registeredColumnName = value;
    }
    public void setAscDesc(String value) {
        _ascDesc = value;
    }

    // =====================================================================================
    //                                                                              Behavior
    //                                                                              ========
    public void setupAsc() {
        _ascDesc = "asc";
    }

    public void setupDesc() {
        _ascDesc = "desc";
    }

    public void reverse() {
        if (_ascDesc == null) {
            String msg = "The attribute[ascDesc] should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_ascDesc.equals("asc")) {
            _ascDesc = "desc";
        } else if (_ascDesc.equals("desc")) {
            _ascDesc = "asc";
        } else {
            String msg = "The attribute[ascDesc] should be asc or desc: but ascDesc=" + _ascDesc;
            throw new IllegalStateException(msg);
        }
    }

    public boolean isAsc() {
        if (_ascDesc == null) {
            String msg = "The attribute[ascDesc] should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_ascDesc.equals("asc")) {
            return true;
        } else if (_ascDesc.equals("desc")) {
            return false;
        } else {
            String msg = "The attribute[ascDesc] should be asc or desc: but ascDesc=" + _ascDesc;
            throw new IllegalStateException(msg);
        }
    }

    public String getColumnFullName() {
        final StringBuffer sb = new StringBuffer();
        if (_aliasName != null) {
            sb.append(_aliasName).append(".");
        }
        if (_columnName == null) {
            String msg = "The attribute[columnName] should not be null.";
            throw new IllegalStateException(msg);
        }
        sb.append(_columnName);
        return sb.toString();
    }

    public String getElementClause() {
        if (_ascDesc == null) {
            String msg = "The attribute[ascDesc] should not be null.";
            throw new IllegalStateException(msg);
        }
        final StringBuffer sb = new StringBuffer();
        sb.append(getColumnFullName()).append(" ").append(_ascDesc);
        return sb.toString();
    }

    // =====================================================================================
    //                                                                        Basic Override
    //                                                                        ==============
    /**
     * This method overrides the method that is declared at super.
     * 
     * @return View-string of all-columns value.
     */
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("[OrderByElement] aliasName=").append(_aliasName);
        sb.append(" columnName=").append(_columnName);
        sb.append(" registeredAliasName=").append(_registeredAliasName);
        sb.append(" registeredColumnName=").append(_registeredColumnName);
        sb.append(" ascDesc=").append(_ascDesc);
        return sb.toString();
    }
}
