package org.seasar.golf.uexample.ldb.allcommon.cbean.cvalue;


import java.util.List;

/**
 * Condition value.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class ConditionValue {

    /** Value of equal. */
    protected Object _equalValue;

    /**
     * Get the value of equal.
     * 
     * @return The value of equal. (Nullable)
     */
    public Object getEqual() {
        return filterValue(_equalValue);
    }

    /**
     * Set the value of equal.
     * 
     * @param value The value of equal. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setEqual(Object value) {
        _equalValue = value;
        return this;
    }

    /** Location of equal. */
    protected String _equalLocation;

    /**
     * Get the location of equal.
     * 
     * @return The location of equal. (Nullable)
     */
    public String getEqualLocation() {
        return _equalLocation;
    }

    /**
     * Set the location of equal.
     * 
     * @param location The location of equal. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setEqualLocation(String location) {
        _equalLocation = location;
        return this;
    }

    /** Value of notEqual. */
    protected Object _notEqualValue;

    /**
     * Get the value of notEqual.
     * 
     * @return The value of notEqual. (Nullable)
     */
    public Object getNotEqual() {
        return filterValue(_notEqualValue);
    }

    /**
     * Set the value of notEqual.
     * 
     * @param value The value of notEqual. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setNotEqual(Object value) {
        _notEqualValue = value;
        return this;
    }

    /** Location of notEqual. */
    protected String _notEqualLocation;

    /**
     * Get the location of notEqual.
     * 
     * @return The location of notEqual. (Nullable)
     */
    public String getNotEqualLocation() {
        return _notEqualLocation;
    }

    /**
     * Set the location of notEqual.
     * 
     * @param location The location of notEqual. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setNotEqualLocation(String location) {
        _notEqualLocation = location;
        return this;
    }

    /** Value of greaterThan. */
    protected Object _greaterThanValue;

    /**
     * Get the value of greaterThan.
     * 
     * @return The value of greaterThan. (Nullable)
     */
    public Object getGreaterThan() {
        return filterValue(_greaterThanValue);
    }

    /**
     * Set the value of greaterThan.
     * 
     * @param value The value of greaterThan. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setGreaterThan(Object value) {
        _greaterThanValue = value;
        return this;
    }

    /** Location of GreaterThan. */
    protected String _greaterThanLocation;

    /**
     * Get the location of greaterThan.
     * 
     * @return The location of greaterThan. (Nullable)
     */
    public String getGreaterThanLocation() {
        return _greaterThanLocation;
    }

    /**
     * Set the location of greaterThan.
     * 
     * @param location The location of greaterThan. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setGreaterThanLocation(String location) {
        _greaterThanLocation = location;
        return this;
    }

    /** Value of lessThan. */
    protected Object _lessThanValue;

    /**
     * Get the value of lessThan.
     * 
     * @return The value of lessThan. (Nullable)
     */
    public Object getLessThan() {
        return filterValue(_lessThanValue);
    }

    /**
     * Set the value of lessThan.
     * 
     * @param value The value of lessThan. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setLessThan(Object value) {
        _lessThanValue = value;
        return this;
    }

    /** Location of lessThan. */
    protected String _lessThanLocation;

    /**
     * Get the location of lessThan.
     * 
     * @return The location of lessThan. (Nullable)
     */
    public String getLessThanLocation() {
        return _lessThanLocation;
    }

    /**
     * Set the location of lessThan.
     * 
     * @param location The location of lessThan. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setLessThanLocation(String location) {
        _lessThanLocation = location;
        return this;
    }

    /** Value of greaterEqual. */
    protected Object _greaterEqualValue;

    /**
     * Get the value of greaterEqual.
     * 
     * @return The value of greaterEqual. (Nullable)
     */
    public Object getGreaterEqual() {
        return filterValue(_greaterEqualValue);
    }

    /**
     * Set the value of greaterEqual.
     * 
     * @param value The value of greaterEqual. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setGreaterEqual(Object value) {
        _greaterEqualValue = value;
        return this;
    }

    /** Location of greaterEqual. */
    protected String _greaterEqualLocation;

    /**
     * Get the location of greaterEqual.
     * 
     * @return The location of greaterEqual. (Nullable)
     */
    public String getGreaterEqualLocation() {
        return _greaterEqualLocation;
    }

    /**
     * Set the location of greaterEqual.
     * 
     * @param location The location of greaterEqual. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setGreaterEqualLocation(String location) {
        _greaterEqualLocation = location;
        return this;
    }

    /** Value of lessEqual. */
    protected Object _lessEqualValue;

    /**
     * Get the value of lessEqual.
     * 
     * @return The value of lessEqual. (Nullable)
     */
    public Object getLessEqual() {
        return filterValue(_lessEqualValue);
    }

    /**
     * Set the value of lessEqual.
     * 
     * @param value The value of lessEqual. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setLessEqual(Object value) {
        _lessEqualValue = value;
        return this;
    }

    /** Location of lessEqual. */
    protected String _lessEqualLocation;

    /**
     * Get the location of lessEqual.
     * 
     * @return The location of lessEqual. (Nullable)
     */
    public String getLessEqualLocation() {
        return _lessEqualLocation;
    }

    /**
     * Set the location of lessEqual.
     * 
     * @param location The location of lessEqual. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setLessEqualLocation(String location) {
        _lessEqualLocation = location;
        return this;
    }

    /** Value of prefixSearch. */
    protected Object _prefixSearch;

    /**
     * Get the value of prefixSearch.
     * 
     * @return The value of prefixSearch. (Nullable)
     */
    public Object getPrefixSearch() {
        return filterValue(_prefixSearch);
    }

    /**
     * Set the value of prefixSearch.
     * 
     * @param value The value of prefixSearch. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setPrefixSearch(Object value) {
        _prefixSearch = value;
        return this;
    }

    /** Location of prefixSearch. */
    protected String _prefixSearchLocation;

    /**
     * Get the location of prefixSearch.
     * 
     * @return The location of prefixSearch. (Nullable)
     */
    public String getPrefixSearchLocation() {
        return _prefixSearchLocation;
    }

    /**
     * Set the location of prefixSearch.
     * 
     * @param location The location of prefixSearch. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setPrefixSearchLocation(String location) {
        _prefixSearchLocation = location;
        return this;
    }

    /** Value of inScope. */
    protected List _inScope;

    /**
     * Get the value of inScope.
     * 
     * @return The value of inScope. (Nullable)
     */
    public List getInScope() {
        return filterValue(_inScope);
    }

    /**
     * Set the value of inScope.
     * 
     * @param value The value of inScope. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setInScope(List value) {
        _inScope = value;
        return this;
    }

    /** Location of InScope. */
    protected String _inScopeLocation;

    /**
     * Get the location of inScope.
     * 
     * @return The location of inScope. (Nullable)
     */
    public String getInScopeLocation() {
        return _inScopeLocation;
    }

    /**
     * Set the location of inScope.
     * 
     * @param location The location of inScope. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setInScopeLocation(String location) {
        _inScopeLocation = location;
        return this;
    }

    /** Value of notInScope. */
    protected List _notInScope;

    /**
     * Get the value of notInScope.
     * 
     * @return The value of notInScope. (Nullable)
     */
    public List getNotInScope() {
        return filterValue(_notInScope);
    }

    /**
     * Set the value of notInScope.
     * 
     * @param value The value of notInScope. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setNotInScope(List value) {
        _notInScope = value;
        return this;
    }

    /** Location of notInScope. */
    protected String _notInScopeLocation;

    /**
     * Get the location of notInScope.
     * 
     * @return The location of notInScope. (Nullable)
     */
    public String getNotInScopeLocation() {
        return _notInScopeLocation;
    }

    /**
     * Set the location of notInScope.
     * 
     * @param location The location of notInScope. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setNotInScopeLocation(String location) {
        _notInScopeLocation = location;
        return this;
    }

    /** Value of isNull. */
    protected Object _isNullValue;

    /**
     * Get the value of isNull.
     * 
     * @return The value of isNull. (Nullable)
     */
    public Object getIsNull() {
        return _isNullValue;
    }

    /**
     * Set the value of isNull.
     * 
     * @param value The value of isNull. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setIsNull(Object value) {
        _isNullValue = value;
        return this;
    }

    /** Location of isNull. */
    protected String _isNullLocation;

    /**
     * Get the location of isNull.
     * 
     * @return The location of isNull. (Nullable)
     */
    public String getIsNullLocation() {
        return _isNullLocation;
    }

    /**
     * Set the location of isNull.
     * 
     * @param location The location of isNull. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setIsNullLocation(String location) {
        _isNullLocation = location;
        return this;
    }

    /** Value of isNotNull. */
    protected Object _isNotNullValue;

    /**
     * Get the value of isNotNull.
     * 
     * @return The value of isNotNull. (Nullable)
     */
    public Object getIsNotNull() {
        return _isNotNullValue;
    }

    /**
     * Set the value of isNotNull.
     * 
     * @param value The value of isNotNull. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setIsNotNull(Object value) {
        _isNotNullValue = value;
        return this;
    }

    /** Location of isNotNull. */
    protected String _isNotNullLocation;

    /**
     * Get the location of isNotNull.
     * 
     * @return The location of isNotNull. (Nullable)
     */
    public String getIsNotNullLocation() {
        return _isNotNullLocation;
    }

    /**
     * Set the location of isNotNull.
     * 
     * @param location The location of isNotNull. (Nullable)
     * @return this. (NotNull)
     */
    public ConditionValue setIsNotNullLocation(String location) {
        _isNotNullLocation = location;
        return this;
    }

    // =====================================================================================
    //                                                                                Filter
    //                                                                                ======
    /**
     * Filter value.
     * If the value is instance of java.util.Date or java.util.Calendar, returns value as java.sql.Date.
     * 
     * @param value Value. (Nullable)
     * @return Filtered value. (Nullable)
     */
    protected Object filterValue(Object value) {
        if (value == null) {
            return value;
        }
        if (value instanceof java.sql.Timestamp) {
            return value;
        }
        if (value instanceof java.util.Date || value instanceof java.util.Calendar) {
            return SqlDateConversionUtil.toDate(value);
        } else {
            return value;
        }
    }

    /**
     * Filter value.
     * If the value is instance of java.util.Date or java.util.Calendar, returns value as java.sql.Date.
     * 
     * @param valueList Value-list. (Nullable)
     * @return Filtered value-list. (Nullable)
     */
    protected java.util.List filterValue(java.util.List valueList) {
        if (valueList == null || valueList.isEmpty()) {
            return valueList;
        }
        final List<Object> resultList = new java.util.ArrayList<Object>();
        for (final java.util.Iterator ite = valueList.iterator(); ite.hasNext(); ) {
            Object value = ite.next();
            resultList.add(filterValue(value));
        }
	    return resultList;
	}

	protected static class SqlDateConversionUtil {

	    private SqlDateConversionUtil() {
	    }

	    public static java.sql.Date toDate(Object o) {
	        return toDate(o, null);
	    }

	    public static java.sql.Date toDate(Object o, String pattern) {
	        if (o instanceof java.sql.Date) {
	            return (java.sql.Date) o;
	        }
	        java.util.Date date = DateConversionUtil.toDate(o, pattern);
	        if (date != null) {
	            return new java.sql.Date(date.getTime());
	        }
	        return null;
	    }
	}

	protected static class DateConversionUtil {

	    private DateConversionUtil() {
	    }

	    public static java.util.Date toDate(Object o) {
	        return toDate(o, null);
	    }

	    public static java.util.Date toDate(Object o, String pattern) {
	        if (o == null) {
	            return null;
	        } else if (o instanceof String) {
	            return toDate((String) o, pattern);
	        } else if (o instanceof java.util.Date) {
	            return (java.util.Date) o;
	        } else if (o instanceof java.util.Calendar) {
	            return ((java.util.Calendar) o).getTime();
	        } else {
	            return toDate(o.toString(), pattern);
	        }
	    }

	    public static java.util.Date toDate(String s, String pattern) {
	        return toDate(s, pattern, java.util.Locale.getDefault());
	    }

	    public static java.util.Date toDate(String s, String pattern, java.util.Locale locale) {
	        java.text.SimpleDateFormat sdf = getDateFormat(s, pattern, locale);
	        try {
	            return sdf.parse(s);
	        } catch (java.text.ParseException ex) {
	            throw new RuntimeException(ex);
	        }
	    }

	    public static java.text.SimpleDateFormat getDateFormat(String s, String pattern,
	            java.util.Locale locale) {
	        if (pattern != null) {
	            return new java.text.SimpleDateFormat(pattern);
	        }
	        return getDateFormat(s, locale);
	    }

	    public static java.text.SimpleDateFormat getDateFormat(String s, java.util.Locale locale) {
	        String pattern = getPattern(locale);
	        String shortPattern = removeDelimiter(pattern);
	        String delimitor = findDelimiter(s);
	        if (delimitor == null) {
	            if (s.length() == shortPattern.length()) {
	                return new java.text.SimpleDateFormat(shortPattern);
	            }
	            if (s.length() == shortPattern.length() + 2) {
	                return new java.text.SimpleDateFormat(StringUtil.replace(shortPattern,
	                        "yy", "yyyy"));
	            }
	        } else {
	            String[] array = StringUtil.split(s, delimitor);
	            for (int i = 0; i < array.length; ++i) {
	                if (array[i].length() == 4) {
	                    pattern = StringUtil.replace(pattern, "yy", "yyyy");
	                    break;
	                }
	            }
	            return new java.text.SimpleDateFormat(pattern);
	        }
	        return new java.text.SimpleDateFormat();
	    }

	    public static java.text.SimpleDateFormat getDateFormat(java.util.Locale locale) {
	        return new java.text.SimpleDateFormat(getPattern(locale));
	    }

	    public static java.text.SimpleDateFormat getY4DateFormat(java.util.Locale locale) {
	        return new java.text.SimpleDateFormat(getY4Pattern(locale));
	    }

	    public static String getY4Pattern(java.util.Locale locale) {
	        String pattern = getPattern(locale);
	        if (pattern.indexOf("yyyy") < 0) {
	            pattern = StringUtil.replace(pattern, "yy", "yyyy");
	        }
	        return pattern;
	    }

	    public static String getPattern(java.util.Locale locale) {
	        java.text.SimpleDateFormat df = (java.text.SimpleDateFormat) java.text.DateFormat.getDateInstance(
	                java.text.DateFormat.SHORT, locale);
	        String pattern = df.toPattern();
	        int index = pattern.indexOf(' ');
	        if (index > 0) {
	            pattern = pattern.substring(0, index);
	        }
	        if (pattern.indexOf("MM") < 0) {
	            pattern = StringUtil.replace(pattern, "M", "MM");
	        }
	        if (pattern.indexOf("dd") < 0) {
	            pattern = StringUtil.replace(pattern, "d", "dd");
	        }
	        return pattern;
	    }

	    public static String findDelimiter(String value) {
	        for (int i = 0; i < value.length(); ++i) {
	            char c = value.charAt(i);
	            if (Character.isDigit(c)) {
	                continue;
	            }
	            return Character.toString(c);
	        }
	        return null;
	    }

	    public static String removeDelimiter(String pattern) {
	        StringBuffer buf = new StringBuffer();
	        for (int i = 0; i < pattern.length(); ++i) {
	            char c = pattern.charAt(i);
	            if (c == 'y' || c == 'M' || c == 'd') {
	                buf.append(c);
	            }
	        }
	        return buf.toString();
	    }
	}

	protected static class StringUtil {

	    public static final String[] EMPTY_STRINGS = new String[0];

	    private StringUtil() {
	    }

	    public static final boolean isEmpty(String text) {
	        return text == null || text.length() == 0;
	    }

	    public static final String replace(String text, String fromText,
	            String toText) {

	        if (text == null || fromText == null || toText == null) {
	            return null;
	        }
	        StringBuffer buf = new StringBuffer(100);
	        int pos = 0;
	        int pos2 = 0;
	        while (true) {
	            pos = text.indexOf(fromText, pos2);
	            if (pos == 0) {
	                buf.append(toText);
	                pos2 = fromText.length();
	            } else if (pos > 0) {
	                buf.append(text.substring(pos2, pos));
	                buf.append(toText);
	                pos2 = pos + fromText.length();
	            } else {
	                buf.append(text.substring(pos2));
	                break;
	            }
	        }
	        return buf.toString();
	    }

	    public static String[] split(String str, String delim) {
	        if (str == null) {
	            return EMPTY_STRINGS;
	        }
	        java.util.List<String> list = new java.util.ArrayList<String>();
	        java.util.StringTokenizer st = new java.util.StringTokenizer(str, delim);
	        while (st.hasMoreElements()) {
	            list.add(st.nextToken());
	        }
	        return (String[]) list.toArray(new String[list.size()]);
	    }
	}
}
