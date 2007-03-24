/*
 * Copyright 2004-2007 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.golf.util;

import java.io.IOException;
import java.util.Properties;
import javax.swing.UnsupportedLookAndFeelException;
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
                checkProp();
		return prop.getProperty(key);
	}
        public static void setLookAndFeel(){
    //javax.swing.UIManager$LookAndFeelInfo[Metal javax.swing.plaf.metal.MetalLookAndFeel]
    //javax.swing.UIManager$LookAndFeelInfo[CDE/Motif com.sun.java.swing.plaf.motif.MotifLookAndFeel]
    //javax.swing.UIManager$LookAndFeelInfo[Windows com.sun.java.swing.plaf.windows.WindowsLookAndFeel]
    //javax.swing.UIManager$LookAndFeelInfo[Windows Classic com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel]        
            try     {
                javax.swing.UIManager.setLookAndFeel(getSetting("LookAndFeel"));

            }
            catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                                 ex.getMessage(), ex);
            }
            catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                                 ex.getMessage(), ex);
            }
            catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                                 ex.getMessage(), ex);
            }
            catch (UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE,
                                                                 ex.getMessage(), ex);
            }            
        }
	

}
