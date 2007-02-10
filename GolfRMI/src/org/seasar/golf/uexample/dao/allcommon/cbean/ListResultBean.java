package org.seasar.golf.uexample.dao.allcommon.cbean;


import org.seasar.golf.uexample.dao.allcommon.cbean.sqlclause.OrderByClause;

/**
 * The list-result-bean of ListResultBean.
 * 
 * @param <T> The generic template for 'selectedList'.
 * @author DBFlute(AutoGenerator)
 */
public class ListResultBean<T> implements java.util.List<T>, java.io.Serializable {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // =====================================================================================
    //                                                                             Attribute
    //                                                                             =========
    /** The value of table db-name. */
    protected String _tableDbName;

    /** The value of all record count. */
    protected int _allRecordCount;

    /** Selected list. */
    protected java.util.List<T> _selectedList = new java.util.ArrayList<T>();

    /** Order-by clause. */
    protected OrderByClause _orderByClause = new OrderByClause();

    // =====================================================================================
    //                                                                           Constructor
    //                                                                           ===========
    /**
     * Constructor.
     */
    public ListResultBean() {
    }

    // =====================================================================================
    //                                                                         Getter Setter
    //                                                                         =============
    /**
     * Get the value of tableDbName.
     * 
     * @return The value of tableDbName.
     */
    public String getTableDbName() {
        return _tableDbName;
    }

    /**
     * Set the value of tableDbName.
     * 
     * @param value The value of tableDbName.
     */
    public void setTableDbName(String value) {
        _tableDbName = value;
    }

    /**
     * Get the value of allRecordCount.
     * 
     * @return The value of allRecordCount.
     */
    public int getAllRecordCount() {
        return _allRecordCount;
    }

    /**
     * Set the value of allRecordCount.
     * 
     * @param value The value of allRecordCount.
     */
    public void setAllRecordCount(int value) {
        _allRecordCount = value;
    }

    /**
     * Get the value of selectedList.
     * 
     * @return Selected list. (NotNull)
     */
    public java.util.List<T> getSelectedList() {
        return _selectedList;
    }

    /**
     * Set the value of selectedList.
     * 
     * @param value Selected list. (NotNull)
     */
    public void setSelectedList(java.util.List<T> value) {
        _selectedList = value;
    }

    /**
     * Get the value of orderByClause.
     * 
     * @return The value of orderByClause. (NotNull)
     */
    public OrderByClause getOrderByClause() {
        return _orderByClause;
    }

    /**
     * Set the value of orderByClause.
     * 
     * @param value The value of orderByClause. (NotNull)
     */
    public void setOrderByClause(OrderByClause value) {
        _orderByClause = value;
    }

    // =====================================================================================
    //                                                                         Determination
    //                                                                         =============
    /**
     * Has this result selected?
     * <pre>
     * If isSetterInvokedSelectedList is true, returns true.
     * </pre>
     * 
     * @return Determination.
     */
    public boolean isSelectedResult() {
        return _tableDbName != null;
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

        sb.append(" tableDbName=").append(_tableDbName);
        sb.append(" allRecordCount=").append(_tableDbName);
        sb.append(" selectedList.size()=").append(_selectedList.size());
        sb.append(" orderByClause=").append(_orderByClause);

        return sb.toString();
    }

    // =====================================================================================
    //                                                                         List Elements
    //                                                                         =============
    public boolean add(T o) {
        return _selectedList.add(o);
    }

    public boolean addAll(java.util.Collection<? extends T> c) {
        return _selectedList.addAll(c);
    }

    public void clear() {
        _selectedList.clear();
    }

    public boolean contains(Object o) {
        return _selectedList.contains(o);
    }

    public boolean containsAll(java.util.Collection<?> c) {
        return _selectedList.containsAll(c);
    }

    public boolean isEmpty() {
        return _selectedList.isEmpty();
    }

    public java.util.Iterator<T> iterator() {
        return _selectedList.iterator();
    }

    public boolean remove(Object o) {
        return _selectedList.remove(o);
    }

    public boolean removeAll(java.util.Collection<?> c) {
        return _selectedList.removeAll(c);
    }

    public boolean retainAll(java.util.Collection<?> c) {
        return _selectedList.retainAll(c);
    }

    public int size() {
        return _selectedList.size();
    }

    public Object[] toArray() {
        return _selectedList.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return _selectedList.toArray(a);
    }

    public void add(int index, T element) {
        _selectedList.add(index, element);
    }

    public boolean addAll(int index, java.util.Collection<? extends T> c) {
        return _selectedList.addAll(index, c);
    }

    public T get(int index) {
        return _selectedList.get(index);
    }

    public int indexOf(Object o) {
        return _selectedList.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return _selectedList.lastIndexOf(o);
    }

    public java.util.ListIterator<T> listIterator() {
        return _selectedList.listIterator();
    }

    public java.util.ListIterator<T> listIterator(int index) {
        return _selectedList.listIterator(index);
    }

    public T remove(int index) {
        return _selectedList.remove(index);
    }

    public T set(int index, T element) {
        return _selectedList.set(index, element);
    }

    public java.util.List<T> subList(int fromIndex, int toIndex) {
        return _selectedList.subList(fromIndex, toIndex);
    }

}
