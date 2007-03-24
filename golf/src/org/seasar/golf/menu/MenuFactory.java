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
        check();
        return menu.createMenu(jt, role);
    }
    public static void setAction(HashMap action) {
        check();
        menu.setAction(action);
    }
    public static void check() {
         if (menu == null) {
            menu = (MenuInterface) SingletonS2ContainerFactory.getContainer().getComponent("menu");
        }       
    }
    
}
