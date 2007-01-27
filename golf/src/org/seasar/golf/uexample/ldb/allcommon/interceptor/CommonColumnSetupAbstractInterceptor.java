package org.seasar.golf.uexample.ldb.allcommon.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.seasar.golf.uexample.ldb.allcommon.EntityDefinedCommonColumn;

/**
 * CommonColumn-Setup Abstract Interceptor.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class CommonColumnSetupAbstractInterceptor extends org.seasar.framework.aop.interceptors.AbstractInterceptor {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(CommonColumnSetupAbstractInterceptor.class);

    /**
     * Invoke.
     * 
     * @param invocation Method invocation.
     * @return Result of the method.
     * @throws Throwable
     */
    public Object invoke(MethodInvocation invocation) throws Throwable {
        final java.lang.reflect.Method method = invocation.getMethod();
        final Object[] args = invocation.getArguments();

        if (!(args != null && args.length != 0)) {
            return invocation.proceed();
        }
        final Object firstArgument = args[0];
        if (isEntityDefinedCommonColumn(firstArgument)) {
            final EntityDefinedCommonColumn entity = (EntityDefinedCommonColumn)firstArgument;
            if (_log.isDebugEnabled()) {
                String msg = "Intercepted the method '" + getShortClassName(method.getDeclaringClass()) + "." + method.getName() + "()'";
                msg = msg + ": entity=" + entity.extractPrimaryKeyMapString();
                _log.debug(msg);
            }
            setupEntity(entity);
            return invocation.proceed();
        } else if (isListSaveEntityDefinedCommonColumn(firstArgument)) {
            final java.util.List ls = (java.util.List)firstArgument;
                if (_log.isDebugEnabled()) {
                    String msg = "Intercepted the method '" + getShortClassName(method.getDeclaringClass()) + "." + method.getName() + "()'";
                    msg = msg + ": entityList.size()=" + ls.size();
                    _log.debug(msg);
                }
            for (final java.util.Iterator ite = ls.iterator(); ite.hasNext(); ) {
                final EntityDefinedCommonColumn entity = (EntityDefinedCommonColumn)ite.next();
                setupEntity(entity);
            }
            return invocation.proceed();
        } else {
            return invocation.proceed();
        }
    }

    /**
     * Is the object entity defined common column?
     * 
     * @param obj Object. If the object is null, returns false. (Nullable)
     * @return Determination.
     */
    protected boolean isEntityDefinedCommonColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof EntityDefinedCommonColumn) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Is the object list that saves entity defined common column?
     * 
     * @param obj Object. If the object is null, returns false. (Nullable)
     * @return Determination.
     */
    protected boolean isListSaveEntityDefinedCommonColumn(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof java.util.List)) {
            return false;
        }
        final java.util.List ls = (java.util.List)obj;
        for (final java.util.Iterator ite = ls.iterator(); ite.hasNext(); ) {
            final Object currentObj = ite.next();
            if (!(currentObj instanceof EntityDefinedCommonColumn)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Set up the entity.
     * 
     * @param entity Entity. (Nullable)
     */
    abstract protected void setupEntity(EntityDefinedCommonColumn entity);

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
}