package org.seasar.golf.uexample.dao.allcommon.dbmeta;


/**
 * The abstract class of dbmeta.
 * 
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractDBMeta implements DBMeta {

    // =====================================================================================
    //                                                                         Name Handling
    //                                                                         =============
    /**
     * This method implements the method that is declared at super.
     * 
     * @param dbName Db-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistDbName(String dbName) {
        return getDbNameCapPropNameMap().containsKey(dbName);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param capPropName Cap-prop-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistCapPropName(String capPropName) {
        return getCapPropNameDbNameMap().containsKey(capPropName);
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param uncapPropName Uncap-prop-name. (NotNull)
     * @return Determination.
     */
    public boolean isExistUncapPropName(String uncapPropName) {
        return getUncapPropNameDbNameMap().containsKey(uncapPropName);
    }

    /// <sumarry>
    /// This method implements the method that is declared at super.
    /// </sumarry>
    /// <param name="multiName">Multi-name.</param>
    /// <returns>Determination.</returns>
    public boolean isExistMultiName(String multiName) {
        if (isExistDbName(multiName)) {
            return true;
        }
        if (isExistCapPropName(multiName)) {
            return true;
        }
        if (isExistUncapPropName(multiName)) {
            return true;
        }
        return false;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param capPropName Cap-prop-name. (NotNull)
     * @return Db-name. (NotNull)
     */
    public String getDbNameByCapPropName(String capPropName) {
        assertStringNotNullAndNotTrimmedEmpty("capPropName", capPropName);
        final String dbName = (String)getCapPropNameDbNameMap().get(capPropName);
        if (dbName == null) {
            String msg = "The capPropNameDbNameMap didn't contain the key of '" + capPropName + "': ";
            throw new IllegalStateException(msg + getCapPropNameDbNameMap());
        }
        return dbName;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param uncapPropName Uncap-prop-name. (NotNull)
     * @return {db-name : java-name} map. (NotNull)
     */
    public String getDbNameByUncapPropName(String uncapPropName) {
        assertStringNotNullAndNotTrimmedEmpty("uncapPropName", uncapPropName);
        final String dbName = (String)getUncapPropNameDbNameMap().get(uncapPropName);
        if (dbName == null) {
            String msg = "The uncapPropNameDbNameMap didn't contain the key of '" + uncapPropName + "': ";
            throw new IllegalStateException(msg + getUncapPropNameDbNameMap());
        }
        return dbName;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param dbName Db-name. (NotNull)
     * @return Cap-prop-name. (NotNull)
     */
    public String getCapPropNameByDbName(String dbName) {
        assertStringNotNullAndNotTrimmedEmpty("dbName", dbName);
        final String capPropName = (String)getDbNameCapPropNameMap().get(dbName);
        if (capPropName == null) {
            String msg = "The dbNameCapPropNameMap didn't contain the key of '" + dbName + "': ";
            throw new IllegalStateException(msg + getDbNameCapPropNameMap());
        }
        return capPropName;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param uncapPropName Uncap-prop-name. (NotNull)
     * @return Cap-prop-name. (NotNull)
     */
    public String getCapPropNameByUncapPropName(String uncapPropName) {
        assertStringNotNullAndNotTrimmedEmpty("uncapPropName", uncapPropName);
        final String capPropName = (String)getDbNameUncapPropNameMap().get(uncapPropName);
        if (capPropName == null) {
            String msg = "The dbNameUncapPropNameMap didn't contain the key of '" + uncapPropName + "': ";
            throw new IllegalStateException(msg + getDbNameUncapPropNameMap());
        }
        return capPropName;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param dbName Db-name. (NotNull)
     * @return Uncap-prop-name. (NotNull)
     */
    public String getUncapPropNameByDbName(String dbName) {
        assertStringNotNullAndNotTrimmedEmpty("dbName", dbName);
        final String uncapPropName = (String)getDbNameUncapPropNameMap().get(dbName);
        if (uncapPropName == null) {
            String msg = "The dbNameUncapPropNameMap didn't contain the key of '" + dbName + "': ";
            throw new IllegalStateException(msg + getDbNameUncapPropNameMap());
        }
        return uncapPropName;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param capPropName Cap-prop-name. (NotNull)
     * @return Uncap-prop-name. (NotNull)
     */
    public String getUncapPropNameByCapPropName(String capPropName) {
        assertStringNotNullAndNotTrimmedEmpty("capPropName", capPropName);
        final String uncapPropName = (String)getDbNameUncapPropNameMap().get(capPropName);
        if (uncapPropName == null) {
            String msg = "The dbNameUncapPropNameMap didn't contain the key of '" + capPropName + "': ";
            throw new IllegalStateException(msg + getDbNameUncapPropNameMap());
        }
        return uncapPropName;
    }

    /**
     * This method implements the method that is declared at super.
     * 
     * @param multiName Multi-name. (NotNull)
     * @return Db-name. (NotNull)
     */
    public String getDbNameByMultiName(String multiName) {
        assertStringNotNullAndNotTrimmedEmpty("multiName", multiName);
        if (isExistDbName(multiName)) {
            return multiName;
        }
        if (isExistCapPropName(multiName)) {
            return getDbNameByCapPropName(multiName);
        }
        if (isExistUncapPropName(multiName)) {
            return getDbNameByUncapPropName(multiName);
        }
        String msg = "The multi-name is invalid: multiName=" + multiName;
        throw new IllegalStateException(msg);
    }

    /**
     * Get java-name by multi-name.
     * 
     * @param multiName Multi-name.
     * @return Cap-prop-name.
     */
    public String getCapPropNameByMultiName(String multiName) {
        assertStringNotNullAndNotTrimmedEmpty("multiName", multiName);
        if (isExistDbName(multiName)) {
            return getCapPropNameByDbName(multiName);
        }
        if (isExistCapPropName(multiName)) {
            return multiName;
        }
        if (isExistUncapPropName(multiName)) {
            return getCapPropNameByUncapPropName(multiName);
        }
        String msg = "The multi-name is invalid: multiName=" + multiName;
        throw new IllegalStateException(msg);
    }

    /**
     * Get property-name by multi-name.
     * 
     * @param multiName Multi-name.
     * @return Uncap-prop-name.
     */
    public String getUncapPropNameByMultiName(String multiName) {
        assertStringNotNullAndNotTrimmedEmpty("multiName", multiName);
        if (isExistDbName(multiName)) {
            return getUncapPropNameByDbName(multiName);
        }
        if (isExistCapPropName(multiName)) {
            return getUncapPropNameByCapPropName(multiName);
        }
        if (isExistUncapPropName(multiName)) {
            return multiName;
        }
        String msg = "The multi-name is invalid: multiName=" + multiName;
        throw new IllegalStateException(msg);
    }

    // ----------------------------------------------------------------
    //                                                    Assert Object
    //                                                    -------------
    /**
     * Assert that the argument is not null.
     * 
     * @param variableName Variable name. (NotNull)
     * @param arg Argument. (NotNull)
     */
    protected void assertObjectNotNull(String variableName, Object arg) {
        if (variableName == null) {
            String msg = "Argument[variableName] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (arg == null) {
            String msg = "Argument[" + variableName + "] should not be null.";
            throw new IllegalArgumentException(msg);
        }
    }

    // ----------------------------------------------------------------
    //                                                    Assert String
    //                                                    -------------
    /**
     * Assert that the string is not null and not trimmed empty.
     * 
     * @param variableName Variable name. (NotNull)
     * @param value Value. (NotNull)
     */
    protected void assertStringNotNullAndNotTrimmedEmpty(String variableName, String value) {
        if (variableName == null) {
            String msg = "Variable[variableName] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (value == null) {
            String msg = "Variable[" + variableName + "] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (value.trim().length() == 0) {
            String msg = "Variable[" + variableName + "] should not be empty: [" + value + "]";
            throw new IllegalArgumentException(msg);
        }
    }
}
