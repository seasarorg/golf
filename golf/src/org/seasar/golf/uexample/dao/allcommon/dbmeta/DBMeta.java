package org.seasar.golf.uexample.dao.allcommon.dbmeta;


import org.seasar.golf.uexample.dao.allcommon.Entity;

/**
 * The interface of dbmeta.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface DBMeta {

    // =====================================================================================
    //                                                                            Table Name
    //                                                                            ==========
    /**
     * Get table db-name.
     * 
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName();

    /**
     * Get table cap-prop-name.
     * 
     * @return Table cap-prop-name. (NotNull)
     */
    public String getTableCapPropName();

    /**
     * Get table uncap-prop-name.
     * 
     * @return Table uncap-prop-name. (NotNull)
     */
    public String getTableUncapPropName();

    // =====================================================================================
    //                                                                         Name Handling
    //                                                                         =============
    /**
     * Is existing db-name?
     * 
     * @param dbName Db-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistDbName(String dbName);

    /**
     * Is existing cap-prop-name?
     * 
     * @param capPropName Cap-prop-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistCapPropName(String capPropName);

    /**
     * Is existing uncap-prop-name?
     * 
     * @param uncapPropName Uncap-prop-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistUncapPropName(String uncapPropName);

    /**
     * Is existing multi-name?
     * 
     * @param multiName Multi-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistMultiName(String multiName);

    /**
     * Get db-name by property-name.
     * 
     * @param capPropName Cap-prop-name.
     * @return Db-name.
     */
    public String getDbNameByCapPropName(String capPropName);

    /**
     * Get db-name by property-name.
     * 
     * @param propertyName Uncap-prop-name.
     * @return {db-name : cap-prop-name} map.
     */
    public String getDbNameByUncapPropName(String propertyName);

    /**
     * Get cap-prop-name by db-name.
     * 
     * @param dbName Db-name.
     * @return Cap-prop-name.
     */
    public String getCapPropNameByDbName(String dbName);

    /**
     * Get cap-prop-name by property-name.
     * 
     * @param propertyName Uncap-prop-name.
     * @return Cap-prop-name.
     */
    public String getCapPropNameByUncapPropName(String propertyName);

    /**
     * Get property-name by db-name.
     * 
     * @param dbName Db-name.
     * @return Uncap-prop-name.
     */
    public String getUncapPropNameByDbName(String dbName);

    /**
     * Get property-name by cap-prop-name.
     * 
     * @param capPropName Cap-prop-name.
     * @return Uncap-prop-name.
     */
    public String getUncapPropNameByCapPropName(String capPropName);

    /**
     * Get db-name by multi-name.
     * 
     * @param multiName Multi-name.
     * @return Db-name.
     */
    public String getDbNameByMultiName(String multiName);

    /**
     * Get cap-prop-name by multi-name.
     * 
     * @param multiName Multi-name.
     * @return Cap-prop-name.
     */
    public String getCapPropNameByMultiName(String multiName);

    /**
     * Get property-name by multi-name.
     * 
     * @param multiName Multi-name.
     * @return Uncap-prop-name.
     */
    public String getUncapPropNameByMultiName(String multiName);

    // =====================================================================================
    //                                                                    DB-Name-Map Getter
    //                                                                    ==================
    /**
     * This method implements the method that is declared at super.
     * 
     * @return {db-name : cap-prop-name} map.
     */
    public java.util.Map<String, String> getDbNameCapPropNameMap();

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {db-name : uncap-prop-name} map.
     */
    public java.util.Map<String, String> getDbNameUncapPropNameMap();

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {cap-prop-name : db-name} map.
     */
    public java.util.Map<String, String> getCapPropNameDbNameMap();

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {cap-prop-name : uncap-prop-name} map.
     */
    public java.util.Map<String, String> getCapPropNameUncapPropNameMap();

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {uncap-prop-name : db-name} map.
     */
    public java.util.Map<String, String> getUncapPropNameDbNameMap();

    /**
     * This method implements the method that is declared at super.
     * 
     * @return {uncap-prop-name : cap-prop-name} map.
     */
    public java.util.Map<String, String> getUncapPropNameCapPropNameMap();

    // =====================================================================================
    //                                                                      Type Name Getter
    //                                                                      ================
    /**
     * Get the type-name of entity.
     * 
     * @return The type-name of entity. (NotNull)
     */ 
    public String getEntityTypeName();

    /**
     * Get the type-name of condition-bean.
     * 
     * @return The type-name of condition-bean. (Nullable: If the condition-bean does not exist)
     */ 
    public String getConditionBeanTypeName();

    /**
     * Get the type-name of dao.
     * 
     * @return The type-name of dao. (Nullable: If the dao does not exist)
     */ 
    public String getDaoTypeName();

    // =====================================================================================
    //                                                                           Type Getter
    //                                                                           ===========
    /**
     * Get the type of entity.
     * 
     * @return The type of entity. (NotNull)
     */ 
    public Class getEntityType();

    // =====================================================================================
    //                                                                       Instance Getter
    //                                                                       ===============
    /**
     * New the instance of entity.
     * 
     * @return The instance of entity. (NotNull)
     */ 
    public Entity newEntity();

    // =====================================================================================
    //                                                                        Foreign DBMeta
    //                                                                        ==============
    /**
     * Get foreign dbmeta.
     * 
     * @param foreignPropertyName Foreign-property-name(Both OK - InitCap or not). (NotNull)
     * @return Foreign DBMeta. (NotNull)
     */ 
    public DBMeta getForeignDBMeta(String foreignPropertyName);

    // =====================================================================================
    //                                                                         Determination
    //                                                                         =============
    /**
     * Has two or more primary-keys?
     * 
     * @return Determination.
     */
    public boolean hasTwoOrMorePrimaryKeys();

    /**
     * Has common column?
     * 
     * @return Determination.
     */
    public boolean hasCommonColumn();
}
