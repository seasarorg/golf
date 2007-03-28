package org.seasar.golf.uexample.dao.allcommon.cbean.coption;


import org.seasar.golf.uexample.dao.allcommon.cbean.coption.parts.local.JapaneseOptionPartsAgent;

/**
 * The class of in-scope-option.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class InScopeOption extends SimpleStringOption {

    // =====================================================================================
    //                                                                                 Split
    //                                                                                 =====
    public InScopeOption splitBySpace() {
        return (InScopeOption)doSplitBySpace();
    }

    public InScopeOption splitBySpace(int splitLimitCount) {
        return (InScopeOption)doSplitBySpace(splitLimitCount);
    }

    public InScopeOption splitBySpaceContainsDoubleByte() {
        return (InScopeOption)doSplitBySpaceContainsDoubleByte();
    }

    public InScopeOption splitBySpaceContainsDoubleByte(int splitLimitCount) {
        return (InScopeOption)doSplitBySpaceContainsDoubleByte(splitLimitCount);
    }

    public InScopeOption splitByPipeLine() {
        return (InScopeOption)doSplitByPipeLine();
    }

    public InScopeOption splitByPipeLine(int splitLimitCount) {
        return (InScopeOption)doSplitByPipeLine(splitLimitCount);
    }

    // =====================================================================================
    //                                                                   To Upper/Lower Case
    //                                                                   ===================
    public InScopeOption toUpperCase() {
        return (InScopeOption)doToUpperCase();
    }

    public InScopeOption toLowerCase() {
        return (InScopeOption)doToLowerCase();
    }

    // =====================================================================================
    //                                                                        To Single Byte
    //                                                                        ==============
    public InScopeOption toSingleByteSpace() {
        return (InScopeOption)doToSingleByteSpace();
    }

    public InScopeOption toSingleByteAlphabetNumber() {
        return (InScopeOption)doToSingleByteAlphabetNumber();
    }

    public InScopeOption toSingleByteAlphabetNumberMark() {
        return (InScopeOption)doToSingleByteAlphabetNumberMark();
    }

    // =====================================================================================
    //                                                                        To Double Byte
    //                                                                        ==============

    // =====================================================================================
    //                                                                              Japanese
    //                                                                              ========
    public JapaneseOptionPartsAgent localJapanese() {
        return doLocalJapanese();
    }

    // =====================================================================================
    //                                                                            Real Value
    //                                                                            ==========
    public java.util.List generateRealValueList(java.util.List valueList) {
        final java.util.List resultList = new java.util.ArrayList();
        for (final java.util.Iterator ite = valueList.iterator(); ite.hasNext(); ) {
            final String value = (String)ite.next();
            resultList.add(generateRealValue(value));
        }
        return resultList;
    }
}
