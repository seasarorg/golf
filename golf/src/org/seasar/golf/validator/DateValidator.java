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
import org.seasar.golf.form.FormManager;
import com.jgoodies.binding.value.ValueModel;
import org.seasar.golf.validation.Severity;
import org.seasar.golf.validation.ValidationMessage;
import org.seasar.golf.validation.message.SimpleValidationMessage;
import org.seasar.golf.util.ValidationUtil;

/**
 *
 * @author shimura
 */
public class DateValidator extends AbstractValidator{
    
    private Integer minRelativeDate = null;
    private Integer maxRelativeDate = null;
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

    public ValidationMessage validate(Object data, String label, Object key, ValueModel valueModel, 
            FormManager formManager, boolean requiredCheck) {
        String newDataS = null;
        String dataS = getDataString(data);
        if (dataS.length() == 0) {
            return null;
        }
        String displayLabel = getDisplayLabel(label);

        Date dd = null;
        try {
           dd = parseFormat.parse(dataS);
           newDataS = displayFormat.format(dd);

           if (!dataS.equals(newDataS)) {
               ValidationUtil.updateValueModelWithoutValidation(formManager, valueModel, key, newDataS);
           }

        } catch (ParseException ex) {
            return new SimpleValidationMessage(displayLabel + getMessage(0, dataS), Severity.ERROR, key );
        }
        int rdate = ValidationUtil.getRelativeToToday(dd);
        if (minRelativeDate != null) {
            if (rdate < minRelativeDate) {
                 return new SimpleValidationMessage(displayLabel + 
                        getMessage(1, displayFormat.format(ValidationUtil.getRelativeToToday(minRelativeDate)) ,
                         newDataS), Severity.ERROR, key );
            }
        }
        if (maxRelativeDate != null) {
            if (rdate > maxRelativeDate) {
                 return new SimpleValidationMessage(displayLabel + 
                        getMessage(2, displayFormat.format(ValidationUtil.getRelativeToToday(maxRelativeDate)) ,
                         newDataS), Severity.ERROR, key );
            }
        }        
        
        return null;
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

    public Integer getMinRelativeDate() {
        return minRelativeDate;
    }

    public void setMinRelativeDate(Integer minRelativeDate) {
        this.minRelativeDate = minRelativeDate;
    }

    public Integer getMaxRelativeDate() {
        return maxRelativeDate;
    }

    public void setMaxRelativeDate(Integer maxRelativeDate) {
        this.maxRelativeDate = maxRelativeDate;
    }
    
}
