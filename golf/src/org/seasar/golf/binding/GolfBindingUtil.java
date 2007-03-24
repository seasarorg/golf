/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
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
                 GolfTableModel golfTableModel, String field, String columnName ) {
                    ValueHolder vh = (ValueHolder) golfTableModel.getFormValidationManager().
                            getFormManager().getFormBindingManager().getValueModel(field);
                    rowBindHandler.addSrcAndColumn(vh, columnName);
                    BeanUtils.addPropertyChangeListener(vh,ValueHolder.class, rowBindHandler);

    }
}
