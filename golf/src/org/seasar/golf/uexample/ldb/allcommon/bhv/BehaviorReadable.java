package org.seasar.golf.uexample.ldb.allcommon.bhv;

import org.seasar.golf.uexample.ldb.allcommon.DaoSelector;
import org.seasar.golf.uexample.ldb.allcommon.DaoReadable;
import org.seasar.golf.uexample.ldb.allcommon.Entity;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ListResultBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.OrderByBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.PagingBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.PagingResultBean;
import org.seasar.golf.uexample.ldb.allcommon.dbmeta.DBMeta;

/**
 * The interface of behavior-readable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface BehaviorReadable {

    // =====================================================================================
    //                                                                            Definition
    //                                                                            ==========
    /** Map-string map-mark. */
    public static final String MAP_STRING_MAP_MARK = "map:";

    /** Map-string list-mark. */
    public static final String MAP_STRING_LIST_MARK = "list:";

    /** Map-string start-brace. */
    public static final String MAP_STRING_START_BRACE = "@{";

    /** Map-string end-brace. */
    public static final String MAP_STRING_END_BRACE = "@}";

    /** Map-string delimiter. */
    public static final String MAP_STRING_DELIMITER = "@;";

    /** Map-string equal. */
    public static final String MAP_STRING_EQUAL = "@=";

    // =====================================================================================
    //                                                                            Table name
    //                                                                            ==========
    /**
     * Get table db-name.
     * 
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName();

    // =====================================================================================
    //                                                                                DBMeta
    //                                                                                ======
    /**
     * Get dbmeta.
     * 
     * @return DBMeta. (NotNull)
     */
    public DBMeta getDBMeta();

    // =====================================================================================
    //                                                                          Dao Accessor
    //                                                                          ============
    /**
     * Get dao-readable.
     * 
     * @return Dao-readable. (NotNull)
     */
    public DaoReadable getDaoReadable();

    /**
     * Get dao-selector.
     * 
     * @return Dao-selector.
     */
    public DaoSelector getDaoSelector();

    /**
     * Set dao-selector.
     * 
     * @param value Dao-selector.
     */
    public void setDaoSelector(DaoSelector value);

    // =====================================================================================
    //                                                                          New Instance
    //                                                                          ============
    /**
     * New entity.
     * 
     * @return Entity. (NotNull)
     */
    public Entity newEntity();

    /**
     * New condition-bean.
     * 
     * @return Condition-bean. (NotNull)
     */
    public ConditionBean newConditionBean();

    // =====================================================================================
    //                                                                       Delegate Method
    //                                                                       ===============
    /**
     * Read count as all. (Delegate-Method)
     * 
     * @return All count. (NotNull)
     */
    public int callGetCountAll();

    /**
     * Read list as all. (Delegate-Method)
     * 
     * @return All list. (NotNull)
     */
    public java.util.List<Entity> callGetListAll();

    /**
     * Read count by condition-bean. (Delegate-Method)
     * If the condition-bean is invoked fetchFirst() and fetchScope() and fetchPage(), throw exception.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read count. (NotNull)
     */
    public int callReadCount(ConditionBean cb);

    /**
     * Read entity by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. If the select result is zero, it returns null. (Nullable)
     */
    public Entity callReadEntity(ConditionBean cb);

    /**
     * Read list by condition-bean. (Delegate-Method)
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read list. If the select result is zero, it returns empty list. (NotNull)
     */
    public java.util.List<Entity> callReadList(ConditionBean cb);

    // =====================================================================================
    //                                                                         Basic Get All
    //                                                                         =============
    /**
     * Get count all.
     * 
     * @return Count all.
     */
    public int getCountAll();

    // =====================================================================================
    //                                                                      Basic Read Count
    //                                                                      ================
    /**
     * Read count by condition-bean.
     * <pre>
     * If the argument 'condition-bean' is effective about fetch-scope,
     * this method invoke select count ignoring the fetch-scope.
     * </pre>
     * @param cb Condition-bean. This condition-bean should not be set up about fetch-scope. (NotNull)
     * @return Read count. (NotNull)
     */
    public int readCount(ConditionBean cb);

    // =====================================================================================
    //                                                                     Basic Read Entity
    //                                                                     =================
    /**
     * Read entity by condition-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (Nullalble)
     * @exception org.seasar.golf.uexample.ldb.allcommon.exception.RecordHasOverlappedException
     */
    public Entity readEntity(ConditionBean cb);

    /**
     * Read simple entity by condition-bean with deleted check.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read entity. (NotNull)
     * @exception org.seasar.golf.uexample.ldb.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public Entity readEntityWithDeletedCheck(ConditionBean cb);

    // =====================================================================================
    //                                                                       Basic Read List
    //                                                                       ===============
    /**
     * Read list as result-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return List-result-bean. If the select result is zero, it returns empty list. (NotNull)
     */
    public ListResultBean<Entity> readList(ConditionBean cb);

    /**
     * Read page as result-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @return Read page. (NotNull)
     */
    public PagingResultBean<Entity> readPage(final ConditionBean cb);

    /**
     * Read page as result-bean.
     * 
     * @param cb Condition-bean. (NotNull)
     * @param invoker Select-page-invoker (NotNull)
     * @return Read page. (NotNull)
     */
    public PagingResultBean<Entity> readPage(final ConditionBean cb, SelectPageInvoker<Entity> invoker);

    /**
     * The interface of select-page callback.
     * 
     * @param <T> The generic template for 'selectedList'.
     */
    public static interface SelectPageCallback<T> {
        public PagingBean getPagingBean();
        public int selectCountIgnoreFetchScope();
        public java.util.List<T> selectListWithFetchScope();
    }

    /**
     * The object of result-bean builder.
     * 
     * @param <T> The generic template for 'resultBean'.
     */
    public static class ResultBeanBuilder<T> {
        protected BehaviorReadable _bhv;
        public ResultBeanBuilder(BehaviorReadable bhv) {
            _bhv = bhv;
        }
        /**
         * Build list-reuslt-bean.
         * 
         * @param ob Order-by-bean. (NotNull)
         * @param selectedList Selected list. (NotNull)
         * @return List-result-bean. (NotNull)
         */
        public ListResultBean<T> buildListResultBean(OrderByBean ob, java.util.List<T> selectedList) {
            ListResultBean<T> rb = new ListResultBean<T>();
            rb.setTableDbName(_bhv.getTableDbName());
            rb.setAllRecordCount(selectedList.size());
            rb.setSelectedList(selectedList);
            rb.setOrderByClause(ob.getSqlComponentOfOrderByClause());
            return rb;
        }
        /**
         * Build paging-reuslt-bean.
         * 
         * @param pb Paging-bean. (NotNull)
         * @param allRecordCount All-record-count.
         * @param selectedList Selected list. (NotNull)
         * @return Paging-result-bean. (NotNull)
         */
        public PagingResultBean<T> buildPagingResultBean(PagingBean pb, int allRecordCount, java.util.List<T> selectedList) {
            PagingResultBean<T> rb = new PagingResultBean<T>();
            rb.setTableDbName(_bhv.getTableDbName());
            rb.setAllRecordCount(allRecordCount);
            rb.setSelectedList(selectedList);
            rb.setPageSize(pb.getFetchSize());
            rb.setCurrentPageNumber(pb.getFetchPageNumber());
            rb.setOrderByClause(pb.getSqlComponentOfOrderByClause());
            return rb;
        }
    }

    public static interface SelectPageInvoker<T> {
        /**
         * Invoke select-page by callback.
         * 
         * @param callback Callback. (NotNull)
         * @return Paging-result-bean. (NotNull)
         */
        public PagingResultBean<T> invokeSelectPage(SelectPageCallback<T> callback);
    }

    /**
     * The object of result-bean builder.
     * 
     * @param <T> The generic template for 'resultBean'.
     */
    public static class SelectPageSimpleInvoker<T> implements SelectPageInvoker<T> {
        protected BehaviorReadable _bhv;
        public SelectPageSimpleInvoker(BehaviorReadable bhv) {
            _bhv = bhv;
        }

        /**
         * Invoke select-page by callback.
         * 
         * @param callback Callback. (NotNull)
         * @return Paging-result-bean. (NotNull)
         */
        public PagingResultBean<T> invokeSelectPage(SelectPageCallback<T> callback) {
            assertObjectNotNull("callback", callback);
            assertObjectNotNull("callback.getPagingBean()", callback.getPagingBean());
            if (!callback.getPagingBean().isFetchScopeEffective()) {
                String msg = "When you invoke select page, you should set up fetch-scope of paging bean.";
                msg = msg + " But the paging bean is not effective about fetch-scope: " + callback.getPagingBean();
                throw new IllegalStateException(msg);
            }
            final int allRecordCount = callback.selectCountIgnoreFetchScope();
            final java.util.List<T> selectedList = callback.selectListWithFetchScope();
            final PagingResultBean<T> rb = new ResultBeanBuilder<T>(_bhv).buildPagingResultBean(callback.getPagingBean(), allRecordCount, selectedList);
            if (isNecessaryToReadPageAgain(rb)) {
                callback.getPagingBean().fetchPage(rb.getAllPageCount());
                final int reAllRecordCount = callback.selectCountIgnoreFetchScope();
                final java.util.List<T> reSelectedList = callback.selectListWithFetchScope();
                return new ResultBeanBuilder<T>(_bhv).buildPagingResultBean(callback.getPagingBean(), reAllRecordCount, reSelectedList);
            } else {
                return rb;
            }
        }

        /**
         * Is it necessary to read page again?
         * 
         * @param rb Paging-result-bean. (NotNull)
         * @return Determination.
         */
        protected boolean isNecessaryToReadPageAgain(PagingResultBean<T> rb) {
            return rb.getAllRecordCount() > 0 && rb.getSelectedList().isEmpty();
        }

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
    }

    /**
     * The marker interface of simple condition-bean setupper.
     */
    public static interface SimpleCBSetupper {
    }
}
