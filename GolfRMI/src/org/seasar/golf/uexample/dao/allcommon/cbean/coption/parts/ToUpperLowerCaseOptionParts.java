package org.seasar.golf.uexample.dao.allcommon.cbean.coption.parts;


/**
 * The class of condition-option-parts about toUpperCase/toLowerCase.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class ToUpperLowerCaseOptionParts {

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    protected boolean _toUpperCase;
    protected boolean _toLowerCase;

    // =====================================================================================
    //                                                                                  Main
    //                                                                                  ====
    public void toUpperCase() {
        _toUpperCase = true;
        _toLowerCase = false;
    }

    public void toLowerCase() {
        _toUpperCase = false;
        _toLowerCase = true;
    }

    // =====================================================================================
    //                                                                            Real Value
    //                                                                            ==========
    public String generateRealValue(String value) {
        if (value == null || value.trim().length() == 0) {
            String msg = "The argument[value] should not be null.";
            throw new IllegalArgumentException(msg);
        }

        // To Upper/Lower Case
        if (_toUpperCase) {
            value = (value != null ? value.toUpperCase() : value);
        }
        if (_toLowerCase) {
            value = (value != null ? value.toLowerCase() : value);
        }
        return value;
    }

    // =====================================================================================
    //                                                                              DeepCopy
    //                                                                              ========
    public Object createDeepCopy() {
        final ToUpperLowerCaseOptionParts deepCopy = new ToUpperLowerCaseOptionParts();
        deepCopy._toUpperCase = _toUpperCase;
        deepCopy._toLowerCase = _toLowerCase;
        return deepCopy;
    }
}
