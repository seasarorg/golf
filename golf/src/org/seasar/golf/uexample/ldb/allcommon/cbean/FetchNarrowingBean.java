package org.seasar.golf.uexample.ldb.allcommon.cbean;

/**
 * The condition-bean as interface.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface FetchNarrowingBean {

    /**
     * Get fetch start index.
     * 
     * @return Fetch start index.
     */
    public int getFetchNarrowingSkipStartIndex();

    /**
     * Get fetch size.
     * 
     * @return Fetch size.
     */
    public int getFetchNarrowingLoopCount();

    /**
     * Is fetch start index supported?
     * 
     * @return Determination.
     */
    public boolean isFetchNarrowingSkipStartIndexEffective();

    /**
     * Is fetch size supported?
     * 
     * @return Determination.
     */
    public boolean isFetchNarrowingLoopCountEffective();

    /**
     * Is fetch-narrowing effective?
     * 
     * @return Determiantion.
     */
    public boolean isFetchNarrowingEffective();
}
