package org.seasar.golf.uexample.dao.bsentity;


import org.seasar.golf.uexample.dao.allcommon.Entity;
import org.seasar.golf.uexample.dao.allcommon.dbmeta.DBMeta;
import org.seasar.golf.uexample.dao.bsentity.dbmeta.CompanyDbm;


/**
 * The entity of company.
 * 
 * <pre>
 * [primary-key]
 *     ccode
 * 
 * [column-property]
 *     ccode, cat, shortname, name, telephone, versionno
 * 
 * [foreign-property]
 *     
 * 
 * [refferer-property]
 *     
 * 
 * [sequence]
 *     company_ccode_seq
 * 
 * [identity]
 *     
 * 
 * [update-date]
 *     
 * 
 * [version-no]
 *     Versionno
 * 
 * </pre>
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCompany implements Entity, java.io.Serializable {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** TABLE-Annotation for S2Dao */
    public static final String TABLE = "company";

    
    /** VERSION_NO-Annotation */
    public static final String VERSION_NO_PROPERTY = "versionno";

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Entity modified properties. (for S2Dao) */
    protected EntityModifiedProperties _modifiedProperties = newEntityModifiedProperties();

  
    /** The value of ccode. */
    protected java.math.BigDecimal _ccode;
    
    /** The value of cat. */
    protected String _cat;
    
    /** The value of shortname. */
    protected String _shortname;
    
    /** The value of name. */
    protected String _name;
    
    /** The value of telephone. */
    protected String _telephone;
    
    /** The value of versionno. */
    protected java.math.BigDecimal _versionno;
  
    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public BsCompany() {
    }

    // =====================================================================================
    //                                                                                DBMeta
    //                                                                                ======
    /**
     * This method implements the method that is declared at super.
     * 
     * @return DBMeta. (NotNull)
     */
    public DBMeta getDBMeta() {
        return CompanyDbm.getInstance();
    }

    // =====================================================================================
    //                                                                            Table Name
    //                                                                            ==========
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName() {
        return getDBMeta().getTableDbName();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table cap-prop-name. (NotNull)
     */
    public String getTableCapPropName() {
        return getDBMeta().getTableCapPropName();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table uncap-prop-name. (NotNull)
     */
    public String getTableUncapPropName() {
        return getDBMeta().getTableUncapPropName();
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========

    /** Column-Annotation for S2Dao */
    public static final String ccode_COLUMN = "ccode";

    /**
     * Get the value of ccode.
     * 
     * @return The value of ccode. (Nullable)
     */
    public java.math.BigDecimal getCcode() {
        return _ccode;
    }
  
    /**
     * Set the value of ccode.
     * 
     * @param ccode The value of ccode. (Nullable)
     */
    public void setCcode(java.math.BigDecimal ccode) {
        _modifiedProperties.addPropertyName("ccode");
        _ccode = ccode;
    }
  
    /** Column-Annotation for S2Dao */
    public static final String cat_COLUMN = "cat";

    /**
     * Get the value of cat.
     * 
     * @return The value of cat. (Nullable)
     */
    public String getCat() {
        return _cat;
    }
  
    /**
     * Set the value of cat.
     * 
     * @param cat The value of cat. (Nullable)
     */
    public void setCat(String cat) {
        _modifiedProperties.addPropertyName("cat");
        _cat = cat;
    }
  
    /** Column-Annotation for S2Dao */
    public static final String shortname_COLUMN = "shortname";

    /**
     * Get the value of shortname.
     * 
     * @return The value of shortname. (Nullable)
     */
    public String getShortname() {
        return _shortname;
    }
  
    /**
     * Set the value of shortname.
     * 
     * @param shortname The value of shortname. (Nullable)
     */
    public void setShortname(String shortname) {
        _modifiedProperties.addPropertyName("shortname");
        _shortname = shortname;
    }
  
    /** Column-Annotation for S2Dao */
    public static final String name_COLUMN = "name";

    /**
     * Get the value of name.
     * 
     * @return The value of name. (Nullable)
     */
    public String getName() {
        return _name;
    }
  
    /**
     * Set the value of name.
     * 
     * @param name The value of name. (Nullable)
     */
    public void setName(String name) {
        _modifiedProperties.addPropertyName("name");
        _name = name;
    }
  
    /** Column-Annotation for S2Dao */
    public static final String telephone_COLUMN = "telephone";

    /**
     * Get the value of telephone.
     * 
     * @return The value of telephone. (Nullable)
     */
    public String getTelephone() {
        return _telephone;
    }
  
    /**
     * Set the value of telephone.
     * 
     * @param telephone The value of telephone. (Nullable)
     */
    public void setTelephone(String telephone) {
        _modifiedProperties.addPropertyName("telephone");
        _telephone = telephone;
    }
  
    /** Column-Annotation for S2Dao */
    public static final String versionno_COLUMN = "versionno";

    /**
     * Get the value of versionno.
     * 
     * @return The value of versionno. (Nullable)
     */
    public java.math.BigDecimal getVersionno() {
        return _versionno;
    }
  
    /**
     * Set the value of versionno.
     * 
     * @param versionno The value of versionno. (Nullable)
     */
    public void setVersionno(java.math.BigDecimal versionno) {
        _modifiedProperties.addPropertyName("versionno");
        _versionno = versionno;
    }
  
    // =====================================================================================
    //                                                                Invoking Determination
    //                                                                ======================
            
    // =====================================================================================
    //                                                                       Classify Method
    //                                                                       ===============
            
    // =====================================================================================
    //                                                          Classification Determination
    //                                                          ============================
            
    // =====================================================================================
    //                                                                 Classification Getter
    //                                                                 =====================
            
    // =====================================================================================
    //                                                                         Foreign Table
    //                                                                         =============

    // =====================================================================================
    //                                                                        Refferer Table
    //                                                                        ==============

    // =====================================================================================
    //                                                                                Accept
    //                                                                                ======
    /**
     * This method implements the method that is declared at super.
     * 
     * @param primaryKeyMap Primary key map. (NotNull and NotEmpty)
     */
    public void acceptPrimaryKeyMap(java.util.Map<String, ? extends Object> primaryKeyMap) {
        MapAssertUtil.assertPrimaryKeyMapNotNullAndNotEmpty(primaryKeyMap);
  
        MapAssertUtil.assertColumnExistingInPrimaryKeyMap(primaryKeyMap, "ccode");
        {
            final Object obj = primaryKeyMap.get("ccode");
            if (obj == null) {
                _ccode = null; _modifiedProperties.remove("ccode");
            } else {
                  
                if (obj instanceof java.math.BigDecimal) {
                    setCcode((java.math.BigDecimal)obj);
                } else {
                    try {
                        setCcode(new java.math.BigDecimal((String)obj));
                    } catch (RuntimeException e) {
                        String msg = "setCcode(new java.math.BigDecimal((String)obj))";
                        throw new RuntimeException(msg + " threw the exception: value=[" + obj + "]", e);
                    }
                }
            }
        }
                    
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param primaryKeyMapString Primary-key map-string. (NotNull and NotEmpty)
     */
    public void acceptPrimaryKeyMapString(String primaryKeyMapString) {
        MapStringUtil.acceptPrimaryKeyMapString(primaryKeyMapString, this);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param columnValueMap Column-value map. (NotNull and NotEmpty)
     */
    public void acceptColumnValueMap(java.util.Map<String, ? extends Object> columnValueMap) {
        MapAssertUtil.assertColumnValueMapNotNullAndNotEmpty(columnValueMap);
  
        {
            final Object obj = columnValueMap.get("ccode");
            if (obj == null) {
                _ccode = null; _modifiedProperties.remove("ccode");
            } else {
                  
                if (obj instanceof java.math.BigDecimal) {
                    setCcode((java.math.BigDecimal)obj);
                } else {
                    try {
                        setCcode(new java.math.BigDecimal((String)obj));
                    } catch (RuntimeException e) {
                        String msg = "setCcode(new java.math.BigDecimal((String)obj))";
                        throw new RuntimeException(msg + " threw the exception: value=[" + obj + "]", e);
                    }
                }
            }
        }
                    
        {
            final Object obj = columnValueMap.get("cat");
            if (obj == null) {
                _cat = null; _modifiedProperties.remove("cat");
            } else {
    
                checkTypeString(obj, "cat", "String");
                setCat((String)obj);
            }
        }
      
        {
            final Object obj = columnValueMap.get("shortname");
            if (obj == null) {
                _shortname = null; _modifiedProperties.remove("shortname");
            } else {
    
                checkTypeString(obj, "shortname", "String");
                setShortname((String)obj);
            }
        }
      
        {
            final Object obj = columnValueMap.get("name");
            if (obj == null) {
                _name = null; _modifiedProperties.remove("name");
            } else {
    
                checkTypeString(obj, "name", "String");
                setName((String)obj);
            }
        }
      
        {
            final Object obj = columnValueMap.get("telephone");
            if (obj == null) {
                _telephone = null; _modifiedProperties.remove("telephone");
            } else {
    
                checkTypeString(obj, "telephone", "String");
                setTelephone((String)obj);
            }
        }
      
        {
            final Object obj = columnValueMap.get("versionno");
            if (obj == null) {
                _versionno = null; _modifiedProperties.remove("versionno");
            } else {
                  
                if (obj instanceof java.math.BigDecimal) {
                    setVersionno((java.math.BigDecimal)obj);
                } else {
                    try {
                        setVersionno(new java.math.BigDecimal((String)obj));
                    } catch (RuntimeException e) {
                        String msg = "setVersionno(new java.math.BigDecimal((String)obj))";
                        throw new RuntimeException(msg + " threw the exception: value=[" + obj + "]", e);
                    }
                }
            }
        }
                    
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param columnValueMapString Column-value map-string. (NotNull and NotEmpty)
     */
    public void acceptColumnValueMapString(String columnValueMapString) {
        MapStringUtil.acceptColumnValueMapString(columnValueMapString, this);
    }

    protected void checkTypeString(Object value, String propertyName, String typeName) {
        MapStringUtil.checkTypeString(value, propertyName, typeName);
    }

    protected long parseDateString(Object value, String propertyName, String typeName) {
        return MapStringUtil.parseDateString(value, propertyName, typeName);
    }

    // =====================================================================================
    //                                                                               Extract
    //                                                                               =======
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Primary-key map-string. (NotNull)
     */
    public String extractPrimaryKeyMapString() {
        return MapStringUtil.extractPrimaryKeyMapString(this);
    }

    /**
     * Extract primary-key map-string.
     * 
     * @param startBrace Start-brace. (NotNull)
     * @param endBrace End-brace. (NotNull)
     * @param delimiter Delimiter. (NotNull)
     * @param equal Equal. (NotNull)
     * @return Primary-key map-string. (NotNull)
     */
    public String extractPrimaryKeyMapString(String startBrace, String endBrace, String delimiter, String equal) {

        final String mapMarkAndStartBrace = MAP_STRING_MAP_MARK + startBrace;
        final StringBuffer sb = new StringBuffer();
      
        sb.append(delimiter).append("ccode").append(equal);
        sb.append((_ccode != null ? _ccode.toString() : ""));
      
        sb.delete(0, delimiter.length()).insert(0, mapMarkAndStartBrace).append(endBrace);
        return sb.toString();

    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Column-value map-string. (NotNull)
     */
    public String extractColumnValueMapString() {
        return MapStringUtil.extractColumnValueMapString(this);
    }

    /**
     * Extract column-value map-string.
     * 
     * @param startBrace Start-brace. (NotNull)
     * @param endBrace End-brace. (NotNull)
     * @param delimiter Delimiter. (NotNull)
     * @param equal Equal. (NotNull)
     * @return Column-value map-string. (NotNull)
     */
    public String extractColumnValueMapString(String startBrace, String endBrace, String delimiter, String equal) {
        final String mapMarkAndStartBrace = MAP_STRING_MAP_MARK + startBrace;
        final StringBuffer sb = new StringBuffer();
    
        sb.append(delimiter).append("ccode").append(equal);
        sb.append((_ccode != null ? _ccode.toString() : ""));
        
        sb.append(delimiter).append("cat").append(equal);
        sb.append((_cat != null ? _cat.toString() : ""));
        
        sb.append(delimiter).append("shortname").append(equal);
        sb.append((_shortname != null ? _shortname.toString() : ""));
        
        sb.append(delimiter).append("name").append(equal);
        sb.append((_name != null ? _name.toString() : ""));
        
        sb.append(delimiter).append("telephone").append(equal);
        sb.append((_telephone != null ? _telephone.toString() : ""));
        
        sb.append(delimiter).append("versionno").append(equal);
        sb.append((_versionno != null ? _versionno.toString() : ""));
    
        sb.delete(0, delimiter.length()).insert(0, mapMarkAndStartBrace).append(endBrace);
        return sb.toString();
    }


    protected String formatDate(java.util.Date value) {
        return MapStringUtil.formatDate(value);
    }

    // =====================================================================================
    //                                                                         Determination
    //                                                                         =============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean hasPrimaryKeyValue() {
  
        if (_ccode == null) {
            return false;
        }
  
        return true;
    }

    // =====================================================================================
    //                                                                   Modified Properties
    //                                                                   ===================
    public java.util.Set<String> getModifiedPropertyNames() {
        return _modifiedProperties.getPropertyNames();
    }

    protected EntityModifiedProperties newEntityModifiedProperties() {
        return new EntityModifiedProperties();
    }

    /**
     * Clear modified property names.
     */
    public void clearModifiedPropertyNames() {
        _modifiedProperties.clear();
    }

    // =====================================================================================
    //                                                                        Basic Override
    //                                                                        ==============

    /**
     * This method overrides the method that is declared at super.
     * If the primary-key of the other is same as this one, returns true.
     * 
     * @param other Other entity.
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (!(other instanceof BsCompany)) {
            return false;
        }
        final BsCompany otherEntity = (BsCompany)other;
  
        if (getCcode() == null || !getCcode().equals(otherEntity.getCcode())) {
            return false;
        }
  
        return true;
    }

    /**
     * This method overrides the method that is declared at super.
     * Calculates hash-code from primary-key.
     * 
     * @return Hash-code from primary-keys.
     */
    public int hashCode() {
        int result = 0;
  
        if (this.getCcode() != null) {
            result = result + getCcode().hashCode();
        }
  
        return result;
    }

    /**
     * This method overrides the method that is declared at super.
     * 
     * @return Column-value map-string. (NotNull)
     */
    public String toString() {
        final String delimiter = ",";
        final StringBuffer sb = new StringBuffer();

        sb.append(delimiter).append(getCcode());

        sb.append(delimiter).append(getCat());

        sb.append(delimiter).append(getShortname());

        sb.append(delimiter).append(getName());

        sb.append(delimiter).append(getTelephone());

        sb.append(delimiter).append(getVersionno());

        sb.delete(0, delimiter.length());
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
}
