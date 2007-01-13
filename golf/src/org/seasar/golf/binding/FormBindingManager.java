/*
 * FormBindingManager.java
 *
 * Created on 2007/01/01, 20:38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.binding;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.seasar.golf.component.LongField;
import org.seasar.golf.component.LongLabel;
import org.seasar.golf.containerFrame.FormManager;
import org.seasar.golf.util.ValidationUtil;
import org.seasar.golf.validator.ComponentValidator;
import org.seasar.golf.validator.GolfValidator;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.ValidationResult;

/**
 *
 * @author shimura
 */
public class FormBindingManager implements PropertyChangeListener, ComponentValidator  {
    private Hashtable valueModels = new Hashtable();
    private ArrayList valueModelsSequence = new ArrayList();
    private FormManager formManager= null;
    private Hashtable tableBindHandlers = new Hashtable();

    public FormBindingManager() {
    }

   public void bind(String name) {
        bind (name, null, null, false, null);

    }
    public void bind(String name, GolfValidator validator, String displayName, boolean required) {
         bind(name, validator, displayName, required, null ); 
     }
    public void bind(String name, GolfValidator validator, String displayName, boolean required, Object choice) {
        String valueModelClass = "ValueHolder";
        JComponent jc = formManager.getComponentFromName(name);
        if (jc ==null) {
            throw new IllegalArgumentException("name " + name + " not found");
        }
        if   ((jc instanceof JComboBox)   ||(jc instanceof JList)   )      {
              valueModelClass = "SelectionInList";
        }      
        ValueModel vh = createValueModel(name, validator, displayName, required, valueModelClass);
        vh.addValueChangeListener(this);
        Bind(jc, vh, choice); 

    }
    public void Bind(JComponent jc, ValueModel vm) {
    	Bind(jc, vm, null);
    }
    public void Bind(JComponent jc, ValueModel vm, Object choice) {
//       if (jc instanceof LongLabel) {
//            GolfBindings.bind((LongLabel)jc, vm);
//      }  
//       else 
//           if (jc instanceof LongField) {
//            GolfBindings.bind((LongField)jc, vm, ((LongField)jc).getDocument()  ,true);
//      }   
//       else 
           if (jc instanceof JTextField) {
            Bindings.bind((JTextField)jc, vm, ((JTextField)jc).getDocument()  ,true);
      }
      else if (jc instanceof JCheckBox) {
            Bindings.bind((JCheckBox)jc, vm);
      }
      else if (jc instanceof JCheckBoxMenuItem) {
            Bindings.bind((JCheckBoxMenuItem)jc, vm);
      }
      else if (jc instanceof JColorChooser) {
            Bindings.bind((JColorChooser)jc, vm);
      }
      else if (jc instanceof JFormattedTextField) {
            Bindings.bind((JFormattedTextField)jc, vm);
      }
      else if (jc instanceof JLabel) {
            Bindings.bind((JLabel)jc, vm);
      }
      else if (jc instanceof JTextArea) {
            Bindings.bind((JTextArea)jc, vm, ((JTextArea)jc).getDocument(), true);
      }
       else if (jc instanceof JRadioButton) {
            if (choice == null) {
                throw (new IllegalArgumentException ("choice not set"));
            }
            Bindings.bind((JRadioButton)jc, vm, choice);
      }
      else if (jc instanceof JRadioButtonMenuItem) {
            if (choice == null) {
                throw (new IllegalArgumentException ("choice not set"));
            }
            Bindings.bind((JRadioButtonMenuItem)jc, vm, choice);
      }
      else if (jc instanceof JComboBox) {
            ((SelectionInList)vm).setListModel(((JComboBox)jc).getModel() );
            Bindings.bind((JComboBox)jc, (SelectionInList)vm);
      }
      else if (jc instanceof JList) {
                ((SelectionInList)vm).setListModel(((JList)jc).getModel() );
            Bindings.bind((JList)jc,  (SelectionInList)vm);
      }
      else {
           
          throw (new UnsupportedBindingClassException(jc.getClass().toString()));
      }   	
    }
    public ValueModel createValueModel(String name, GolfValidator validator, String displayName, boolean required, String valueModelClass) {
       ValueModel vh = null;
        if (valueModelClass.equals( "ValueHolder")) {
            vh = new ValueHolder();
        }
        else if (valueModelClass.equals( "SelectionInList")) {
            vh = new SelectionInList();
        }
         else {
            throw (new IllegalArgumentException (valueModelClass));
        }
        ValueModelAndValidatorConnector con = 
                new ValueModelAndValidatorConnector(vh, validator, displayName, required);
        valueModels.put(name, con);
        valueModelsSequence.add(name);
        return vh;
        
    }

    public void propertyChange(PropertyChangeEvent evt) {
            formManager.getFormValidationManager().Validate(false);
    }



    public ValidationResult validate(ValidationResult  validationResult, boolean requiredCheck) {
        ValidationResult vr =  (validationResult == null ) ? new ValidationResult(): validationResult;
        
        for (int i=0; i < valueModelsSequence.size(); i++) {
            String name = (String)valueModelsSequence.get(i);
            ValueModelAndValidatorConnector con = (ValueModelAndValidatorConnector) valueModels.get(name);
            
            if (con.getValidatorDef().getValidator() != null || (requiredCheck && con.getValidatorDef().getRequired())) {
                
                vr = ValidationUtil.validate( vr, con.getValidatorDef().getValidator(), con.getValueModel().getValue(),
                    name, con.getValidatorDef().getDisplayName(), formManager.getComponentFromName(name), 
                        requiredCheck && con.getValidatorDef().getRequired(), con.getValueModel(), formManager); 
            }
         }
        return vr;
    }
    public ValueModel getValueModel (String name) {
        try {
            return ((ValueModelAndValidatorConnector)valueModels.get(name)).getValueModel();
        }
        catch (Exception e) {
            throw (new IllegalArgumentException(name +" not found"));
        }
    }
    
     public ValueModelAndValidatorConnector getValueModelAndValidatorConnector (String name) {
        return (ValueModelAndValidatorConnector)valueModels.get(name);
    }

    public FormManager getFrameManager() {
        return formManager;
    }

    public void setFrameManager(FormManager formManager) {
        this.formManager = formManager;
    }
    


    public Hashtable getTableBindHandlers() {
        return tableBindHandlers;
    }
}
