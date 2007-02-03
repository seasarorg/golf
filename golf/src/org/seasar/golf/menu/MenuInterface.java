/*
 * MenuInterface.java
 *
 * Created on 2007/01/16, 20:07
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.menu;

import javax.swing.JTree;
import java.util.HashMap;

/**
 *
 * @author shimura
 */
public interface MenuInterface {

public boolean createMenu(JTree jt, String role);
public void setAction(HashMap action);
}