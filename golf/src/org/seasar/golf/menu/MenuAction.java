/*
 * MenuAction.java
 *
 * Created on 2007/01/16, 21:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.menu;

import java.util.Hashtable;
import org.seasar.golf.data.TableData;

/**
 *
 * @author shimura
 */
public class MenuAction {
    private static Hashtable action = null;
    /** Creates a new instance of MenuAction */
    private MenuAction() {
    }
    private static void check() {
        if (action == null) {
            action  = new Hashtable();
            MenuFactory.setAction(action);
        }
    }
    public static boolean isMenuAction (String actionKey) {
        check();
        return action.containsKey(actionKey);
    }
    public static MenuActionItem getMenuAction(String actionKey) {
        check();
        MenuActionItem ma = (MenuActionItem) action.get(actionKey);
        return ma;
    }
}
