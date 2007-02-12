/*
 * FrameManager.java
 *
 * Created on 2007/01/06, 8:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.form;

import java.lang.reflect.Field;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.Session;
import org.seasar.golf.binding.FormBindingManager;
import org.seasar.golf.containerFrame.*;
import org.seasar.golf.transaction.FormTrxManager;
import org.seasar.golf.data.TableData;
import org.seasar.golf.util.TableUtil;
import org.seasar.golf.validator.FormValidationManager;
import org.seasar.golf.validator.GolfValidationResultViewFactory;


/**
 *
 * @author shimura
 */
public class FormManager {
    private FormBindingManager formBindingManager = new FormBindingManager();
    private FormValidationManager formValidationManager = new FormValidationManager();
    private JFrame frame;
    private HashMap componentNameIndex = new HashMap();
    private Session session = null;
    private FormTrxManager formTrxManager = null;
    private String form;
    /** Creates a new instance of FrameManager */
    public FormManager(JFrame frame) {
        this.setFrame(frame);
    }
    public void init() {
        formBindingManager.setFrameManager(this); 
        formValidationManager.addValidator(formBindingManager);
        addAllJcomponent();
        FormManagerUtil.generateFieldCsv(this);
        formValidationManager.setFormManager(this);
        formTrxManager = new FormTrxManager(this);
      }

    public FormBindingManager getFormBindingManager() {
        return formBindingManager;
    }

    public FormValidationManager getFormValidationManager() {
        return formValidationManager;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public void addComponentName(JComponent jc, String name) {
        componentNameIndex.put(name,jc);
    }
    public JComponent getComponentFromName(String name) {
        return (JComponent) componentNameIndex.get(name);
    }
    
    public void addAllJcomponent() {
    	Field[] fld =frame.getClass().getDeclaredFields();
    	for(int i=0; i < fld.length; i++) {
    		try {
    			fld[i].setAccessible(true);
    			Object jc = null;
				if ((jc = fld[i].get(frame)) instanceof JComponent) {
					addComponentName((JComponent) jc, fld[i].getName());
				}
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
	public HashMap getComponentNameIndex() {
		return componentNameIndex;
	}
	public Object getValue(String name) {
		return formBindingManager.getValueModel(name).getValue();
	}
	public void setValidationFromCsvResource(String path) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path);
		FormManagerUtil.setValidationSub(td, this);
	}
	
	public void setValidationFromCsvResource(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path, charsetName);
		FormManagerUtil.setValidationSub(td, this);
	}
	public void setValidationFromCsv(String path) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path);
		FormManagerUtil.setValidationSub(td, this);
	}
	public void setValidationFromCsv(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path, charsetName);	
		FormManagerUtil.setValidationSub(td,  this);
	}

	public void setBindFromCsvResource(String path) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path);
		FormManagerUtil.setBindSub(td, this);
	}
	
	public void setBindFromCsvResource(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path, charsetName);
		FormManagerUtil.setBindSub(td, this);
	}
	public void setBindFromCsv(String path) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path);
		FormManagerUtil.setBindSub(td, this);
	}
	public void setBindFromCsv(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path, charsetName);	
		FormManagerUtil.setBindSub(td, this);
	}

	public void SetTableColumnFromCsvResource(
			JTable jt, String tableDisplayName, GolfTableModel gtm, String path) {
                SetTableColumnFromCsvResource(jt, tableDisplayName, null, gtm,  path);
	}
        public void SetTableColumnFromCsvResource(
			JTable jt, String tableDisplayName,String hostName, GolfTableModel gtm, String path) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path);
		FormManagerUtil.SetTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, hostName);
	}
	public void SetTableColumnFromCsvResource(JTable jt, String tableDisplayName,
                    GolfTableModel gtm, String path, String charsetName) {
                SetTableColumnFromCsvResource(jt, tableDisplayName, gtm, null, path, charsetName);
	}
	public void SetTableColumnFromCsvResource(JTable jt, String tableDisplayName,
			GolfTableModel gtm, String hostName, String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path, charsetName);
		FormManagerUtil.SetTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, hostName);
	}        
	public void SetTableColumnFromCsv(JTable jt, String tableDisplayName,
			GolfTableModel gtm, String path) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path);
		FormManagerUtil.SetTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, null);
	}
	public void SetTableColumnFromCsv(JTable jt,  String tableDisplayName,
			GolfTableModel gtm,String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path, charsetName);	
		FormManagerUtil.SetTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, null);
	}

	
	public void createReportList(JScrollPane js){
		GolfValidationResultViewFactory.createReportList(js, formValidationManager);
	}

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public FormTrxManager getFormTrxManager() {
        return formTrxManager;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}
