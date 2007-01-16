/*
 * MenuFactory.java
 *
 * Created on 2007/01/16, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.menu;

import java.util.Hashtable;
import javax.swing.JTree;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;

/**
 *
 * @author shimura
 */
public class MenuFactory {
    private static MenuInterface menu = null;
    
    /** Creates a new instance of MenuFactory */
    private MenuFactory() {
    }
    public static boolean setMenu(JTree jt, String role) {
        if (menu == null) {
            menu = (MenuInterface) SingletonS2ContainerFactory.getContainer().getComponent(MenuInterface.class);
        }
        return menu.createMenu(jt, role);
    }
    public static void setAction(Hashtable action) {
        menu.setAction(action);
    }
    
}
