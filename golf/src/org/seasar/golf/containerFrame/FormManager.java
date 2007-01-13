/*
 * FrameManager.java
 *
 * Created on 2007/01/06, 8:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.containerFrame;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.binding.FormBindingManager;
import org.seasar.golf.data.TableData;
import org.seasar.golf.util.GolfSetting;
import org.seasar.golf.util.TableUtil;
import org.seasar.golf.util.ValidationUtil;
import org.seasar.golf.validator.FormValidationManager;
import org.seasar.golf.validator.GolfValidationResultViewFactory;
import org.seasar.golf.validator.GolfValidator;
import org.seasar.golf.validator.ValidatorDef;

import com.jgoodies.binding.adapter.Bindings;

/**
 *
 * @author shimura
 */
public class FormManager {
    private FormBindingManager formBindingManager = new FormBindingManager();
    private FormValidationManager formValidationManager = new FormValidationManager();
    private JFrame frame;
    private Hashtable componentNameIndex = new Hashtable();
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
	public Hashtable getComponentNameIndex() {
		return componentNameIndex;
	}
	public Object getValue(String name) {
		return formBindingManager.getValueModel(name).getValue();
	}
	public void setValidationFromCsvResource(String path) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path);
		setValidationSub(td);
	}
	
	public void setValidationFromCsvResource(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path, charsetName);
		setValidationSub(td);
	}
	public void setValidationFromCsv(String path) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path);
		setValidationSub(td);
	}
	public void setValidationFromCsv(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path, charsetName);	
		setValidationSub(td);
	}
	private void setValidationSub(TableData td) {
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
                        String name = (String) td.getTextAt(i,"name");
                        if (name == null) {
                            return;
                        }                 
			String s =((String) td.getTextAt(i,"validator"));
			GolfValidator v = (s != null && s.length() > 0) ? ValidationUtil.getValidator(s):null;
			boolean required = getBooleanValueFromTable(td, i,"required" );
			formBindingManager.bind(name, v, (String)td.getTextAt(i,"displayname"), required);
		}
		
	}
	public void setBindFromCsvResource(String path) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path);
		setBindSub(td);
	}
	
	public void setBindFromCsvResource(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path, charsetName);
		setBindSub(td);
	}
	public void setBindFromCsv(String path) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path);
		setBindSub(td);
	}
	public void setBindFromCsv(String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path, charsetName);	
		setBindSub(td);
	}
	private void setBindSub(TableData td) {
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
                        String name = (String) td.getTextAt(i,"name");
                        if (name == null) {
                            return;
                        }
			Object jc = getComponentFromName(name);
                        if (jc == null) {
                            throw new IllegalArgumentException("name " +name+ " not found");
                        }
                        
			String smodel = ((String) td.getTextAt(i,"model"));
			formBindingManager.Bind((JComponent)jc, formBindingManager.getValueModel(smodel));
		}
		
	}
	public void SetTableColumnFromCsvResource(
			JTable jt, String tableDisplayName, GolfTableModel gtm, String path) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path);
		SetTableColumnSub(jt, tableDisplayName, gtm, td);
	}
	
	public void SetTableColumnFromCsvResource(JTable jt, String tableDisplayName,
			GolfTableModel gtm, String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadCsvFromResource(td, path, charsetName);
		SetTableColumnSub(jt, tableDisplayName, gtm, td);
	}
	public void SetTableColumnFromCsv(JTable jt, String tableDisplayName,
			GolfTableModel gtm, String path) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path);
		SetTableColumnSub(jt, tableDisplayName, gtm, td);
	}
	public void SetTableColumnFromCsv(JTable jt,  String tableDisplayName,
			GolfTableModel gtm,String path, String charsetName) {
		TableData td = new TableData();
		TableUtil.ReadFromCsv(td, path, charsetName);	
		SetTableColumnSub(jt, tableDisplayName, gtm, td);
	}
	private void SetTableColumnSub(JTable jt, String tableDisplayName, 
			GolfTableModel gtm, TableData td) {
		ColumnDef[] columnDefs = new ColumnDef[td.getRowCount()];
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
                    
                        String field = (String) td.getTextAt(i,"field");
                        if (field == null) {
                            return;
                        }
			boolean canEdit = getBooleanValueFromTable(td, i,"canedit" );
			String clazz = (String) td.getTextAt(i,"class");
			String clazzNew = GolfSetting.getSetting(clazz);
			clazz = (clazzNew != null) ? clazzNew: clazz;
			try {
				columnDefs[i]= new ColumnDef(field, Class.forName(clazz), canEdit);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gtm.setColumnDefs(columnDefs);
		gtm.setJtable(jt, tableDisplayName);
		gtm.setFormValidationManager(formValidationManager);
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
			boolean insCheck = getBooleanValueFromTable(td, i,"inscheck" );
			if (insCheck){
				gtm.getColumnDef(i).setInsertCheckColumn(true);
			}
			String v = (String) td.getTextAt(i,"validator");
			GolfValidator validator = (v != null && v.length() > 0) ?
					ValidationUtil.getValidator(v): null;	
			String displayName = (String) td.getTextAt(i,"displayName");
			if (displayName != null && displayName.length() == 0) {
				displayName = null;
			}
			boolean required = getBooleanValueFromTable(td, i,"required" );
			if (validator != null || required) {
				gtm.getColumnDef(i).setValidatorDef(
					new ValidatorDef(validator,	displayName, required));
			}
			
		}
		
	}
	private boolean getBooleanValueFromTable(TableData td, int i, String fld) {
		String b = ((String) td.getTextAt(i, fld));
		boolean brtn = false;
		if (b != null && b.toLowerCase().equals("t")) {
			brtn = true;
		}
		return brtn;
	}
	
	public void createReportList(JScrollPane js){
		GolfValidationResultViewFactory.createReportList(js, formValidationManager);
	}
}
