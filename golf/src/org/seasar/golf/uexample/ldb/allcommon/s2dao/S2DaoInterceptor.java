package org.seasar.golf.uexample.ldb.allcommon.s2dao;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.seasar.golf.uexample.ldb.allcommon.Entity;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBeanContext;
import org.seasar.golf.uexample.ldb.allcommon.cbean.FetchNarrowingBeanContext;
import org.seasar.golf.uexample.ldb.allcommon.cbean.FetchNarrowingBean;

/**
 * My-DaoInterceptor.
 * Customises original class 'S2DaoInterceptor'.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class S2DaoInterceptor extends org.seasar.framework.aop.interceptors.AbstractInterceptor {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(S2DaoInterceptor.class);

    /** Dao meta data factory. */
    private org.seasar.dao.DaoMetaDataFactory daoMetaDataFactory_;

    /**
     * Constructor.
     * 
     * @param daoMetaDataFactory Dao meta data factory.
     */
    public S2DaoInterceptor(org.seasar.dao.DaoMetaDataFactory daoMetaDataFactory) {
        daoMetaDataFactory_ = daoMetaDataFactory;
    }

    /**
     * Invoke.
     * 
     * @param invocation Method invocation.
     * @return Result of the method.
     * @throws Throwable
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        final java.lang.reflect.Method method = invocation.getMethod();
        if (!org.seasar.framework.util.MethodUtil.isAbstract(method)) {
            return invocation.proceed();
        }

        traceMethod(invocation);

        final org.seasar.dao.SqlCommand cmd;
        {
            final Class targetClass = getTargetClass(invocation);
            final org.seasar.dao.DaoMetaData dmd = daoMetaDataFactory_.getDaoMetaData(targetClass);
            cmd = dmd.getSqlCommand(method.getName());
        }

        final ConditionBean cb = preprocessConditionBean(invocation, cmd);
        Object ret = null;
        final long before = System.currentTimeMillis();
        try {
            ret = cmd.execute(invocation.getArguments());
        } catch (Exception e) {
            _log.info("Dao threw the exception: " + e.getClass() + " msg=" + e.getMessage());
            _log.info("    method   --> " + invocation.getMethod());
            _log.info("    argument --> " + getObjectArrayString(invocation.getArguments()));
            if (e instanceof org.seasar.framework.exception.SQLRuntimeException) {
                final Throwable causeException = ((org.seasar.framework.exception.SQLRuntimeException)e).getCause();
                if (causeException instanceof org.seasar.framework.exception.SSQLException) {
                    final String sql = ((org.seasar.framework.exception.SSQLException)causeException).getSql();
                    _log.info("    sql      --> " + sql);
                }
            }
            throw e;
        } finally {
            postprocessConditionBean(invocation, cb);
        }
        final long after = System.currentTimeMillis();

        final Class retType = method.getReturnType();
        assertRetType(retType, ret);
        traceReturn(invocation, retType, ret, before, after);

        if (retType.isPrimitive()) {
            return org.seasar.framework.util.NumberConversionUtil.convertPrimitiveWrapper(retType, ret);
        } else if (Number.class.isAssignableFrom(retType)) {
            return org.seasar.framework.util.NumberConversionUtil.convertNumber(retType, ret);
        } else {
            return ret;
        }
    }

    protected void traceMethod(MethodInvocation invocation) {
        if (_log.isDebugEnabled()) {
            final java.lang.reflect.Method method = invocation.getMethod();
            final String invokeName = getShortClassName(method.getDeclaringClass()) + "." + method.getName();
            final int length = invokeName.length();
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++) {
                sb.append("=");
            }
            _log.debug("/=====================================================" + sb.toString() + "==");
            _log.debug("                                                      " + invokeName + "()");
            _log.debug("                                                      " + sb.toString() + "=/");
        }
    }

    protected void assertRetType(Class retType, Object ret) {
        if (java.util.List.class.isAssignableFrom(retType)) {
            if (ret != null && !(ret instanceof java.util.List)) {
                String msg = "The retType is difference from actual return: ";
                msg = msg + "retType=" + retType + " ret.getClass()=" + ret.getClass() + " ref=" + ret;
                throw new IllegalStateException(msg);
            }
        } else if (Entity.class.isAssignableFrom(retType)) {
            if (ret != null && !(ret instanceof Entity)) {
                String msg = "The retType is difference from actual return: ";
                msg = msg + "retType=" + retType + " ret.getClass()=" + ret.getClass() + " ref=" + ret;
                throw new IllegalStateException(msg);
            }
        }
    }

    protected void traceReturn(MethodInvocation invocation, Class retType, Object ret, long before, long after)
            throws Throwable {
        if (_log.isDebugEnabled()) {
            try {
                final String daoResultPrefix = "===========/ [" + getPerformanceView(after - before) + " - ";
                if (java.util.List.class.isAssignableFrom(retType)) {
                    if (ret == null) {
                        _log.debug(daoResultPrefix + "Selected count: null]");
                    } else {
                        final java.util.List ls = (java.util.List) ret;
                        if (ls.isEmpty()) {
                            _log.debug(daoResultPrefix + "Selected count: 0]");
                        } else {
                            _log.debug(daoResultPrefix + "Selected count: " + ls.size() + " first=" + ls.get(0) + "]");
                        }
                    }
                } else if (Entity.class.isAssignableFrom(retType)) {
                    if (ret == null) {
                        _log.debug(daoResultPrefix + "Selected entity: null" + "]");
                    } else {
                        final Entity entity = (Entity) ret;
                        _log.debug(daoResultPrefix + "Selected entity: " + entity + "]");
                    }
                } else {
                    if (isSelectCountIgnoreFetchScopeMethod(invocation)) {
                        _log.debug(daoResultPrefix + "Selected count: " + ret + "]");
                    } else {
                        _log.debug(daoResultPrefix + "Result: " + ret + "]");
                    }
                }
                _log.debug(" ");
            } catch (Exception e) {
                String msg = "Result object debug threw the exception: methodName=";
                msg = msg + invocation.getMethod().getName() + " retType=" + retType;
                msg = msg + " ret=" + ret;
                _log.warn(msg, e);
                throw e;
            }
        }
    }

    // =====================================================================================
    //                                                                      Pre&Post Process
    //                                                                      ================
    /**
     * Preprocess condition-bean.
     * <p>
     * If this method is condition bean select target, make dynamic sql.
     * Else nothing.
     * 
     * @param invocation Method invocation. (NotNull)
     * @param cmd Sql command. (NotNull)
     * @return Condition-bean. (Nullable)
     */
    protected ConditionBean preprocessConditionBean(MethodInvocation invocation, org.seasar.dao.SqlCommand cmd) {
        clearThreadLocal();

        final ConditionBean cb;
        {
            final Object[] args = invocation.getArguments();
            if (args == null || !(args.length >= 1)) {
                return null;
            }

            final Object arg0 = args[0];
            if (arg0 == null) {
                return null;
            }

            if (!ConditionBeanContext.isTheTypeConditionBean(arg0.getClass())) {// The argument is not condition-bean...
                if (!FetchNarrowingBeanContext.isTheTypeFetchNarrowingBean(arg0.getClass())) {// And it is not fetch-narrowing-bean...
                    return null;
                }
                FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread((FetchNarrowingBean)arg0);
                return null;
            }

            cb = (ConditionBean)arg0;
        }

        if (!(cmd instanceof S2DaoSelectDynamicCommand)) {// The argument is condition-bean, but this method use outer-sql-file...
            FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread(cb);
            return null;
        }

        if (isSelectCountIgnoreFetchScopeMethod(invocation)) {
            cb.setupSelectCountIgnoreFetchScope();
        } else {
            FetchNarrowingBeanContext.setFetchNarrowingBeanOnThread(cb);
        }

        ConditionBeanContext.setConditionBeanOnThread(cb);
        return cb;
    }

    /**
     * Postprocess condition-bean.
     * 
     * @param invocation Method invocation. (NotNull)
     * @param cb Condition-bean. (Nullable)
     */
    public void postprocessConditionBean(MethodInvocation invocation, ConditionBean cb) {
        clearThreadLocal();

        if (cb != null && isSelectCountIgnoreFetchScopeMethod(invocation)) {
            cb.afterCareSelectCountIgnoreFetchScope();
        }
    }

    protected void clearThreadLocal() {
        if (FetchNarrowingBeanContext.isExistFetchNarrowingBeanOnThread()) {
            FetchNarrowingBeanContext.clearFetchNarrowingBeanOnThread();
        }
        if (ConditionBeanContext.isExistConditionBeanOnThread()) {
            ConditionBeanContext.clearConditionBeanOnThread();
        }
    }

    // =====================================================================================
    //                                                                         Determination
    //                                                                         =============
    /**
     * Is select count ignore-fetch-scope method?
     * 
     * @param invocation Method invocation. (NotNull)
     * @return Determination.
     */
    protected boolean isSelectCountIgnoreFetchScopeMethod(MethodInvocation invocation) {
        final String name = invocation.getMethod().getName();
        if (name.startsWith("readCount")
                || name.startsWith("selectCount")
                || name.startsWith("readCountIgnoreFetchScope")
                || name.startsWith("selectCountIgnoreFetchScope")) {
            return true;
        } else {
            return false;
        }
    }

    // =====================================================================================
    //                                                                                Helper
    //                                                                                ======
    /**
     * Get short class name.
     * 
     * @param clazz Class instance. (NotNull)
     * @return Short class name. (NotNull)
     */
    protected String getShortClassName(Class clazz) {
        String s = clazz.getName();
        int i = s.lastIndexOf('.');
        if (i > 0) {
            return s.substring(i + 1);
        }
        return s;
    }

    /**
     * Change object array to string divided with comma.
     * 
     * @param objArray Object array. (Nullable)
     * @return String (NotNull: If the argument is null, returns empty string.)
     */
    protected String getObjectArrayString(Object[] objArray) {
        if (objArray == null) {
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < objArray.length; i++) {
            if (i == 0) {
                sb.append(objArray[i]);
            } else {
                sb.append(", ").append(objArray[i]);
            }
        }
        return sb.toString();
    }

    /**
     * Get performance view.
     * 
     * @param mil The value of millisecound.
     * @return Performance view. (ex. 1m23s456ms) (NotNull)
     */
    protected String getPerformanceView(long mil) {
        if (mil < 0) {
            return String.valueOf(mil);
        }

        long sec = mil / 1000;
        long min = sec / 60;
        sec = sec % 60;
        mil = mil % 1000;

        StringBuffer sb = new StringBuffer();
        if (min >= 10) { // Minute
            sb.append(min).append("m");
        } else if (min < 10 && min >= 0) {
            sb.append("0").append(min).append("m");
        }
        if (sec >= 10) { // Second
            sb.append(sec).append("s");
        } else if (sec < 10 && sec >= 0) {
            sb.append("0").append(sec).append("s");
        }
        if (mil >= 100) { // Millisecond
            sb.append(mil).append("ms");
        } else if (mil < 100 && mil >= 10) {
            sb.append("0").append(mil).append("ms");
        } else if (mil < 10 && mil >= 0) {
            sb.append("00").append(mil).append("ms");
        }

        return sb.toString();
    }
}