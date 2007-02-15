package org.seasar.golf.uexample.dao.allcommon;


/**
 * The sigleton class that has generate-meta-data(GenMetaData).
 * 
 * @author DBFlute(AutoGenerator)
 */
public class GenMetaData {

    /** Singleton instance. */
    private static final GenMetaData _instance = new GenMetaData();

    /**
     * Constructor.
     */
    private GenMetaData() {
    }

    /**
     * Get instance.
     *
     * @return Singleton instance.
     */
    public static GenMetaData getInstance() {
        return _instance;
    }

    // =========================================================================================
    //                                                                     Generated method name
    //                                                                     =====================
    /**
     * Get the method name of 'getCountAll'.
     *
     * @return The method name of 'getCountAll'. (NotNull)
     */
    public String getMethodNameOfGetCountAll() {
        return "getCountAll";
    }

    /**
     * Get the method name of 'getListAll'.
     *
     * @return The method name of 'getListAll'. (NotNull)
     */
    public String getMethodNameOfGetListAll() {
        return "getListAll";
    }

    /**
     * Get the method name of 'getEntity'.
     *
     * @return The method name of 'getEntity'. (NotNull)
     */
    public String getMethodNameOfGetEntity() {
        return "getEntity";
    }

    /**
     * Get the method name of 'selectCountIgnoreFetchNarrowing'.
     *
     * @return The method name of 'selectCountIgnoreFetchNarrowing'. (NotNull)
     */
    public String getMethodNameOfSelectCountIgnoreFetchScope() {
        return "selectCountIgnoreFetchScope";
    }

    /**
     * Get the method name of 'selectEntity'.
     *
     * @return The method name of 'selectEntity'. (NotNull)
     */
    public String getMethodNameOfSelectEntity() {
        return "selectEntity";
    }

    /**
     * Get the method name of 'selectList'.
     *
     * @return The method name of 'selectList'. (NotNull)
     */
    public String getMethodNameOfSelectList() {
        return "selectList";
    }

    // =========================================================================================
    //                                             Only when having generated, the effective one
    //                                             =============================================
    // -------------------------------------------------------------------------------
    //                                                                           Basic
    //                                                                           -----
    /**
     * Get the property-value of targetLanguage.
     *
     * @return The property-value.
     */
    public String getTargetLanguage() {
        return "java";
    }

    /**
     * Get the property-value of templateFileExtension.
     *
     * @return The property-value.
     */
    public String getTemplateFileExtension() {
        return "vm";
    }

    /**
     * Get the property-value of classFileExtension.
     *
     * @return The property-value.
     */
    public String getClassFileExtension() {
        return "java";
    }

    /**
     * Get the property-value of templateFileEncoding.
     *
     * @return The property-value.
     */
    public String getTemplateEncoding() {
        return "UTF-8";
    }

    /**
     * Get the property-value of classAuthor.
     *
     * @return The property-value.
     */
    public String getClassAuthor() {
        return "DBFlute(AutoGenerator)";
    }

    // -------------------------------------------------------------------------------
    //                                                                       Available
    //                                                                       ---------
    /**
     * Is java name of table same as db name? Answer is false!
     *
     * @return The property-value.
     */
    public boolean isJavaNameOfTableSameAsDbName() {
        return false;
    }

    /**
     * Is java name of column same as db name? Answer is false!
     *
     * @return The property-value.
     */
    public boolean isJavaNameOfColumnSameAsDbName() {
        return false;
    }

    /**
     * Is available behavior generation? Answer is true!
     *
     * @return The property-value.
     */
    public boolean isAvailableBehaviorGeneration() {
        return true;
    }

    /**
     * Is available common-column-setup interceptor to behavior? Answer is false!
     *
     * @return The property-value.
     */
    public boolean isAvailableCommonColumnSetupInterceptorToBehavior() {
        return false;
    }

    /**
     * Is available common-column-setup interceptor to dao? Answer is false!
     *
     * @return The property-value.
     */
    public boolean isAvailableCommonColumnSetupInterceptorToDao() {
        return false;
    }

    /**
     * Is available generics? Answer is true!
     *
     * @return The property-value.
     */
    public boolean isAvailableGenerics() {
        return true;
    }

    // -------------------------------------------------------------------------------
    //                                                                          Prefix
    //                                                                          ------
    /**
     * Get the property-value of projectPrefix.
     *
     * @return The property-value.
     */
    public String getProjectPrefix() {
        return "";
    }

