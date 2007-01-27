package org.seasar.golf.uexample.ldb.allcommon.helper;

/**
 * The interface of map-string-builder.
 *
 * @author DBFlute(AutoGenerator)
 */
public interface MapStringBuilder {

    public void setColumnNames(String[] value);

    public void setMsMapMark(String value);

    public void setMsStartBrace(String value);

    public void setMsEndBrace(String value);

    public void setMsDelimiter(String value);

    public void setMsEqual(String value);

    public String buildByDelimiter(String values, String delimiter);

    public static class DifferentDelimiterCountException extends RuntimeException {
        protected String[] _columnNames;
        protected String[] _values;
        public DifferentDelimiterCountException(String msg, String[] columnNames, String[] values) {
            super(msg);
            _columnNames = columnNames;
            _values = values;
        }
        public String[] getColumnNames() {
            return _columnNames;
        }
        public String[] getValues() {
            return _values;
        }
    }
}
