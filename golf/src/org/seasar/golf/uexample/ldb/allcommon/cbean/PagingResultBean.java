package org.seasar.golf.uexample.ldb.allcommon.cbean;


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

    /** The value of page-group size. */
    protected int _pageGroupSize = 0;

    /** The value of page-range size. */
    protected int _pageRangeSize = 0;

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public PagingResultBean() {
    }

    // =====================================================================================
    //                                                                         Getter Setter
    //                                                                         =============
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
     * @param value The value of pageSize.
     */
    public void setPageSize(int value) {
        _pageSize = value;
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
     * @param value The value of currentPageNumber.
     */
    public void setCurrentPageNumber(int value) {
        _currentPageNumber = value;
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

    /**
     * Get the value of pageGroupSize.
     * 
     * @return The value of pageGroupSize.
     */
    public int getPageGroupSize() {
        return _pageGroupSize;
    }

    /**
     * Set the value of pageGroupSize.
     * 
     * @param value The value of pageGroupSize.
     */
    public void setPageGroupSize(int value) {
        _pageGroupSize = value;
    }

    /**
     * Get the value of pageRangeSize.
     * 
     * @return The value of pageRangeSize.
     */
    public int getPageRangeSize() {
        return _pageRangeSize;
    }

    /**
     * Set the value of pageRangeSize.
     * 
     * @param value The value of pageRangeSize.
     */
    public void setPageRangeSize(int value) {
        _pageRangeSize = value;
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
        assertPageGroupSizeValid();
        final int pageGroupSize = _pageGroupSize;
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
        assertPageGroupSizeValid();
        final int pageGroupSize = _pageGroupSize;
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
        assertPageGroupSizeValid();
        return convertListToIntArray(getCurrentPageGroupPageNumberList());
    }

    /**
     * Is existing previous page-group?
     * Using values are currentPageNumber and pageGroupSize.
     * 
     * @return Determination.
     */
    public boolean isExistPrePageGroup() {
        assertPageGroupSizeValid();
        return (_currentPageNumber > _pageGroupSize);
    }

    /**
     * Is existing next page-group?
     * Using values are currentPageNumber and pageGroupSize and allPageCount.
     * 
     * @return Determination.
     */
    public boolean isExistNextPageGroup() {
        assertPageGroupSizeValid();
        int currentPageGroupStartPageNumber = calculateCurrentPageGroupStartPageNumber();
        if (!(currentPageGroupStartPageNumber > 0)) {
            String msg = "currentPageGroupStartPageNumber should be greater than 0. {> 0} But:";
            msg = msg + " currentPageGroupStartPageNumber=" + currentPageGroupStartPageNumber;
            throw new IllegalStateException(msg);
        }
        int nextPageGroupStartPageNumber = currentPageGroupStartPageNumber + _pageGroupSize;
        return (nextPageGroupStartPageNumber <= getAllPageCount());
    }

    protected void assertPageGroupSizeValid() {
        final int pageGroupSize = _pageGroupSize;
        if (pageGroupSize == 0) {
            String msg = "The pageGroupSize should be greater than 1. But the value is zero.";
            msg = msg + " pageGroupSize=" + pageGroupSize;
            throw new IllegalStateException(msg);
        }
        if (pageGroupSize == 1) {
            String msg = "The pageGroupSize should be greater than 1. But the value is one.";
            msg = msg + " pageGroupSize=" + pageGroupSize;
            throw new IllegalStateException(msg);
        }
    }

    // -------------------------------------------
    //                                  Page Range
    //                                  ----------
    /**
     * Get current page-range page-number-list.
     * Using values are currentPageNumber and pageRangeSize and allPageCount.
     * 
     * @return Current page-range page-number-list.
     */
    public java.util.List<Integer> getCurrentPageRangePageNumberList() {
        assertPageRangeSizeValid();
        final int pageRangeSize = _pageRangeSize;
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
        for (int i=currentPageNumber+1 ; i <= endPageNumber; i++) {
            if (i > allPageCount) {
                break;
            }
            resultList.add(new Integer(i));
        }
        return resultList;
    }

    /**
     * Get current page-range page-number-array.
     * Using values are currentPageNumber and pageRangeSize and allPageCount.
     * 
     * @return Current page-range page-number-array.
     */
    public int[] getCurrentPageRangePageNumberArray() {
        assertPageRangeSizeValid();
        return convertListToIntArray(getCurrentPageRangePageNumberList());
    }

    protected void assertPageRangeSizeValid() {
        final int pageRangeSize = _pageRangeSize;
        if (pageRangeSize == 0) {
            String msg = "The pageRangeSize should be greater than 1. But the value is zero.";
            throw new IllegalStateException(msg);
        }
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
     * Using values are currentPageNumber and pageRangeSize.
     * 
     * @return Determination.
     */
    public boolean isExistPrePageRange() {
        assertPageRangeSizeValid();
        final int[] array = getCurrentPageRangePageNumberArray();
        if (array.length == 0) {
            return false;
        }
        return array[0] > 1;
    }

    /**
     * Is existing next page-range?
     * Using values are currentPageNumber and pageRangeSize and allPageCount.
     * 
     * @return Determination.
     */
    public boolean isExistNextPageRange() {
        assertPageRangeSizeValid();
        final int[] array = getCurrentPageRangePageNumberArray();
        if (array.length == 0) {
            return false;
        }
        return array[array.length-1] < getAllPageCount();
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