    /**
     * Get the property-value of basePrefix.
     *
     * @return The property-value.
     */
    public String getBasePrefix() {
        return "Bs";
    }

    // -------------------------------------------------------------------------------
    //                                                                        DaoDicon
    //                                                                        --------
    /**
     * Get the property-value of daoDiconNamespace.
     *
     * @return The property-value.
     */
    public String getDaoDiconNamespace() {
        return "dbflute";
    }

    /**
     * Get the property-value of daoDiconPackageName.
     *
     * @return The property-value.
     */
    public String getDaoDiconPackageName() {
        return "";
    }

    /**
     * Get the property-value of daoDiconFileName.
     *
     * @return The property-value.
     */
    public String getDaoDiconFileName() {
        return "dbflute.dicon";
    }

    /**
     * Get the property-value of jdbcDiconResourceName.
     *
     * @return The property-value.
     */
    public String getJdbcDiconResourceName() {
        return "j2ee.dicon";
    }

    /**
     * Get the property-value of requiredTxComponentName.
     *
     * @return The property-value.
     */
    public String getRequiredTxComponentName() {
        return "requiredTx";
    }

    // -------------------------------------------------------------------------------
    //                                                                         Package
    //                                                                         -------
    /**
     * Get the property-value of baseCommonPackage.
     *
     * @return The property-value.
     */
    public String getBaseCommonPackage() {
        return "org.seasar.golf.uexample.dao.allcommon";
    }

    /**
     * Get the property-value of baseBehaviorPackage.
     *
     * @return The property-value.
     */
    public String getBaseBehaviorPackage() {
        return "org.seasar.golf.uexample.dao.bsbhv";
    }

    /**
     * Get the property-value of baseDaoPackage.
     *
     * @return The property-value.
     */
    public String getBaseDaoPackage() {
        return "org.seasar.golf.uexample.dao.bsdao";
    }

    /**
     * Get the property-value of baseEntityPackage.
     *
     * @return The property-value.
     */
    public String getBaseEntityPackage() {
        return "org.seasar.golf.uexample.dao.bsentity";
    }

    /**
     * Get the property-value of conditionBeanPackage.
     *
     * @return The property-value.
     */
    public String getConditionBeanPackage() {
        return "org.seasar.golf.uexample.dao.cbean";
    }

    /**
     * Get the property-value of extendedDaoPackage.
     *
     * @return The property-value.
     */
    public String getExtendedDaoPackage() {
        return "org.seasar.golf.uexample.dao.exdao";
    }

    /**
     * Get the property-value of extendedBehaviorPackage.
     *
     * @return The property-value.
     */
    public String getExtendedBehaviorPackage() {
        return "org.seasar.golf.uexample.dao.exbhv";
    }

    /**
     * Get the property-value of extendedEntityPackage.
     *
     * @return The property-value.
     */
    public String getExtendedEntityPackage() {
        return "org.seasar.golf.uexample.dao.exentity";
    }

    // -------------------------------------------------------------------------------
    //                                                                 Optimistic Lock
    //                                                                 ---------------
    /**
     * Get the property-value of updateDateFieldName.
     *
     * @return The property-value.
     */
    public String getUpdateDateFieldName() {
        return "";
    }

    /**
     * Get the property-value of versionNoFieldName.
     *
     * @return The property-value.
     */
    public String getVersionNoFieldName() {
        return "versionno";
    }

    // -------------------------------------------------------------------------------
    //                                                                    Select Param
    //                                                                    ------------
    /**
     * Get the property-value of selectQueryTimeout.
     *
     * @return The property-value.
     */
    public int getSelectQueryTimeout() {
        return -1;
    }

    // -------------------------------------------------------------------------------
    //                                                                         Extract
    //                                                                         -------
    /**
     * Get the value of 'extractAcceptStartBrace'.
     *
     * @return The property-value. (NotNull)
     */
    public String getExtractAcceptStartBrace() {
        return "@{";
    }

    /**
     * Get the value of 'extractAcceptEndBrace'.
     *
     * @return The property-value. (NotNull)
     */
    public String getExtractAcceptEndBrace() {
        return "@}";
    }

    /**
     * Get the value of 'extractAcceptDelimiter'.
     *
     * @return The property-value. (NotNull)
     */
    public String getExtractAcceptDelimiter() {
        return "@;";
    }

    /**
     * Get the value of 'extractAcceptEqual'.
     *
     * @return The property-value. (NotNull)
     */
    public String getExtractAcceptEqual() {
        return "@=";
    }
}
