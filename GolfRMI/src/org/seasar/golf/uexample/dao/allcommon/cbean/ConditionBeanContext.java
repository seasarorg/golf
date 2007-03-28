package org.seasar.golf.uexample.dao.allcommon.cbean;

import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.*;

/**
 * Condition-Bean context. (referring to s2pager)
 * 
 * @author DBFlute(AutoGenerator)
 */
public class ConditionBeanContext {

    /** The thread-local for this. */
    private static final ThreadLocal<ConditionBean> _threadLocal = new ThreadLocal<ConditionBean>();

    /** The database product name. */
    private static String _databaseProductName;

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

    /**
     * Get database product name.
     * 
     * @return Database product name.
     */
    public static String getDatabaseProductName() {
        return _databaseProductName;
    }

    /**
     * Set database product name.
     * 
     * @param name Database product name. (NotNull)
     */
    public static void setDatabaseProductName(String name) {
        if (_databaseProductName != null) {
            String msg = "Already set up: current=" + _databaseProductName + " your=" + name;
            throw new IllegalStateException(msg);
        }
        _databaseProductName = name;
    }

    public static SqlClause createSqlClause(String tableDbName) {
        final String databaseProductName = getDatabaseProductName();
        if (databaseProductName == null) {
            return new SqlClausePostgreSql(tableDbName);
        } else {
            final String name = databaseProductName.toLowerCase();
            if (name.startsWith("derby")) {
                return new SqlClauseDerby(tableDbName);
            } else if (name.startsWith("oracle")) {
                return new SqlClauseOracle(tableDbName);
            } else if (name.startsWith("firebird")) {
                return new SqlClauseFirebird(tableDbName);
            } else if (name.startsWith("mysql")) {
                return new SqlClauseMySql(tableDbName);
            } else if (name.startsWith("postgre")) {
                return new SqlClausePostgreSql(tableDbName);
            } else if (name.startsWith("mssql")) {
                return new SqlClauseSqlServer(tableDbName);
            } else if (name.startsWith("db2")) {
                return new SqlClauseDb2(tableDbName);
            } else {
                return new SqlClausePostgreSql(tableDbName);
            }
        }
    }
}
