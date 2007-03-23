
/*
 * SessionUtil.java
 *
 * Created on 2007/01/27, 10:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JFrame;
import org.seasar.framework.container.ComponentDef;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
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
            HashMap newParams = mergeParams(params, formAction.getParams());
            switch (formAction.getFormStack()) {
                case MENU :
                        if (session.getFormManagers().size()==0) {
                            createForm(0, formAction, session, session.getConnection().getLoginInfo());
                        }
                        setForm(0, session);
                    break;
                case FIRST :
                        createAndSetForm(1,formAction, session, newParams);
                    break;  
                case NEXT:
                        int no = session.getFormManagers().size();
                        createAndSetForm(no,formAction, session, newParams);
                    break;
                case SAME:
                        int sameNo = session.getFormManagers().size() - 1;
                        createAndSetForm(sameNo,formAction, session, newParams);
                    break;                    
                case BACK:
                        int newNo = session.getFormManagers().size() - 2;
                        setForm(newNo, session);
                        break;
                case DIALOG:
                        int dialogNo = session.getFormManagers().size();
                        createDialog(dialogNo,formAction, session, newParams);
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
                        s.processAction(formAction, newParams);
                    break;        
            case SELECTED:
                        int i = 0;
                        for(i=session.getFormManagers().size() - 1; i > 0; i--){
                            if (((FormManager)session.getFormManagers().get(i)).getForm().equals(formAction.getForm())) {
                                break;
                            }
                        }
                        if (i > 0) {
                            GolfForm form = setForm(i, session);
                            formAction.setProcessAction(true);
                            //form.processAction(formAction.getParams());
                        }
                    break;
                default:
                    break;
            }

            if (formAction.isProcessAction()) {
                FormManager formManager = session.getFormManagers().get(session.getFormManagers().size() - 1);
                if (formManager.getFrame() != null) {
                    ((GolfForm)formManager.getFrame()).processAction(newParams);
                } else {
                    ((GolfDialog)formManager.getDialog()).processAction(newParams);                    
            }
        }   
        public static JFrame createForm(String formName, Session session){
                  javax.swing.JFrame form = org.seasar.golf.Factory.
                        createForm(formName +"Frame");
                FormManager formManager = new FormManager(form);
                formManager.init();
                formManager.setSession(session);
                formManager.setForm(formName); 
                ((org.seasar.golf.GolfForm) form).setFormManger(formManager);
                return form;
        }
        
        public static void createForm(int index, FormAction formAction, Session session, HashMap params) {
                javax.swing.JFrame form =  createForm(formAction.getForm(), session);
                ((org.seasar.golf.GolfForm) form).initBinding(params);
                removeUpperForm(index - 1, session);
                session.getFormManagers().add(((org.seasar.golf.GolfForm) form).getFormManager());
}
        public static GolfForm setForm(int index, Session session ){
                    removeUpperForm(index , session);
                    GolfForm golfForm =   (GolfForm)((FormManager) session.getFormManagers().get(index
                            )).getFrame();
                    session.getContainerManager().setForm( golfForm); 
                    return golfForm;
        }
        public static JDialog createDialog(String formName, Session session, int index){
               JDialog dialog = null ; 
               ComponentDef cdef ;
               S2Container container = SingletonS2ContainerFactory.getContainer();
               cdef = container.getComponentDef(formName +"Dialog");               
               FormManager parent = (FormManager) session.getFormManagers().get(index - 1);
               Constructor constructors[] = cdef.getComponentClass().getConstructors();
            try {
                    if (parent.getFrame() == null ) {
                        Class param[] = { java.awt.Dialog.class, Boolean.TYPE };
                        Constructor constructor = cdef.getComponentClass().getConstructor(param);
                        dialog = (JDialog) constructor.newInstance( parent.getDialog(), Boolean.TRUE);                        
               } else {
                        Class param[] = { java.awt.Frame.class, Boolean.TYPE };      
                        Constructor constructor = cdef.getComponentClass().getConstructor(param);
                        dialog = (JDialog) constructor.newInstance(parent.getFrame(), Boolean.TRUE );
                    }
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (SecurityException ex) {
                ex.printStackTrace();
               } catch (NoSuchMethodException ex) {
                ex.printStackTrace();
            }

//                  javax.swing.JDialog dialog = org.seasar.golf.Factory.
//                          createDialog(formName + "Dialog");
                FormManager formManager = new FormManager(null);
                formManager.setDialog(dialog);
                formManager.init();
                formManager.setSession(session);
                formManager.setForm(formName); 
                ((org.seasar.golf.GolfDialog) dialog).setFormManger(formManager);
                return dialog;
        }        
        private static void createDialog(int index, FormAction formAction, Session session, HashMap params) {
                 javax.swing.JDialog dialog =  createDialog(formAction.getForm(), session, index);
                ((org.seasar.golf.GolfDialog) dialog).initBinding(params);
                session.getFormManagers().add(((org.seasar.golf.GolfDialog) dialog).getFormManager()); 
                dialog.setVisible(true);
                //\u3053\u3053\u3067 Dialog \u8868\u793A
                 removeUpperForm(index -1, session);
        }         
        private static void createAndSetForm(int index, FormAction formAction, Session session, HashMap params) {
                createForm(index, formAction, session, params);
                setForm(index, session);
        } 
        public static void removeUpperForm(int index, Session session) {
            while(session.getFormManagers().size() > index + 1) {
                if (((FormManager)session.getFormManagers().get(session.getFormManagers().size() - 1))
                    .getDialog() != null) {
                    ((FormManager)session.getFormManagers().get(session.getFormManagers().size() - 1))
                    .getDialog().dispose();
                }
                session.getFormManagers().remove(session.getFormManagers().size() - 1);
            }
        }
        public static HashMap getActionParameter(String parameter){
            HashMap param = new HashMap();
            if (parameter != null && parameter.length()>0) {
                String[] params = parameter.split(",");
                for (int i=0; i < params.length; i++) {
                    String[] items = params[i].split("=");
                    param.put(items[0],items[1]);
                }
            }
            return param;
        }

    private static HashMap mergeParams(HashMap params, HashMap actionParams) {
        HashMap newParams = new HashMap();
        if (actionParams!=null) {
            newParams.putAll(actionParams);
        }
        if (params!=null) {
            for(Object o:params.keySet()){
                if (newParams.containsKey(o)) {
                    newParams.remove(o);
                }
            }
            newParams.putAll(params);
        }
        return newParams;
    }
}