package org.seasar.golf.uexample.dao.allcommon.s2dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.seasar.extension.jdbc.impl.ResultSetWrapper;
import org.seasar.framework.exception.SQLRuntimeException;

import org.seasar.golf.uexample.dao.allcommon.cbean.FetchNarrowingBean;

/**
 * Fetch-narrowing-result-set-wrapper.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class FetchNarrowingResultSetWrapper extends ResultSetWrapper {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(FetchNarrowingResultSetWrapper.class);

    /** Is internal-debug enabled? */
    private boolean _isInternalDebugEnabled = false;

    /** Original result set. */
    private ResultSet _resultSet;

    /** FetchNarrowing-bean. */
    private FetchNarrowingBean _cb;

    /** Fetch counter. */
    private long _counter;

    /**
     * Constructor.
     * 
     * @param resultSet Original result set. (NotNull)
     * @param cb FetchNarrowing-bean. (NotNull)
     */
    public FetchNarrowingResultSetWrapper(ResultSet resultSet, FetchNarrowingBean cb) {
        super(resultSet);

        _resultSet = resultSet;
        _cb = cb;

        if (_isInternalDebugEnabled) {
            if (_log.isDebugEnabled()) {
                String msg = "    isFetchNarrowingSkipStartIndexEffective()=" + getFetchNarrowingBean().isFetchNarrowingSkipStartIndexEffective();
                _log.debug(msg);
                msg = "    isFetchNarrowingLoopCountEffective()=" + getFetchNarrowingBean().isFetchNarrowingLoopCountEffective();
                _log.debug(msg);
                msg = "    getFetchNarrowingSkipStartIndex()=" + getFetchNarrowingSkipStartIndex();
                _log.debug(msg);
                msg = "    getFetchNarrowingLoopCount()=" + getFetchNarrowingLoopCount();
                _log.debug(msg);
            }
        }

        skip();
    }

    /**
     * Skip to start-index.
     */
    private void skip() {
        if (!getFetchNarrowingBean().isFetchNarrowingSkipStartIndexEffective()) {
            return;
        }
        if (isCursorUsed()) {
            try {
                if (0 == getFetchNarrowingSkipStartIndex()) {
                    getResultSet().beforeFirst();
                } else {
                    getResultSet().absolute(getFetchNarrowingSkipStartIndex());
                }
                _counter = getResultSet().getRow();
            } catch (SQLException e) {
                throw new SQLRuntimeException(e);
            }
        } else {
            try {
                while (getResultSet().getRow() < getFetchNarrowingSkipStartIndex() && getResultSet().next()) {
                    ++_counter;
                }
            } catch (SQLException e) {
                throw new SQLRuntimeException(e);
            }
        }
    }

    /**
     * Next.
     * 
     * @return Does the result set have next record?
     * @throws SQLException
     */
    public boolean next() throws SQLException {
        final boolean hasNext = super.next();
        if (!getFetchNarrowingBean().isFetchNarrowingLoopCountEffective()) {
            return hasNext;
        }
        if (hasNext && _counter < getFetchNarrowingSkipStartIndex() + getFetchNarrowingLoopCount()) {
            ++_counter;
            return true;
        } else {
            if (_isInternalDebugEnabled) {
                if (_log.isDebugEnabled()) {
                    String msg = "    Finally the result of next() is false! Because counter is greater-equal";
                    msg = msg + " than 'fetch-start-index + real-fetch-size'.";
                    msg = msg + " " + _counter + " >= " + getFetchNarrowingSkipStartIndex() + " + " + getFetchNarrowingLoopCount();
                    _log.debug(msg);
                }
            }
            return false;
        }
    }

    /**
     * Get result set.
     * 
     * @return Result set.
     */
    protected ResultSet getResultSet() {
        return _resultSet;
    }

    /**
     * Get fetch-narrowing-bean.
     * 
     * @return FetchNarrowing-bean.
     */
    protected FetchNarrowingBean getFetchNarrowingBean() {
        return _cb;
    }

    /**
     * Get fetch-start-index from fetch-narrowing-bean.
     * 
     * @return Fetch-start-index.
     */
    protected int getFetchNarrowingSkipStartIndex() {
        return _cb.getFetchNarrowingSkipStartIndex();
    }

    /**
     * Get fetch-size from fetch-narrowing-bean.
     * 
     * @return Fetch-size.
     */
    protected int getFetchNarrowingLoopCount() {
        return _cb.getFetchNarrowingLoopCount();
    }

    /**
     * Is cursor used?
     * 
     * @return Determination.
     */
    protected boolean isCursorUsed() {
        return isCursorSupported(getResultSet());
    }

    /**
     * Is cursor supported?
     * 
     * @param resultSet ResultSet
     * @return Determation.
     */
    public static boolean isCursorSupported(ResultSet resultSet) {
        try {
            return !(resultSet.getType() == ResultSet.TYPE_FORWARD_ONLY);
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }
}
