package org.seasar.golf.util;

import java.io.IOException;
import java.util.Properties;

import org.seasar.framework.util.ResourceUtil;

public class GolfSetting {
	private GolfSetting (){
		
	}
	private static Properties prop = null;
	public static boolean isDebug() {
		checkProp();
		return (getSetting("mode").equals("debug"));
	}
	private static void checkProp() {
		if (prop == null) {
			prop = new Properties();
			try {
				prop.load(ResourceUtil.getResourceAsStream("golf.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static String getSetting(String key) {
		return prop.getProperty(key);
	}
	

}
