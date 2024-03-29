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

package org.seasar.golf.binding;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.seasar.golf.component.DoubleField;
import org.seasar.golf.component.LongField;
import org.seasar.golf.form.FormManager;
import org.seasar.golf.util.ValidationUtil;
import org.seasar.golf.validator.ComponentValidator;
import org.seasar.golf.validator.GolfValidator;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import org.seasar.golf.validation.ValidationResult;

/**
 *
 * @author shimura
 */
public class FormBindingManager implements PropertyChangeListener, ComponentValidator  {
    private HashMap valueModels = new HashMap();
    private ArrayList valueModelsSequence = new ArrayList();
    private FormManager formManager= null;
    private HashMap tableBindHandlers = new HashMap();


    public FormBindingManager() {
    }

   public void bind(String name) {
        bind (name, null, null, false, null, false);

    }
    public void bind(String name, ArrayList <GolfValidator> validators, String displayName, 
                boolean required, Object choice, boolean immed) {
        String valueModelClass = "ValueHolder";
        JComponent jc = formManager.getComponentFromName(name);
        if (jc ==null) {
            throw new IllegalArgumentException("name " + name + " not found");
        }
        if   ((jc instanceof JComboBox)   ||(jc instanceof JList)   )      {
              valueModelClass = "SelectionInList";
        }      
        ValueModel vh = createValueModel(name, validators, displayName, required, valueModelClass);
        vh.addValueChangeListener(this);
        Bind(jc, vh, choice, immed); 

    }
    public void Bind(JComponent jc, ValueModel vm, Object choice, boolean  immed) {

        
     if (jc instanceof DoubleField) {
            GolfBindings.bind((DoubleField)jc, vm, ((DoubleField)jc).getDocument()  ,!immed);
      }         else 
      if (jc instanceof LongField) {
            GolfBindings.bind((LongField)jc, vm, ((LongField)jc).getDocument()  ,!immed);
      }   

 
       else if (jc instanceof JTextField) {
            Bindings.bind((JTextField)jc, vm, ((JTextField)jc).getDocument()  ,!immed);
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
            Bindings.bind((JTextArea)jc, vm, ((JTextArea)jc).getDocument(), !immed);
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
    public ValueModel createValueModel(String name, ArrayList <GolfValidator> validators, String displayName, boolean required, String valueModelClass) {
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
                new ValueModelAndValidatorConnector(vh, validators, displayName, required);
        valueModels.put(name, con);
        valueModelsSequence.add(name);
        return vh;
        
    }

    public void propertyChange(PropertyChangeEvent evt) {
            if ( formManager.getFormValidationManager().isFireValidate()) {
                formManager.getFormValidationManager().Validate(false);
            }
    }



    public ValidationResult validate(ValidationResult  validationResult, boolean requiredCheck) {
        ValidationResult vr =  (validationResult == null ) ? new ValidationResult(): validationResult;
        
        for (int i=0; i < valueModelsSequence.size(); i++) {
            String name = (String)valueModelsSequence.get(i);
            ValueModelAndValidatorConnector con = (ValueModelAndValidatorConnector) valueModels.get(name);
            
            if (con.getValidatorDef().getValidators().size() > 0 || (requiredCheck && con.getValidatorDef().getRequired())) {
                if (con.getValidatorDef().getValidators().size() == 0 ) {
                 vr = ValidationUtil.validate( vr,null , con.getValueModel().getValue(),
                    name, con.getValidatorDef().getDisplayName(), formManager.getComponentFromName(name), 
                        requiredCheck && con.getValidatorDef().getRequired(), con.getValueModel(), formManager);                   
                } else {
                    for(GolfValidator validator:con.getValidatorDef().getValidators()) {
                
                        vr = ValidationUtil.validate( vr, validator, con.getValueModel().getValue(),
                            name, con.getValidatorDef().getDisplayName(), formManager.getComponentFromName(name), 
                                requiredCheck && con.getValidatorDef().getRequired(), con.getValueModel(), formManager); 
                    }
                }
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
    


    public HashMap getTableBindHandlers() {
        return tableBindHandlers;
    }

}
