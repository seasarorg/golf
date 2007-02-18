
package org.seasar.golf.uexample.dao.cbean.cq.bs;



import org.seasar.golf.uexample.dao.allcommon.cbean.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.ckey.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.cvalue.ConditionValue;
import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClause;
import org.seasar.golf.uexample.dao.cbean.cq.*;

/**
 * The condition-query of {table.Name}.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsCompanyCQ extends AbstractConditionQuery {

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     * 
     * @param childQuery Child query as abstract class. (Nullable: If null, this is base instance.)
     * @param sqlClause SQL clause instance. (NotNull)
     * @param aliasName My alias name. (NotNull)
     * @param nestLevel Nest level.
     */
    public AbstractBsCompanyCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

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
    //                                                                                 Query
    //                                                                                 =====
      
    // /* * * * * * * * * * * * * * * * * * * * * * *
    //   MyTable = [company]
    // * * * * * * * * */

      
    /** Column db name of ccode. */
    protected static final String COL_ccode = "ccode";

    /** Column java name of ccode. */
    protected static final String J_Ccode = "Ccode";

    /** Column uncapitalised java name of ccode. */
    protected static final String UJ_ccode = "ccode";
            
    /**
     * Set the value of ccode using equal. { = }
     * 
     * @param value The value of ccode as equal.
     */
    public void setCcode_Equal(java.math.BigDecimal value) {
        registerCcode(ConditionKey.CK_EQUAL, value);
    }
      
    /**
     * Set the value of ccode using notEqual. { != }
     * 
     * @param value The value of ccode as notEqual.
     */
    public void setCcode_NotEqual(java.math.BigDecimal value) {
        registerCcode(ConditionKey.CK_NOT_EQUAL, value);
    }

    /**
     * Set the value of ccode using greaterThan. { &gt; }
     * 
     * @param value The value of ccode as greaterThan.
     */
    public void setCcode_GreaterThan(java.math.BigDecimal value) {
        registerCcode(ConditionKey.CK_GREATER_THAN, value);
    }

    /**
     * Set the value of ccode using lessThan. { &lt; }
     * 
     * @param value The value of ccode as lessThan.
     */
    public void setCcode_LessThan(java.math.BigDecimal value) {
        registerCcode(ConditionKey.CK_LESS_THAN, value);
    }
      
    /**
     * Set the value of ccode using greaterEqual. { &gt;= }
     * 
     * @param value The value of ccode as greaterEqual.
     */
    public void setCcode_GreaterEqual(java.math.BigDecimal value) {
        registerCcode(ConditionKey.CK_GREATER_EQUAL, value);
    }

    /**
     * Set the value of ccode using lessEqual. { &lt;= }
     * 
     * @param value The value of ccode as lessEqual.
     */
    public void setCcode_LessEqual(java.math.BigDecimal value) {
        registerCcode(ConditionKey.CK_LESS_EQUAL, value);
    }

    /**
     * Set the value of ccode using inScope. { in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of ccode as inScope.
     */
    public void setCcode_InScope(java.util.List<java.math.BigDecimal> valueList) {
        registerCcode(ConditionKey.CK_IN_SCOPE, valueList);
    }

    /**
     * Set the value of ccode using notInScope. { not in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of ccode as notInScope.
     */
    public void setCcode_NotInScope(java.util.List<java.math.BigDecimal> valueList) {
        registerCcode(ConditionKey.CK_NOT_IN_SCOPE, valueList);
    }
                                          
    /**
     * Register condition of ccode.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of ccode. (Nullable)
     */
    protected void registerCcode(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueCcode(), COL_ccode, J_Ccode, UJ_ccode);
    }

    /**
     * Register inline condition of ccode.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of ccode. (Nullable)
     */
    protected void registerInlineCcode(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueCcode(), COL_ccode, J_Ccode, UJ_ccode);
    }

    abstract protected ConditionValue getCValueCcode();
      
    /** Column db name of cat. */
    protected static final String COL_cat = "cat";

    /** Column java name of cat. */
    protected static final String J_Cat = "Cat";

    /** Column uncapitalised java name of cat. */
    protected static final String UJ_cat = "cat";
    
    /**
     * Set the value of cat using equal. { = }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as equal.
     */
    public void setCat_Equal(String value) {
        registerCat(ConditionKey.CK_EQUAL, filterRemoveEmptyString(value));
    }
            
    /**
     * Set the value of cat using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as notEqual.
     */
    public void setCat_NotEqual(String value) {
        registerCat(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of cat using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as greaterThan.
     */
    public void setCat_GreaterThan(String value) {
        registerCat(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of cat using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as lessThan.
     */
    public void setCat_LessThan(String value) {
        registerCat(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of cat using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as greaterEqual.
     */
    public void setCat_GreaterEqual(String value) {
        registerCat(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of cat using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as lessEqual.
     */
    public void setCat_LessEqual(String value) {
        registerCat(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of cat using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of cat as prefixSearch.
     */
    public void setCat_PrefixSearch(String value) {
        registerCat(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of cat using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of cat as inScope.
     */
    public void setCat_InScope(java.util.List<String> valueList) {
        registerCat(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }

    /**
     * Set the value of cat using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of cat as notInScope.
     */
    public void setCat_NotInScope(java.util.List<String> valueList) {
        registerCat(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }
                                              
    /**
     * Register condition of cat.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of cat. (Nullable)
     */
    protected void registerCat(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueCat(), COL_cat, J_Cat, UJ_cat);
    }

    /**
     * Register inline condition of cat.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of cat. (Nullable)
     */
    protected void registerInlineCat(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueCat(), COL_cat, J_Cat, UJ_cat);
    }

    abstract protected ConditionValue getCValueCat();
      
    /** Column db name of shortname. */
    protected static final String COL_shortname = "shortname";

    /** Column java name of shortname. */
    protected static final String J_Shortname = "Shortname";

    /** Column uncapitalised java name of shortname. */
    protected static final String UJ_shortname = "shortname";
    
    /**
     * Set the value of shortname using equal. { = }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as equal.
     */
    public void setShortname_Equal(String value) {
        registerShortname(ConditionKey.CK_EQUAL, filterRemoveEmptyString(value));
    }
            
    /**
     * Set the value of shortname using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as notEqual.
     */
    public void setShortname_NotEqual(String value) {
        registerShortname(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of shortname using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as greaterThan.
     */
    public void setShortname_GreaterThan(String value) {
        registerShortname(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of shortname using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as lessThan.
     */
    public void setShortname_LessThan(String value) {
        registerShortname(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of shortname using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as greaterEqual.
     */
    public void setShortname_GreaterEqual(String value) {
        registerShortname(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of shortname using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as lessEqual.
     */
    public void setShortname_LessEqual(String value) {
        registerShortname(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of shortname using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of shortname as prefixSearch.
     */
    public void setShortname_PrefixSearch(String value) {
        registerShortname(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of shortname using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of shortname as inScope.
     */
    public void setShortname_InScope(java.util.List<String> valueList) {
        registerShortname(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }

    /**
     * Set the value of shortname using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of shortname as notInScope.
     */
    public void setShortname_NotInScope(java.util.List<String> valueList) {
        registerShortname(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }
                                              
    /**
     * Register condition of shortname.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of shortname. (Nullable)
     */
    protected void registerShortname(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueShortname(), COL_shortname, J_Shortname, UJ_shortname);
    }

    /**
     * Register inline condition of shortname.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of shortname. (Nullable)
     */
    protected void registerInlineShortname(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueShortname(), COL_shortname, J_Shortname, UJ_shortname);
    }

    abstract protected ConditionValue getCValueShortname();
      
    /** Column db name of name. */
    protected static final String COL_name = "name";

    /** Column java name of name. */
    protected static final String J_Name = "Name";

    /** Column uncapitalised java name of name. */
    protected static final String UJ_name = "name";
    
    /**
     * Set the value of name using equal. { = }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as equal.
     */
    public void setName_Equal(String value) {
        registerName(ConditionKey.CK_EQUAL, filterRemoveEmptyString(value));
    }
            
    /**
     * Set the value of name using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as notEqual.
     */
    public void setName_NotEqual(String value) {
        registerName(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of name using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as greaterThan.
     */
    public void setName_GreaterThan(String value) {
        registerName(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of name using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as lessThan.
     */
    public void setName_LessThan(String value) {
        registerName(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of name using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as greaterEqual.
     */
    public void setName_GreaterEqual(String value) {
        registerName(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of name using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as lessEqual.
     */
    public void setName_LessEqual(String value) {
        registerName(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of name using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of name as prefixSearch.
     */
    public void setName_PrefixSearch(String value) {
        registerName(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of name using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of name as inScope.
     */
    public void setName_InScope(java.util.List<String> valueList) {
        registerName(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }

    /**
     * Set the value of name using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of name as notInScope.
     */
    public void setName_NotInScope(java.util.List<String> valueList) {
        registerName(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }
                                              
    /**
     * Register condition of name.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of name. (Nullable)
     */
    protected void registerName(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueName(), COL_name, J_Name, UJ_name);
    }

    /**
     * Register inline condition of name.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of name. (Nullable)
     */
    protected void registerInlineName(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueName(), COL_name, J_Name, UJ_name);
    }

    abstract protected ConditionValue getCValueName();
      
    /** Column db name of telephone. */
    protected static final String COL_telephone = "telephone";

    /** Column java name of telephone. */
    protected static final String J_Telephone = "Telephone";

    /** Column uncapitalised java name of telephone. */
    protected static final String UJ_telephone = "telephone";
    
    /**
     * Set the value of telephone using equal. { = }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as equal.
     */
    public void setTelephone_Equal(String value) {
        registerTelephone(ConditionKey.CK_EQUAL, filterRemoveEmptyString(value));
    }
            
    /**
     * Set the value of telephone using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as notEqual.
     */
    public void setTelephone_NotEqual(String value) {
        registerTelephone(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of telephone using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as greaterThan.
     */
    public void setTelephone_GreaterThan(String value) {
        registerTelephone(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of telephone using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as lessThan.
     */
    public void setTelephone_LessThan(String value) {
        registerTelephone(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of telephone using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as greaterEqual.
     */
    public void setTelephone_GreaterEqual(String value) {
        registerTelephone(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of telephone using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as lessEqual.
     */
    public void setTelephone_LessEqual(String value) {
        registerTelephone(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of telephone using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param value The value of telephone as prefixSearch.
     */
    public void setTelephone_PrefixSearch(String value) {
        registerTelephone(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(value));
    }

    /**
     * Set the value of telephone using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of telephone as inScope.
     */
    public void setTelephone_InScope(java.util.List<String> valueList) {
        registerTelephone(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }

    /**
     * Set the value of telephone using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of telephone as notInScope.
     */
    public void setTelephone_NotInScope(java.util.List<String> valueList) {
        registerTelephone(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(valueList));
    }
                                          
    /**
     * Set the value of telephone using isNull. { is null }
     */
    public void setTelephone_IsNull() {
        registerTelephone(ConditionKey.CK_IS_NULL, DUMMY_OBJECT);
    }

    /**
     * Set the value of telephone using isNotNull. { is not null }
     */
    public void setTelephone_IsNotNull() {
        registerTelephone(ConditionKey.CK_IS_NOT_NULL, DUMMY_OBJECT);
    }
        
    /**
     * Register condition of telephone.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of telephone. (Nullable)
     */
    protected void registerTelephone(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueTelephone(), COL_telephone, J_Telephone, UJ_telephone);
    }

    /**
     * Register inline condition of telephone.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of telephone. (Nullable)
     */
    protected void registerInlineTelephone(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueTelephone(), COL_telephone, J_Telephone, UJ_telephone);
    }

    abstract protected ConditionValue getCValueTelephone();
      
    /** Column db name of versionno. */
    protected static final String COL_versionno = "versionno";

    /** Column java name of versionno. */
    protected static final String J_Versionno = "Versionno";

    /** Column uncapitalised java name of versionno. */
    protected static final String UJ_versionno = "versionno";
            
    /**
     * Set the value of versionno using equal. { = }
     * 
     * @param value The value of versionno as equal.
     */
    public void setVersionno_Equal(java.math.BigDecimal value) {
        registerVersionno(ConditionKey.CK_EQUAL, value);
    }
      
    /**
     * Set the value of versionno using notEqual. { != }
     * 
     * @param value The value of versionno as notEqual.
     */
    public void setVersionno_NotEqual(java.math.BigDecimal value) {
        registerVersionno(ConditionKey.CK_NOT_EQUAL, value);
    }

    /**
     * Set the value of versionno using greaterThan. { &gt; }
     * 
     * @param value The value of versionno as greaterThan.
     */
    public void setVersionno_GreaterThan(java.math.BigDecimal value) {
        registerVersionno(ConditionKey.CK_GREATER_THAN, value);
    }

    /**
     * Set the value of versionno using lessThan. { &lt; }
     * 
     * @param value The value of versionno as lessThan.
     */
    public void setVersionno_LessThan(java.math.BigDecimal value) {
        registerVersionno(ConditionKey.CK_LESS_THAN, value);
    }
      
    /**
     * Set the value of versionno using greaterEqual. { &gt;= }
     * 
     * @param value The value of versionno as greaterEqual.
     */
    public void setVersionno_GreaterEqual(java.math.BigDecimal value) {
        registerVersionno(ConditionKey.CK_GREATER_EQUAL, value);
    }

    /**
     * Set the value of versionno using lessEqual. { &lt;= }
     * 
     * @param value The value of versionno as lessEqual.
     */
    public void setVersionno_LessEqual(java.math.BigDecimal value) {
        registerVersionno(ConditionKey.CK_LESS_EQUAL, value);
    }

    /**
     * Set the value of versionno using inScope. { in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of versionno as inScope.
     */
    public void setVersionno_InScope(java.util.List<java.math.BigDecimal> valueList) {
        registerVersionno(ConditionKey.CK_IN_SCOPE, valueList);
    }

    /**
     * Set the value of versionno using notInScope. { not in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param valueList The value of versionno as notInScope.
     */
    public void setVersionno_NotInScope(java.util.List<java.math.BigDecimal> valueList) {
        registerVersionno(ConditionKey.CK_NOT_IN_SCOPE, valueList);
    }
                                          
    /**
     * Register condition of versionno.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of versionno. (Nullable)
     */
    protected void registerVersionno(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueVersionno(), COL_versionno, J_Versionno, UJ_versionno);
    }

    /**
     * Register inline condition of versionno.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of versionno. (Nullable)
     */
    protected void registerInlineVersionno(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueVersionno(), COL_versionno, J_Versionno, UJ_versionno);
    }

    abstract protected ConditionValue getCValueVersionno();
  
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
