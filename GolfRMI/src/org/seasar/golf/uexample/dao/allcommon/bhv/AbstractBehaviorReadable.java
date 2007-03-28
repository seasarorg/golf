
package org.seasar.golf.uexample.dao.allcommon.bhv;

import org.seasar.golf.uexample.dao.allcommon.DaoSelector;
import org.seasar.golf.uexample.dao.allcommon.Entity;
import org.seasar.golf.uexample.dao.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.ListResultBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.PagingBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.PagingResultBean;


/**
 * The abstract class of behavior-readable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBehaviorReadable implements BehaviorReadable {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** Dao-selector instance. */
    protected DaoSelector _daoSelector;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public AbstractBehaviorReadable() {
    }

    // =====================================================================================
    //                                                                          Dao Accessor
    //                                                                          ============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return Dao-selector.
     */
    public DaoSelector getDaoSelector() {
        return _daoSelector;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param value Dao-selector.
     */
    public void setDaoSelector(DaoSelector value) {
        _daoSelector = value;
    }

    // =====================================================================================
    //                                                                       Delegate Method
    //                                                                       ===============
    /**
     * This method implements the method that is declared at super.
     * 
     * @return All count.
     */
    public int callGetCountAll() {
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "getCountAll", new Class[]{});
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{});
        return ((Integer)result).intValue();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @return All list. (NotNull)
     */
    public java.util.List<Entity> callGetListAll() {
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "getListAll", new Class[]{});
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{});
        return (java.util.List<Entity>)result;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean that the type is condition-bean-interface. (NotNull)
     * @return Read count. (NotNull)
     */
    public int callReadCount(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final Class[] types = new Class[]{cb.getClass()};
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "selectCount", types);
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{cb});
        return ((Integer)result).intValue();
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean that the type is condition-bean-interface. (NotNull)
     * @return Read entity. If the select result is zero, it returns null. (Nullable)
     */
    public Entity callReadEntity(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final Class[] types = new Class[]{cb.getClass()};
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "selectEntity", types);
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{cb});
        return (Entity)result;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean that the type is condition-bean-interface. (NotNull)
     * @return Read list. If the select result is zero, it returns empty list. (NotNull)
     */
    public java.util.List<Entity> callReadList(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final Class[] types = new Class[]{cb.getClass()};
        final java.lang.reflect.Method mtd = getMethod(getDaoReadable().getClass(), "selectList", types);
        final Object result = invoke(mtd, getDaoReadable(), new Object[]{cb});
        return (java.util.List<Entity>)result;
    }

    private java.lang.reflect.Method getMethod(Class clazz, String methodName, Class[] argTypes) {
        try {
            return clazz.getMethod(methodName, argTypes);
        } catch (NoSuchMethodException ex) {
            String msg = "class=" + clazz + " method=" + methodName + "-" + java.util.Arrays.asList(argTypes);
            throw new RuntimeException(msg, ex);
        }
    }

    private Object invoke(java.lang.reflect.Method method, Object target, Object[] args) {
        try {
            return method.invoke(target, args);
        } catch (java.lang.reflect.InvocationTargetException ex) {
            Throwable t = ex.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            }
            if (t instanceof Error) {
                throw (Error) t;
            }
            String msg = "target=" + target + " method=" + method + "-" + java.util.Arrays.asList(args);
            throw new RuntimeException(msg, ex);
        } catch (IllegalAccessException ex) {
            String msg = "target=" + target + " method=" + method + "-" + java.util.Arrays.asList(args);
            throw new RuntimeException(msg, ex);
        }
    }

    // =====================================================================================
    //                                                                         Basic Get All
    //                                                                         =============
    /**
     * Get count all.
     * 
     * @return Count all.
     */
    public int getCountAll() {
        return callGetCountAll();
    }

    // =====================================================================================
    //                                                                      Basic Read Count
    //                                                                      ================
    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean. This condition-bean should not be set up about fetch-scope. (NotNull)
     * @return Read count. (NotNull)
     */
    public int readCount(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        return callReadCount(cb);
    }

    // =====================================================================================
    //                                                                     Basic Read Entity
    //                                                                     =================
    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (Nullalble)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Entity readEntity(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Entity> ls = readList(cb);
        if (ls.isEmpty()) {
            return null;
        }
        assertRecordHasBeenSelectedAsOne(ls, cb.toString());
        return (Entity)ls.get(0);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (NotNull)
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    public Entity readEntityWithDeletedCheck(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        final java.util.List<Entity> ls = readList(cb);
        assertRecordHasNotBeenDeleted(ls, cb.toString());
        assertRecordHasBeenSelectedAsOne(ls, cb.toString());
        return (Entity)ls.get(0);
    }

    // =====================================================================================
    //                                                                       Basic Read List
    //                                                                       ===============
    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean.
     * @return List-result-bean. If the select result is zero, it returns empty list. (NotNull)
     */
    public ListResultBean<Entity> readList(ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        return new ResultBeanBuilder<Entity>(this).buildListResultBean(cb, callReadList(cb));
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read page. (NotNull)
     */
    public PagingResultBean<Entity> readPage(final ConditionBean cb) {
        assertConditionBeanNotNull(cb);
        return readPage(cb, new SelectPageSimpleInvoker<Entity>(this));
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param cb Condition-bean. (NotNull)
     * @param invoker Select-page-invoker (NotNull)
     * @return Read page. (NotNull)
     */
    public PagingResultBean<Entity> readPage(final ConditionBean cb, SelectPageInvoker<Entity> invoker) {
        assertConditionBeanNotNull(cb);
        final SelectPageCallback<Entity> pageCallback = new SelectPageCallback<Entity>() {
            public PagingBean getPagingBean() { return cb; }
            public int selectCountIgnoreFetchScope() {
                return readCount(cb);
            }
            public java.util.List<Entity> selectListWithFetchScope() {
                return readList(cb);
            }
        };
        return invoker.invokeSelectPage(pageCallback);
    }

    /**
     * Assert that record has not been deleted.
     * 
     * @param entity Selected entity.
     * @param searchKey4log Search-key for Logging.
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    protected void assertRecordHasNotBeenDeleted(org.seasar.golf.uexample.dao.allcommon.Entity entity, Object searchKey4log) {
        if (entity == null) {
            String msg = "The record has already been deleted by other thread: searchKey=" + searchKey4log;
            throw new org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException(msg);
        }
    }

    /**
     * Assert that record has not been deleted.
     * 
     * @param ls Selected list.
     * @param searchKey4log Search-key for Logging.
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    protected void assertRecordHasNotBeenDeleted(java.util.List ls, Object searchKey4log) {
        if (ls == null || ls.isEmpty()) {
            String msg = "The record has already been deleted by other thread: searchKey=" + searchKey4log;
            throw new org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException(msg);
        }
    }

    /**
     * Assert that record has been selected as one.
     * 
     * @param ls Selected list.
     * @param searchKey4log Search-key for Logging.
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException
     */
    protected void assertRecordHasBeenSelectedAsOne(java.util.List ls, Object searchKey4log) {
        if (ls == null || ls.isEmpty()) {
            String msg = "The record has already been deleted by other thread: searchKey=" + searchKey4log;
            throw new org.seasar.golf.uexample.dao.allcommon.exception.RecordHasAlreadyBeenDeletedException(msg);
        }
        if (ls.size() != 1) {
            String msg = "This selected contents should be only one: searchKey=" + searchKey4log;
            msg = msg + " resultCount=" + ls.size();
            throw new org.seasar.golf.uexample.dao.allcommon.exception.RecordHasOverlappedException(msg);
        }
    }

    /**
     * Assert that selected count has not exceeded max count.
     * 
     * @param selectedCount Selected count.
     * @param maxCount Max count.
     * @param clauseString Clause string for exception message.
     * @exception org.seasar.golf.uexample.dao.allcommon.exception.SelectedCountExceedMaxCountException
     */
    protected void assertSelectedCountHasNotExceededMaxCount(int selectedCount, int maxCount, String clauseString) {
        if (selectedCount > maxCount) {
            String msg = "Selected count[" + selectedCount + "] has exceeded max count[" + maxCount + "]: clauseString=" + clauseString;
            throw new org.seasar.golf.uexample.dao.allcommon.exception.SelectedCountExceedMaxCountException(msg, selectedCount, maxCount);
        }
    }

    // =====================================================================================
    //                                                                         Helper Method
    //                                                                         =============
    /**
     * To lower case if the type is String.
     * 
     * @param obj Object. (Nullable)
     * @return Lower object. (Nullable)
     */
    protected Object toLowerCaseIfString(Object obj) {
        if (obj != null && obj instanceof String) {
            return ((String)obj).toLowerCase();
        }
        return obj;
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

    /**
     * Assert that the entity is not null.
     * 
     * @param entity Entity. (NotNull)
     */
    protected void assertEntityNotNull(Entity entity) {
        assertObjectNotNull("entity", entity);
    }

    /**
     * Assert that the condition-bean is not null.
     * 
     * @param cb Condition-bean. (NotNull)
     */
    protected void assertConditionBeanNotNull(org.seasar.golf.uexample.dao.allcommon.cbean.ConditionBean cb) {
        assertObjectNotNull("cb", cb);
    }

    /**
     * Assert that the entity has primary-key value.
     * 
     * @param entity Entity. (NotNull)
     */
    protected void assertEntityNotNullAndHasPrimaryKeyValue(Entity entity) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            String msg = "The entity must should primary-key: entity=" + entity;
            throw new IllegalArgumentException(msg + entity);
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
        assertObjectNotNull(variableName, value);
        if (value.trim().length() ==0) {
            String msg = "The value should not be empty: variableName=" + variableName + " value=" + value;
            throw new IllegalArgumentException(msg);
        }
    }

    // ----------------------------------------------------------------
    //                                                      Assert List
    //                                                      -----------
    /**
     * Assert that the list is empty.
     * 
     * @param ls List. (NotNull)
     */
    protected void assertListNotNullAndEmpty(java.util.List ls) {
        assertObjectNotNull("ls", ls);
        if (!ls.isEmpty()) {
            String msg = "The list should be empty: ls=" + ls.toString();
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the list is not empty.
     * 
     * @param ls List. (NotNull)
     */
    protected void assertListNotNullAndNotEmpty(java.util.List ls) {
        assertObjectNotNull("ls", ls);
        if (ls.isEmpty()) {
            String msg = "The list should not be empty: ls=" + ls.toString();
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Assert that the list having only one.
     * 
     * @param ls List. (NotNull)
     */
    protected void assertListNotNullAndHasOnlyOne(java.util.List ls) {
        assertObjectNotNull("ls", ls);
        if (ls.size() != 1) {
            String msg = "The list should contain only one object: ls=" + ls.toString();
            throw new IllegalArgumentException(msg);
        }
    }
}
