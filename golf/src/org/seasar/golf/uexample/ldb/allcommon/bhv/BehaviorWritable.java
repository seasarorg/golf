package org.seasar.golf.uexample.ldb.allcommon.bhv;

import org.seasar.golf.uexample.ldb.allcommon.DaoWritable;
import org.seasar.golf.uexample.ldb.allcommon.Entity;

/**
 * The interface of behavior-writable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface BehaviorWritable extends BehaviorReadable {

    /**
     * Get dao-writable.
     * 
     * @return Dao-writable. (NotNull)
     */
    public DaoWritable getDaoWritable();

    /**
     * Create entity. (Delegate-Method)
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Inserted count.
     */
    public int callCreate(Entity entity);

    /**
     * Modify entity. (Delegate-Method)
     * {modified only}
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int callModify(Entity entity);

    /**
     * Remove entity. (Delegate-Method)
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Deleted count.
     */
    public int callRemove(Entity entity);

    /**
     * Create several entity-list. (Delegate-Method)
     * 
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return Inserted count.
     */
    public int callCreateList(java.util.List<Entity> entityList);

    /**
     * Modify several entity-list. (Delegate-Method)
     * 
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int callModifyList(java.util.List<Entity> entityList);

    /**
     * Remove several entity-list. (Delegate-Method)
     * 
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return Deleted count.
     */
    public int callRemoveList(java.util.List<Entity> entityList);

    // =====================================================================================
    //                                                                   Basic Entity Update
    //                                                                   ===================
    /**
     * Create.
     * 
     * @param entity Entity. (NotNull)
     */
    public void create(org.seasar.golf.uexample.ldb.allcommon.Entity entity);

    /**
     * Modify.
     * 
     * @param entity Entity. (NotNull)
     */
    public void modify(org.seasar.golf.uexample.ldb.allcommon.Entity entity);

    /**
     * Modify after select.
     * 
     * @param entity Entity.
     * @exception org.seasar.golf.uexample.ldb.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public void modifyAfterSelect(org.seasar.golf.uexample.ldb.allcommon.Entity entity);

    /**
     * Create or modify after select.
     * 
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     */
    public void createOrModifyAfterSelect(org.seasar.golf.uexample.ldb.allcommon.Entity entity);

    /**
     * Remove.
     * 
     * @param entity Entity. (NotNull)
     */
    public void remove(org.seasar.golf.uexample.ldb.allcommon.Entity entity);

    // =====================================================================================
    //                                                                    Basic Batch Update
    //                                                                    ==================
    /**
     * Create list.
     * 
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Created count.
     */
    public int createList(java.util.List<Entity> entityList);

    /**
     * Modify list.
     * 
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Modified count.
     */
    public int modifyList(java.util.List<Entity> entityList);

    /**
     * Remove list.
     * 
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Removed count.
     */
    public int removeList(java.util.List<Entity> entityList);

    // =====================================================================================
    //                                                                        Separated File
    //                                                                        ==============
    /**
     * Reflect(insert or update) from separated-file.
     * 
     * @param filename Name of the file. (NotNull and NotEmpty)
     * @param encoding Encoding of the file. (NotNull and NotEmpty)
     * @param delimiter Delimiter of the file. (NotNull and NotEmpty)
     * @param batchCount Batch-count for transaction.
     * @param isErrorContinue If true, this method continue in spite of throwing the exception.   
     * @return The list of InsertOrUpdateExceptionResult. (NotNull)
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public java.util.List<OneEntityExceptionResult> reflectFromSeparatedFile(
            String filename, String encoding,
            String delimiter, int batchCount, boolean isErrorContinue
            ) throws java.io.FileNotFoundException, java.io.IOException;

    /**
     * Exception result for one entity. 
     */
    public static class OneEntityExceptionResult {
        protected String _primaryKeyMapString;
        protected Entity _entity;
        protected Exception _exception;
        
        public String getPrimaryKeyMapString() {
            return _primaryKeyMapString;
        }
        public void setPrimaryKeyMapString(String value) {
            _primaryKeyMapString = value;
        }
        public Entity getEntity() {
            return _entity;
        }
        public void setEntity(Entity value) {
            _entity = value;
        }
        public Exception getException() {
            return _exception;
        }
        public void setException(Exception value) {
            _exception = value;
        }
    }
}
