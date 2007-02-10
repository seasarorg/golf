package org.seasar.golf.uexample.dao.allcommon.exception;

/**
 * The exception when the record has overlapped.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class RecordHasOverlappedException extends RuntimeException {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     * 
     * @param msg Exception message.
     */
    public RecordHasOverlappedException(String msg) {
        super(msg);
    }
}
