/*
 * BindingUtil.java
 *
 * Created on 2007/01/08, 17:42
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.binding;

import com.jgoodies.binding.beans.BeanUtils;
import com.jgoodies.binding.value.ValueHolder;
import org.seasar.golf.GolfTableModel;

/**
 *
 * @author shimura
 */
public class GolfBindingUtil {
    
    /** Creates a new instance of BindingUtil */
    private GolfBindingUtil() {
    }
    public  static TableBindHandler createTableBindHandler(GolfTableModel golfTableModel){
        TableBindHandler handler = new TableBindHandler(golfTableModel);
        golfTableModel.addTableModelListener(handler);
        return handler;
    }
    public static void bindTableRowColumn(TableBindHandler rowBindHandler,
                 GolfTableModel golfTableModel, String field, String ColumnName ) {
                    ValueHolder vh = (ValueHolder) golfTableModel.getFormValidationManager().
                            getFrameManager().getFormBindingManager().getValueModel(field);
                    rowBindHandler.addSrcAndColumn(vh, ColumnName);
                    BeanUtils.addPropertyChangeListener(vh,ValueHolder.class, rowBindHandler);

    }
}
