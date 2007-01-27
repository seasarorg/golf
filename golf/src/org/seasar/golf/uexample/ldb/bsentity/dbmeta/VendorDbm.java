package org.seasar.golf.uexample.ldb.bsentity.dbmeta;


import org.seasar.golf.uexample.ldb.allcommon.Entity;
import org.seasar.golf.uexample.ldb.allcommon.dbmeta.DBMeta;
import org.seasar.golf.uexample.ldb.allcommon.dbmeta.AbstractDBMeta;
import org.seasar.golf.uexample.ldb.exentity.Vendor;

/**
 * The dbmeta of vendor. (Singleton)
 * 
 * <pre>
 * [primary-key]
 *     id
 * 
 * [column-property]
 *     id, vcode, shortname, name, telephone, versionno
 * 
 * [foreign-property]
 *     
 * 
 * [refferer-property]
 *     
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     id
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
public class VendorDbm extends AbstractDBMeta {

    /** The type of entity. */
    protected static final Class ENTITY_TYPE = Vendor.class;

    /** Singleton instance. */
    private static final VendorDbm _instance = new VendorDbm();

    /**
     * Constructor
     */
    private VendorDbm() {
    }

    /**
     * Get instance.
     * 
     * @return Singleton instance. (NotNull)
     */
    public static VendorDbm getInstance() {
        return _instance;
    }

    // =====================================================================================
    //                                                                       Name Definition
    //                                                                       ===============
    /** Table db name. */
    public static final String TABLE_DB_NAME = "vendor";

    /** Table cap-prop name. */
    public static final String TABLE_CAP_PROP_NAME = "Vendor";

    /** Table uncap-prop name. */
    public static final String TABLE_UNCAP_PROP_NAME = "vendor";


    /** Db-name of Id. */
    public static final String COLUMN_DB_NAME_OF_Id = "id";

    /** Db-name of Vcode. */
    public static final String COLUMN_DB_NAME_OF_Vcode = "vcode";

    /** Db-name of Shortname. */
    public static final String COLUMN_DB_NAME_OF_Shortname = "shortname";

    /** Db-name of Name. */
    public static final String COLUMN_DB_NAME_OF_Name = "name";

    /** Db-name of Telephone. */
    public static final String COLUMN_DB_NAME_OF_Telephone = "telephone";

    /** Db-name of Versionno. */
    public static final String COLUMN_DB_NAME_OF_Versionno = "versionno";


    /** Cap-prop-name of Id. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Id = "Id";

    /** Cap-prop-name of Vcode. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Vcode = "Vcode";

    /** Cap-prop-name of Shortname. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Shortname = "Shortname";

    /** Cap-prop-name of Name. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Name = "Name";

    /** Cap-prop-name of Telephone. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Telephone = "Telephone";

    /** Cap-prop-name of Versionno. */
    public static final String COLUMN_CAP_PROP_NAME_OF_Versionno = "Versionno";


    /** Uncap-prop-name of Id. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Id = "id";

    /** Uncap-prop-name of Vcode. */
    public static final String COLUMN_UNCAP_PROP_NAME_OF_Vcode = "vcode";

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

        map.put(COLUMN_DB_NAME_OF_Id, COLUMN_CAP_PROP_NAME_OF_Id);

        map.put(COLUMN_DB_NAME_OF_Vcode, COLUMN_CAP_PROP_NAME_OF_Vcode);

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

        map.put(COLUMN_DB_NAME_OF_Id, COLUMN_UNCAP_PROP_NAME_OF_Id);

        map.put(COLUMN_DB_NAME_OF_Vcode, COLUMN_UNCAP_PROP_NAME_OF_Vcode);

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

        map.put(COLUMN_CAP_PROP_NAME_OF_Id, COLUMN_DB_NAME_OF_Id);

        map.put(COLUMN_CAP_PROP_NAME_OF_Vcode, COLUMN_DB_NAME_OF_Vcode);

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

        map.put(COLUMN_CAP_PROP_NAME_OF_Id, COLUMN_UNCAP_PROP_NAME_OF_Id);

        map.put(COLUMN_CAP_PROP_NAME_OF_Vcode, COLUMN_UNCAP_PROP_NAME_OF_Vcode);

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

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Id, COLUMN_DB_NAME_OF_Id);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Vcode, COLUMN_DB_NAME_OF_Vcode);

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

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Id, COLUMN_CAP_PROP_NAME_OF_Id);

        map.put(COLUMN_UNCAP_PROP_NAME_OF_Vcode, COLUMN_CAP_PROP_NAME_OF_Vcode);

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
        return "org.seasar.golf.uexample.ldb.exentity.Vendor";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type-name of condition-bean. (NotNull)
     */ 
    public String getConditionBeanTypeName() {
        return "VendorCB.VendorCB";
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return The type-name of dao. (NotNull)
     */ 
    public String getDaoTypeName() {
        return "org.seasar.golf.uexample.ldb.exdao.VendorDao";
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
    public Vendor newMyEntity() {
        return new Vendor();
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
