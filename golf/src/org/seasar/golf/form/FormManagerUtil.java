package org.seasar.golf.form;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.text.JTextComponent;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.ColumnDef;
import org.seasar.golf.GolfFormInterface;
import org.seasar.golf.GolfTableModel;
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
	private static HashMap formHistory = new HashMap();
	public static void generateFieldCsv(FormManager fm) {
		if (GolfSetting.isDebug()) {
			if (!formHistory.containsKey(fm.getFrame().getClass())){
				TableData td = new TableData();
				td.setColumnIdentifires(new String[]{"class","name"});
                                Object[] keys =  fm.getComponentNameIndex().keySet().toArray();
                                for( Object key:keys) {
                                    td.addRow(new String[]{
                                                    fm.getComponentNameIndex().get(key).getClass().toString()
                                                    .substring(6), (String)key });
				
				}
				TableUtil.WriteToCsv(td,
						GolfSetting.getSetting("csvpath") + 
						fm.getFrame().getClass().toString().substring(6)+
						".csv", "ms932");
				String s = GolfSetting.getSetting("csvpath") + 
				fm.getClass().toString().substring(6)+
				".csv";
				formHistory.put(fm.getFrame().getClass(),s);
			}
			
		}
	}
         public  static  GolfFormInterface getFrame(String frameName) {
            return (GolfFormInterface) SingletonS2ContainerFactory.getContainer().getComponent(frameName);
        }
	public static  void setTableColumnSub(JTable jt, String tableDisplayName, 
			GolfTableModel gtm, TableData td, FormValidationManager formValidationManager, String tableHostName) {
		ColumnDef[] columnDefs = new ColumnDef[td.getRowCount()];
                gtm.setHostName(tableHostName);
                formValidationManager.getFormManager().getFormTrxManager().initTable(tableHostName, gtm);
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
                    
                        String field = (String) td.getTextAt(i,"field");
                        if (field == null) {
                            return;
                        }
                        boolean hide = getBooleanValueFromTable(td, i,"canedit","h" );
                        if (hide) {
                            gtm.setColumnCount(Integer.valueOf(i));
                        }
			boolean canEdit = getBooleanValueFromTable(td, i,"canedit","t" );
			String clazz = (String) td.getTextAt(i,"class");
			String clazzNew = GolfSetting.getSetting(clazz);
			clazz = (clazzNew != null) ? clazzNew: clazz;
                        String hostName = (String) td.getTextAt(i,"hostname");
			try {
				columnDefs[i]= new ColumnDef(field, Class.forName(clazz), canEdit,  hostName);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gtm.setColumnDefs(columnDefs);
		gtm.setJtable(jt, tableDisplayName);
		gtm.setFormValidationManager(formValidationManager);
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
			boolean insCheck = getBooleanValueFromTable(td, i,"inscheck","t" );
			if (insCheck){
				gtm.getColumnDef(i).setInsertCheckColumn(true);
			}
			String v = (String) td.getTextAt(i,"validator");
                        ArrayList <GolfValidator> validators = getValidators(v);
			String displayName = (String) td.getTextAt(i,"displayName");
			if (displayName != null && displayName.length() == 0) {
				displayName = null;
			}
			boolean required = getBooleanValueFromTable(td, i,"required","t" );
			if (validators.size()>0 || required) {
				gtm.getColumnDef(i).setValidatorDef(
					new ValidatorDef(validators,	displayName, required));
			}
		}
	}
        
        public static ArrayList <GolfValidator> getValidators (String v){
                String[] vs = v.split(",");
                ArrayList <GolfValidator> validators = new ArrayList <GolfValidator>();
                for(int no=0; no < vs.length; no++) {
                    GolfValidator validator = (vs[no] != null && vs[no].length() > 0) ?
                                    ValidationUtil.getValidator(vs[no]): null;
                    if (validator != null ) {
                        validators.add(validator);
                    }
                }
                return validators;
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
                        String choice = ((String) td.getTextAt(i,"choice"));
                        boolean immed = getBooleanValueFromTable(td, i,"immed","t" );
			formManager.getFormBindingManager().Bind((JComponent)jc, 
                                formManager.getFormBindingManager().getValueModel(smodel), choice, immed);
		}
	}     
	public static  void setValidationSub(TableData td, FormManager formManager) {
		for(int i = 0; i < td.getDataArray().size(); i++ ) {
                        String name = (String) td.getTextAt(i,"name");
                        if (name == null) {
                            return;
                        }                 
			String s =((String) td.getTextAt(i,"validator"));
                        ArrayList <GolfValidator> validators = getValidators(s);                    
			boolean required = getBooleanValueFromTable(td, i,"required","t" );
                        String choice =((String) td.getTextAt(i,"choice"));
                        boolean immed = getBooleanValueFromTable(td, i,"immed","t" );
			formManager.getFormBindingManager().
                                bind(name, validators, (String)td.getTextAt(i,"displayname"), required, choice, immed);
                        String bind =((String) td.getTextAt(i,"hostname"));
                        if (bind != null) {
                            formManager.getFormTrxManager().initField(name, bind);
                        }
		}
	}        
	private static  boolean getBooleanValueFromTable(TableData td, int i, String fld, String value) {
		String b = ((String) td.getTextAt(i, fld));
		boolean brtn = false;
		if (b != null && b.toLowerCase().equals(value)) {
			brtn = true;
		}
		return brtn;
	}         
        public static void setMode(String mode, TableData modeControl, FormManager formManager){
            int modeCol = -1;
            for (modeCol=2; modeCol < modeControl.getColumnCount(); modeCol++){
                if (((String)modeControl.getColumnName(modeCol)).equals(mode.toUpperCase())) {
                    break;
                }
            }
            if (modeCol == modeControl.getColumnCount()) {
                throw new RuntimeException("MODE " + mode+ " not defined in modeControl");
            }
            for (int row=0; row < modeControl.getRowCount(); row++) {
                setFieldAttr((String)modeControl.getValueAt(row, modeCol), 
                        (String)modeControl.getValueAt(row, 1), formManager);                
            }          
        } 
        public static void setFieldAttr(String attr, String field, FormManager formManager ) {
            JComponent jc = formManager.getComponentFromName(field);
            if (jc==null) {
                throw new RuntimeException("Component " + field+ " not defined");
            }
            jc.setVisible(true);
            jc.setEnabled(true);

            if (jc instanceof JTextComponent) {
                ((JTextComponent)jc).setEditable(true);
                jc.setBackground(formManager.getNormalBgColor());
            }
        
            if (attr.toUpperCase().indexOf("I") != -1){
                jc.setVisible(false);
            }
            if (attr.toUpperCase().indexOf("D") != -1){
                jc.setEnabled(false);
            }
            if (attr.toUpperCase().indexOf("R") != -1){
                if (jc instanceof JTextComponent) {
                    ((JTextComponent)jc).setEditable(false);
                    jc.setBackground(formManager.getIneditableBgColor());
                }
            }            
        }

    static Color getDefaultBgColor(String mode) {
        String setting = (mode.equals("N") )? GolfSetting.getSetting("normal.bgcolor")
         :   GolfSetting.getSetting("ineditable.bgcolor");
        String [] color = setting.split(",");
        Integer i1 = Integer.parseInt(color[0]);
        Integer i2 = Integer.parseInt(color[1]);
        Integer i3 = Integer.parseInt(color[2]);       
        return new Color(i1.intValue(),i2.intValue(),i3.intValue());
    }
      
}
