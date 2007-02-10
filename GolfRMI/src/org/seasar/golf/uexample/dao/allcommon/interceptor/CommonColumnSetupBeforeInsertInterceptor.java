package org.seasar.golf.uexample.dao.allcommon.interceptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.seasar.golf.uexample.dao.allcommon.EntityDefinedCommonColumn;

/**
 * CommonColumn-Setup-before-Insert Interceptor.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class CommonColumnSetupBeforeInsertInterceptor extends CommonColumnSetupAbstractInterceptor {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(CommonColumnSetupBeforeInsertInterceptor.class);

    /**
     * Set up the entity.
     * 
     * @param entity Entity. (Nullable)
     */
    protected void setupEntity(EntityDefinedCommonColumn entity) {
        if (_log.isDebugEnabled()) {
            _log.debug("  before setup : " + entity.extractCommonColumnValueMapString());
        }

        if (_log.isDebugEnabled()) {
            _log.debug("  after setup  : " + entity.extractCommonColumnValueMapString());
        }
    }
}