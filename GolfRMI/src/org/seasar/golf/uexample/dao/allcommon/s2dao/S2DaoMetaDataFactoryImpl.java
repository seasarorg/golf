package org.seasar.golf.uexample.dao.allcommon.s2dao;

import javax.sql.DataSource;

import org.seasar.dao.AnnotationReaderFactory;
import org.seasar.dao.BeanEnhancer;
import org.seasar.dao.impl.DaoMetaDataFactoryImpl;
import org.seasar.dao.impl.DaoMetaDataImpl;
import org.seasar.extension.jdbc.ResultSetFactory;
import org.seasar.extension.jdbc.StatementFactory;

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