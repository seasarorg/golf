package org.seasar.golf.uexample.dao.allcommon.cbean;


/**
 * The paging-result-bean of PagingResultBean.
 * 
 * @param <T> The generic template for 'selectedList'.
 * @author DBFlute(AutoGenerator)
 */
public class PagingResultBean<T> extends ListResultBean<T> {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** The value of current page number. */
    protected int _pageSize;

    /** The value of current page number. */
    protected int _currentPageNumber;

    // -----------------------------------------
    //                                Page Group
    //                                ----------
    /** The value of page-group option. */
    protected PageGroupOption _pageGroupOption;

    // -----------------------------------------
    //                                Page Range
    //                                ----------
    /** The value of page-range option. */
    protected PageRangeOption _pageRangeOption;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public PagingResultBean() {
    }

    // =====================================================================================
    //                                                                              Accessor
    //                                                                              ========
    /**
     * Get the value of pageSize.
     * 
     * @return The value of pageSize.
     */
    public int getPageSize() {
        return _pageSize;
    }

    /**
     * Set the value of pageSize.
     * 
     * @param pageSize The value of pageSize.
     */
    public void setPageSize(int pageSize) {
        _pageSize = pageSize;
    }

    /**
     * Get the value of currentPageNumber.
     * 
     * @return The value of currentPageNumber.
     */
    public int getCurrentPageNumber() {
        return _currentPageNumber;
    }

    /**
     * Set the value of currentPageNumber.
     * 
     * @param currentPageNumber The value of currentPageNumber.
     */
    public void setCurrentPageNumber(int currentPageNumber) {
        _currentPageNumber = currentPageNumber;
    }

    /**
     * Get the value of allPageCount.
     * 
     * @return The value of allPageCount.
     */
    public int getAllPageCount() {
        return calculateAllPageCount(_allRecordCount, _pageSize);
    }

    /**
     * Get the value of currentStartRecordNumber.
     * 
     * @return The value of currentStartRecordNumber.
     */
    public int getCurrentStartRecordNumber() {
        return calculateCurrentStartRecordNumber(_currentPageNumber, _pageSize);
    }

    /**
     * Get the value of currentEndRecordNumber.
     * 
     * @return The value of currentEndRecordNumber.
     */
    public int getCurrentEndRecordNumber() {
        return calculateCurrentEndRecordNumber(_currentPageNumber, _pageSize);
    }

    // -----------------------------------------
    //                                Page Group
    //                                ----------
    /**
     * Get the value of pageGroupSize.
     * 
     * @return The value of pageGroupSize.
     */
    public int getPageGroupSize() {
        return _pageGroupOption != null ? _pageGroupOption.getPageGroupSize() : 0;
    }

    /**
     * Set the value of pageGroupSize.
     * 
     * @param value The value of pageGroupSize.
     */
    public void setPageGroupSize(int pageGroupSize) {
        final PageGroupOption option = new PageGroupOption();
        option.setPageGroupSize(pageGroupSize);
        setPageGroupOption(option);
    }

    /**
     * Set the value of pageGroupOption.
     * 
     * @param pageGroupOption The value of pageGroupOption.
     */
    public void setPageGroupOption(PageGroupOption pageGroupOption) {
        _pageGroupOption = pageGroupOption;
    }

    public static class PageGroupOption {
        protected int _pageGroupSize;

        public int getPageGroupSize() {
            return _pageGroupSize;
        }

        public void setPageGroupSize(int pageGroupSize) {
            _pageGroupSize = pageGroupSize;
        }
    }

    // -----------------------------------------
    //                                Page Range
    //                                ----------
    /**
     * Get the value of pageRangeSize.
     * 
     * @return The value of pageRangeSize.
     */
    public int getPageRangeSize() {
        return _pageRangeOption != null ? _pageRangeOption.getPageRangeSize() : 0;
    }

