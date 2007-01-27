package org.seasar.golf.uexample.ldb.allcommon.cbean.ckey;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.seasar.golf.uexample.ldb.allcommon.cbean.cvalue.ConditionValue;

/**
 * The condition-key of prefixSearch.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class ConditionKeyPrefixSearch extends ConditionKey {

    /** Log-instance. */
    private static final Log _log = LogFactory.getLog(ConditionKeyPrefixSearch.class);

    /**
     * Constructor.
     */
    protected ConditionKeyPrefixSearch() {
        _conditionKey = "prefixSearch";
        _operand = "like";
    }

    /**
     * Is valid registration?
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param callerName Caller name. (NotNull)
     * @return Determination.
     */
    public boolean isValidRegistration(ConditionValue conditionValue, Object value, String callerName) {
        if (value == null) {
            return false;
        }
        Object valueObject = conditionValue.getPrefixSearch();
        if (valueObject != null && valueObject.equals(value + getWildCard())) {
            _log.warn("The value has already registered at " + callerName + ": " + valueObject + " = " + value);
            return false;
        }
        return true;
    }

    /**
     * This method implements super#doAddWhereClause().
     * 
     * @param conditionList Condition list. (NotNull)
     * @param columnName Column name. (NotNull)
     * @param value Condition value. (NotNull)
     */
    protected void doAddWhereClause(java.util.List<String> conditionList, String columnName, ConditionValue value) {
        if (value.getPrefixSearch() == null) {
            return;
        }
        conditionList.add(buildBindClause(columnName, value.getPrefixSearchLocation()));
    }

    /**
     * This method implements super#doSetupConditionValue().
     * 
     * @param conditionValue Condition value. (NotNull)
     * @param value Value. (NotNull)
     * @param location Location. (NotNull)
     */
    protected void doSetupConditionValue(ConditionValue conditionValue, Object value, String location) {
        conditionValue.setPrefixSearch((value != null ? value + getWildCard() : null)).setPrefixSearchLocation(location);
    }
}
