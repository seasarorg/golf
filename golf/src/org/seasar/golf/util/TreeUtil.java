/*
 * TreeUtil.java
 *
 * Created on 2007/01/15, 23:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.util;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.seasar.framework.util.ResourceUtil;

/**
 *
 * @author shimura
 */
public class TreeUtil {
    private  static String closeIcon=null;
    private  static String openIcon=null;
    private  static String leafIcon=null;    
    
    /** Creates a new instance of TreeUtil */
    private TreeUtil() {
    }
    public static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ResourceUtil.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    } 
    public static void setImageIcon(JTree jt) {
        if (closeIcon == null) {
            closeIcon = GolfSetting.getSetting("close.icon");
        }
        if (openIcon == null) {
            openIcon = GolfSetting.getSetting("open.icon");
        }
        if (leafIcon == null) {
            leafIcon = GolfSetting.getSetting("leaf.icon");
        }        
        ImageIcon ileafIcon = TreeUtil.createImageIcon(leafIcon);
        ImageIcon iopenIcon = TreeUtil.createImageIcon(openIcon);
        ImageIcon icloseIcon = TreeUtil.createImageIcon(closeIcon);        
        if (leafIcon != null) {
            DefaultTreeCellRenderer renderer = 
                new DefaultTreeCellRenderer();
            renderer.setLeafIcon( ileafIcon);
            //renderer.setIcon(leafIcon);
           renderer.setClosedIcon(icloseIcon);
           renderer.setOpenIcon(iopenIcon);
            jt.setCellRenderer(renderer);
        }      
    }

    public static void setCloseIcon(String aCloseIcon) {
        closeIcon = aCloseIcon;
    }

    public static void setOpenIcon(String aOpenIcon) {
        openIcon = aOpenIcon;
    }

    public static void setLeafIcon(String aLeafIcon) {
        leafIcon = aLeafIcon;
    }
}


