/*
 * MenuImpl.java
 *
 * Created on 2007/01/16, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
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
