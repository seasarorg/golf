
package org.seasar.golf.uexample.dao.bsbhv;

import org.seasar.golf.uexample.dao.allcommon.*;
import org.seasar.golf.uexample.dao.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.ListResultBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.PagingBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.PagingResultBean;
import org.seasar.golf.uexample.dao.allcommon.dbmeta.DBMeta;
  
import org.seasar.golf.uexample.dao.exdao.*;
import org.seasar.golf.uexample.dao.exentity.*;
import org.seasar.golf.uexample.dao.bsentity.dbmeta.*;
import org.seasar.golf.uexample.dao.cbean.*;



/**
 * The behavior of company.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCompanyBhv extends org.seasar.golf.uexample.dao.allcommon.bhv.AbstractBehaviorWritable {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Dao instance. */
    protected CompanyDao _dao;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public BsCompanyBhv() {
    }

    // =====================================================================================
    //                                                                            Table name
    //                                                                            ==========
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName() {
        return "company";
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

    /**
     * Get my dbmeta.
     * 
     * @return DBMeta. (NotNull)
     */
    public CompanyDbm getMyDBMeta() {
        return CompanyDbm.getInstance();
    }

    // =====================================================================================
    //                                                                          Dao Accessor
    //                                                                          ============
    /**
     * Get my dao.
     * 
     * @return My dao.
     */
    public CompanyDao getMyDao() {
        return _dao;
    }

    /**
     * Set my dao.
     * 
     * @param dao My dao. (NotNull)
     */
    public void setMyDao(CompanyDao dao) {
        assertObjectNotNull("dao", dao);
        _dao = dao;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Dao-readable. (NotNull)
     */
    public DaoReadable getDaoReadable() {
        return getMyDao();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return Dao-writable. (NotNull)
     */
    public DaoWritable getDaoWritable() {
        return getMyDao();
    }

    // =====================================================================================
    //                                                                          New Instance
    //                                                                          ============
    /**
     * New entity.
     * 
     * @return Entity. (NotNull)
     */
    public Entity newEntity() {
        return newMyEntity();
    }

    /**
     * New condition-bean.
     * 
     * @return Condition-bean. (NotNull)
     */
    public ConditionBean newConditionBean() {
        return newMyConditionBean();
    }

    /**
     * New my entity.
     * 
     * @return My entity. (NotNull)
     */
    public Company newMyEntity() {
        return new Company();
    }

    /**
     * New my condition-bean.
     * 
     * @return My condition-bean. (NotNull)
     */
    public CompanyCB newMyConditionBean() {
        return new CompanyCB();
    }

    // =====================================================================================
    //                                                                       Delegate Method
    //                                                                       ===============
    /**
     * Get count as all. (Delegate-Method)
     * 
     * @return All count. (NotNull)
     */
    public int delegateGetCountAll() {
        return getMyDao().getCountAll();
    }

    /**
     * Get list as all. (Delegate-Method)
     * 
     * @return All list. (NotNull)
     */
    public java.util.List<Company> delegateGetListAll() {
        return getMyDao().getListAll();
    }

    //
    // Get entity. (Delegate-Method)
    // 
    // @param Primary-keys (NotNull)
    // @return Entity. (NotNull)
    //
    public Company delegateGetEntity(java.math.BigDecimal ccode) {
        return getMyDao().getEntity(ccode);
    }

    /**
     * Select count by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected count. (NotNull)
     */
    public int delegateSelectCount(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().selectCount(cb);
    }

    /**
     * Select entity by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. If the select result is zero, it returns null. (Nullable)
     */
    public Company delegateSelectEntity(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().selectEntity(cb);
    }

    /**
     * Select list by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected list. If the select result is zero, it returns empty list. (NotNull)
     */
    public java.util.List<Company> delegateSelectList(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().selectList(cb);
    }


    /**
     * Select next value as sequence. (Delegate-Method)
     * 
     * @return Next value. (NotNull)
     */
    public java.math.BigDecimal delegateSelectNextVal() {
        return getMyDao().selectNextVal();
    }


    /**
     * Insert one entity. (Delegate-Method)
     * 
     * @param entity Entity. (NotNull)
     * @return Inserted count.
     */
    public int delegateInsert(Company entity) {
        assertEntityNotNull(entity);// If this table use identity, the entity does not have primary-key.
        filterEntityOfInsert(entity);
        assertEntityOfInsert(entity);
        return getMyDao().insert(entity);
    }

    /**
     * Update one entity. (Delegate-Method)
     * {modified only}
     * 
     * @param entity Entity. (NotNull)
     * @return Updated count.
     */
    public int delegateUpdate(Company entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        filterEntityOfUpdate(entity);
        assertEntityOfUpdate(entity);
        return getMyDao().updateModifiedOnly(entity);
    }

    /**
     * Delete one entity. (Delegate-Method)
     * 
     * @param entity Entity. (NotNull)
     * @return Deleted count.
     */
    public int delegateDelete(Company entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        filterEntityOfDelete(entity);
        assertEntityOfDelete(entity);
        return getMyDao().delete(entity);
    }

    /**
     * Insert several entities. (Delegate-Method)
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Inserted count.
     */
    public int delegateInsertList(java.util.List<Company> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return getMyDao().insertList(entityList);
    }

    /**
     * Update several entities. (Delegate-Method)
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Updated count.
     */
    public int delegateUpdateList(java.util.List<Company> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return getMyDao().updateList(entityList);
    }

    /**
     * Delete several entities. (Delegate-Method)
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Deleted count.
     */
    public int delegateDeleteList(java.util.List<Company> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return getMyDao().deleteList(entityList);
    }

    // =====================================================================================
    //                                                                    Basic Select Count
    //                                                                    ==================
    /**
     * Select count by condition-bean.
     * <pre>
     * If the argument 'condition-bean' is effective about fetch-scope,
     * this method invoke select count ignoring the fetch-scope.
     * </pre>
     * @param cb Condition-bean. This condition-bean should not be set up about fetch-scope. (NotNull)
     * @return Selected count.
     */
    public int selectCount(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        return delegateSelectCount(cb);
    }

    // =====================================================================================
    //                                                                   Basic Select Entity
    //                                                                   ===================
    /**
     * Select entity by condition-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. (Nullalble)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Company selectEntity(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Company> ls = selectList(cb);
        if (ls.isEmpty()) {
            return null;
        }
        assertRecordHasBeenSelectedAsOne(ls, cb.toString());
        return (Company)ls.get(0);
    }

    /**
     * Select entity by condition-bean with deleted check.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Company selectEntityWithDeletedCheck(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Company> ls = selectList(cb);
        assertRecordHasNotBeenDeleted(ls, cb.toString());
        assertRecordHasBeenSelectedAsOne(ls, cb.toString());
        return (Company)ls.get(0);
    }

    /*
     * Select entity with deleted check. {by primary-key}
     * 
     * @param primaryKey
     * @return Selected entity. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Company selectByPKValueWithDeletedCheck(java.math.BigDecimal ccode) {
        Company entity = new Company();
        entity.setCcode(ccode);
        final CompanyCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
        return selectEntityWithDeletedCheck(cb);
    }

    // =====================================================================================
    //                                                                     Basic Select List
    //                                                                     =================
    /**
     * Select list as result-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected list-result-bean. (NotNull)
     */
    public ListResultBean<Company> selectList(CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        return new ResultBeanBuilder<Company>(this).buildListResultBean(cb, delegateSelectList(cb));
    }

    /**
     * Select page as result-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected paging-result-bean. (NotNull)
     */
    public PagingResultBean<Company> selectPage(final CompanyCB cb) {
        assertConditionBeanNotNull(cb);
        return selectPage(cb, new SelectPageSimpleInvoker<Company>(this));
    }

    /**
     * Select page.
     * 
     * @param cb Condition-bean. (NotNull)
     * @param invoker Select-page-invoker (NotNull)
     * @return Selected paging-result-bean. (NotNull)
     */
    public PagingResultBean<Company> selectPage(final CompanyCB cb, SelectPageInvoker<Company> invoker) {
        assertConditionBeanNotNull(cb);
        final SelectPageCallback<Company> pageCallback = new SelectPageCallback<Company>() {
            public PagingBean getPagingBean() { return cb; }
            public int selectCountIgnoreFetchScope() {
                return selectCount(cb);
            }
            public java.util.List<Company> selectListWithFetchScope() {
                return selectList(cb);
            }
        };
        return invoker.invokeSelectPage(pageCallback);
    }


  
    // =====================================================================================
    //                                                                              Sequence
    //                                                                              ========
    /**
     * Select next value as sequence.
     * 
     * @return Next value. (NotNull)
     */
    public java.math.BigDecimal selectNextVal() {
        return getMyDao().selectNextVal();
    }

    // =====================================================================================
    //                                                                         Load Refferer
    //                                                                         =============
  
    // =====================================================================================
    //                                                                   Basic Entity Update
    //                                                                   ===================
    /**
     * Insert.
     * 
     * @param entity Entity. (NotNull)
     */
    public void insert(Company entity) {
        assertEntityNotNull(entity);
        delegateInsert(entity);
    }

    protected void doCreate(Entity entity) {
        insert((Company)entity);
    }

    /**
     * Update.
     * 
     * @param entity Entity. (NotNull)
     */
    public void update(Company entity) {
        assertEntityNotNull(entity);
        final int updatedCount = delegateUpdate(entity);
        if (updatedCount != 1) {
            throw new org.seasar.dao.NotSingleRowUpdatedRuntimeException(entity, updatedCount);
        }
    }

    protected void doModify(Entity entity) {
        update((Company)entity);
    }

    /**
     * Update after select.
     * 
     * @param entity Entity. This must contain primary-key value at least. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public void updateAfterSelect(Company entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        final CompanyCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
        final Company currentEntity = selectEntityWithDeletedCheck(cb);
        mergeEntity(entity, currentEntity);
        update(currentEntity);
    }

    protected void doModifyAfterSelect(Entity entity) {
        updateAfterSelect((Company)entity);
    }

    /**
     * Insert or update after select.
     * {update: modified only}
     * 
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     */
    public void insertOrUpdateAfterSelect(Company entity) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            insert(entity);
            return;
        }
        Company currentEntity = null;
        try {
            final CompanyCB cb = newMyConditionBean();
            cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
            currentEntity = selectEntityWithDeletedCheck(cb);
        } catch (org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException e) {
            insert(entity);
            return;
        }
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        mergeEntity(entity, currentEntity);
        update(currentEntity);
    }

    protected void doCreateOrModifyAfterSelect(Entity entity) {
        insertOrUpdateAfterSelect((Company)entity);
    }
  
    /**
     * This method implements the method that is declared at super.
     * 
     * @param sourceEntity Source entity. (NotNull)
     * @param destinationEntity Destination entity. (NotNull)
     */
    protected void mergeEntity(Entity sourceEntity, Entity destinationEntity) {
        assertEntityNotNull(sourceEntity);
        assertEntityNotNull(destinationEntity);
        final Company sourceMyEntity = (Company)sourceEntity;
        final Company destinationMyEntity = (Company)destinationEntity;
        destinationMyEntity.clearModifiedPropertyNames();
        final java.util.Set<String> names = sourceMyEntity.getModifiedPropertyNames();
  
        if (names.contains("ccode")) {
            destinationMyEntity.setCcode(sourceMyEntity.getCcode());
        }
  
        if (names.contains("cat")) {
            destinationMyEntity.setCat(sourceMyEntity.getCat());
        }
  
        if (names.contains("shortname")) {
            destinationMyEntity.setShortname(sourceMyEntity.getShortname());
        }
  
        if (names.contains("name")) {
            destinationMyEntity.setName(sourceMyEntity.getName());
        }
  
        if (names.contains("telephone")) {
            destinationMyEntity.setTelephone(sourceMyEntity.getTelephone());
        }
  
        if (names.contains("versionno")) {
            destinationMyEntity.setVersionno(sourceMyEntity.getVersionno());
        }
  
    }

    /**
     * Delete.
     * 
     * @param entity Entity. (NotNull)
     */
    public void delete(Company entity) {
        assertEntityNotNull(entity);
        final int deletedCount = delegateDelete(entity);
        if (deletedCount != 1) {
            throw new org.seasar.dao.NotSingleRowUpdatedRuntimeException(entity, deletedCount);
        }
    }

    protected void doRemove(Entity entity) {
        delete((Company)entity);
    }

    /**
     * Delete after select.
     * 
     * @param entity Entity. This must contain primary-key value at least. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public void deleteAfterSelect(Company entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        final CompanyCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
        selectEntityWithDeletedCheck(cb);
        delete(entity);
    }

    protected void doRemoveAfterSelect(Entity entity) {
        deleteAfterSelect((Company)entity);
    }

    // =====================================================================================
    //                                                                    Basic Batch Update
    //                                                                    ==================
    /**
     * Insert list.
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Inserted count.
     */
    public int insertList(java.util.List<Company> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return delegateInsertList(entityList);
    }

    /**
     * Update list.
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Updated count.
     */
    public int updateList(java.util.List<Company> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return delegateUpdateList(entityList);
    }

    /**
     * Delete list.
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Deleted count.
     */
    public int deleteList(java.util.List<Company> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return delegateDeleteList(entityList);
    }

    // =====================================================================================
    //                                                                        Various Insert
    //                                                                        ==============
  
    // =====================================================================================
    //                                                                            CBSetupper
    //                                                                            ==========
    /**
     * The interface of condition-bean setupper.
     */
    public static interface CBSetupper extends SimpleCBSetupper {
        /**
         * Set up condition.
         * 
         * @param cb Condition-bean. (NotNull)
         */
        public void setup(CompanyCB cb);
    }
}
