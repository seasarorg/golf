/*
 * SessionUtil.java
 *
 * Created on 2007/01/27, 10:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.util.Hashtable;
import javax.swing.JFrame;
import org.seasar.golf.containerFrame.FormManager;
import org.seasar.golf.uexample.frame.FormAction;

/**
 *
 * @author shimura
 */
public class SessionUtil {
    
    /** Creates a new instance of SessionUtil */
        private SessionUtil() {
        }
        public static void processAction(FormAction formAction, Session session) {
            switch (formAction.getFormStack()) {
                case MENU :
                        setForm(0, formAction, session, session.getConnection().getLoginInfo());
                    break;
                case FIRST :
                        setForm(1, formAction, session, null);
                    break;    
                case NEWMENU :
                        session.getConnection().addSession();
                    break;         
                case NEWFIRST :
                        Session s = session.getConnection().addSession();
                        if (s == null ) {
                            break;
                        }
                        formAction.setFormStack(FormAction.FormStack.FIRST);
                        s.processAction(formAction);
                    break;                 
                default:
                    break;
            }

        }   

        public static void setForm(int index, FormAction formAction, Session session, Hashtable params ){
                    if (session.getFormManagers().size() == index) {
                        JFrame form = Factory.createForm(formAction.getActionItem().getForm()+"Frame");
                        String parameter = formAction.getActionItem().getParameter();
                        Hashtable actionParam = getActionParameter(parameter);
                        if (params != null) {
                            ((GolfFormInterface)form).initBinding(params);
                        } else {
                            ((GolfFormInterface)form).initBinding(actionParam);   
                        }
                        FormManager formManager = ((GolfFormInterface)form).getFormManager();
                        formManager.setSession(session);
                        session.getFormManagers().add(formManager);
                    }
                    removeUpperForm(index, session);
                    session.getContainerManager().setForm(
                            (GolfFormInterface)((FormManager) session.getFormManagers().get(index
                            )).getFrame());        
        }

        public static void removeUpperForm(int index, Session session) {
            while(session.getFormManagers().size() > index + 1) {
                session.getFormManagers().remove(session.getFormManagers().size() - 1);
            }
        }
        public static Hashtable getActionParameter(String parameter){
            Hashtable param = new Hashtable();
            if (parameter != null) {
                String[] params = parameter.split(",");
                for (int i=0; i < params.length; i++) {
                    String[] items = params[i].split("=");
                    param.put(items[0],items[1]);
                }
            }
            return param;
        }
    }
