package org.seasar.golf.uexample.ldb.allcommon.helper;

/**
 * The implementation of map-string-builder.
 *
 * @author DBFlute(AutoGenerator)
 */
public class MapStringBuilderImpl implements MapStringBuilder {

    protected String[] _columnNames;

    protected String _msMapMark;

    protected String _msStartBrace;

    protected String _msEndBrace;

    protected String _msDelimiter;

    protected String _msEqual;

    public void setColumnNames(String[] value) {
        _columnNames = value;
    }

    public void setMsMapMark(String value) {
        _msMapMark = value;
    }

    public void setMsStartBrace(String value) {
        _msStartBrace = value;
    }

    public void setMsEndBrace(String value) {
        _msEndBrace = value;
    }

    public void setMsDelimiter(String value) {
        _msDelimiter = value;
    }

    public void setMsEqual(String value) {
        _msEqual = value;
    }

    public String buildByDelimiter(String values, String delimiter) {
        if (values == null) {
            String msg = "The argument[values] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        if (delimiter == null) {
            String msg = "The argument[delimiter] should not be null.";
            throw new IllegalArgumentException(msg);
        }
        assertStringComponent();

        String[] valueArray = tokenToArgs(values, delimiter);
        assertValueArray(_columnNames, valueArray);

        final StringBuffer sb = new StringBuffer();
        sb.append(_msMapMark).append(_msStartBrace);
        for (int i = 0; i < _columnNames.length; i++ ) {
            sb.append(_columnNames[i]).append(_msEqual).append(valueArray[i]).append(_msDelimiter);
        }

        sb.delete(sb.length() - _msDelimiter.length(), sb.length());
        sb.append(_msEndBrace);
        return sb.toString(); 
    }

    protected void assertStringComponent() {
        if (_columnNames == null) {
            String msg = "The columnNames should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_columnNames.length == 0) {
            String msg = "The columnNames should not be empty-array.";
            throw new IllegalStateException(msg);
        }
        if (_msMapMark == null) {
            String msg = "The msMapMark should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_msStartBrace == null) {
            String msg = "The msStartBrace should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_msEndBrace == null) {
            String msg = "The msEndBrace should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_msDelimiter == null) {
            String msg = "The msDelimiter should not be null.";
            throw new IllegalStateException(msg);
        }
        if (_msEqual == null) {
            String msg = "The msEqual should not be null.";
            throw new IllegalStateException(msg);
        }
    }

    protected void assertValueArray(String[] expected, String[] actual) {
        if (expected.length != actual.length) {
            String msg = "StringArray's length is difference. (" + expected.length + ", " + actual.length + ")";
            msg = msg + " expectedNames=" + java.util.Arrays.asList(expected);
            msg = msg + " actualValues=" + java.util.Arrays.asList(actual);
            throw new DifferentDelimiterCountException(msg, expected, actual);
        }
    }

    protected static final String replace(String text, String fromText, String toText) {
        if (text == null || fromText == null || toText == null) {
            return null;
        }
        final StringBuffer buf = new StringBuffer(100);
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

    protected static String[] tokenToArgs(String value, String delimiter) {
        java.util.List list = tokenToList(value, delimiter);
        return (String[])list.toArray(new String[list.size()]);
    }

    protected static java.util.List tokenToList(String value, String delimiter) {
        java.util.List list = new java.util.ArrayList();
        int i = 0;
        int j = value.indexOf(delimiter);
        for (int h = 0; j >= 0; h++) {
            list.add(value.substring(i, j));
            i = j + 1;
            j = value.indexOf(delimiter, i);
        }
        list.add(value.substring(i));
        return list;
    }
}
