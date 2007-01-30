package org.seasar.golf.uexample.dao.allcommon;

import org.seasar.golf.uexample.dao.allcommon.bhv.BehaviorReadable;
import org.seasar.golf.uexample.dao.allcommon.bhv.BehaviorWritable;

import org.seasar.golf.uexample.dao.allcommon.dbmeta.DBMetaInstanceHandler;
import org.seasar.golf.uexample.dao.allcommon.dbmeta.DBMeta;

import org.seasar.framework.container.S2Container;

/**
 * The implementation of dao-selector.
 * <pre>
 * Long long ago this object have cache of dao and bhv.
 * But the cache cause wrong performance when this is initialized.
 * So now this object don't have cache.
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class CacheDaoSelector implements DaoSelector {

    protected S2Container _container;

    public void setContainer(S2Container container) {
        this._container = container;
    }

    /**
     * Get dao-readable by dao type.
     * 
     * @param daoType Dao type. (NotNull)
     * @return Dao-readable. (NotNull)
     */
    public DaoReadable getRDao(Class daoType) {
        assertObjectNotNull("daoType", daoType);
        return (DaoReadable)_container.getComponent(daoType);
    }

    /**
     * Get dao-readable by entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Dao-readable. (NotNull)
     */
    public DaoReadable getRDao(Entity entity) {
        assertObjectNotNull("entity", entity);
        return getRDao(getDaoType(entity.getDBMeta()));
    }

    /**
     * Get dao-readable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Dao-readable. (NotNull)
     */
    public DaoReadable getRDao(String tableMultiName) {
        assertStringNotNullAndNotTrimmedEmpty("tableMultiName", tableMultiName);
        final DBMeta dbmeta = DBMetaInstanceHandler.getInstanceByTableMultiName(tableMultiName);
        return getRDao(getDaoType(dbmeta));
    }

    /**
     * Get dao-writable by dao type.
     * 
     * @param daoType Dao type. (NotNull)
     * @return Dao-writable. (NotNull)
     */
    public DaoWritable getWDao(Class daoType) {
        assertObjectNotNull("daoType", daoType);
        return (DaoWritable)getRDao(daoType);
    }

    /**
     * Get dao-writable by entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Dao-writable. (NotNull)
     */
    public DaoWritable getWDao(Entity entity) {
        assertObjectNotNull("entity", entity);
        return (DaoWritable)getRDao(entity);
    }

    /**
     * Get dao-writable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Dao-writable. (NotNull)
     */
    public DaoWritable getWDao(String tableMultiName) {
        assertStringNotNullAndNotTrimmedEmpty("tableMultiName", tableMultiName);
        return (DaoWritable)getRDao(tableMultiName);
    }

    /**
     * Get bhv-readable by bhv type.
     * 
     * @param bhvType Bhv type. (NotNull)
     * @return Bhv-readable. (NotNull)
     */
    public BehaviorReadable getRBhv(Class bhvType) {
        assertObjectNotNull("bhvType", bhvType);
        return (BehaviorReadable)_container.getComponent(bhvType);
    }

    /**
     * Get bhv-readable by entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Bhv-readable. (NotNull)
     */
    public BehaviorReadable getRBhv(Entity entity) {
        assertObjectNotNull("entity", entity);
        return getRBhv(getBhvType(entity.getDBMeta()));
    }

    /**
     * Get bhv-readable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Bhv-readable. (NotNull)
     */
    public BehaviorReadable getRBhv(String tableMultiName) {
        assertStringNotNullAndNotTrimmedEmpty("tableMultiName", tableMultiName);
        final DBMeta dbmeta = DBMetaInstanceHandler.getInstanceByTableMultiName(tableMultiName);
        return getRBhv(getBhvType(dbmeta));
    }

    /**
     * Get bhv-writable by bhv type.
     * 
     * @param bhvType Bhv type. (NotNull)
     * @return Bhv-writable. (NotNull)
     */
    public BehaviorWritable getWBhv(Class bhvType) {
        assertObjectNotNull("bhvType", bhvType);
        return (BehaviorWritable)getRBhv(bhvType);
    }

    /**
     * Get bhv-writable by entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Bhv-writable. (NotNull)
     */
    public BehaviorWritable getWBhv(Entity entity) {
        assertObjectNotNull("entity", entity);
        return (BehaviorWritable)getRBhv(entity);
    }

    /**
     * Get bhv-writable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Bhv-writable. (NotNull)
     */
    public BehaviorWritable getWBhv(String tableMultiName) {
        assertStringNotNullAndNotTrimmedEmpty("tableMultiName", tableMultiName);
        return (BehaviorWritable)getRBhv(tableMultiName);
    }

    /**
     * Get bhv-type by dbmeta.
     * 
     * @param dbmeta Dbmeta. (NotNull)
     * @return Bhv-type. (NotNull)
     */
    protected Class getBhvType(DBMeta dbmeta) {
        final String bhvTypeName = dbmeta.getBehaviorTypeName();
        if (bhvTypeName == null) {
            String msg = "The dbmeta.getBehaviorTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class bhvType;
        try {
            bhvType = Class.forName(bhvTypeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("The class does not exist: " + bhvTypeName, e);
        }
        return bhvType;
    }

    protected Class getDaoType(DBMeta dbmeta) {
        final String daoTypeName = dbmeta.getDaoTypeName();
        if (daoTypeName == null) {
            String msg = "The dbmeta.getDaoTypeName() should not return null: dbmeta=" + dbmeta;
            throw new IllegalStateException(msg);
        }
        final Class daoType;
        try {
            daoType = Class.forName(daoTypeName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("The class does not exist: " + daoTypeName, e);
        }
        return daoType;
    }

    // =====================================================================================
    //                                                                               Destroy
    //                                                                               =======
    public void destroy() {
        _container = null;
    }

    // ----------------------------------------------------------------
    //                                                    Assert Object
    //                                                    -------------
    /**
     * Assert that the object is not null.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     * @exception IllegalArgumentException
     */
    protected void assertObjectNotNull(String variableName, Object value) {
        if (variableName == null) {
            String msg = "The value should not be null: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "The value should not be null: variableName=" + variableName;
            throw new IllegalArgumentException(msg);
        }
    }

    // ----------------------------------------------------------------
    //                                                    Assert String
    //                                                    -------------
    /**
     * Assert that the entity is not null and not trimmed empty.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        assertObjectNotNull("variableName", variableName);
        assertObjectNotNull("value", value);
        if (value.trim().length() ==0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }
}
