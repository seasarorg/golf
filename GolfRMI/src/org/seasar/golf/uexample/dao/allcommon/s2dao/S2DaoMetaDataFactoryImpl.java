package org.seasar.golf.uexample.dao.allcommon.s2dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.sql.DataSource;

import org.seasar.dao.AnnotationReaderFactory;
import org.seasar.dao.BeanEnhancer;
import org.seasar.dao.impl.DaoMetaDataFactoryImpl;
import org.seasar.dao.impl.DaoMetaDataImpl;
import org.seasar.extension.jdbc.ResultSetFactory;
import org.seasar.extension.jdbc.StatementFactory;

import org.seasar.dao.Dbms;
import org.seasar.dao.dbms.DbmsManager;
import org.seasar.extension.jdbc.util.ConnectionUtil;
import org.seasar.extension.jdbc.util.DataSourceUtil;

import org.seasar.golf.uexample.dao.allcommon.cbean.ConditionBeanContext;

/**
 * DaoMetaDataFactoryImpl for DBFlute.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class S2DaoMetaDataFactoryImpl extends DaoMetaDataFactoryImpl {

    /**
     * Constructor.
     * 
     * @param dataSource Data source.
     * @param statementFactory Statement factory.
     * @param resultSetFactory Result set factory.
     * @param readerFactory Annotation reader factory.
     */
    public S2DaoMetaDataFactoryImpl(DataSource dataSource,
            StatementFactory statementFactory,
            ResultSetFactory resultSetFactory,
            AnnotationReaderFactory readerFactory) {
        super(dataSource, statementFactory, resultSetFactory, readerFactory);

        initializeDatabaseProductNameOfContext(dataSource);
    }

    protected void initializeDatabaseProductNameOfContext(DataSource dataSource) {
        if (getDatabaseProductNameFromContext() != null) {
            return;
        }
        final Connection con = DataSourceUtil.getConnection(dataSource);
        String suffix = null;
        try {
            final DatabaseMetaData dbMetaData = ConnectionUtil.getMetaData(con);
            final Dbms dbms = DbmsManager.getDbms(dbMetaData);
            suffix = dbms.getSuffix();
        } finally {
            ConnectionUtil.close(con);
        }
        if (suffix == null) {
            setDatabaseProductNameToContext("PostgreSql");
            return;
        }
        suffix = suffix.startsWith("_") ? suffix.substring("_".length()) : suffix;
        setDatabaseProductNameToContext(suffix);
    }

    protected String getDatabaseProductNameFromContext() {
        return ConditionBeanContext.getDatabaseProductName();
    }

    protected void setDatabaseProductNameToContext(String name) {
        ConditionBeanContext.setDatabaseProductName(name);
    }


    protected BeanEnhancer beanEnhancer;

    public BeanEnhancer getBeanEnhancer() {
        return beanEnhancer;
    }

    public void setBeanEnhancer(final BeanEnhancer beanEnhancer) {
        this.beanEnhancer = beanEnhancer;
    }

    protected DaoMetaDataImpl createDaoMetaDataImpl() {
        S2DaoMetaDataExtension dmdExtension = new S2DaoMetaDataExtension();
        dmdExtension.setBeanEnhancer(this.beanEnhancer);
        return dmdExtension;
    }

}