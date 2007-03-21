package org.seasar.golf.uexample.dao.bsentity.dbmeta;


import org.seasar.golf.uexample.dao.allcommon.Entity;
import org.seasar.golf.uexample.dao.allcommon.dbmeta.DBMeta;
import org.seasar.golf.uexample.dao.allcommon.dbmeta.AbstractDBMeta;
import org.seasar.golf.uexample.dao.exentity.Company;

/**
 * The dbmeta of company. (Singleton)
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
public class CompanyDbm extends AbstractDBMeta {

    /** The type of entity. */
    protected static final Class ENTITY_TYPE = Company.class;

    /** Singleton instance. */
    private static final CompanyDbm _instance = new CompanyDbm();

    /**
     * Constructor
     */
    private CompanyDbm() {
    }

    /**
     * Get instance.
     * 
     * @return Singleton instance. (NotNull)
     */
    public static CompanyDbm getInstance() {
        return _instance;
    }

    // =====================================================================================
    //                                                                       Name Definition
    //                                                                       ===============
    /** Table db name. */
    public static final String TABLE_DB_NAME = "company";

    /** Table cap-prop name. */
    public static final String TABLE_CAP_PROP_NAME = "Company";

    /** Table uncap-prop name. */
    public static final String TABLE_UNCAP_PROP_NAME = "company";


    /** Db-name of Ccode. */
    public static final String COLUMN_DB_NAME_OF_Ccode = "ccode";

    /** Db-name of Cat. */
    public static final String COLUMN_DB_NAME_OF_Cat = "cat";

    /** Db-name of Shortname. */
    public static final String COLUMN_DB_NAME_OF_Shortname = "shortname";

    /** Db-name of Name. */
    public static final String COLUMN_DB_NAME_OF_Name = "name";

    /** Db-name of Telephone. */
    public static final String COLUMN_DB_NAME_OF_Telephone = "telephone";

    /** Db-name of Versionno. */
    public static final String COLUMN_DB_NAME_OF_Versionno = "versionno";


    /** Cap-prop-name of Ccode. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Ccode = "Ccode";

    /** Cap-prop-name of Cat. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Cat = "Cat";

    /** Cap-prop-name of Shortname. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Shortname = "Shortname";

    /** Cap-prop-name of Name. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Name = "Name";

    /** Cap-prop-name of Telephone. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Telephone = "Telephone";

    /** Cap-prop-name of Versionno. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Versionno = "Versionno";


    /** Uncap-prop-name of Ccode. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Ccode = "ccode";

    /** Uncap-prop-name of Cat. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Cat = "cat";

    /** Uncap-prop-name of Shortname. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Shortname = "shortname";

    /** Uncap-prop-name of Name. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Name = "name";

    /** Uncap-prop-name of Telephone. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Telephone = "telephone";

    /** Uncap-prop-name of Versionno. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Versionno = "versionno";

    /** {db-name : cap-prop-name} map. */
    protected static final java.util.Map<String, String> _dbNameCapPropNameMap;
    static {
        final java.util.Map<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.put(TABLE_DB_NAME, TABLE_CAP_PROP_NAME);

        map.put(COLUMN_DB_NAME_OF_Ccode, COLUMN_CAP_PROP_NAME_OF_Ccode);

        map.put(COLUMN_DB_NAME_OF_Cat, COLUMN_CAP_PROP_NAME_OF_Cat);

        map.put(COLUMN_DB_NAME_OF_Shortname, COLUMN_CAP_PROP_NAME_OF_Shortname);

        map.put(COLUMN_DB_NAME_OF_Name, COLUMN_CAP_PROP_NAME_OF_Name);

        map.put(COLUMN_DB_NAME_OF_Telephone, COLUMN_CAP_PROP_NAME_OF_Telephone);

        map.put(COLUMN_DB_NAME_OF_Versionno, COLUMN_CAP_PROP_NAME_OF_Versionno);

        _dbNameCapPropNameMap = java.util.Collections.unmodifiableMap(map);
    }

    /** {db-name : uncap-prop-name} map. */
    protected static final java.util.Map<String, String> _dbNameUncapPropNameMap;
    static {
        final java.util.Map<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.put(TABLE_DB_NAME, TABLE_UNCAP_PROP_NAME);

        map.put(COLUMN_DB_NAME_OF_Ccode, COLUMN_UNCAP_PROP_NAME_OF_Ccode);

        map.put(COLUMN_DB_NAME_OF_Cat, COLUMN_UNCAP_PROP_NAME_OF_Cat);

        map.put(COLUMN_DB_NAME_OF_Shortname, COLUMN_UNCAP_PROP_NAME_OF_Shortname);

        map.put(COLUMN_DB_NAME_OF_Name, COLUMN_UNCAP_PROP_NAME_OF_Name);

        map.put(COLUMN_DB_NAME_OF_Telephone, COLUMN_UNCAP_PROP_NAME_OF_Telephone);

        map.put(COLUMN_DB_NAME_OF_Versionno, COLUMN_UNCAP_PROP_NAME_OF_Versionno);

        _dbNameUncapPropNameMap = java.util.Collections.unmodifiableMap(map);
    }

    /** {cap-prop-name : db-name} map. */
    protected static final java.util.Map<String, String> _capPropNameDbNameMap;
    static {
        final java.util.Map<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.put(TABLE_CAP_PROP_NAME, TABLE_DB_NAME);

        map.put(COLUMN_CAP_PROP_NAME_OF_Ccode, COLUMN_DB_NAME_OF_Ccode);

        map.put(COLUMN_CAP_PROP_NAME_OF_Cat, COLUMN_DB_NAME_OF_Cat);

        map.put(COLUMN_CAP_PROP_NAME_OF_Shortname, COLUMN_DB_NAME_OF_Shortname);

        map.put(COLUMN_CAP_PROP_NAME_OF_Name, COLUMN_DB_NAME_OF_Name);

        map.put(COLUMN_CAP_PROP_NAME_OF_Telephone, COLUMN_DB_NAME_OF_Telephone);

        map.put(COLUMN_CAP_PROP_NAME_OF_Versionno, COLUMN_DB_NAME_OF_Versionno);

        _capPropNameDbNameMap = java.util.Collections.unmodifiableMap(map);
    }

    /** {cap-prop-name : uncap-prop-name} map. */
    protected static final java.util.Map<String, String> _capPropNameUncapPropNameMap;
    static {
        final java.util.Map<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.put(TABLE_CAP_PROP_NAME, TABLE_UNCAP_PROP_NAME);

        map.put(COLUMN_CAP_PROP_NAME_OF_Ccode, COLUMN_UNCAP_PROP_NAME_OF_Ccode);

        map.put(COLUMN_CAP_PROP_NAME_OF_Cat, COLUMN_UNCAP_PROP_NAME_OF_Cat);

        map.put(COLUMN_CAP_PROP_NAME_OF_Shortname, COLUMN_UNCAP_PROP_NAME_OF_Shortname);

        map.put(COLUMN_CAP_PROP_NAME_OF_Name, COLUMN_UNCAP_PROP_NAME_OF_Name);

        map.put(COLUMN_CAP_PROP_NAME_OF_Telephone, COLUMN_UNCAP_PROP_NAME_OF_Telephone);

        map.put(COLUMN_CAP_PROP_NAME_OF_Versionno, COLUMN_UNCAP_PROP_NAME_OF_Versionno);

        _capPropNameUncapPropNameMap = java.util.Collections.unmodifiableMap(map);
    }

    /** {uncap-prop-name : db-name} map. */
    protected static final java.util.Map<String, String> _uncapPropNameDbNameMap;
    static {
        final java.util.Map<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.put(TABLE_UNCAP_PROP_NAME, TABLE_DB_NAME);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Ccode, COLUMN_DB_NAME_OF_Ccode);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Cat, COLUMN_DB_NAME_OF_Cat);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Shortname, COLUMN_DB_NAME_OF_Shortname);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Name, COLUMN_DB_NAME_OF_Name);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Telephone, COLUMN_DB_NAME_OF_Telephone);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Versionno, COLUMN_DB_NAME_OF_Versionno);

        _uncapPropNameDbNameMap = java.util.Collections.unmodifiableMap(map);
    }

    /** {uncap-prop-name : cap-prop-name} map. */
    protected static final java.util.Map<String, String> _uncapPropNameCapPropNameMap;
    static {
        final java.util.Map<String, String> map = new java.util.LinkedHashMap<String, String>();
        map.put(TABLE_UNCAP_PROP_NAME, TABLE_CAP_PROP_NAME);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Ccode, COLUMN_CAP_PROP_NAME_OF_Ccode);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Cat, COLUMN_CAP_PROP_NAME_OF_Cat);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Shortname, COLUMN_CAP_PROP_NAME_OF_Shortname);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Name, COLUMN_CAP_PROP_NAME_OF_Name);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Telephone, COLUMN_CAP_PROP_NAME_OF_Telephone);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Versionno, COLUMN_CAP_PROP_NAME_OF_Versionno);

        _uncapPropNameCapPropNameMap = java.util.Collections.unmodifiableMap(map);
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
        return TABLE_DB_NAME;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table cap-prop-name. (NotNull)
     */
    public String getTableCapPropName() {
        return TABLE_CAP_PROP_NAME;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table property-name. (NotNull)
     */
    public String getTableUncapPropName() {
        return TABLE_UNCAP_PROP_NAME;
    }

    // =====================================================================================
    //                                                                    DB-Name-Map Getter
    //                                                                    ==================
    /**
     * This method implements the method that is declared at super.
     * 
     * @return {db-name : cap-prop-name} map.
     */
    public java.util.Map<String, String> getDbNameCapPropNameMap() {
        return _dbNameCapPropNameMap;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {db-name : uncap-prop-name} map.
     */
    public java.util.Map<String, String> getDbNameUncapPropNameMap() {
        return _dbNameUncapPropNameMap;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {cap-prop-name : db-name} map.
     */
    public java.util.Map<String, String> getCapPropNameDbNameMap() {
        return _capPropNameDbNameMap;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {cap-prop-name : uncap-prop-name} map.
     */
    public java.util.Map<String, String> getCapPropNameUncapPropNameMap() {
        return _capPropNameUncapPropNameMap;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {uncap-prop-name : db-name} map.
     */
    public java.util.Map<String, String> getUncapPropNameDbNameMap() {
        return _uncapPropNameDbNameMap;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {uncap-prop-name : cap-prop-name} map.
     */
    public java.util.Map<String, String> getUncapPropNameCapPropNameMap() {
        return _uncapPropNameCapPropNameMap;
    }

    // =====================================================================================
    //                                                                      Type Name Getter
    //                                                                      ================
    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type-name of entity. (NotNull)
     */ 
    public String getEntityTypeName() {
        return "org.seasar.golf.uexample.dao.exentity.Company";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type-name of condition-bean. (NotNull)
     */ 
    public String getConditionBeanTypeName() {
        return "CompanyCB.CompanyCB";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type-name of dao. (NotNull)
     */ 
    public String getDaoTypeName() {
        return "org.seasar.golf.uexample.dao.exdao.CompanyDao";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type-name of behavior. (NotNull)
     */ 
    public String getBehaviorTypeName() {
        return "org.seasar.golf.uexample.dao.exbhv.CompanyBhv";
    }


    // =====================================================================================
    //                                                                           Type Getter
    //                                                                           ===========
    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type of entity. (NotNull)
     */ 
    public Class getEntityType() {
        return ENTITY_TYPE;
    }

    // =====================================================================================
    //                                                                       Instance Getter
    //                                                                       ===============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type of entity. (NotNull)
     */ 
    public Entity newEntity() {
        return newMyEntity();
    }

    /**
     * New the instance of my entity.
     * 
     * @return The instance of my entity. (NotNull)
     */ 
    public Company newMyEntity() {
        return new Company();
    }

    // =====================================================================================
    //                                                                        Foreign DBMeta
    //                                                                        ==============
    /**
     * This method implements the method that is declared at super.
     * 
     * @param foreignPropertyName Foreign-property-name(Both OK - InitCap or not). (NotNull)
     * @return Foreign DBMeta. (NotNull)
     */ 
    public DBMeta getForeignDBMeta(String foreignPropertyName) {
        assertStringNotNullAndNotTrimmedEmpty("foreignPropertyName", foreignPropertyName);
        final String methodName = "getForeignDBMeta_" + foreignPropertyName.substring(0, 1) + foreignPropertyName.substring(1);

        java.lang.reflect.Method method = null;
        try {
            method = this.getClass().getMethod(methodName, new Class[]{});
        } catch (NoSuchMethodException e) {
            String msg = "The foreignPropertyName is not found: foreignPropertyName=" + foreignPropertyName;
            msg = msg + " tableName=" + TABLE_DB_NAME + " methodName=" + methodName;
            throw new RuntimeException(msg, e);
        }
        try {
            return (DBMeta)method.invoke(this, new Object[]{});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            throw new RuntimeException(e.getCause());
        }
    }



    // =====================================================================================
    //                                                                         Determination
    //                                                                         =============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean hasTwoOrMorePrimaryKeys() {
        return false;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Determination.
     */
    public boolean hasCommonColumn() {
        return false;
    }
}
