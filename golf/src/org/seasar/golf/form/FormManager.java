/*
 * FrameManager.java
 *
 * Created on 2007/01/06, 8:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.form;

import java.awt.Color;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.Session;
import org.seasar.golf.binding.FormBindingManager;
import org.seasar.golf.data.ResultData;
import org.seasar.golf.transaction.FormTrxManager;
import org.seasar.golf.data.TableData;
import org.seasar.golf.util.TableUtil;
import org.seasar.golf.validator.FormValidationManager;
import org.seasar.golf.validation.view.GolfValidationResultViewFactory;


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
    private ResultData resultData = null;
    private TableData modeControl;
    private Color ineditableBgColor;
    private Color normalBgColor;    
    private String mode;
    private HashMap formData = new HashMap();    
    private JDialog dialog;

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
        ineditableBgColor = FormManagerUtil.getDefaultBgColor("I");
        normalBgColor = FormManagerUtil.getDefaultBgColor("N");        
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
        Object parent = null;
        if (frame != null) {
            parent = frame;
        } else {
            parent = dialog;
        }

    	Field[] fld =parent.getClass().getDeclaredFields();
        for(int i=0; i < fld.length; i++) {
                try {
                        fld[i].setAccessible(true);
                        Object jc = null;
                                    if ((jc = fld[i].get(parent)) instanceof JComponent) {
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
    public void setValue(String name, Object value) {
            formBindingManager.getValueModel(name).setValue(value);
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

    public void setTableColumnFromCsvResource(
                    JTable jt, String tableDisplayName, GolfTableModel gtm, String path) {
            setTableColumnFromCsvResource(jt, tableDisplayName, null, gtm,  path);
    }
    public void setTableColumnFromCsvResource(
                    JTable jt, String tableDisplayName,String hostName, GolfTableModel gtm, String path) {
            TableData td = new TableData();
            TableUtil.ReadCsvFromResource(td, path);
            FormManagerUtil.setTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, hostName);
    }
    public void setTableColumnFromCsvResource(JTable jt, String tableDisplayName,
                GolfTableModel gtm, String path, String charsetName) {
            setTableColumnFromCsvResource(jt, tableDisplayName, gtm, null, path, charsetName);
    }
    public void setTableColumnFromCsvResource(JTable jt, String tableDisplayName,
                    GolfTableModel gtm, String hostName, String path, String charsetName) {
            TableData td = new TableData();
            TableUtil.ReadCsvFromResource(td, path, charsetName);
            FormManagerUtil.setTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, hostName);
    }        
    public void setTableColumnFromCsv(JTable jt, String tableDisplayName,
                    GolfTableModel gtm, String path) {
            TableData td = new TableData();
            TableUtil.ReadFromCsv(td, path);
            FormManagerUtil.setTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, null);
    }
    public void setTableColumnFromCsv(JTable jt,  String tableDisplayName,
                    GolfTableModel gtm,String path, String charsetName) {
            TableData td = new TableData();
            TableUtil.ReadFromCsv(td, path, charsetName);	
            FormManagerUtil.setTableColumnSub(jt, tableDisplayName, gtm, td, formValidationManager, null);
    }

    public void setModeControlFromCsvResource(String path) {
            modeControl = new TableData();
            TableUtil.ReadCsvFromResource(modeControl, path);  

    } 
    
    public void setMode(String mode) {
            FormManagerUtil.setMode(mode, modeControl, this); 
            this.mode = mode;
    }
    
    public String getMode () {
        return mode;
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

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    public Color getIneditableBgColor() {
        return ineditableBgColor;
    }

    public void setIneditableBgColor(Color ineditableBgColor) {
        this.ineditableBgColor = ineditableBgColor;
    }

    public Color getNormalBgColor() {
        return normalBgColor;
    }

    public void setNormalBgColor(Color normalBgColor) {
        this.normalBgColor = normalBgColor;
    }

    public HashMap getFormData() {
        return formData;
    }

    public JDialog getDialog() {
        return dialog;
    }

    public void setDialog(JDialog dialog) {
        this.dialog = dialog;
    }

}
