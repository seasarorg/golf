package org.seasar.golf.uexample.dao.allcommon.dbmeta;


import java.util.Map;
import java.util.LinkedHashMap;

/**
 * DBMeta instance handler.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class DBMetaInstanceHandler {

    /** Table db-name instance map. */
    protected static final Map<String, DBMeta> _tableDbNameInstanceMap;
    static {
        Map<String, DBMeta> tmpMap = new LinkedHashMap<String, DBMeta>();


        tmpMap.put("company", getDBMeta("org.seasar.golf.uexample.dao.bsentity.dbmeta.CompanyDbm"));

        tmpMap.put("vendor", getDBMeta("org.seasar.golf.uexample.dao.bsentity.dbmeta.VendorDbm"));

        _tableDbNameInstanceMap = java.util.Collections.unmodifiableMap(tmpMap);
    }

    /** Table cap-prop-name instance map. */
    protected static final Map<String, DBMeta> _tableCapPropNameInstanceMap;
    static {
        Map<String, DBMeta> tmpMap = new LinkedHashMap<String, DBMeta>();


        tmpMap.put("Company", getDBMeta("org.seasar.golf.uexample.dao.bsentity.dbmeta.CompanyDbm"));

        tmpMap.put("Vendor", getDBMeta("org.seasar.golf.uexample.dao.bsentity.dbmeta.VendorDbm"));

        _tableCapPropNameInstanceMap = java.util.Collections.unmodifiableMap(tmpMap);
    }

    /** Table uncap-prop-name instance map. */
    protected static final Map<String, DBMeta> _tableUncapPropNameInstanceMap;
    static {
        Map<String, DBMeta> tmpMap = new LinkedHashMap<String, DBMeta>();


        tmpMap.put("company", getDBMeta("org.seasar.golf.uexample.dao.bsentity.dbmeta.CompanyDbm"));

        tmpMap.put("vendor", getDBMeta("org.seasar.golf.uexample.dao.bsentity.dbmeta.VendorDbm"));

        _tableUncapPropNameInstanceMap = java.util.Collections.unmodifiableMap(tmpMap);
    }

    protected static DBMeta getDBMeta(String className) {
        try {
            final Class clazz = Class.forName(className);
            final java.lang.reflect.Method methoz = clazz.getMethod("getInstance", (Class[])null);
            final Object result = methoz.invoke(null, (Object[])null);
            return (DBMeta)result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get instance by table db-name.
     * 
     * @param tableDbName Table db-name. (NotNull)
     * @return Instance. (NotNull)
     */
    public static DBMeta getInstanceByTableDbName(String tableDbName) {
        assertStringNotNullAndNotTrimmedEmpty("tableDbName", tableDbName);
        final DBMeta instance = (DBMeta)_tableDbNameInstanceMap.get(tableDbName);
        if (instance == null) {
            String msg = "The instance map returned null by the key: key=" + tableDbName + " instanceMap=" + _tableDbNameInstanceMap;
            throw new IllegalStateException(msg);
        }
        return instance;
    }

    /**
     * Get instance by table cap-prop-name.
     * 
     * @param tableCapPropName Table cap-prop-name. (NotNull)
     * @return Instance. (NotNull)
     */
    public static DBMeta getInstanceByTableCapPropName(String tableCapPropName) {
        assertStringNotNullAndNotTrimmedEmpty("tableCapPropName", tableCapPropName);
        final DBMeta instance = (DBMeta)_tableCapPropNameInstanceMap.get(tableCapPropName);
        if (instance == null) {
            String msg = "The instance map returned null by the key: key=" + tableCapPropName + " instanceMap=" + _tableCapPropNameInstanceMap;
            throw new IllegalStateException(msg);
        }
        return instance;
    }

    /**
     * Get instance by table uncap-prop-name.
     * 
     * @param tableUncapPropName Table uncap-prop-name. (NotNull)
     * @return Instance. (NotNull)
     */
    public static DBMeta getInstanceByTableUncapPropName(String tableUncapPropName) {
        assertStringNotNullAndNotTrimmedEmpty("tableUncapPropName", tableUncapPropName);
        final DBMeta instance = (DBMeta)_tableUncapPropNameInstanceMap.get(tableUncapPropName);
        if (instance == null) {
            String msg = "The instance map returned null by the key: key=" + tableUncapPropName + " instanceMap=" + _tableUncapPropNameInstanceMap;
            throw new IllegalStateException(msg);
        }
        return instance;
    }

    /**
     * Get instance by table uncap-prop-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Instance. (NotNull)
     */
    public static DBMeta getInstanceByTableMultiName(String tableMultiName) {
        assertStringNotNullAndNotTrimmedEmpty("tableMultiName", tableMultiName);
        {
            final DBMeta instance = (DBMeta)_tableDbNameInstanceMap.get(tableMultiName);
            if (instance != null) {
                return instance;
            }
        }
        {
            final DBMeta instance = (DBMeta)_tableCapPropNameInstanceMap.get(tableMultiName);
            if (instance != null) {
                return instance;
            }
        }
        {
            final DBMeta instance = (DBMeta)_tableUncapPropNameInstanceMap.get(tableMultiName);
            if (instance != null) {
                return instance;
            }
        }
        String msg = "The tableMultiName does not exist in all-instance-map: tableMultiName=" + tableMultiName;
        msg = msg + " tableDbNameInstanceMap=" + _tableDbNameInstanceMap;
        msg = msg + " tableCapPropNameInstanceMap=" + _tableCapPropNameInstanceMap;
        msg = msg + " tableUncapPropNameInstanceMap=" + _tableUncapPropNameInstanceMap;
        throw new IllegalStateException(msg);
    }

    // ----------------------------------------------------------------
    //                                                    Assert Object
    //                                                    -------------
    /**
     * Assert that the argument is not null.
     * 
     * @param variableName Variable name. (NotNull)
     * @param arg Argument. (NotNull)
     */
    protected static void assertObjectNotNull(String variableName, Object arg) {
        if (variableName == null) {
            String msg = "Argument[variableName] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (arg == null) {
            String msg = "Argument[" + variableName + "] should not be null.";
            throw new IllegalArgumentException(msg);
        }
    }

    // ----------------------------------------------------------------
    //                                                    Assert String
    //                                                    -------------
    /**
     * Assert that the string is not null and not trimmed empty.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected static void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        if (variableName == null) {
            String msg = "Variable[variableName] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "Variable[" + variableName + "] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (value.trim().length() == 0) {
            String msg = "Variable[" + variableName + "] should not be empty: [" + value + "]";
            throw new IllegalArgumentException(msg);
        }
    }
}
