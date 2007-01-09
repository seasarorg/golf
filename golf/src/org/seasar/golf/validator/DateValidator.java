/*
 * StringValidator.java
 *
 * Created on 2007/01/01, 13:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.seasar.golf.GolfTableModel;
import org.seasar.golf.containerFrame.FormManager;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.Severity;
import com.jgoodies.validation.ValidationMessage;
import com.jgoodies.validation.message.SimpleValidationMessage;

/**
 *
 * @author shimura
 */
public class DateValidator extends AbstractValidator{
    
    private Integer minLength = null;
    private Integer maxLength = null;
    private DateFormat formatShort = DateFormat.getDateInstance(DateFormat.SHORT);
    private DateFormat formatLong  = DateFormat.getDateInstance(DateFormat.LONG);
    public DateValidator() {
        messageKey = new String[] { 
            "org.seasar.golf.validator.DateValidator.INVALID",
            "org.seasar.golf.validator.DateValidator.MINIMUM",
            "org.seasar.golf.validator.DateValidator.MAXIMUM"};        
    }
    private DateFormat parseFormat = formatShort; 
    private DateFormat displayFormat =formatShort; 

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, FormManager formManager) {
        String dataS = getDataString(data);
        if (dataS.length() == 0) {
            return null;
        }
        String displayLabel = getDisplayLabel(label);

        Date dd = null;
        try {
           dd = parseFormat.parse(dataS);
           String newDataS = displayFormat.format(dd);

           if (!dataS.equals(newDataS)) {
                if (valueModel != null)    {
                    valueModel.setValue(newDataS);
                } else if (key instanceof JTableFieldInfo) {
                   JTable jt = ((JTableFieldInfo)key).getJtable();
                   TableModel tm = jt.getModel();
                   if (tm instanceof GolfTableModel) {
                       ((GolfTableModel)tm).setValueAt(newDataS,  
                               ((JTableFieldInfo)key).getRow(), ((JTableFieldInfo)key).getColumn());
                   }
                }
           }

        } catch (ParseException ex) {
            return new SimpleValidationMessage(displayLabel + getMessage(0, dataS), Severity.ERROR, key );
        }
        
        return null;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public void setMinLength(Integer minLength) {
        this.minLength = minLength;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    public DateFormat getFormatShort() {
        return formatShort;
    }

    public void setFormatShort(DateFormat formatShort) {
        this.formatShort = formatShort;
    }

    public DateFormat getFormatLong() {
        return formatLong;
    }

    public void setFormatLong(DateFormat formatLong) {
        this.formatLong = formatLong;
    }

    public String getParseFormat() {
        return getFormatSub(parseFormat);
    }
    
    public String getFormatSub(DateFormat df) {
          if (df == formatShort) {
            return "S";
        }   else {
           return "L";
        }      
    }

    public void setParseFormat(String type) {
         if (type.toUpperCase().equals("L")) {
             parseFormat = formatLong;
        } else if (type.toUpperCase().equals("S")) {
             parseFormat = formatShort;
        } else {
            throw (new IllegalArgumentException("parse Format should be L or S"));
        }  
    }
    
    public String getDisplayFormat() {
         return getFormatSub(displayFormat);
    }

    public void setDisplayFormat(String type) {
         if (type.toUpperCase().equals("L")) {
             displayFormat = formatLong;
        } else if (type.toUpperCase().equals("S")) {  
             displayFormat =  formatShort;
        } else {
            throw (new IllegalArgumentException("display Format should be L or S"));
        } 
    }
    
}
