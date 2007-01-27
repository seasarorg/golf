
package org.seasar.golf.uexample.ldb.allcommon.s2dao;

import java.lang.reflect.Method;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.seasar.dao.BeanEnhancer;
import org.seasar.dao.BeanMetaData;
import org.seasar.dao.BeanMetaDataFactory;
import org.seasar.dao.Dbms;
import org.seasar.dao.RelationPropertyType;
import org.seasar.dao.RelationRowCreator;
import org.seasar.dao.ResultSetHandlerFactory;
import org.seasar.dao.impl.BeanMetaDataFactoryImpl;
import org.seasar.dao.impl.BeanMetaDataImpl;
import org.seasar.dao.impl.DaoMetaDataImpl;
import org.seasar.dao.impl.RelationRowCreatorImpl;
import org.seasar.dao.impl.SelectDynamicCommand;
import org.seasar.extension.jdbc.PropertyType;
import org.seasar.extension.jdbc.ResultSetHandler;
import org.seasar.extension.jdbc.types.ValueTypes;
import org.seasar.framework.beans.BeanDesc;
import org.seasar.framework.beans.PropertyDesc;
import org.seasar.framework.util.StringUtil;

import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBeanContext;

/**
 * DaoMetaDataImpl for DaoGen.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class S2DaoMetaDataExtension extends DaoMetaDataImpl {

    /**
     * Constructor.
     */
    public S2DaoMetaDataExtension() {
    }

    protected BeanEnhancer beanEnhancer;

    public BeanEnhancer getBeanEnhancer() {
        return beanEnhancer;
    }

    public void setBeanEnhancer(final BeanEnhancer beanEnhancer) {
        this.beanEnhancer = beanEnhancer;
    }

    // =====================================================================================
    //                                                      ResultSetHandlerFactory Override
    //                                                      ================================

    protected ResultSetHandlerFactory createResultSetHandlerFactory(final BeanMetaData beanMetaData) {
        return new ResultSetHandlerFactoryExtension(beanMetaData);
    }

    // =====================================================================================
    //                                                                ConditionBean Override
    //                                                                ======================

    protected SelectDynamicCommand setupNonQuerySelectMethodByDto(Method method, ResultSetHandler handler, String[] argNames, String query) {
        Class[] types = method.getParameterTypes();
        Class clazz = types[0];
        if (!ConditionBeanContext.isTheTypeConditionBean(clazz)) {
            return super.setupNonQuerySelectMethodByDto(method, handler, argNames, query);
        }
        // /----------------------------------------------------- [MyExtension]
        argNames = new String[] { "dto" };
        final String sqlNormal = getSelectClause(getBeanMetaData());
        final String sqlPKOnly = getSelectClausePKOnly(getBeanMetaData());
        final S2DaoSelectDynamicCommand dynamicCommand = newMySelectDynamicCommand(handler);
        String sql = sqlNormal;
        final SelectDynamicCommand cmd = dynamicCommand;
        dynamicCommand.setSelectClause(sqlNormal);
        dynamicCommand.setSelectClausePKOnly(sqlPKOnly);
        // -----------/
        if (query != null) {
            sql = sql + " " + query;
        }
        cmd.setSql(sql);
        cmd.setArgNames(argNames);
        cmd.setArgTypes(types);
        return cmd;
    }

    /**
     * Get select clause.
     * 
     * @param beanMetaData BeanMetaData. (NotNull)
     * @return Select clause. (NotNull)
     */
    protected String getSelectClause(BeanMetaData beanMetaData) {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("select/*$dto.selectHint*/ ");

        final StringBuffer sbMySelectList = new StringBuffer(100);
        for (int i = 0; i < beanMetaData.getPropertyTypeSize(); ++i) {
            final PropertyType pt = beanMetaData.getPropertyType(i);
            if (pt.isPersistent()) {
                if (sbMySelectList.length() != 0) {
                    sbMySelectList.append(", ");
                }
                sbMySelectList.append(beanMetaData.getTableName());
                sbMySelectList.append(".");
                sbMySelectList.append(pt.getColumnName());
            }
        }
        sb.append(sbMySelectList);

        setupRelationSelectClause(sb, beanMetaData, "", "", 1);
        return sb.toString();
    }

    protected void setupRelationSelectClause(StringBuffer sb, BeanMetaData baseBmd, String judgeProp, String preNoSuffix, int cqNestNo) {
        for (int i = 0; i < baseBmd.getRelationPropertyTypeSize(); ++i) {
            final StringBuffer sbYourSelectList = new StringBuffer(100);
            final RelationPropertyType rpt = baseBmd.getRelationPropertyType(i);
            if (rpt == null) {
                String msg = "The baseBmd.GetRelationPropertyType(" + i + ") returned null";
                msg = msg + ": baseBmd.getTableName()=" + baseBmd.getTableName();
                msg = msg + ": baseBmd.getRelationPropertyTypeSize()=" + baseBmd.getRelationPropertyTypeSize();
                throw new IllegalStateException(msg);
            }

            final BeanMetaData relationBmd = rpt.getBeanMetaData();
            final String initCapPropertyName = StringUtil.capitalize(rpt.getPropertyName());
            final String ifComment = "/*IF dto." + judgeProp + "isSelect" + initCapPropertyName + "()*/";
            final String endComment = "/*END*/";
            for (int j = 0; j < relationBmd.getPropertyTypeSize(); ++j) {
                final PropertyType pt = relationBmd.getPropertyType(j);
                final String tableAliasName = StringUtil.capitalize(rpt.getPropertyName()) + (cqNestNo > 1 ? "_n" + cqNestNo : "");
                if (pt.isPersistent()) {
                    final String columnName = pt.getColumnName();
                    sbYourSelectList.append(", ");
                    sbYourSelectList.append(tableAliasName).append(".").append(columnName);
                    sbYourSelectList.append(" AS ");
                    sbYourSelectList.append(pt.getColumnName()).append(preNoSuffix).append("_").append(rpt.getRelationNo());
                }
            }
            if (relationBmd.getRelationPropertyTypeSize() > 0) {
                final String nssString = "nss" + initCapPropertyName + ".";
                final String nextPreNoSuffix = preNoSuffix + "_" + rpt.getRelationNo();
                final int nextCQNestNo = cqNestNo + 1;
                setupRelationSelectClause(sbYourSelectList, relationBmd, nssString, nextPreNoSuffix, nextCQNestNo);
            }
            sb.append(ifComment).append(sbYourSelectList).append(endComment);
        }
    }

    /**
     * Get select clause PK only.
     * 
     * @param beanMetaData BeanMetaData. (NotNull)
     * @return Select clause PK only. (NotNull)
     */
    protected String getSelectClausePKOnly(BeanMetaData beanMetaData) {
        final StringBuffer sb = new StringBuffer(100);
        sb.append("select/*$dto.selectHint*/ ");

        final StringBuffer sbMySelectList = new StringBuffer(100);
        for (int i = 0; i < beanMetaData.getPropertyTypeSize(); ++i) {
            final PropertyType pt = beanMetaData.getPropertyType(i);
            if (pt.isPersistent() && pt.isPrimaryKey()) {
                if (sbMySelectList.length() != 0) {
                    sbMySelectList.append(", ");
                }
                sbMySelectList.append(beanMetaData.getTableName());
                sbMySelectList.append(".");
                sbMySelectList.append(pt.getColumnName());
            }
        }
        sb.append(sbMySelectList);

        return sb.toString();
    }

    /**
     * New my select dynamic command.
     * 
     * @param handler ResultSetHandler
     * @return My select dynamic command. (NotNull)
     */
    protected S2DaoSelectDynamicCommand newMySelectDynamicCommand(ResultSetHandler handler) {
        return new S2DaoSelectDynamicCommand(dataSource, statementFactory, handler, resultSetFactory);
    }

    // =====================================================================================
    //                                                                     ByManual Override
    //                                                                     =================
    protected void setupSelectMethodByManual(Method method, String sql) {
        final BeanMetaData beanMetaData = buildBeanMetaData(method, this.dataSource);
        final ResultSetHandlerFactory factory = new ResultSetHandlerFactoryExtension(beanMetaData);
        SelectDynamicCommand cmd = createSelectDynamicCommand(factory.createResultSetHandler(method));
        cmd.setSql(sql);
        cmd.setArgNames(this.annotationReader.getArgNames(method));
        cmd.setArgTypes(method.getParameterTypes());
        this.sqlCommands.put(method.getName(), cmd);
    }

    protected BeanMetaData buildBeanMetaData(Method method, DataSource ds) {
        final Class beanClass4SelectMethodByManual = getOriginalBeanClass(method);
        if (beanClass4SelectMethodByManual.equals(getBeanClass())) {
            return getBeanMetaData();
        }
        return createOriginalBmdFactory().createBeanMetaData(getOriginalBeanClass(method));
    }

    protected BeanMetaDataFactory createOriginalBmdFactory() {
        final S2BeanMetaDataFactoryImpl originalBmdFactory = new S2BeanMetaDataFactoryImpl() {
            protected BeanMetaDataImpl createBeanMetaDataImpl() {
                return new BeanMetaDataImpl() {
                    protected void setupDatabaseMetaData(BeanDesc beanDesc, DatabaseMetaData dbMetaData, Dbms dbms) {
                        // Nothing.
                    }
                };
            }
        };
        originalBmdFactory.setAnnotationReaderFactory(this.annotationReaderFactory);
        originalBmdFactory.setValueTypeFactory(this.valueTypeFactory);
        originalBmdFactory.setDataSource(this.dataSource);
        originalBmdFactory.setDaoNamingConvention(this.daoNamingConvention);
        originalBmdFactory.setBeanEnhancer(this.beanEnhancer);
        return originalBmdFactory;
    }

    protected Class getOriginalBeanClass(Method method) {
        final Class retType = method.getReturnType();
        if (java.util.List.class.isAssignableFrom(retType)) {
            final Class elementType = MethodUtil.getElementTypeOfListFromReturnMethod(method);
            if (elementType != null) {
                return elementType;
            } else {
                return getBeanClass();
            }
        } else if (retType.isArray()) {
            return retType.getComponentType();
        } else if (retType.isPrimitive() || !ValueTypes.getValueType(retType).equals(ValueTypes.OBJECT)) {
            return getBeanClass();
        } else {
            return retType;
        }
    }
    
    protected static class MethodUtil {
        public static Class getElementTypeOfListFromReturnMethod(Method method) {
            return ReflectionUtil.getElementTypeOfListFromReturnType(method);
        }
    }

    protected static class ReflectionUtil {
        public static Class<?> getElementTypeOfList(final Type parameterizedList) {
            if (!(parameterizedList instanceof ParameterizedType)) {
                return null;
            }

            final ParameterizedType parameterizedType = ParameterizedType.class.cast(parameterizedList);
            final Type rawType = parameterizedType.getRawType();
            if (!(rawType instanceof Class)) {
                return null;
            }

            final Class<?> rawClass = Class.class.cast(rawType);
            if (!rawClass.isAssignableFrom(List.class)) {
                return null;
            }

            final Type[] actualTypeArgument = parameterizedType.getActualTypeArguments();
            if (actualTypeArgument == null || actualTypeArgument.length != 1) {
                return null;
            }
            if (!(actualTypeArgument[0] instanceof Class)) {
                return null;
            }

            return Class.class.cast(actualTypeArgument[0]);
        }

        public static Class<?> getElementTypeOfListFromParameterType(final Method method, final int parameterPosition) {
            final Type[] parameterTypes = method.getGenericParameterTypes();
            return getElementTypeOfList(parameterTypes[parameterPosition]);
        }

        public static Class<?> getElementTypeOfListFromReturnType(final Method method) {
            return getElementTypeOfList(method.getGenericReturnType());
        }
    }

    protected static class ResultSetHandlerFactoryExtension extends ResultSetHandlerFactoryImpl {
        public ResultSetHandlerFactoryExtension(BeanMetaData beanMetaData) {
            super(beanMetaData);
        }

        protected RelationRowCreator createRelationRowCreator() {
            return new RelationRowCreatorExtension();
        }
    }

    protected static class RelationRowCreatorExtension extends RelationRowCreatorImpl {
        public Object createRelationRow(ResultSet rs, RelationPropertyType rpt, Set columnNames, Map relKeyValues)
                throws SQLException {
            return createRelationRow(rs, rpt, columnNames, relKeyValues, "");
        }

        public Object createRelationRow(ResultSet rs, RelationPropertyType rpt, Set columnNames, Map relKeyValues,
                String preRelationNoSuffix) throws SQLException {
            final Object row = setupRelationKeyValue(rpt, columnNames, relKeyValues);
            return setupRelationAllValue(row, rs, rpt, columnNames, relKeyValues, preRelationNoSuffix);
        }

        protected Object setupRelationAllValue(Object row, ResultSet rs, RelationPropertyType rpt, Set columnNames,
                Map relKeyValues, String preRelationNoSuffix) throws SQLException {
            final String relationNoSuffix = preRelationNoSuffix + "_" + rpt.getRelationNo();
            final BeanMetaData bmd = rpt.getBeanMetaData();
            int existColumn = 0;
            for (int i = 0; i < bmd.getPropertyTypeSize(); ++i) {
                final PropertyType pt = bmd.getPropertyType(i);
                final String columnName = pt.getColumnName() + relationNoSuffix;
                if (!columnNames.contains(columnName)) {
                    continue;
                }
                existColumn++;
                if (row == null) {
                    row = createRelationRow(rpt);
                }
                registerRelationValue(row, rs, rpt, pt, columnName, relKeyValues);
            }
            if (existColumn == 0) {
                return null;
            }
            if (rpt.getBeanMetaData().getRelationPropertyTypeSize() != 0) {
                createParentRelationRow(rs, rpt.getBeanMetaData(), columnNames, relationNoSuffix, row);
            }
            return row;
        }

        protected void createParentRelationRow(ResultSet rs, BeanMetaData parentBmd, Set columnNames,
                String relationNoSuffix, Object row) throws SQLException {
            for (int i = 0; i < parentBmd.getRelationPropertyTypeSize(); ++i) {
                RelationPropertyType parentParentRpt = parentBmd.getRelationPropertyType(i);
                if (parentParentRpt == null) {
                    continue;
                }
                Object relationRow = createRelationRow(rs, parentParentRpt, columnNames, null, relationNoSuffix);
                if (relationRow != null) {
                    PropertyDesc pd = parentParentRpt.getPropertyDesc();
                    pd.setValue(row, relationRow);
                }
            }
        }
    }
}
