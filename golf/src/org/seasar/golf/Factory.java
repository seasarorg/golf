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

package org.seasar.golf;

import javax.swing.JFrame;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.menu.MenuAction;
import org.seasar.golf.menu.MenuActionItem;

/**
 *
 * @author shimura
 */
public class Factory {
    
    /**
     * Creates a new instance of Factory
     */
    private Factory() {
    }

    public static JFrame createForm(String form) {
        return (JFrame) SingletonS2ContainerFactory.getContainer().getComponent(form);
    }
    public static JFrame createFormFromAction(String menuAction) {
        MenuActionItem actionItem = MenuAction.getMenuAction(menuAction);
        JFrame frame = null;
        if (actionItem != null) {
            frame = createForm(actionItem.getForm()+"Frame");
        }
        return frame;
    }
    public static FormManager createFormManager(Session session, JFrame frame) {
        FormManager  formManager = new FormManager(frame);
        formManager.setSession(session);
        return formManager;
    }
    public static Session createSession(Connection connection) {
        Session session = new Session(connection);
        session.init();
        return session;
    }
    
}
