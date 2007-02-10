package org.seasar.golf.uexample.dao.allcommon;

import org.seasar.golf.uexample.dao.allcommon.dbmeta.DBMeta;
import org.seasar.golf.uexample.dao.allcommon.helper.MapListString;
import org.seasar.golf.uexample.dao.allcommon.helper.MapListStringImpl;

/**
 * The interface of entity.
 * 
 * @author DBFlute(AutoGenerator)
 */
public interface Entity {

    // =====================================================================================
    //                                                                            Definition
    //                                                                            ==========
    /** Map-string map-mark. */
    public static final String MAP_STRING_MAP_MARK = "map:";

    /** Map-string list-mark. */
    public static final String MAP_STRING_LIST_MARK = "list:";

    /** Map-string start-brace. */
    public static final String MAP_STRING_START_BRACE = "@{";

    /** Map-string end-brace. */
    public static final String MAP_STRING_END_BRACE = "@}";

    /** Map-string delimiter. */
    public static final String MAP_STRING_DELIMITER = "@;";

    /** Map-string equal. */
    public static final String MAP_STRING_EQUAL = "@=";

    // =====================================================================================
    //                                                                                DBMeta
    //                                                                                ======
    /**
     * Get dbmeta.
     * 
     * @return DBMeta. (NotNull)
     */
    public DBMeta getDBMeta();

    // =====================================================================================
    //                                                                            Table Name
    //                                                                            ==========
    /**
     * Get table db-name.
     * 
     * @return Table db-name. (NotNull)
     */
    public String getTableDbName();

    /**
     * Get table cap-prop-name.
     * 
     * @return Table cap-prop-name. (NotNull)
     */
    public String getTableCapPropName();

    /**
     * Get table uncap-prop-name.
     * 
     * @return Table uncap-prop-name. (NotNull)
     */
    public String getTableUncapPropName();

    // =====================================================================================
    //                                                                                Accept
    //                                                                                ======
    /**
     * Accept primary-key map.
     * 
     * The column that column-value map-string doesn't have the key of or the value of is initialized.
     * The instance variable is registered as null, and the isSetterInvoked flag is registered as false.
     * 
     * @param primaryKeyMap Primary-key map. (NotNull and NotEmpty)
     */
    public void acceptPrimaryKeyMap(java.util.Map<String, ? extends Object> primaryKeyMap);

    /**
     * Accept primary-key map-string.
     * 
     * The column that column-value map-string doesn't have the key of or the value of is initialized.
     * The instance variable is registered as null, and the isSetterInvoked flag is registered as false.
     * 
     * @param primaryKeyMapString Primary-key map-string. (NotNull)
     */
    public void acceptPrimaryKeyMapString(String primaryKeyMapString);

    /**
     * Accept column-value map.
     * 
     * The column that column-value map-string doesn't have the key of or the value of is initialized.
     * The instance variable is registered as null, and the isSetterInvoked flag is registered as false.
     * 
     * @param columnValueMap Column-value map. (NotNull and NotEmpty)
     */
    public void acceptColumnValueMap(java.util.Map<String, ? extends Object> columnValueMap);

    /**
     * Accept column-value map-string.
     * 
     * The column that column-value map-string doesn't have the key of or the value of is initialized.
     * The instance variable is registered as null, and the isSetterInvoked flag is registered as false.
     * 
     * @param columnValueMapString Column-value map-string. (NotNull)
     */
    public void acceptColumnValueMapString(String columnValueMapString);

    // =====================================================================================
    //                                                                               Extract
    //                                                                               =======
    /**
     * Extract primary-key map-string. Delimiter is at-mark and semicolon.
     * <p>
     * <pre>
     * ex) Uses that this method have.
     *   final String primaryKeyMapString = entity.extractPrimaryKeyMapString();
     *   final LdBook entity = dao.selectEntity(new LdBookCB().acceptPrimaryKeyMapString(primaryKeyMapString));
     *   ... // as primary key for condition.
     * </pre>
     * 
     * @return Primary-key map-string. (NotNull)
     */
    public String extractPrimaryKeyMapString();