    /**
     * Set the value of pageRangeSize.
     * 
     * @param pageRangeSize The value of pageRangeSize.
     */
    public void setPageRangeSize(int pageRangeSize) {
        final PageRangeOption option = new PageRangeOption();
        option.setPageRangeSize(pageRangeSize);
        setPageRangeOption(option);
    }

    /**
     * Set the value of pageRangeOption.
     * 
     * @param value The value of pageRangeOption.
     */
    public void setPageRangeOption(PageRangeOption pageRangeOption) {
        _pageRangeOption = pageRangeOption;
    }

    public static class PageRangeOption {
        protected int _pageRangeSize;

        protected boolean _fillLimit;
        
        public int getPageRangeSize() {
            return _pageRangeSize;
        }

        public void setPageRangeSize(int pageRangeSize) {
            _pageRangeSize = pageRangeSize;
        }

        public boolean isFillLimit() {
            return _fillLimit;
        }

        public void setFillLimit(boolean fillLimit) {
            _fillLimit = fillLimit;
        }
    }

    // =====================================================================================
    //                                                                             Calculate
    //                                                                             =========
    // -------------------------------------------
    //                                        Page
    //                                        ----
    /**
     * Calculate all page count.
     * 
     * @param allRecordCount All record count.
     * @param pageSize Fetch-size.
     * @return All page count.
     */
    protected int calculateAllPageCount(int allRecordCount, int pageSize) {
        if (allRecordCount == 0) {
            return 1;
        }
        int pageCountBase = (allRecordCount / pageSize);
        if (allRecordCount % pageSize > 0) {
            pageCountBase++;
        }
        return pageCountBase;
    }

    protected int calculateCurrentStartRecordNumber(int currentPageNumber, int pageSize) {
        return ((currentPageNumber - 1) * pageSize) + 1;
    }

    protected int calculateCurrentEndRecordNumber(int currentPageNumber, int pageSize) {
        return calculateCurrentStartRecordNumber(currentPageNumber, pageSize) + _selectedList.size() - 1;
    }

    /**
     * Is existing previous page?
     * Using values are currentPageNumber.
     * 
     * @return Determination.
     */
    public boolean isExistPrePage() {
        return (_allRecordCount > 0 && _currentPageNumber > 1);
    }

    /**
     * Is existing next page?
     * Using values are currentPageNumber and allPageCount.
     * 
     * @return Determination.
     */
    public boolean isExistNextPage() {
        return (_allRecordCount > 0 && _currentPageNumber < getAllPageCount());
    }

    // -------------------------------------------
    //                                  Page Group
    //                                  ----------
    /**
     * Calculate current page-group start-page-number.
     * Using values are currentPageNumber and pageGroupSize.
     * 
     * @return Current page-group start-page-number.
     */
    public int calculateCurrentPageGroupStartPageNumber() {
        assertPageGroupValid();
        final int pageGroupSize = _pageGroupOption.getPageGroupSize();
        final int currentPageNumber = _currentPageNumber;

        int currentPageGroupNumber = (currentPageNumber / pageGroupSize);
        if ((currentPageNumber % pageGroupSize) == 0)
        {
            currentPageGroupNumber--;
        }
        final int currentPageGroupStartPageNumber = (pageGroupSize * currentPageGroupNumber) + 1;
        if (!(currentPageNumber >= currentPageGroupStartPageNumber)) {
            String msg = "currentPageNumber should be greater equal currentPageGroupStartPageNumber. But:";
            msg = msg + " currentPageNumber=" + currentPageNumber;
            msg = msg + " currentPageGroupStartPageNumber=" + currentPageGroupStartPageNumber;
            throw new IllegalStateException(msg);
        }
        return currentPageGroupStartPageNumber;
    }

