
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
public abstract class AbstractBsVendorCQ extends AbstractConditionQuery {

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
    public AbstractBsVendorCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "vendor";
    }

    // =====================================================================================
    //                                                                                 Query
    //                                                                                 =====
      
    // /* * * * * * * * * * * * * * * * * * * * * * *
    //   MyTable = [vendor]
    // * * * * * * * * */

      
    /** Column db name of id. */
    protected static final String COL_id = "id";

    /** Column java name of id. */
    protected static final String J_Id = "Id";

    /** Column uncapitalised java name of id. */
    protected static final String UJ_id = "id";
            
    /**
     * Set the value of id using equal. { = }
     * 
     * @param id The value of id as equal.
     */
    public void setId_Equal(java.math.BigDecimal id) {
        registerId(ConditionKey.CK_EQUAL, id);
    }
            
    /**
     * Set the value of id using notEqual. { != }
     * 
     * @param id The value of id as notEqual.
     */
    public void setId_NotEqual(java.math.BigDecimal id) {
        registerId(ConditionKey.CK_NOT_EQUAL, id);
    }
            
    /**
     * Set the value of id using greaterThan. { &gt; }
     * 
     * @param id The value of id as greaterThan.
     */
    public void setId_GreaterThan(java.math.BigDecimal id) {
        registerId(ConditionKey.CK_GREATER_THAN, id);
    }
            
    /**
     * Set the value of id using lessThan. { &lt; }
     * 
     * @param id The value of id as lessThan.
     */
    public void setId_LessThan(java.math.BigDecimal id) {
        registerId(ConditionKey.CK_LESS_THAN, id);
    }
            
    /**
     * Set the value of id using greaterEqual. { &gt;= }
     * 
     * @param id The value of id as greaterEqual.
     */
    public void setId_GreaterEqual(java.math.BigDecimal id) {
        registerId(ConditionKey.CK_GREATER_EQUAL, id);
    }
            
    /**
     * Set the value of id using lessEqual. { &lt;= }
     * 
     * @param id The value of id as lessEqual.
     */
    public void setId_LessEqual(java.math.BigDecimal id) {
        registerId(ConditionKey.CK_LESS_EQUAL, id);
    }
                  
    /**
     * Set the value of id using inScope. { in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param idList The value of id as inScope.
     */
    public void setId_InScope(java.util.List<java.math.BigDecimal> idList) {
        registerId(ConditionKey.CK_IN_SCOPE, idList);
    }
            
    /**
     * Set the value of id using notInScope. { not in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param idList The value of id as notInScope.
     */
    public void setId_NotInScope(java.util.List<java.math.BigDecimal> idList) {
        registerId(ConditionKey.CK_NOT_IN_SCOPE, idList);
    }
                                                
    /**
     * Register condition of id.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of id. (Nullable)
     */
    protected void registerId(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueId(), COL_id, J_Id, UJ_id);
    }

    /**
     * Register inline condition of id.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of id. (Nullable)
     */
    protected void registerInlineId(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueId(), COL_id, J_Id, UJ_id);
    }

    abstract protected ConditionValue getCValueId();
      
    /** Column db name of vcode. */
    protected static final String COL_vcode = "vcode";

    /** Column java name of vcode. */
    protected static final String J_Vcode = "Vcode";

    /** Column uncapitalised java name of vcode. */
    protected static final String UJ_vcode = "vcode";
    
    /**
     * Set the value of vcode using equal. { = }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as equal.
     */
    public void setVcode_Equal(String vcode) {
        registerVcode(ConditionKey.CK_EQUAL, filterRemoveEmptyString(vcode));
    }
                  
    /**
     * Set the value of vcode using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as notEqual.
     */
    public void setVcode_NotEqual(String vcode) {
        registerVcode(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(vcode));
    }
            
    /**
     * Set the value of vcode using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as greaterThan.
     */
    public void setVcode_GreaterThan(String vcode) {
        registerVcode(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(vcode));
    }
            
    /**
     * Set the value of vcode using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as lessThan.
     */
    public void setVcode_LessThan(String vcode) {
        registerVcode(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(vcode));
    }
            
    /**
     * Set the value of vcode using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as greaterEqual.
     */
    public void setVcode_GreaterEqual(String vcode) {
        registerVcode(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(vcode));
    }
            
    /**
     * Set the value of vcode using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as lessEqual.
     */
    public void setVcode_LessEqual(String vcode) {
        registerVcode(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(vcode));
    }
            
    /**
     * Set the value of vcode using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param vcode The value of vcode as prefixSearch.
     */
    public void setVcode_PrefixSearch(String vcode) {
        registerVcode(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(vcode));
    }
            
    /**
     * Set the value of vcode using likeSearch. { like '%xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * You can invoke this method several times and the conditions are set up.
     * 
     * @param vcode The value of vcode as likeSearch.
     * @param likeSearchOption Like search option. (NotNull)
     */
    public void setVcode_LikeSearch(String vcode, org.seasar.golf.uexample.dao.allcommon.cbean.coption.LikeSearchOption option) {
        registerLikeSearchQuery(ConditionKey.CK_LIKE_SEARCH, filterRemoveEmptyString(vcode), getCValueVcode(), COL_vcode, J_Vcode, UJ_vcode, option);
    }
            
    /**
     * Set the value of vcode using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param vcodeList The value of vcode as inScope.
     */
    public void setVcode_InScope(java.util.List<String> vcodeList) {
        registerVcode(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(vcodeList));
    }

    /**
     * Set the value of vcode using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param vcode The value of vcode as inScope.
     */
    public void setVcode_InScope(String vcode, org.seasar.golf.uexample.dao.allcommon.cbean.coption.InScopeOption option) {
        registerInScopeQuery(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyString(vcode), getCValueVcode(), COL_vcode, J_Vcode, UJ_vcode, option);
    }
            
    /**
     * Set the value of vcode using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param vcodeList The value of vcode as notInScope.
     */
    public void setVcode_NotInScope(java.util.List<String> vcodeList) {
        registerVcode(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(vcodeList));
    }
                                                    
    /**
     * Register condition of vcode.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of vcode. (Nullable)
     */
    protected void registerVcode(ConditionKey key, Object value) {
        registerQuery(key, value, getCValueVcode(), COL_vcode, J_Vcode, UJ_vcode);
    }

    /**
     * Register inline condition of vcode.
     * 
     * @param key Condition key. (NotNull)
     * @param value The value of vcode. (Nullable)
     */
    protected void registerInlineVcode(ConditionKey key, Object value) {
        registerInlineQuery(key, value, getCValueVcode(), COL_vcode, J_Vcode, UJ_vcode);
    }

    abstract protected ConditionValue getCValueVcode();
      
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
     * @param shortname The value of shortname as equal.
     */
    public void setShortname_Equal(String shortname) {
        registerShortname(ConditionKey.CK_EQUAL, filterRemoveEmptyString(shortname));
    }
                  
    /**
     * Set the value of shortname using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param shortname The value of shortname as notEqual.
     */
    public void setShortname_NotEqual(String shortname) {
        registerShortname(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(shortname));
    }
            
    /**
     * Set the value of shortname using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param shortname The value of shortname as greaterThan.
     */
    public void setShortname_GreaterThan(String shortname) {
        registerShortname(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(shortname));
    }
            
    /**
     * Set the value of shortname using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param shortname The value of shortname as lessThan.
     */
    public void setShortname_LessThan(String shortname) {
        registerShortname(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(shortname));
    }
            
    /**
     * Set the value of shortname using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param shortname The value of shortname as greaterEqual.
     */
    public void setShortname_GreaterEqual(String shortname) {
        registerShortname(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(shortname));
    }
            
    /**
     * Set the value of shortname using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param shortname The value of shortname as lessEqual.
     */
    public void setShortname_LessEqual(String shortname) {
        registerShortname(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(shortname));
    }
            
    /**
     * Set the value of shortname using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param shortname The value of shortname as prefixSearch.
     */
    public void setShortname_PrefixSearch(String shortname) {
        registerShortname(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(shortname));
    }
            
    /**
     * Set the value of shortname using likeSearch. { like '%xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * You can invoke this method several times and the conditions are set up.
     * 
     * @param shortname The value of shortname as likeSearch.
     * @param likeSearchOption Like search option. (NotNull)
     */
    public void setShortname_LikeSearch(String shortname, org.seasar.golf.uexample.dao.allcommon.cbean.coption.LikeSearchOption option) {
        registerLikeSearchQuery(ConditionKey.CK_LIKE_SEARCH, filterRemoveEmptyString(shortname), getCValueShortname(), COL_shortname, J_Shortname, UJ_shortname, option);
    }
            
    /**
     * Set the value of shortname using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param shortnameList The value of shortname as inScope.
     */
    public void setShortname_InScope(java.util.List<String> shortnameList) {
        registerShortname(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(shortnameList));
    }

    /**
     * Set the value of shortname using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param shortname The value of shortname as inScope.
     */
    public void setShortname_InScope(String shortname, org.seasar.golf.uexample.dao.allcommon.cbean.coption.InScopeOption option) {
        registerInScopeQuery(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyString(shortname), getCValueShortname(), COL_shortname, J_Shortname, UJ_shortname, option);
    }
            
    /**
     * Set the value of shortname using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param shortnameList The value of shortname as notInScope.
     */
    public void setShortname_NotInScope(java.util.List<String> shortnameList) {
        registerShortname(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(shortnameList));
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
     * @param name The value of name as equal.
     */
    public void setName_Equal(String name) {
        registerName(ConditionKey.CK_EQUAL, filterRemoveEmptyString(name));
    }
                  
    /**
     * Set the value of name using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param name The value of name as notEqual.
     */
    public void setName_NotEqual(String name) {
        registerName(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(name));
    }
            
    /**
     * Set the value of name using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param name The value of name as greaterThan.
     */
    public void setName_GreaterThan(String name) {
        registerName(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(name));
    }
            
    /**
     * Set the value of name using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param name The value of name as lessThan.
     */
    public void setName_LessThan(String name) {
        registerName(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(name));
    }
            
    /**
     * Set the value of name using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param name The value of name as greaterEqual.
     */
    public void setName_GreaterEqual(String name) {
        registerName(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(name));
    }
            
    /**
     * Set the value of name using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param name The value of name as lessEqual.
     */
    public void setName_LessEqual(String name) {
        registerName(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(name));
    }
            
    /**
     * Set the value of name using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param name The value of name as prefixSearch.
     */
    public void setName_PrefixSearch(String name) {
        registerName(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(name));
    }
            
    /**
     * Set the value of name using likeSearch. { like '%xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * You can invoke this method several times and the conditions are set up.
     * 
     * @param name The value of name as likeSearch.
     * @param likeSearchOption Like search option. (NotNull)
     */
    public void setName_LikeSearch(String name, org.seasar.golf.uexample.dao.allcommon.cbean.coption.LikeSearchOption option) {
        registerLikeSearchQuery(ConditionKey.CK_LIKE_SEARCH, filterRemoveEmptyString(name), getCValueName(), COL_name, J_Name, UJ_name, option);
    }
            
    /**
     * Set the value of name using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param nameList The value of name as inScope.
     */
    public void setName_InScope(java.util.List<String> nameList) {
        registerName(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(nameList));
    }

    /**
     * Set the value of name using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param name The value of name as inScope.
     */
    public void setName_InScope(String name, org.seasar.golf.uexample.dao.allcommon.cbean.coption.InScopeOption option) {
        registerInScopeQuery(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyString(name), getCValueName(), COL_name, J_Name, UJ_name, option);
    }
            
    /**
     * Set the value of name using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param nameList The value of name as notInScope.
     */
    public void setName_NotInScope(java.util.List<String> nameList) {
        registerName(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(nameList));
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
     * @param telephone The value of telephone as equal.
     */
    public void setTelephone_Equal(String telephone) {
        registerTelephone(ConditionKey.CK_EQUAL, filterRemoveEmptyString(telephone));
    }
                  
    /**
     * Set the value of telephone using notEqual. { != }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param telephone The value of telephone as notEqual.
     */
    public void setTelephone_NotEqual(String telephone) {
        registerTelephone(ConditionKey.CK_NOT_EQUAL, filterRemoveEmptyString(telephone));
    }
            
    /**
     * Set the value of telephone using greaterThan. { &gt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param telephone The value of telephone as greaterThan.
     */
    public void setTelephone_GreaterThan(String telephone) {
        registerTelephone(ConditionKey.CK_GREATER_THAN, filterRemoveEmptyString(telephone));
    }
            
    /**
     * Set the value of telephone using lessThan. { &lt; }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param telephone The value of telephone as lessThan.
     */
    public void setTelephone_LessThan(String telephone) {
        registerTelephone(ConditionKey.CK_LESS_THAN, filterRemoveEmptyString(telephone));
    }
            
    /**
     * Set the value of telephone using greaterEqual. { &gt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param telephone The value of telephone as greaterEqual.
     */
    public void setTelephone_GreaterEqual(String telephone) {
        registerTelephone(ConditionKey.CK_GREATER_EQUAL, filterRemoveEmptyString(telephone));
    }
            
    /**
     * Set the value of telephone using lessEqual. { &lt;= }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param telephone The value of telephone as lessEqual.
     */
    public void setTelephone_LessEqual(String telephone) {
        registerTelephone(ConditionKey.CK_LESS_EQUAL, filterRemoveEmptyString(telephone));
    }
            
    /**
     * Set the value of telephone using prefixSearch. { like 'xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * 
     * @param telephone The value of telephone as prefixSearch.
     */
    public void setTelephone_PrefixSearch(String telephone) {
        registerTelephone(ConditionKey.CK_PREFIX_SEARCH, filterRemoveEmptyString(telephone));
    }
            
    /**
     * Set the value of telephone using likeSearch. { like '%xxx%' }
     * If the value is null or empty-string, this condition is ignored.
     * You can invoke this method several times and the conditions are set up.
     * 
     * @param telephone The value of telephone as likeSearch.
     * @param likeSearchOption Like search option. (NotNull)
     */
    public void setTelephone_LikeSearch(String telephone, org.seasar.golf.uexample.dao.allcommon.cbean.coption.LikeSearchOption option) {
        registerLikeSearchQuery(ConditionKey.CK_LIKE_SEARCH, filterRemoveEmptyString(telephone), getCValueTelephone(), COL_telephone, J_Telephone, UJ_telephone, option);
    }
            
    /**
     * Set the value of telephone using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param telephoneList The value of telephone as inScope.
     */
    public void setTelephone_InScope(java.util.List<String> telephoneList) {
        registerTelephone(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyStringFromList(telephoneList));
    }

    /**
     * Set the value of telephone using inScope. { in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param telephone The value of telephone as inScope.
     */
    public void setTelephone_InScope(String telephone, org.seasar.golf.uexample.dao.allcommon.cbean.coption.InScopeOption option) {
        registerInScopeQuery(ConditionKey.CK_IN_SCOPE, filterRemoveEmptyString(telephone), getCValueTelephone(), COL_telephone, J_Telephone, UJ_telephone, option);
    }
            
    /**
     * Set the value of telephone using notInScope. { not in ('a', 'b') }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param telephoneList The value of telephone as notInScope.
     */
    public void setTelephone_NotInScope(java.util.List<String> telephoneList) {
        registerTelephone(ConditionKey.CK_NOT_IN_SCOPE, filterRemoveEmptyStringFromList(telephoneList));
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
     * @param versionno The value of versionno as equal.
     */
    public void setVersionno_Equal(java.math.BigDecimal versionno) {
        registerVersionno(ConditionKey.CK_EQUAL, versionno);
    }
            
    /**
     * Set the value of versionno using notEqual. { != }
     * 
     * @param versionno The value of versionno as notEqual.
     */
    public void setVersionno_NotEqual(java.math.BigDecimal versionno) {
        registerVersionno(ConditionKey.CK_NOT_EQUAL, versionno);
    }
            
    /**
     * Set the value of versionno using greaterThan. { &gt; }
     * 
     * @param versionno The value of versionno as greaterThan.
     */
    public void setVersionno_GreaterThan(java.math.BigDecimal versionno) {
        registerVersionno(ConditionKey.CK_GREATER_THAN, versionno);
    }
            
    /**
     * Set the value of versionno using lessThan. { &lt; }
     * 
     * @param versionno The value of versionno as lessThan.
     */
    public void setVersionno_LessThan(java.math.BigDecimal versionno) {
        registerVersionno(ConditionKey.CK_LESS_THAN, versionno);
    }
            
    /**
     * Set the value of versionno using greaterEqual. { &gt;= }
     * 
     * @param versionno The value of versionno as greaterEqual.
     */
    public void setVersionno_GreaterEqual(java.math.BigDecimal versionno) {
        registerVersionno(ConditionKey.CK_GREATER_EQUAL, versionno);
    }
            
    /**
     * Set the value of versionno using lessEqual. { &lt;= }
     * 
     * @param versionno The value of versionno as lessEqual.
     */
    public void setVersionno_LessEqual(java.math.BigDecimal versionno) {
        registerVersionno(ConditionKey.CK_LESS_EQUAL, versionno);
    }
                  
    /**
     * Set the value of versionno using inScope. { in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param versionnoList The value of versionno as inScope.
     */
    public void setVersionno_InScope(java.util.List<java.math.BigDecimal> versionnoList) {
        registerVersionno(ConditionKey.CK_IN_SCOPE, versionnoList);
    }
            
    /**
     * Set the value of versionno using notInScope. { not in (a, b) }
     * If the element in the list is null or empty-string, the condition-element is ignored.
     * 
     * @param versionnoList The value of versionno as notInScope.
     */
    public void setVersionno_NotInScope(java.util.List<java.math.BigDecimal> versionnoList) {
        registerVersionno(ConditionKey.CK_NOT_IN_SCOPE, versionnoList);
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