    /**
     * Extract primary-key map-string.
     * 
     * @param startBrace Start-brace. (NotNull)
     * @param endBrace End-brace. (NotNull)
     * @param delimiter Delimiter. (NotNull)
     * @param equal Equal. (NotNull)
     * @return Primary-key map-string. (NotNull)
     */
    public String extractPrimaryKeyMapString(String startBrace, String endBrace, String delimiter, String equal);

    /**
     * Extract column-value map-string. Delimiter is at-mark and semicolon.
     * 
     * @return Column-value map-string. (NotNull)
     */
    public String extractColumnValueMapString();

    /**
     * Extract column-value map-string.
     * 
     * @param startBrace Start-brace. (NotNull)
     * @param endBrace End-brace. (NotNull)
     * @param delimiter Delimiter. (NotNull)
     * @param equal Equal. (NotNull)
     * @return Column-value map-string. (NotNull)
     */
    public String extractColumnValueMapString(String startBrace, String endBrace, String delimiter, String equal);

    // =====================================================================================
    //                                                                         Determination
    //                                                                         =============
    /**
     * Has primary-key value?
     * 
     * @return Determination.
     */
    public boolean hasPrimaryKeyValue();

    // =====================================================================================
    //                                                                   Modified Properties
    //                                                                   ===================
    /**
     * Get modified property names. (JavaBeansRule)
     * 
     * @return Modified property names. (NotNull)
     */
    public java.util.Set<String> getModifiedPropertyNames();

    /**
     * Clear modified property names.
     */
    public void clearModifiedPropertyNames();

    public static class EntityModifiedProperties {
        /** Set of properties. */
        protected java.util.Set<String> _propertiesSet = new java.util.LinkedHashSet<String>();

        /**
         * Add property name. (JavaBeansRule)
         * 
         * @param propertyName Property name. (Nullable)
         */
        public void addPropertyName(String propertyName) {
            _propertiesSet.add(propertyName);
        }

        /**
         * Get the set of properties.
         * 
         * @return The set of properties. (NotNull)
         */
        public java.util.Set<String> getPropertyNames() {
            return _propertiesSet;
        }

        /**
         * Clear the set of properties.
         */
        public void clear() {
            _propertiesSet.clear();
        }

        /**
         * Remove property name from the set. (JavaBeansRule)
         * 
         * @param propertyName Property name. (Nullable)
         */
        public void remove(String propertyName) {
            _propertiesSet.remove(propertyName);
        }
    }

