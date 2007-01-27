
package org.seasar.golf.uexample.ldb.allcommon.bhv;

import org.seasar.golf.uexample.ldb.allcommon.Entity;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.ldb.allcommon.helper.MapStringBuilder;
import org.seasar.golf.uexample.ldb.allcommon.helper.MapStringBuilderImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The abstract class of behavior-writable.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBehaviorWritable extends AbstractBehaviorReadable implements BehaviorWritable {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(AbstractBehaviorWritable.class);

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public AbstractBehaviorWritable() {
    }

    // =====================================================================================
    //                                                                       Delegate Method
    //                                                                       ===============
    /**
     * This method implements the method that is declared at super.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Inserted count.
     */
    public int callCreate(Entity entity) {
        assertEntityNotNull(entity);// If this table use identity, the entity does not have primary-key.
        filterEntityOfInsert(entity);
        assertEntityOfInsert(entity);
        return getDaoWritable().create(entity);
    }

    /**
     * This method implements the method that is declared at super.
     * {modified only}
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int callModify(Entity entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        filterEntityOfUpdate(entity);
        assertEntityOfUpdate(entity);
        return getDaoWritable().modifyModifiedOnly(entity);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     * @return Deleted count.
     */
    public int callRemove(Entity entity) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        filterEntityOfDelete(entity);
        assertEntityOfDelete(entity);
        return getDaoWritable().remove(entity);
    }

    /**
     * Filter the entity of insert.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     */
    protected void filterEntityOfInsert(Entity entity) {
    }

    /**
     * Assert the entity of insert.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     */
    protected void assertEntityOfInsert(Entity entity) {
    }

    /**
     * Filter the entity of update.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     */
    protected void filterEntityOfUpdate(Entity entity) {
    }

    /**
     * Assert the entity of update.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     */
    protected void assertEntityOfUpdate(Entity entity) {
    }


    /**
     * Filter the entity of delete.
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     */
    protected void filterEntityOfDelete(Entity entity) {
    }

    /**
     * Assert the entity of delete
     * 
     * @param entity Entity that the type is entity-interface. (NotNull)
     */
    protected void assertEntityOfDelete(Entity entity) {
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return Inserted count.
     */
    public int callCreateList(java.util.List<Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        for (final java.util.Iterator ite = entityList.iterator(); ite.hasNext(); ) {
            final Entity entity = (Entity)ite.next();
            filterEntityOfInsert(entity);
            assertEntityOfInsert(entity);
        }
        return getDaoWritable().createList(entityList);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return Updated count.
     */
    public int callModifyList(java.util.List<Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        for (final java.util.Iterator ite = entityList.iterator(); ite.hasNext(); ) {
            final Entity entity = (Entity)ite.next();
            filterEntityOfUpdate(entity);
            assertEntityOfUpdate(entity);
        }
        return getDaoWritable().modifyList(entityList);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param entityList Entity-list that the type is entity-interface. (NotNull)
     * @return Deleted count.
     */
    public int callRemoveList(java.util.List<Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        for (final java.util.Iterator ite = entityList.iterator(); ite.hasNext(); ) {
            final Entity entity = (Entity)ite.next();
            filterEntityOfDelete(entity);
            assertEntityOfDelete(entity);
        }
        return getDaoWritable().removeList(entityList);
    }

    // =====================================================================================
    //                                                                   Basic Entity Update
    //                                                                   ===================
    /**
     * Create.
     * 
     * @param entity Entity. (NotNull)
     */
    public void create(Entity entity) {
        doCreate(entity);
    }

    abstract protected void doCreate(Entity entity);

    /**
     * Modify.
     * 
     * @param entity Entity. (NotNull)
     */
    public void modify(Entity entity) {
        doModify(entity);
    }

    abstract protected void doModify(Entity entity);

    /**
     * This method implements the method that is declared at super.
     * 
     * @param entity Entity having primary-key value. (NotNull)
     * @exception org.seasar.golf.uexample.ldb.allcommon.exception.RecordHasAlreadyBeenDeletedException
     */
    public void modifyAfterSelect(Entity entity) {
        doModifyAfterSelect(entity);
    }

    abstract protected void doModifyAfterSelect(Entity entity);

    /**
     * Create or modify after select.
     * {modify: modified only}
     * 
     * @param entity Entity. This must contain primary-key value at least(Except use identity). (NotNull)
     */
    public void createOrModifyAfterSelect(org.seasar.golf.uexample.ldb.allcommon.Entity entity) {
        assertEntityNotNull(entity);
        if (!entity.hasPrimaryKeyValue()) {
            create(entity);
            return;
        }
        org.seasar.golf.uexample.ldb.allcommon.Entity currentEntity = null;
        try {
            final ConditionBean cb = newConditionBean();
            cb.acceptPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
            currentEntity = readEntityWithDeletedCheck(cb);
        } catch (org.seasar.golf.uexample.ldb.allcommon.exception.RecordHasAlreadyBeenDeletedException e) {
            create(entity);
            return;
        }
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        mergeEntity(entity, currentEntity);
        modify(entity);
    }

    abstract protected void doCreateOrModifyAfterSelect(Entity entity);

    /**
     * Merge entity.
     * Copy the column data of sourceEntity that the setter has been invoked to destinationEntity.
     * 
     * @param sourceEntity Source entity. (NotNull)
     * @param destinationEntity Destination entity. (NotNull)
     */
    abstract protected void mergeEntity(Entity sourceEntity, Entity destinationEntity);

    /**
     * Remove.
     * 
     * @param entity Entity. (NotNull)
     * @return Removed count.
     */
    public void remove(org.seasar.golf.uexample.ldb.allcommon.Entity entity) {
        assertEntityNotNull(entity);
        callRemove(entity);
    }

    abstract protected void doRemove(Entity entity);

    // =====================================================================================
    //                                                                    Basic Batch Update
    //                                                                    ==================
    /**
     * Create list.
     * 
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Created count.
     */
    public int createList(java.util.List<Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return callCreateList(entityList);
    }

    /**
     * Modify list.
     * 
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Modified count.
     */
    public int modifyList(java.util.List<Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return callModifyList(entityList);
    }

    /**
     * Remove list.
     * 
     * @param entityList Entity-list. (NotNull and NotEmpty)
     * @return Removed count.
     */
    public int removeList(java.util.List<Entity> entityList) {
        assertListNotNullAndNotEmpty(entityList);
        return callRemoveList(entityList);
    }

    // =====================================================================================
    //                                                                        Separated File
    //                                                                        ==============

    /**
     * Reflect(insert or update) from separated-file.
     * 
     * @param filename Name of the file. (NotNull and NotEmpty)
     * @param encoding Encoding of the file. (NotNull and NotEmpty)
     * @param delimiter Delimiter of the file. (NotNull and NotEmpty)
     * @param batchCount Batch-count for transaction. If this value is 0, all records are done in one transaction.
     * @param isErrorContinue If true, this method continue in spite of throwing the exception.   
     * @return The list of InsertOrUpdateExceptionResult. (NotNull)
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public java.util.List<OneEntityExceptionResult> reflectFromSeparatedFile(
            String filename, String encoding,
            String delimiter, int batchCount, boolean isErrorContinue
            ) throws java.io.FileNotFoundException, java.io.IOException {
        assertStringNotNullAndNotTrimmedEmpty("filename", filename);
        assertStringNotNullAndNotTrimmedEmpty("encoding", encoding);
        assertObjectNotNull("delimiter", delimiter);
        final java.util.List<OneEntityExceptionResult> exceptionList = new java.util.ArrayList<OneEntityExceptionResult>();

        java.io.FileInputStream fis = null;
        java.io.InputStreamReader ir = null;
        java.io.BufferedReader br = null;
        try {
            fis = new java.io.FileInputStream(filename);
            ir = new java.io.InputStreamReader(fis, encoding);
            br = new java.io.BufferedReader(ir);

            final MapStringBuilder builder = new MapStringBuilderImpl();
            builder.setMsMapMark(MAP_STRING_MAP_MARK);
            builder.setMsStartBrace(MAP_STRING_START_BRACE);
            builder.setMsEndBrace(MAP_STRING_END_BRACE);
            builder.setMsDelimiter(MAP_STRING_DELIMITER);
            builder.setMsEqual(MAP_STRING_EQUAL);
            final java.util.List<Entity> entityList = new java.util.ArrayList<Entity>();
            int count = 0;
            while (true) {
                ++count;

                final String lineString = br.readLine();
                if (lineString == null) {
                    if (entityList.size() > 0) {
                        final java.util.List<OneEntityExceptionResult> tmpList = reflectAfterSelectNewTx(entityList, isErrorContinue);
                        exceptionList.addAll(tmpList);
                        entityList.clear();
                    }
                    break;
                }
                if (count == 1) {
                    builder.setColumnNames(lineString.split(delimiter));
                    continue;
                }

                final String mapString = builder.buildByDelimiter(lineString, delimiter);
                final Entity entity = getDBMeta().newEntity();
                entity.acceptColumnValueMapString(mapString);
                entityList.add(entity);

                if (entityList.size() == batchCount) {
                    final java.util.List<OneEntityExceptionResult> tmpList = reflectAfterSelectNewTx(entityList, isErrorContinue);
                    exceptionList.addAll(tmpList);
                    entityList.clear();
                }
            }
        } catch (java.io.FileNotFoundException e) {
            throw e;
        } catch (java.io.IOException e) {
            throw e;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ir != null) {
                    ir.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (java.io.IOException ignored) {
                _log.warn("File-close threw the exception: ", ignored);
            }
        }
        return exceptionList;
    }

    /**
     * Reflect(insert or update) from separated-file.
     * 
     * @param entityList The list of entity that is reflection target. (NotNull)
     * @param isErrorContinue If true, this method continue in spite of throwing the exception.
     * @return The list of InsertOrUpdateExceptionResult. (NotNull)
     */
    public java.util.List<OneEntityExceptionResult> reflectAfterSelectNewTx(java.util.List<Entity> entityList,
            boolean isErrorContinue) {
        final java.util.List<OneEntityExceptionResult> exceptionList = new java.util.ArrayList<OneEntityExceptionResult>();
        for (final java.util.Iterator ite = entityList.iterator(); ite.hasNext(); ) {
            final Entity entity = (Entity)ite.next();
            try {
                createOrModifyAfterSelect(entity);
            } catch (RuntimeException e) {
                if (isErrorContinue) {
                    final OneEntityExceptionResult result = new OneEntityExceptionResult();
                    result.setPrimaryKeyMapString(entity.extractPrimaryKeyMapString());
                    result.setEntity(entity);
                    result.setException(e);
                    exceptionList.add(result);
                    continue;
                }
                throw e;
            }
        }
        return exceptionList;
    }
}
