package org.seasar.golf.uexample.ldb.allcommon.cbean;

/**
 * Condition-Bean context. (referring to s2pager)
 * 
 * @author DBFlute(AutoGenerator)
 */
public class ConditionBeanContext {

    /** The thread-local for this. */
    private static ThreadLocal<ConditionBean> _threadLocal = new ThreadLocal<ConditionBean>();

    /**
     * Get fetch-narrowing-bean on thread.
     * 
     * @return Condition-bean context. (Nullable)
     */
    public static ConditionBean getConditionBeanOnThread() {
        return (ConditionBean)_threadLocal.get();
    }

    /**
     * Set condition-bean on thread.
     * 
     * @param cb Condition-bean. (NotNull)
     */
    public static void setConditionBeanOnThread(ConditionBean cb) {
        if (cb == null) {
            String msg = "The argument[cb] must not be null.";
            throw new IllegalArgumentException(msg);
        }
        _threadLocal.set(cb);
    }

    /**
     * Is existing condition-bean on thread?
     * 
     * @return Determination.
     */
    public static boolean isExistConditionBeanOnThread() {
        return (_threadLocal.get() != null);
    }

    /**
     * Clear condition-bean on thread.
     */
    public static void clearConditionBeanOnThread() {
        _threadLocal.set(null);
    }

    /**
     * Is the argument condition-bean?
     * 
     * @param dtoInstance Dto instance.
     * @return Determination.
     */
    public static boolean isTheArgumentConditionBean(final Object dtoInstance) {
        if (dtoInstance instanceof ConditionBean) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Is the type condition-bean?
     * 
     * @param dtoClass DtoClass.
     * @return Determination.
     */
    public static boolean isTheTypeConditionBean(final Class dtoClass) {
        if (ConditionBean.class.isAssignableFrom(dtoClass)) {
            return true;
        } else {
            return false;
        }
    }
}