    /**
     * Get current page-group page-number-list.
     * Using values are currentPageNumber and pageGroupSize and allPageCount.
     * 
     * @return Current page-group page-number-list.
     */
    public java.util.List<Integer> getCurrentPageGroupPageNumberList() {
        assertPageGroupValid();
        final int pageGroupSize = _pageGroupOption.getPageGroupSize();
        final int allPageCount = getAllPageCount();
        final int currentPageGroupStartPageNumber = calculateCurrentPageGroupStartPageNumber();
        if (!(currentPageGroupStartPageNumber > 0)) {
            String msg = "currentPageGroupStartPageNumber should be greater than 0. {> 0} But:";
            msg = msg + " currentPageGroupStartPageNumber=" + currentPageGroupStartPageNumber;
            throw new IllegalStateException(msg);
        }
        final int nextPageGroupStartPageNumber = currentPageGroupStartPageNumber + pageGroupSize;

        final java.util.List<Integer> resultList = new java.util.ArrayList<Integer>();
        for (int i=currentPageGroupStartPageNumber; i < nextPageGroupStartPageNumber && i <= allPageCount; i++) {
            resultList.add(new Integer(i));
        }
        return resultList;
    }

    /**
     * Get current page-group page-number-array.
     * Using values are currentPageNumber and pageGroupSize and allPageCount.
     * 
     * @return Current page-group page-number-array.
     */
    public int[] getCurrentPageGroupPageNumberArray() {
        assertPageGroupValid();
        return convertListToIntArray(getCurrentPageGroupPageNumberList());
    }

    /**
     * Is existing previous page-group?
     * Using values are currentPageNumber and pageGroupSize.
     * 
     * @return Determination.
     */
    public boolean isExistPrePageGroup() {
        assertPageGroupValid();
        return (_currentPageNumber > _pageGroupOption.getPageGroupSize());
    }

    /**
     * Is existing next page-group?
     * Using values are currentPageNumber and pageGroupSize and allPageCount.
     * 
     * @return Determination.
     */
    public boolean isExistNextPageGroup() {
        assertPageGroupValid();
        int currentPageGroupStartPageNumber = calculateCurrentPageGroupStartPageNumber();
        if (!(currentPageGroupStartPageNumber > 0)) {
            String msg = "currentPageGroupStartPageNumber should be greater than 0. {> 0} But:";
            msg = msg + " currentPageGroupStartPageNumber=" + currentPageGroupStartPageNumber;
            throw new IllegalStateException(msg);
        }
        int nextPageGroupStartPageNumber = currentPageGroupStartPageNumber + _pageGroupOption.getPageGroupSize();
        return (nextPageGroupStartPageNumber <= getAllPageCount());
    }

    protected void assertPageGroupValid() {
        if (_pageGroupOption == null) {
            String msg = "The pageGroupOption should not be null. Please invoke setPageGroupOption().";
            throw new IllegalStateException(msg);
        }
        if (_pageGroupOption.getPageGroupSize() == 0) {
            String msg = "The pageGroupSize should be greater than 1. But the value is zero.";
            msg = msg + " pageGroupSize=" + _pageGroupOption.getPageGroupSize();
            throw new IllegalStateException(msg);
        }
        if (_pageGroupOption.getPageGroupSize() == 1) {
            String msg = "The pageGroupSize should be greater than 1. But the value is one.";
            msg = msg + " pageGroupSize=" + _pageGroupOption.getPageGroupSize();
            throw new IllegalStateException(msg);
        }
    }

