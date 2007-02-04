/*
 * Factory.java
 *
 * Created on 2007/01/25, 21:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
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
