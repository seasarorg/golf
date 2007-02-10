
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
public class BsVendorCQ extends AbstractBsVendorCQ {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected VendorCIQ _inlineQuery;

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
    public BsVendorCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
    public VendorCIQ inline() {
        if (_inlineQuery == null) {
            _inlineQuery = new VendorCIQ(getChildQuery(), getSqlClause(), getAliasName(), getNestLevel(), this);
        }
        return _inlineQuery;
    }

    // =====================================================================================
    //                                                                         IncludeAsMine
    //                                                                         =============
  
    /**
     * Include select-column of id as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Id() {
        registerIncludedSelectColumn("Id", getRealColumnName("id"));
    }

    /**
     * Include select-column of id as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Id(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("id"));
    }
  
    /**
     * Include select-column of vcode as mine.
     * Alias name is java-name of this column.
     * Be careful to whether your table have the same column.
     */
    public void includeAsMine_Vcode() {
        registerIncludedSelectColumn("Vcode", getRealColumnName("vcode"));
    }

    /**
     * Include select-column of vcode as mine.
     * 
     * @param aliasName Alias name. {select columnName as aliasName from ...} This should not contain comma. (NotNull)
     */
    public void includeAsMine_Vcode(String aliasName) {
        registerIncludedSelectColumn(aliasName, getRealColumnName("vcode"));
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
    //   MyTable = [vendor]
    // * * * * * * * * */

  
    /** The attribute of id. */
    protected ConditionValue _id;

    /**
     * Get the value of id.
     * 
     * @return The value of id.
     */
    public ConditionValue getId() {
        if (_id == null) {
            _id = new ConditionValue();
        }
        return _id;
    }

    protected ConditionValue getCValueId() {
        return getId();
    }

                                                        
    /**
     * Add order-by of id as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Id_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_id), null, true);return this;
    }

    /**
     * Add order-by of id as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Id_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_id), null, false);return this;
    }
      
    /** The attribute of vcode. */
    protected ConditionValue _vcode;

    /**
     * Get the value of vcode.
     * 
     * @return The value of vcode.
     */
    public ConditionValue getVcode() {
        if (_vcode == null) {
            _vcode = new ConditionValue();
        }
        return _vcode;
    }

    protected ConditionValue getCValueVcode() {
        return getVcode();
    }

                                                        
    /**
     * Add order-by of vcode as ASC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Vcode_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_vcode), null, true);return this;
    }

    /**
     * Add order-by of vcode as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Vcode_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_vcode), null, false);return this;
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
    public BsVendorCQ addOrderBy_Shortname_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_shortname), null, true);return this;
    }

    /**
     * Add order-by of shortname as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Shortname_Desc() {
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
    public BsVendorCQ addOrderBy_Name_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_name), null, true);return this;
    }

    /**
     * Add order-by of name as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Name_Desc() {
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
    public BsVendorCQ addOrderBy_Telephone_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_telephone), null, true);return this;
    }

    /**
     * Add order-by of telephone as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Telephone_Desc() {
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
    public BsVendorCQ addOrderBy_Versionno_Asc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_versionno), null, true);return this;
    }

    /**
     * Add order-by of versionno as DESC.
     * 
     * @return this. (NotNull)
     */
    public BsVendorCQ addOrderBy_Versionno_Desc() {
        getSqlClause().registerOrderBy(getRealColumnName(COL_versionno), null, false);return this;
    }
      
    // =====================================================================================
    //                                                               Query-SetupOuter-Method
    //                                                               =======================

  
  
}
