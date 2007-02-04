/*
 * SessionUtil.java
 *
 * Created on 2007/01/27, 10:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.util.HashMap;
import javax.swing.JFrame;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.form.FormAction;

/**
 *
 * @author shimura
 */
public class SessionUtil {
    
    /** Creates a new instance of SessionUtil */
        private SessionUtil() {
        }
        public static void processAction(FormAction formAction, Session session, HashMap params) {
            switch (formAction.getFormStack()) {
                case MENU :
                        if (session.getFormManagers().size()==0) {
                            createForm(0, formAction, session, session.getConnection().getLoginInfo());
                        }
                        setForm(0, session, null);
                    break;
                case FIRST :
                        //removeUpperForm(0, session);
                        createForm(1, formAction, session, params);
                        setForm(1, session, null);
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
                        s.processAction(formAction, params);
                    break;                 
                default:
                    break;
            }

        }   
        
        public static void createForm(int index, FormAction formAction, Session session, HashMap params) {
                         JFrame form = Factory.createForm(formAction.getActionItem().getForm()+"Frame");
                        String parameter = formAction.getActionItem().getParameter();
                        HashMap actionParam = getActionParameter(parameter);
                        if (params != null) {
                            ((GolfFormInterface)form).initBinding(params);
                        } else {
                            ((GolfFormInterface)form).initBinding(actionParam);   
                        }
                        FormManager formManager = ((GolfFormInterface)form).getFormManager();
                        formManager.setSession(session);
                        removeUpperForm(index - 1 , session);
                        session.getFormManagers().add(formManager);           
        }
        public static void setForm(int index, Session session, HashMap params ){
                    removeUpperForm(index , session);
                    GolfFormInterface golfForm =   (GolfFormInterface)((FormManager) session.getFormManagers().get(index
                            )).getFrame();
                    session.getContainerManager().setForm( golfForm);        
        }

        public static void removeUpperForm(int index, Session session) {
            while(session.getFormManagers().size() > index + 1) {
                session.getFormManagers().remove(session.getFormManagers().size() - 1);
            }
        }
        public static HashMap getActionParameter(String parameter){
            HashMap param = new HashMap();
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