    // =====================================================================================
    //                                                                            Util Class
    //                                                                            ==========
    /**
     * This class is for Internal. Don't use this!
     */
    public static class MapStringUtil {
        public static void acceptPrimaryKeyMapString(String primaryKeyMapString, Entity entity) {
            if (primaryKeyMapString == null) {
                String msg = "The argument[primaryKeyMapString] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            final String prefix = MAP_STRING_MAP_MARK + MAP_STRING_START_BRACE;
            final String suffix = MAP_STRING_END_BRACE;
            if (!primaryKeyMapString.trim().startsWith(prefix)) {
                primaryKeyMapString = prefix + primaryKeyMapString;
            }
            if (!primaryKeyMapString.trim().endsWith(suffix)) {
                primaryKeyMapString = primaryKeyMapString + suffix;
            }
            MapListString mapListString = new MapListStringImpl();
            mapListString.setMapMark(MAP_STRING_MAP_MARK);
            mapListString.setListMark(MAP_STRING_LIST_MARK);
            mapListString.setStartBrace(MAP_STRING_START_BRACE);
            mapListString.setEndBrace(MAP_STRING_END_BRACE);
            mapListString.setEqual(MAP_STRING_EQUAL);
            mapListString.setDelimiter(MAP_STRING_DELIMITER);
            entity.acceptPrimaryKeyMap(mapListString.generateMap(primaryKeyMapString));
        }

        public static void acceptColumnValueMapString(String columnValueMapString, Entity entity) {
            if (columnValueMapString == null) {
                String msg = "The argument[columnValueMapString] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            final String prefix = MAP_STRING_MAP_MARK + MAP_STRING_START_BRACE;
            final String suffix = MAP_STRING_END_BRACE;
            if (!columnValueMapString.trim().startsWith(prefix)) {
                columnValueMapString = prefix + columnValueMapString;
            }
            if (!columnValueMapString.trim().endsWith(suffix)) {
                columnValueMapString = columnValueMapString + suffix;
            }
            MapListString mapListString = new MapListStringImpl();
            mapListString.setMapMark(MAP_STRING_MAP_MARK);
            mapListString.setListMark(MAP_STRING_LIST_MARK);
            mapListString.setStartBrace(MAP_STRING_START_BRACE);
            mapListString.setEndBrace(MAP_STRING_END_BRACE);
            mapListString.setEqual(MAP_STRING_EQUAL);
            mapListString.setDelimiter(MAP_STRING_DELIMITER);
            entity.acceptColumnValueMap(mapListString.generateMap(columnValueMapString));
        }

        public static String extractPrimaryKeyMapString(Entity entity) {
            final String startBrace = MAP_STRING_START_BRACE;
            final String endBrace = MAP_STRING_END_BRACE;
            final String delimiter = MAP_STRING_DELIMITER;
            final String equal = MAP_STRING_EQUAL;
            return entity.extractPrimaryKeyMapString(startBrace, endBrace, delimiter, equal);
        }

        public static String extractColumnValueMapString(Entity entity) {
            final String startBrace = MAP_STRING_START_BRACE;
            final String endBrace = MAP_STRING_END_BRACE;
            final String delimiter = MAP_STRING_DELIMITER;
            final String equal = MAP_STRING_EQUAL;
            return entity.extractColumnValueMapString(startBrace, endBrace, delimiter, equal);
        }

        public static void checkTypeString(Object value, String propertyName, String typeName) {
            if (value == null) {
                throw new IllegalArgumentException("The value should not be null: " + propertyName);
            }
            if (!(value instanceof String)) {
                String msg = "The value of " + propertyName + " should be " + typeName + " or String: ";
                msg = msg + "valueType=" + value.getClass() + " value=" + value;
                throw new IllegalArgumentException(msg);
            }
        }

        public static long parseDateString(Object value, String propertyName, String typeName) {
            checkTypeString(value, propertyName, typeName);
            try {
                return getDateFormat().parse((String)value).getTime();
            } catch (java.text.ParseException e) {
                String msg = "The value of " + propertyName + " should be " + typeName + ". but: " + value;
                throw new RuntimeException(msg + " threw the exception: value=[" + value + "]", e);
            } catch (RuntimeException e) {
                String msg = "The value of " + propertyName + " should be " + typeName + ". but: " + value;
                throw new RuntimeException(msg + " threw the exception: value=[" + value + "]", e);
            }
        }

        public static String formatDate(java.util.Date value) {
            return getDateFormat().format(value);
        }

        public static java.text.DateFormat getDateFormat() {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
    }

    /**
     * This class is for Internal. Don't use this!
     */
    public static class MapAssertUtil {
        public static void assertPrimaryKeyMapNotNullAndNotEmpty(java.util.Map<String, ? extends Object> primaryKeyMap) {
            if (primaryKeyMap == null) {
                String msg = "The argument[primaryKeyMap] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            if (primaryKeyMap.isEmpty()) {
                String msg = "The argument[primaryKeyMap] should not be empty.";
                throw new IllegalArgumentException(msg);
            }
        }
        public static void assertColumnExistingInPrimaryKeyMap(java.util.Map<String, ? extends Object> primaryKeyMap, String columnName) {
            if (!primaryKeyMap.containsKey(columnName)) {
                String msg = "The primaryKeyMap must have the value of " + columnName;
                throw new IllegalStateException(msg + ": primaryKeyMap --> " + primaryKeyMap);
            }
        }
        public static void assertColumnValueMapNotNullAndNotEmpty(java.util.Map<String, ? extends Object> columnValueMap) {
            if (columnValueMap == null) {
                String msg = "The argument[columnValueMap] should not be null.";
                throw new IllegalArgumentException(msg);
            }
            if (columnValueMap.isEmpty()) {
                String msg = "The argument[columnValueMap] should not be empty.";
                throw new IllegalArgumentException(msg);
            }
        }
    }

}
