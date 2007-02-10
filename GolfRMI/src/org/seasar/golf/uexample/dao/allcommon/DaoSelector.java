package org.seasar.golf.uexample.dao.allcommon;

import org.seasar.golf.uexample.dao.allcommon.bhv.BehaviorReadable;
import org.seasar.golf.uexample.dao.allcommon.bhv.BehaviorWritable;

/**
 * The interface of dao-selector.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface DaoSelector {

	/**
	 * Get dao-readable by dao type.
	 * 
	 * @param daoType Dao type. (NotNull)
	 * @return Dao-readable. (NotNull)
	 */
	public DaoReadable getRDao(Class daoType);

	/**
	 * Get dao-readable by entity.
	 * 
	 * @param entity Entity. (NotNull)
	 * @return Dao-readable. (NotNull)
	 */
	public DaoReadable getRDao(Entity entity);

    /**
     * Get dao-readable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Dao-readable. (NotNull)
     */
    public DaoReadable getRDao(String tableMultiName);

	/**
	 * Get dao-writable by dao type.
	 * 
	 * @param daoType Dao type. (NotNull)
	 * @return Dao-writable. (NotNull)
	 */
	public DaoWritable getWDao(Class daoType);

	/**
	 * Get dao-writable by entity.
	 * 
	 * @param entity Entity. (NotNull)
	 * @return Dao-writable. (NotNull)
	 */
	public DaoWritable getWDao(Entity entity);

    /**
     * Get dao-writable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Dao-writable. (NotNull)
     */
    public DaoWritable getWDao(String tableMultiName);

	/**
	 * Get bhv-readable by bhv type.
	 * 
	 * @param bhvType Bhv type. (NotNull)
	 * @return Bhv-readable. (NotNull)
	 */
	public BehaviorReadable getRBhv(Class bhvType);

	/**
	 * Get bhv-readable by entity.
	 * 
	 * @param entity Entity. (NotNull)
	 * @return Bhv-readable. (NotNull)
	 */
	public BehaviorReadable getRBhv(Entity entity);

    /**
     * Get bhv-readable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Bhv-readable. (NotNull)
     */
    public BehaviorReadable getRBhv(String tableMultiName);

	/**
	 * Get bhv-writable by bhv type.
	 * 
	 * @param bhvType Bhv type. (NotNull)
	 * @return Bhv-writable. (NotNull)
	 */
	public BehaviorWritable getWBhv(Class bhvType);

	/**
	 * Get bhv-writable by entity.
	 * 
	 * @param entity Entity. (NotNull)
	 * @return Bhv-writable. (NotNull)
	 */
	public BehaviorWritable getWBhv(Entity entity);

    /**
     * Get bhv-writable by table multi-name.
     * 
     * @param tableMultiName Table multi-name. (NotNull)
     * @return Bhv-writable. (NotNull)
     */
    public BehaviorWritable getWBhv(String tableMultiName);
}
