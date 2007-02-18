
package org.seasar.golf.uexample.dao.cbean.cq.bs;

import org.seasar.golf.uexample.dao.cbean.cq.*;
  
import org.seasar.golf.uexample.dao.allcommon.cbean.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.ckey.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.cvalue.ConditionValue;
import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.SqlClause;
import org.seasar.golf.uexample.dao.cbean.cq.ciq.*;

/**
 * The condition-query of {table.Name}.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class BsCompanyCQ extends AbstractBsCompanyCQ {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected CompanyCIQ _inlineQuery;

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
    public BsCompanyCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // =====================================================================================
    //                                                                                Inline
    //                                                                                ======
    /**
     * Get inline query.
     * 
     * @return Inline query. (NotNull)
     */
    public CompanyCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = new CompanyCIQ(getChildQuery(), getSqlClause(), getAliasName(), getNestLevel(), this);
        }
        return _inlineQuery;
    }

    // =====================================================================================
    //                                                                         IncludeAsMine
    //                                                                         =============
  
    /**
     * Include select-column of ccode as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Ccode() {
        registerIncludedSelectColumn("Ccode", getRealColumnName("ccode"));
    }

    /**
     * Include select-column of ccode as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Ccode(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("ccode"));
    }
  
    /**
     * Include select-column of cat as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Cat() {
        registerIncludedSelectColumn("Cat", getRealColumnName("cat"));
    }

    /**
     * Include select-column of cat as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Cat(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("cat"));
    }
  
    /**
     * Include select-column of shortname as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Shortname() {
        registerIncludedSelectColumn("Shortname", getRealColumnName("shortname"));
    }

    /**
     * Include select-column of shortname as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Shortname(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("shortname"));
    }
  
    /**
     * Include select-column of name as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Name() {
        registerIncludedSelectColumn("Name", getRealColumnName("name"));
    }

    /**
     * Include select-column of name as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Name(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("name"));
    }
  
    /**
     * Include select-column of telephone as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Telephone() {
        registerIncludedSelectColumn("Telephone", getRealColumnName("telephone"));
    }

    /**
     * Include select-column of telephone as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Telephone(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("telephone"));
    }
  
    /**
     * Include select-column of versionno as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Versionno() {
        registerIncludedSelectColumn("Versionno", getRealColumnName("versionno"));
    }

    /**
     * Include select-column of versionno as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Versionno(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("versionno"));
    }
  
    // =====================================================================================
    //                                                                                 Query
    //                                                                                 =====
      
    // /* * * * * * * * * * * * * * * * * * * * * * *
    //   MyTable = [company]
    // * * * * * * * * */

  
    /** The attribute of ccode. */
    protected ConditionValue _ccode;

    /**
     * Get the value of ccode.
     * 
     * @return The value of ccode.
     */
    public ConditionValue getCcode() {
        if (_ccode == null) {
            _ccode = new ConditionValue();
        }
        return _ccode;
    }

    protected ConditionValue getCValueCcode() {
        return getCcode();
    }

                                                        
    /**
     * Add order-by of ccode as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Ccode_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_ccode), null, true);return this;
    }

    /**
     * Add order-by of ccode as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Ccode_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_ccode), null, false);return this;
    }
      
    /** The attribute of cat. */
    protected ConditionValue _cat;

    /**
     * Get the value of cat.
     * 
     * @return The value of cat.
     */
    public ConditionValue getCat() {
        if (_cat == null) {
            _cat = new ConditionValue();
        }
        return _cat;
    }

    protected ConditionValue getCValueCat() {
        return getCat();
    }

                                                        
    /**
     * Add order-by of cat as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Cat_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_cat), null, true);return this;
    }

    /**
     * Add order-by of cat as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Cat_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_cat), null, false);return this;
    }
      
    /** The attribute of shortname. */
    protected ConditionValue _shortname;

    /**
     * Get the value of shortname.
     * 
     * @return The value of shortname.
     */
    public ConditionValue getShortname() {
        if (_shortname == null) {
            _shortname = new ConditionValue();
        }
        return _shortname;
    }

    protected ConditionValue getCValueShortname() {
        return getShortname();
    }

                                                        
    /**
     * Add order-by of shortname as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Shortname_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_shortname), null, true);return this;
    }

    /**
     * Add order-by of shortname as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Shortname_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_shortname), null, false);return this;
    }
      
    /** The attribute of name. */
    protected ConditionValue _name;

    /**
     * Get the value of name.
     * 
     * @return The value of name.
     */
    public ConditionValue getName() {
        if (_name == null) {
            _name = new ConditionValue();
        }
        return _name;
    }

    protected ConditionValue getCValueName() {
        return getName();
    }

                                                        
    /**
     * Add order-by of name as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Name_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_name), null, true);return this;
    }

    /**
     * Add order-by of name as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Name_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_name), null, false);return this;
    }
      
    /** The attribute of telephone. */
    protected ConditionValue _telephone;

    /**
     * Get the value of telephone.
     * 
     * @return The value of telephone.
     */
    public ConditionValue getTelephone() {
        if (_telephone == null) {
            _telephone = new ConditionValue();
        }
        return _telephone;
    }

    protected ConditionValue getCValueTelephone() {
        return getTelephone();
    }

                                                            
    /**
     * Add order-by of telephone as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Telephone_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_telephone), null, true);return this;
    }

    /**
     * Add order-by of telephone as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Telephone_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_telephone), null, false);return this;
    }
      
    /** The attribute of versionno. */
    protected ConditionValue _versionno;

    /**
     * Get the value of versionno.
     * 
     * @return The value of versionno.
     */
    public ConditionValue getVersionno() {
        if (_versionno == null) {
            _versionno = new ConditionValue();
        }
        return _versionno;
    }

    protected ConditionValue getCValueVersionno() {
        return getVersionno();
    }

                                                        
    /**
     * Add order-by of versionno as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Versionno_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_versionno), null, true);return this;
    }

    /**
     * Add order-by of versionno as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsCompanyCQ addOrderBy_Versionno_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_versionno), null, false);return this;
    }
      
    // =====================================================================================
    //                                                               Query-SetupOuter-Method
    //                                                               =======================

  
  
}
