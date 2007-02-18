
package org.seasar.golf.uexample.dao.bsdao;

import org.seasar.golf.uexample.dao.exentity.Company;

/**
 * The dao interface of company.
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
 *     
 * 
 * [identity]
 *     ccode
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
public interface BsCompanyDao extends org.seasar.golf.uexample.dao.allcommon.DaoWritable {

    /** BEAN-Annotation. */
    public Class BEAN = org.seasar.golf.uexample.dao.exentity.Company.class;

    /** SQL-Annotation for getCountAll(). */
    public static final String getCountAll_SQL = "select count(*) from company";

    /**
     * Get count as all.
     * 
     * @return All count.
     */
    public int getCountAll();

    /** SQL-Annotation for getListAll(). */
    public static final String getListAll_SQL = "select * from company";

    /**
     * Get list as all.
     * 
     * @return All list. (NotNull)
     */
    public java.util.List<Company> getListAll();

    /** SQL-Annotation for getEntity(). */
    public static final String getEntity_SQL = "select * from company where company.ccode = /*ccode*/null";

    /** Args-Annotation for getEntity(). */
    public static final String getEntity_ARGS = "ccode";

    public Company getEntity(java.math.BigDecimal ccode);

    /**
     * Select count by condition-bean.
     * <pre>
     * Ignore fetchFirst() and fetchScope() and fetchPage().
     * But the fetch status of the condition-bean remains as it is.
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final CompanyCB cb = new CompanyCB();
     *   cb.query().setXxx_GreaterEqual(new BigDecimal(14));
     *   final int count = dao.selectCount(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected count. (NotNull)
     */
    public int selectCount(org.seasar.golf.uexample.dao.cbean.CompanyCB cb);

    /**
     * Select count by condition-bean.
     * <pre>
     * Ignore fetchFirst() and fetchScope() and fetchPage(). But the fetch status of the condition-bean remains as it is.
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final CompanyCB cb = new CompanyCB();
     *   cb.query().setXxx_GreaterEqual(new BigDecimal(14));
     *   final int count = dao.${database.ConditionBeanSelectCountMethodName}(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected count. (NotNull)
     * @deprecated Please use selectCount().
     */
    public int selectCountIgnoreFetchScope(org.seasar.golf.uexample.dao.cbean.CompanyCB cb);

    /**
     * Select entity 'Company' by condition-bean.
     * <pre>
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final CompanyCB cb = new CompanyCB();
     *   cb.query().setXxxCode_Equal("abc");// It is assumed that this is the primary key...
     *   cb.lockForUpdate();
     *   final Company entity = dao.selectEntity(cb);
     * </pre>
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. If the select result is zero, it returns null. (Nullable)
     */
    public Company selectEntity(org.seasar.golf.uexample.dao.cbean.CompanyCB cb);

    /**
     * Select list by condition-bean.
     * <pre>
     * This select method generates SQL based on condition-bean.
     * 
     * Example)
     *   final CompanyCB cb = new CompanyCB();
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
    public java.util.List<Company> selectList(org.seasar.golf.uexample.dao.cbean.CompanyCB cb);


    /**
     * Insert one entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Inserted count.
     */
    public int insert(Company entity);

    /**
     * Update one entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Updated count.
     */
    public int update(Company entity);

    /**
     * Update one entity. (modified only)
     * 
     * @param entity Entity. (NotNull)
     * @return Updated count.
     */
    public int updateModifiedOnly(Company entity);

    /**
     * Delete one entity.
     * 
     * @param entity Entity. (NotNull)
     * @return Deleted count.
     */
    public int delete(Company entity);

    /**
     * Insert several entities.
     * 
     * @param entityList Entity-list. (NotNull)
     * @return Inserted count.
     */
    public int insertList(java.util.List<Company> entityList);

    /**
     * Update several entities.
     * 
     * @param entityList Entity-list. (NotNull)
     * @return Updated count.
     */
    public int updateList(java.util.List<Company> entityList);

    /**
     * Delete several entities.
     * 
     * @param entityList Entity-list. (NotNull)
     * @return Deleted count.
     */
    public int deleteList(java.util.List<Company> entityList);

}
