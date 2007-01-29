
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
 * The behavior of vendor.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorBhv extends org.seasar.golf.uexample.dao.allcommon.bhv.AbstractBehaviorWritable {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Dao instance. */
    protected VendorDao _dao;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public BsVendorBhv() {
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
        return "vendor";
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
        return VendorDbm.getInstance();
    }

    /**
     * Get my dbmeta.
     * 
     * @return DBMeta. (NotNull)
     */
    public VendorDbm getMyDBMeta() {
        return VendorDbm.getInstance();
    }

    // =====================================================================================
    //                                                                          Dao Accessor
    //                                                                          ============
    /**
     * Get my dao.
     * 
     * @return My dao.
     */
    public VendorDao getMyDao() {
        return _dao;
    }

    /**
     * Set my dao.
     * 
     * @param dao My dao. (NotNull)
     */
    public void setMyDao(VendorDao dao) {
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
    public Vendor newMyEntity() {
        return new Vendor();
    }

    /**
     * New my condition-bean.
     * 
     * @return My condition-bean. (NotNull)
     */
    public VendorCB newMyConditionBean() {
        return new VendorCB();
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
    public java.util.List<Vendor> delegateGetListAll() {
        return getMyDao().getListAll();
    }

    //
    // Get entity. (Delegate-Method)
    // 
    // @param Primary-keys (NotNull)
    // @return Entity. (NotNull)
    //
    public Vendor delegateGetEntity(java.math.BigDecimal id) {
        return getMyDao().getEntity(id);
    }

    /**
     * Select count by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected count. (NotNull)
     */
    public int delegateSelectCount(VendorCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().selectCount(cb);
    }

    /**
     * Select entity by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. If the select result is zero, it returns null. (Nullable)
     */
    public Vendor delegateSelectEntity(VendorCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().selectEntity(cb);
    }

    /**
     * Select list by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected list. If the select result is zero, it returns empty list. (NotNull)
     */
    public java.util.List<Vendor> delegateSelectList(VendorCB cb) {
        assertConditionBeanNotNull(cb);
        return getMyDao().selectList(cb);
    }



    /**
     * Insert one entity. (Delegate-Method)
     * 
     * @param entity Entity. (NotNull)
     * @return Inserted count.
     */
    public int delegateInsert(Vendor entity) {
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
    public int delegateUpdate(Vendor entity) {
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
    public int delegateDelete(Vendor entity) {
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
    public int delegateInsertList(java.util.List<Vendor> entityList) {
        assertListNotNullAndEmpty(entityList);
        return getMyDao().insertList(entityList);
    }

    /**
     * Update several entities. (Delegate-Method)
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Updated count.
     */
    public int delegateUpdateList(java.util.List<Vendor> entityList) {
        assertListNotNullAndEmpty(entityList);
        return getMyDao().updateList(entityList);
    }

    /**
     * Delete several entities. (Delegate-Method)
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Deleted count.
     */
    public int delegateDeleteList(java.util.List<Vendor> entityList) {
        assertListNotNullAndEmpty(entityList);
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
    public int selectCount(VendorCB cb) {
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
    public Vendor selectEntity(VendorCB cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Vendor> ls = selectList(cb);
        if (ls.isEmpty()) {
            return null;
        }
        assertRecordHasBeenSelectedAsOne(ls, cb.toString());
        return (Vendor)ls.get(0);
    }

    /**
     * Select entity by condition-bean with deleted check.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected entity. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Vendor selectEntityWithDeletedCheck(VendorCB cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Vendor> ls = selectList(cb);
        assertRecordHasNotBeenDeleted(ls, cb.toString());
        assertRecordHasBeenSelectedAsOne(ls, cb.toString());
        return (Vendor)ls.get(0);
    }

    /*
     * Select entity with deleted check. {by primary-key}
     * 
     * @param primaryKey
     * @return Selected entity. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Vendor selectByPKValueWithDeletedCheck(java.math.BigDecimal id) {
        Vendor entity = new Vendor();
        entity.setId(id);
        final VendorCB cb = newMyConditionBean();
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
    public ListResultBean<Vendor> selectList(VendorCB cb) {
        assertConditionBeanNotNull(cb);
        return new ResultBeanBuilder<Vendor>(this).buildListResultBean(cb, delegateSelectList(cb));
    }

    /**
     * Select page as result-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Selected paging-result-bean. (NotNull)
     */
    public PagingResultBean<Vendor> selectPage(final VendorCB cb) {
        assertConditionBeanNotNull(cb);
        return selectPage(cb, new SelectPageSimpleInvoker<Vendor>(this));
    }

    /**
     * Select page.
     * 
     * @param cb Condition-bean. (NotNull)
     * @param invoker Select-page-invoker (NotNull)
     * @return Selected paging-result-bean. (NotNull)
     */
    public PagingResultBean<Vendor> selectPage(final VendorCB cb, SelectPageInvoker<Vendor> invoker) {
        assertConditionBeanNotNull(cb);
        final SelectPageCallback<Vendor> pageCallback = new SelectPageCallback<Vendor>() {
            public PagingBean getPagingBean() { return cb; }
            public int selectCountIgnoreFetchScope() {
                return selectCount(cb);
            }
            public java.util.List<Vendor> selectListWithFetchScope() {
                return selectList(cb);
            }
        };
        return invoker.invokeSelectPage(pageCallback);
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
     * @return Inserted count.
     */
    public void insert(Vendor entity) {
        assertEntityNotNull(entity);
        delegateInsert(entity);
    }

    protected void doCreate(Entity entity) {
        insert((Vendor)entity);
    }

    /**
     * Update.
     * 
     * @param entity Entity. (NotNull)
     * @return Updated count.
     */
    public void update(Vendor entity) {
        assertEntityNotNull(entity);
        final int updatedCount = delegateUpdate(entity);
        if (updatedCount != 1) {
            throw new org.seasar.dao.NotSingleRowUpdatedRuntimeException(entity, updatedCount);
        }
    }

    protected void doModify(Entity entity) {
        update((Vendor)entity);
    }

    /**
     * Update after select.
     * 
     * @param entity Entity. This must contain primary-key value at least. (NotNull)
     * @return Updated count.
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public void updateAfterSelect(Vendor entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        final VendorCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
        final Vendor currentEntity = selectEntityWithDeletedCheck(cb);
        mergeEntity(entity, currentEntity);
        update(currentEntity);
    }

    protected void doModifyAfterSelect(Entity entity) {
        updateAfterSelect((Vendor)entity);
    }

    /**
     * Insert or update after select.
     * {update: modified only}
     * 
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     * @return Updated count.
     */
    public void insertOrUpdateAfterSelect(Vendor entity) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            insert(entity);
            return;
        }
        Vendor currentEntity = null;
        try {
            final VendorCB cb = newMyConditionBean();
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
        insertOrUpdateAfterSelect((Vendor)entity);
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
        final Vendor sourceMyEntity = (Vendor)sourceEntity;
        final Vendor destinationMyEntity = (Vendor)destinationEntity;
        destinationMyEntity.clearModifiedPropertyNames();
        final java.util.Set<String> names = sourceMyEntity.getModifiedPropertyNames();
  
        if (names.contains("id")) {
            destinationMyEntity.setId(sourceMyEntity.getId());
        }
  
        if (names.contains("vcode")) {
            destinationMyEntity.setVcode(sourceMyEntity.getVcode());
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
     * @return Deleted count.
     */
    public int delete(Vendor entity) {
        assertEntityNotNull(entity);
        return delegateDelete(entity);
    }

    protected void doRemove(Entity entity) {
        delete((Vendor)entity);
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
    public int insertList(java.util.List<Vendor> entityList) {
        assertListNotNullAndEmpty(entityList);
        return delegateInsertList(entityList);
    }

    /**
     * Update list.
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Updated count.
     */
    public int updateList(java.util.List<Vendor> entityList) {
        assertListNotNullAndEmpty(entityList);
        return delegateUpdateList(entityList);
    }

    /**
     * Delete list.
     * 
     * @param entityList Entity-list. (NotNull & NotEmpty)
     * @return Deleted count.
     */
    public int deleteList(java.util.List<Vendor> entityList) {
        assertListNotNullAndEmpty(entityList);
        return delegateDeleteList(entityList);
    }

    // =====================================================================================
    //                                                                        Various Insert
    //                                                                        ==============
      
    /* (non-javadoc) 
     * Copy-insert.
     * 
     * @param primaryKey Primary-keys. (NotNull)
     * @return Inserted count.
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public int copyInsertByPKValueAfterSelect(java.math.BigDecimal id) {
        Vendor entity = new Vendor();
        entity.setId(id);
        final VendorCB cb = newMyConditionBean();
        cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
        final Vendor currentEntity = selectEntityWithDeletedCheck(cb);
        return delegateInsert(currentEntity);
    }
    
    /**
     * Filter 'copy-insert' entity.
     * 
     * @param entity Entity. (NotNull)
     */
    protected void filterCopyInsertEntity(Vendor entity) {
    }
  
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
        public void setup(VendorCB cb);
    }
}
