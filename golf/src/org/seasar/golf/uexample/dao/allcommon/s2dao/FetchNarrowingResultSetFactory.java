package org.seasar.golf.uexample.dao.allcommon.s2dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.seasar.extension.jdbc.ResultSetFactory;
import org.seasar.framework.util.PreparedStatementUtil;

import org.seasar.golf.uexample.dao.allcommon.cbean.FetchNarrowingBean;
import org.seasar.golf.uexample.dao.allcommon.cbean.FetchNarrowingBeanContext;

/**
 * Fetch page result set factory.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class FetchNarrowingResultSetFactory implements ResultSetFactory {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(FetchNarrowingResultSetFactory.class);

    /** Is internal-debug enabled? */
    private boolean _isInternalDebugEnabled = false;

    /**
     * Constructor.
     */
    public FetchNarrowingResultSetFactory() {
    }

    /**
     * Create result set.
     * 
     * @param ps Prepared statement.
     * @return Result set. (NotNull)
     */
    public ResultSet createResultSet(PreparedStatement ps) {
        if (_isInternalDebugEnabled) {
            if (_log.isDebugEnabled()) {
                _log.debug("executeQuery(ps) ps=" + ps);
            }
        }
        final ResultSet resultSet = PreparedStatementUtil.executeQuery(ps);

        if (!FetchNarrowingBeanContext.isExistFetchNarrowingBeanOnThread()) {
            return resultSet;
        }

        final FetchNarrowingBean cb = FetchNarrowingBeanContext.getFetchNarrowingBeanOnThread();
        if (!cb.isFetchNarrowingEffective()) {
            return resultSet;// It is not necessary to control.
        }
        if (!cb.isFetchNarrowingSkipStartIndexEffective() && !cb.isFetchNarrowingLoopCountEffective()) {
            return resultSet;// It is not necessary to control. The sql already have been controlled.
        }

        if (_isInternalDebugEnabled) {
            if (_log.isDebugEnabled()) {
                _log.debug("Necessary to control fetch-narrowing! cb=" + cb);
            }
        }
        return new FetchNarrowingResultSetWrapper(resultSet, cb);
    }
}
