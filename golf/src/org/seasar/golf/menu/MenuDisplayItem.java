/*
 * MenuDisplayItem.java
 *
 * Created on 2007/01/16, 20:32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.menu;

/**
 *
 * @author shimura
 */
public class MenuDisplayItem {
    private String display;
    private String action;
    /** Creates a new instance of MenuDisplayItem */
    public MenuDisplayItem() {
        
    }
    public MenuDisplayItem(String display, String action) {
        this.setDisplay(display);
        this.setAction(action);
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }


    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    public String toString() {
        return display;
    }
    
}
