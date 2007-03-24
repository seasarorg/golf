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

package org.seasar.golf.menu;

import java.util.HashMap;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.seasar.framework.exception.ResourceNotFoundRuntimeException;
import org.seasar.golf.data.TableData;
import org.seasar.golf.util.TableUtil;

/**
 *
 * @author shimura
 */
public class MenuImpl  implements MenuInterface{
    
    /** Creates a new instance of MenuImpl */
    public MenuImpl() {
    }
    public boolean createMenu(JTree jt, String role){
        TableData td = new TableData();
        try {
            TableUtil.ReadCsvFromResource(td, role + "menu.csv");
        } catch (ResourceNotFoundRuntimeException ex) {
                return false;
        }
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(role);
        DefaultMutableTreeNode cat = null;
        for (int i = 0; i < td.getRowCount(); i++) {
            if (td.getValueAt(i,0) != null &&((String)td.getValueAt(i,0)).trim().length() > 0)  {
                cat = new DefaultMutableTreeNode(td.getValueAt(i,0));
                root.add(cat);
            }
            else {
                MenuDisplayItem mdi = new MenuDisplayItem((String)td.getValueAt(i,1),
                            (String)td.getValueAt(i,2));
                DefaultMutableTreeNode item = new DefaultMutableTreeNode(mdi);
                cat.add(item);
            }
        }
        DefaultTreeModel dtm = new DefaultTreeModel(root);
        jt.setModel(dtm);
        return true;
    }

    public void setAction(HashMap action) {
        TableData td = new TableData();
        TableUtil.ReadCsvFromResource(td, "menuaction.csv");       
        for (int i = 0; i < td.getRowCount(); i++) {
            MenuActionItem item = 
                    new MenuActionItem((String)td.getValueAt(i,1), (String)td.getValueAt(i,2));
            action.put(td.getValueAt(i,0), item); 
        }
    }
    
}