    // -------------------------------------------
    //                                  Page Range
    //                                  ----------
    /**
     * Get current page-range page-number-list.
     * Using values are pageRangeOption and currentPageNumber and allPageCount.
     * 
     * @return Current page-range page-number-list. (NotNull)
     */
    public java.util.List<Integer> getCurrentPageRangePageNumberList() {
        assertPageRangeValid();
        final int pageRangeSize = _pageRangeOption.getPageRangeSize();
        final int allPageCount = this.getAllPageCount();
        final int currentPageNumber = _currentPageNumber;

        final java.util.List<Integer> resultList = new java.util.ArrayList<Integer>();
        for (int i = currentPageNumber - pageRangeSize; i < currentPageNumber; i++) {
            if (i < 1) {
                continue;
            }
            resultList.add(new Integer(i));
        }

        resultList.add(new Integer(currentPageNumber));

        final int endPageNumber = (currentPageNumber + pageRangeSize);
        for (int i = currentPageNumber + 1 ; i <= endPageNumber && i <= allPageCount; i++) {
            resultList.add(new Integer(i));
        }

        final boolean fillLimit = _pageRangeOption.isFillLimit();
        final int limitSize = (pageRangeSize * 2) + 1;
        if (fillLimit && !resultList.isEmpty() && resultList.size() < limitSize) {
            final Integer firstElements = (Integer)resultList.get(0);
            final Integer lastElements = (Integer)resultList.get(resultList.size() - 1);
            if (firstElements.intValue() > 1) {
                for (int i = firstElements.intValue() - 1 ; resultList.size() < limitSize && i > 0; i--) {
                    resultList.add(0, new Integer(i));
                }
            }
            for (int i = lastElements.intValue() + 1 ; resultList.size() < limitSize && i <= allPageCount; i++) {
                resultList.add(new Integer(i));
            }
        }
        return resultList;
    }

    /**
     * Get current page-range page-number-array.
     * Using values are pageRangeOption and currentPageNumber and allPageCount.
     * 
     * @return Current page-range page-number-array.
     */
    public int[] getCurrentPageRangePageNumberArray() {
        assertPageRangeValid();
        return convertListToIntArray(getCurrentPageRangePageNumberList());
    }

    protected int[] convertListToIntArray(java.util.List<Integer> ls) {
        final int[] resultArray = new int[ls.size()];
        int arrayIndex = 0;
        for (final java.util.Iterator ite = ls.iterator(); ite.hasNext(); ) {
            final Integer tmpPageNumber = (Integer)ite.next();
            resultArray[arrayIndex] = tmpPageNumber.intValue();
            arrayIndex++;
        }
        return resultArray;
    }

    /**
     * Is existing previous page-range?
     * Using values are pageRangeOption and currentPageNumber and allPageCount.
     * 
     * @return Determination.
     */
    public boolean isExistPrePageRange() {
        assertPageRangeValid();
        final int[] array = getCurrentPageRangePageNumberArray();
        if (array.length == 0) {
            return false;
        }
        return array[0] > 1;
    }

    /**
     * Is existing next page-range?
     * Using values are pageRangeOption and currentPageNumber and allPageCount.
     * 
     * @return Determination.
     */
    public boolean isExistNextPageRange() {
        assertPageRangeValid();
        final int[] array = getCurrentPageRangePageNumberArray();
        if (array.length == 0) {
            return false;
        }
        return array[array.length-1] < getAllPageCount();
    }

    protected void assertPageRangeValid() {
        if (_pageRangeOption == null) {
            String msg = "The pageRangeOption should not be null. Please invoke setPageRangeOption().";
            throw new IllegalStateException(msg);
        }
        final int pageRangeSize = _pageRangeOption.getPageRangeSize();
        if (pageRangeSize == 0) {
            String msg = "The pageRangeSize should be greater than 1. But the value is zero.";
            throw new IllegalStateException(msg);
        }
    }

    // =====================================================================================
    //                                                                 Basic-Override Method
    //                                                                 =====================
    /**
     * This method overrides the method that is declared at super.
     * 
     * @return View-string of all-columns value.
     */
    public String toString() {
        final StringBuffer sb = new StringBuffer();

        sb.append(getCurrentPageNumber()).append("/").append(getAllPageCount());
        sb.append(" of ").append(getAllRecordCount());
        sb.append(" listSize=").append(getSelectedList() != null ? new Integer(getSelectedList().size()) : null);
        sb.append(" pageSize=").append(getPageSize());
        sb.append(" page:{").append(isExistPrePage()).append("/").append(isExistNextPage()).append("}");
        sb.append(" groupSize=").append(getPageGroupSize());
        sb.append(" rangeSize=").append(getPageRangeSize());

        return sb.toString();
    }
}
