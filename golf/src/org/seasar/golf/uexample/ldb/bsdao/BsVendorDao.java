
package org.seasar.golf.uexample.ldb.bsdao;

import org.seasar.golf.uexample.ldb.exentity.Vendor;

/**
 * The dao interface of vendor.
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
public interface BsVendorDao extends org.seasar.golf.uexample.ldb.allcommon.DaoWritable {

    /** BEAN-Annotation. */
    public Class BEAN = org.seasar.golf.uexample.ldb.exentity.Vendor.class;

    /** SQL-Annotation for getCountAll(). */
    public static final String getCountAll_SQL = "select count(*) from vendor";

    /**
     * Get count as all.
     * 
     * @return All count.
     */
    public int getCountAll();

    /** SQL-Annotation for getListAll(). */
    public static final String getListAll_SQL = "select * from vendor";

    /**
     * Get list as all.
     * 
     * @return All list. (NotNull)
     */
    public java.util.List<Vendor> getListAll();

    /** SQL-Annotation for getEntity(). */
    public static final String getEntity_SQL = "select * from vendor where vendor.id = /*id*/null";

    /** Args-Annotation for getEntity(). */
    public static final String getEntity_ARGS = "id";

    public Vendor getEntity(java.math.BigDecimal id);

    /**
     * Select count by condition-bean.
     * <pre>
     * Ignore fetchFirst() and fetchScope() and fetchPage().
     * But the fetch status of the condition-bean remains as it is.
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final VendorCB cb = new VendorCB();
     *   cb.query().setXxx_GreaterEqual(new BigDecimal(14));
     *   final int count = dao.selectCount(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected count. (NotNull)
     */
    public int selectCount(org.seasar.golf.uexample.ldb.cbean.VendorCB cb);

    /**
     * Select count by condition-bean.
     * <pre>
     * Ignore fetchFirst() and fetchScope() and fetchPage(). But the fetch status of the condition-bean remains as it is.
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final VendorCB cb = new VendorCB();
     *   cb.query().setXxx_GreaterEqual(new BigDecimal(14));
     *   final int count = dao.${database.ConditionBeanSelectCountMethodName}(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected count. (NotNull)
     * @deprecated Please use selectCount().
     */
    public int selectCountIgnoreFetchScope(org.seasar.golf.uexample.ldb.cbean.VendorCB cb);

    /**
     * Select entity 'Vendor' by condition-bean.
     * <pre>
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final VendorCB cb = new VendorCB();
     *   cb.query().setXxxCode_Equal("abc");// It is assumed that this is the primary key...
     *   cb.lockForUpdate();
     *   final Vendor entity = dao.selectEntity(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. If the select result is zero, it returns null. (Nullable)
     */
    public Vendor selectEntity(org.seasar.golf.uexample.ldb.cbean.VendorCB cb);

    /**
     * Select list by condition-bean.
     * <pre>
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final VendorCB cb = new VendorCB();
     *   cb.setupSelect_Xxx(); // Including the foreign table in select clause
     *   cb.query().setXxxName_PrefixSearch("abc");
     *   cb.query().setXxxStartDate_IsNotNull();
     *   cb.addOrderBy_PK_Asc().fetchFirst(20);
     *   final List resultList = dao.selectList(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected list. If the select result is zero, it returns empty list. (NotNull)
     */
    public java.util.List<Vendor> selectList(org.seasar.golf.uexample.ldb.cbean.VendorCB cb);


    /**
     * Insert one entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Inserted count.
     */
    public int insert(Vendor entity);

    /**
     * Update one entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Updated count.
     */
    public int update(Vendor entity);

    /**
     * Update one entity. (modified only)
     * 
     * @param entity Entity. (NotNull)
     * @return Updated count.
     */
    public int updateModifiedOnly(Vendor entity);

    /**
     * Delete one entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Deleted count.
     */
    public int delete(Vendor entity);

    /**
     * Insert several entities.
     * 
     * @param entityList Entity-list. (NotNull)
     * @return Inserted count.
     */
    public int insertList(java.util.List<Vendor> entityList);

    /**
     * Update several entities.
     * 
     * @param entityList Entity-list. (NotNull)
     * @return Updated count.
     */
    public int updateList(java.util.List<Vendor> entityList);

    /**
     * Delete several entities.
     * 
     * @param entityList Entity-list. (NotNull)
     * @return Deleted count.
     */
    public int deleteList(java.util.List<Vendor> entityList);

}
