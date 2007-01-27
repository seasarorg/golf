package org.seasar.golf.uexample.ldb.allcommon.s2dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.seasar.dao.CommandContext;
import org.seasar.dao.impl.SelectDynamicCommand;
import org.seasar.extension.jdbc.ResultSetFactory;
import org.seasar.extension.jdbc.ResultSetHandler;
import org.seasar.extension.jdbc.StatementFactory;
import org.seasar.extension.jdbc.impl.BasicSelectHandler;

import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBean;
import org.seasar.golf.uexample.ldb.allcommon.cbean.ConditionBeanContext;

/**
 * My-SelectDynamicCommand.
 * Overrides original class 'SelectDynamicCommand'.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class S2DaoSelectDynamicCommand extends SelectDynamicCommand {

    /** Result-set handler. */
    private ResultSetHandler resultSetHandler;

    /** Result-set factory. */
    private ResultSetFactory resultSetFactory;

    /** Cache of select clause command. */
    protected S2DaoSelectDynamicCommand _selectClauseCommand;

    /** Cache of select clause PK-only command. */
    protected S2DaoSelectDynamicCommand _selectClausePKOnlyCommand;

    /**
     * Constructor.
     * 
     * @param dataSource Data source.
     * @param statementFactory Statement factory.
     * @param resultSetHandler Result-set handler.
     * @param resultSetFactory Result-set factory.
     */
    public S2DaoSelectDynamicCommand(DataSource dataSource,
            StatementFactory statementFactory,
            ResultSetHandler resultSetHandler, ResultSetFactory resultSetFactory) {

        super(dataSource, statementFactory, resultSetHandler, resultSetFactory);

        this.resultSetHandler = resultSetHandler;
        this.resultSetFactory = resultSetFactory;
    }

    /**
     * Do apply. {for delegating to apply()}
     * 
     * @param args Arguments. (NotNull)
     * @return Command context. (NotNull)
     */
    public CommandContext doApply(Object[] args) {
        return apply(args);
    }

    /**
     * Set select clause.
     * 
     * @param value Select clause. (Nullable)
     * @return this. (NotNull)
     */
    public S2DaoSelectDynamicCommand setSelectClause(String value) {
        _selectClauseCommand = createMySelectDynamicCommand();
        _selectClauseCommand.setSql(value);
        return this;
    }

    /**
     * Set select clause PK only.
     * 
     * @param value Select clause PK only. (Nullable)
     * @return this. (NotNull)
     */
    public S2DaoSelectDynamicCommand setSelectClausePKOnly(String value) {
        _selectClausePKOnlyCommand = createMySelectDynamicCommand();
        _selectClausePKOnlyCommand.setSql(value);
        return this;
    }

    protected S2DaoSelectDynamicCommand createMySelectDynamicCommand() {
        return new S2DaoSelectDynamicCommand(getDataSource(), getStatementFactory(), resultSetHandler, resultSetFactory);
    }

    public void setArgNames(String[] argNames) {
        if (_selectClauseCommand != null) {
            _selectClauseCommand.setArgNames(argNames);
        }
        if (_selectClausePKOnlyCommand != null) {
            _selectClausePKOnlyCommand.setArgNames(argNames);
        }
        super.setArgNames(argNames);
    }

    public void setArgTypes(Class[] argTypes) {
        if (_selectClauseCommand != null) {
            _selectClauseCommand.setArgTypes(argTypes);
        }
        if (_selectClausePKOnlyCommand != null) {
            _selectClausePKOnlyCommand.setArgTypes(argTypes);
        }
        super.setArgTypes(argTypes);
    }

    public Object execute(Object[] args) {
        if (!ConditionBeanContext.isExistConditionBeanOnThread()) {
            return super.execute(args);
        }
        assertSelectClauseCommand();
        final List<Object> bindVariableList = new ArrayList<Object>();
        final List<Class> bindVariableTypeList = new ArrayList<Class>();

        final StringBuffer sb = new StringBuffer();
        sb.append(setupRealSelectClause(args, bindVariableList, bindVariableTypeList));
        sb.append(" ");
        sb.append(setupRealFromWhereClause(args, bindVariableList, bindVariableTypeList));

        BasicSelectHandler selectHandler = createBasicSelectHandler(sb.toString());
        selectHandler.setFetchSize(-1);

        return selectHandler.execute(bindVariableList.toArray(), toClassArray(bindVariableTypeList));
    }

    protected String setupRealSelectClause(Object[] args, List<Object> bindVariableList, List<Class> bindVariableTypeList) {
        final ConditionBean cb = ConditionBeanContext.getConditionBeanOnThread();
        if (cb.isSelectCountIgnoreFetchScope()) {
            return "select count(*)";
        }
        final String realSelectClause;
        {
            final CommandContext ctx;
            if (cb.isLimitSelect_PKOnly()) {
                ctx = _selectClausePKOnlyCommand.doApply(args);
            } else {
                ctx = _selectClauseCommand.doApply(args);
            }
            realSelectClause = ctx.getSql();
            addBindVariableInfo(ctx, bindVariableList, bindVariableTypeList);
        }
        return realSelectClause;
    }

    protected String setupRealFromWhereClause(Object[] args, List<Object> bindVariableList, List<Class> bindVariableTypeList) {
        final ConditionBean cb = ConditionBeanContext.getConditionBeanOnThread();
        final String realFromWhereClause;
        {
            final S2DaoSelectDynamicCommand fromWhereCommand = createMySelectDynamicCommand();
            fromWhereCommand.setArgNames(getArgNames());
            fromWhereCommand.setArgTypes(getArgTypes());
            fromWhereCommand.setSql(cb.getSqlClause().getClause());
            CommandContext ctx = fromWhereCommand.doApply(args);
            realFromWhereClause = ctx.getSql();
            addBindVariableInfo(ctx, bindVariableList, bindVariableTypeList);
        }
        return realFromWhereClause;
    }

    protected BasicSelectHandler createBasicSelectHandler(String realSql) {

        return new BasicSelectHandler(getDataSource(), realSql, resultSetHandler, getStatementFactory(), resultSetFactory);

    }

    protected Class[] toClassArray(List<Class> bindVariableTypeList) {
        final Class[] bindVariableTypesArray = new Class[bindVariableTypeList.size()];
        for (int i = 0; i < bindVariableTypeList.size(); i++) {
            final Class bindVariableType = (Class) bindVariableTypeList.get(i);
            bindVariableTypesArray[i] = bindVariableType;
        }
        return bindVariableTypesArray;
    }

    protected void addBindVariableInfo(CommandContext ctx, List<Object> bindVariableList, List<Class> bindVariableTypeList) {
        final Object[] bindVariables = ctx.getBindVariables();
        addBindVariableList(bindVariableList, bindVariables);
        final Class[] bindVariableTypes = ctx.getBindVariableTypes();
        addBindVariableTypeList(bindVariableTypeList, bindVariableTypes);
    }

    protected void addBindVariableList(List<Object> bindVariableList, Object[] bindVariables) {
        for (int i=0; i < bindVariables.length; i++) {
            bindVariableList.add(bindVariables[i]);
        }
    }

    protected void addBindVariableTypeList(List<Class> bindVariableTypeList, Class[] bindVariableTypes) {
        for (int i=0; i < bindVariableTypes.length; i++) {
            bindVariableTypeList.add(bindVariableTypes[i]);
        }
    }

    protected void assertSelectClauseCommand() {
        if (_selectClauseCommand == null) {
            String msg = "Select clause command should not be null.";
            throw new IllegalStateException(msg);
        }
    }
}