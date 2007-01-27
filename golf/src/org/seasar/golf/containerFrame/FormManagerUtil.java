package org.seasar.golf.containerFrame;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JComponent;

import javax.swing.JFrame;
import javax.swing.JTable;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfFormInterface;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.binding.FormBindingManager;

import org.seasar.golf.data.TableData;
import org.seasar.golf.util.GolfSetting;
import org.seasar.golf.util.TableUtil;
import org.seasar.golf.util.ValidationUtil;
import org.seasar.golf.validator.FormValidationManager;
import org.seasar.golf.validator.GolfValidator;
import org.seasar.golf.validator.ValidatorDef;

public class FormManagerUtil {

	private FormManagerUtil() {
	}
	private static Hashtable formHistory = new Hashtable();
	public static void generateFieldCsv(FormManager fm) {
		if (GolfSetting.isDebug()) {
			if (!formHistory.containsKey(fm.getFrame().getClass())){
				TableData td = new TableData();
				td.setColumnIdentifires(new String[]{"class","name"});
				Enumeration e = fm.getComponentNameIndex().keys();
				while (e.hasMoreElements()){
					String key = (String) e.nextElement();
					td.addRow(new String[]{
							fm.getComponentNameIndex().get(key).getClass().toString()
							.substring(6), key });
				
				}
				TableUtil.WriteToCsv(td,
						GolfSetting.getSetting("csvpath") + 
						fm.getFrame().getClass().toString().substring(6)+
						".csv", "ms932");
				String s = GolfSetting.getSetting("csvpath") + 
				fm.getClass().toString().substring(6)+
				".csv";
				formHistory.put(fm.getFrame().getClass(),"");
			}
			
		}
	}
         public  static  GolfFormInterface getFrame(String frameName) {
            return (GolfFormInterface) SingletonS2ContainerFactory.getContainer().getComponent(frameName);
        }
	public static  void SetTableColumnSub(JTable jt, String tableDisplayName, 
			GolfTableModel gtm, TableData td, FormValidationManager formValidationManager) {
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
	public static void setBindSub(TableData td, FormManager formManager) {
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
                        String name = (String) td.getTextAt(i,"name");
                        if (name == null) {
                            return;
                        }
			Object jc = formManager.getComponentFromName(name);
                        if (jc == null) {
                            throw new IllegalArgumentException("name " +name+ " not found");
                        }
                        
			String smodel = ((String) td.getTextAt(i,"model"));
			formManager.getFormBindingManager().Bind((JComponent)jc, 
                                formManager.getFormBindingManager().getValueModel(smodel));
		}
		
	}     
	public static  void setValidationSub(TableData td, FormBindingManager formBindingManager) {
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
	private static  boolean getBooleanValueFromTable(TableData td, int i, String fld) {
		String b = ((String) td.getTextAt(i, fld));
		boolean brtn = false;
		if (b != null && b.toLowerCase().equals("t")) {
			brtn = true;
		}
		return brtn;
	}         
}
