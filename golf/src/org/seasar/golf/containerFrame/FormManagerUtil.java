package org.seasar.golf.containerFrame;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JFrame;
import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.GolfFormInterface;

import org.seasar.golf.data.TableData;
import org.seasar.golf.util.GolfSetting;
import org.seasar.golf.util.TableUtil;

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
}
