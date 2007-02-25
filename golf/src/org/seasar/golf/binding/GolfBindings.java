/*
 * Copyright (c) 2002-2006 JGoodies Karsten Lentzsch. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer. 
 *     
 *  o Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *     
 *  o Neither the name of JGoodies Karsten Lentzsch nor the names of 
 *    its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

package org.seasar.golf.binding;

import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeListenerProxy;
import java.beans.PropertyChangeSupport;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.value.BufferedValueModel;
import com.jgoodies.binding.value.ComponentValueModel;
import com.jgoodies.binding.value.*;
import com.jgoodies.binding.adapter.*;
import org.seasar.golf.component.DoubleField;
import org.seasar.golf.component.LongField;
import org.seasar.golf.component.LongLabel;

/**
 * Consists only of static methods that bind Swing components to ValueModels.
 * This is one of two helper classes that assist you in establishing a binding:
 * 1) this Bindings class binds components that have been created before;
 * it wraps ValueModels with the adapters from package 
 * <code>com.jgoodies.binding.adapter</code>.
 * 2) the BasicComponentFactory creates Swing components that are then
 * bound using this Bindings class.<p>
 * 
 * If you have an existing factory that vends Swing components, 
 * you can use this Bindings class to bind them to ValueModels. 
 * If you don't have such a factory, you can use the BasicComponentFactory 
 * or a custom subclass to create and bind Swing components.<p> 
 * 
 * The binding process for JCheckBox, JRadioButton, and other AbstractButtons
 * retains the former enablement state. Before the new (adapting) model
 * is set, the enablement is requested from the model, not the button.
 * This enablement is set after the new model has been set.<p>
 *  
 * TODO: Consider adding binding methods for JProgressBar, 
 * JSlider, JSpinner, and JTabbedPane.<p>
 * 
 * TODO: Consider adding connection methods for pairs of bean properties.
 * In addition to the PropertyConnector's <code>#connect</code> method,
 * this could add boolean operators such as: not, and, or, nor.
 * 
 * @author  Karsten Lentzsch
 * @version $Revision: 1.11 $
 * 
 * @see com.jgoodies.binding.value.ValueModel
 * @see BasicComponentFactory
 */
public final class GolfBindings
{
    
    /**
     * A JComponent client property key used to store 
     * and retrieve an associated ComponentValueModel.
     * 
     * @see #addComponentPropertyHandler(JComponent, ValueModel)
     * @see #removeComponentPropertyHandler(JComponent)
     * @see ComponentValueModel
     */
    private static final String COMPONENT_VALUE_MODEL_KEY =
        "componentValueModel";

    
    /**
     * A JComponent client property key used to store 
     * and retrieve an associated ComponentPropertyHandler.
     * 
     * @see #addComponentPropertyHandler(JComponent, ValueModel)
     * @see #removeComponentPropertyHandler(JComponent)
     */
    private static final String COMPONENT_PROPERTY_HANDLER_KEY =
        "componentPropertyHandler";
    
    
    /**
     * Triggers a commit in the shared focus lost trigger
     * if focus is lost permanently. Shared among all components
     * that are configured to commit on focus lost.
     * 
     * @see #createCommitOnFocusLostModel(ValueModel, Component)
     */
    static final FocusLostHandler FOCUS_LOST_HANDLER = new FocusLostHandler();
    
    /**
     * Holds a weak trigger that is shared by BufferedValueModels
     * that commit on permanent focus change.
     * 
     * @see #createCommitOnFocusLostModel(ValueModel, Component)
     */
    static final WeakTrigger FOCUS_LOST_TRIGGER = new WeakTrigger();
    
    
    private GolfBindings() {
        // Suppresses default constructor, ensuring non-instantiability.
    }
       public static void bind(LongLabel label, ValueModel valueModel) {
             PropertyConnector connector = 
            new PropertyConnector(valueModel, "value", label, "value");
        connector.updateProperty2();
        
        addComponentPropertyHandler(label, valueModel);      
       }
    
       public static void bind(
            LongField textField, 
            ValueModel valueModel, 
            Document document,
            boolean commitOnFocusLost) {
        if (valueModel == null)
            throw new NullPointerException("The value model must not be null.");
        
        ValueModel textModel = commitOnFocusLost
            ? createCommitOnFocusLostModel(valueModel, textField)
            : valueModel;
        textField.setDocument(new GolfLongDocumentAdapter(
                textModel, 
                document, 
                true /* filterNewlines */));
        
        Bindings.addComponentPropertyHandler(textField, valueModel);
    }
       
    static void bind(
            DoubleField textField, 
            ValueModel valueModel, 
            Document document,
            boolean commitOnFocusLost) {
        if (valueModel == null)
            throw new NullPointerException("The value model must not be null.");
        
        ValueModel textModel = commitOnFocusLost
            ? createCommitOnFocusLostModel(valueModel, textField)
            : valueModel;
        textField.setDocument(new GolfLongDocumentAdapter(
                textModel, 
                document, 
                true /* filterNewlines */));
        
        Bindings.addComponentPropertyHandler(textField, valueModel);        

    }       
    // Binding Methods ********************************************************
    
    
    public static void addComponentPropertyHandler(JComponent component, ValueModel valueModel) {
        if (!(valueModel instanceof ComponentValueModel)) {
            return;
        }
        ComponentValueModel cvm = (ComponentValueModel) valueModel;
        PropertyChangeListener componentHandler = new ComponentPropertyHandler(component);
        cvm.addPropertyChangeListener(componentHandler);
        component.putClientProperty(COMPONENT_VALUE_MODEL_KEY, cvm);
        component.putClientProperty(COMPONENT_PROPERTY_HANDLER_KEY, componentHandler);
        
        component.setEnabled(cvm.isEnabled());
        component.setVisible(cvm.isVisible());
        if (component instanceof JTextComponent) {
            ((JTextComponent) component).setEditable(cvm.isEditable());
        }
    }
    
    
    /**
     * If the given component holds a ComponentValueModel and 
     * a ComponentPropertyHandler in its client properties,
     * the handler is removed as listener from the model,
     * and the model and handler are removed from the client properties.
     * 
     * @param component
     * 
     * @see #addComponentPropertyHandler(JComponent, ValueModel)
     * @see ComponentValueModel
     * 
     * @since 1.1
     */
    public static void removeComponentPropertyHandler(JComponent component) {
        ComponentValueModel componentValueModel = (ComponentValueModel) component.getClientProperty(
                COMPONENT_VALUE_MODEL_KEY);
        PropertyChangeListener componentHandler = (PropertyChangeListener) component.getClientProperty(
                COMPONENT_PROPERTY_HANDLER_KEY);
        if ((componentValueModel != null) && (componentHandler != null)) {
            componentValueModel.removePropertyChangeListener(componentHandler);
            component.putClientProperty(COMPONENT_VALUE_MODEL_KEY, null);
            component.putClientProperty(COMPONENT_PROPERTY_HANDLER_KEY, null);
        } else if ((componentValueModel == null) && (componentHandler == null)) {
            return;
        } else if (componentValueModel != null) {
            throw new IllegalStateException(
                    "The component has a ComponentValueModel stored, "
                  + "but lacks the ComponentPropertyHandler.");
        } else {
            throw new IllegalStateException(
                    "The component has a ComponentPropertyHandler stored, "
                  + "but lacks the ComponentValueModel.");
        }
    }
    
    
    // Helper Code ************************************************************
    
    /**
     * Creates and returns a ValueModel that commits its value 
     * if the given component looses the focus permanently. 
     * It wraps the underlying ValueModel with a BufferedValueModel 
     * and delays the value commit until this class' shared FOCUS_LOST_TRIGGER
     * commits. This happens, because this class' shared FOCUS_LOST_HANDLER
     * is registered with the specified component. 
     * 
     * @param valueModel  the model that provides the value
     * @param component   the component that looses the focus
     * @return a buffering ValueModel that commits on focus lost
     * 
     * @throws NullPointerException if the value model is <code>null</code>
     */
    private static ValueModel createCommitOnFocusLostModel(
            ValueModel valueModel, 
            Component component) {
        if (valueModel == null)
            throw new NullPointerException("The value model must not be null.");
        
        ValueModel model = new BufferedValueModel(valueModel, FOCUS_LOST_TRIGGER);
        component.addFocusListener(FOCUS_LOST_HANDLER);
        return model;
    }





    // Helper Classes *********************************************************
    
    /** 
     * Triggers a commit event on permanent focus lost.
     */
    private static class FocusLostHandler extends FocusAdapter {
        
        /**
         * Triggers a commit event if the focus lost is permanent.
         * 
         * @param evt   the focus lost event
         */
        public void focusLost(FocusEvent evt) {
            if (!evt.isTemporary())
                FOCUS_LOST_TRIGGER.triggerCommit();
        }
    }
    
    
    /**
     * Listens to property changes in a ComponentValueModel and 
     * updates the associated component state.
     * 
     * @see ComponentValueModel
     */
    private static final class ComponentPropertyHandler implements PropertyChangeListener {
        
        private final JComponent component;
        
        private ComponentPropertyHandler(JComponent component) {
            this.component = component;
        }
        
        public void propertyChange(PropertyChangeEvent evt) {
            String propertyName = evt.getPropertyName();
            ComponentValueModel model = (ComponentValueModel) evt.getSource();
            if (ComponentValueModel.PROPERTYNAME_ENABLED.equals(propertyName)) {
                component.setEnabled(model.isEnabled());
            } else if (ComponentValueModel.PROPERTYNAME_VISIBLE.equals(propertyName)) {
                component.setVisible(model.isVisible());
            } else if (ComponentValueModel.PROPERTYNAME_EDITABLE.equals(propertyName)) {
                ((JTextComponent) component).setEditable(model.isEditable());
            } 
        }
    }
    
    
    // Helper Code for a Weak Trigger *****************************************
    
    /**
     * Unlike the Trigger class, this implementation uses WeakReferences
     * to store value change listeners.
     */
    private static final class WeakTrigger implements ValueModel {

        private final transient WeakPropertyChangeSupport changeSupport;
        
        private Boolean value;
        

        // Instance Creation ******************************************************

        /**
         * Constructs a WeakTrigger set to neutral.
         */
        WeakTrigger() {
            value = null;
            changeSupport = new WeakPropertyChangeSupport(this);
        }
        

        // ValueModel Implementation **********************************************
        
        /**
         * Returns a Boolean that indicates the current trigger state.
         * 
         * @return a Boolean that indicates the current trigger state 
         */
        public Object getValue() {
            return value;
        }

        /**
         * Sets a new Boolean value and rejects all non-Boolean values.
         * Fires no change event if the new value is equal to the 
         * previously set value.<p>
         * 
         * This method is not intended to be used by API users.
         * Instead you should trigger commit and flush events by invoking
         * <code>#triggerCommit</code> or <code>#triggerFlush</code>. 
         * 
         * @param newValue  the Boolean value to be set
         * @throws IllegalArgumentException   if the newValue is not a Boolean
         */
        public void setValue(Object newValue) {
            if ((newValue != null) && !(newValue instanceof Boolean))
                throw new IllegalArgumentException(
                    "Trigger values must be of type Boolean.");
            
            Object oldValue = value;
            value = (Boolean) newValue;
            fireValueChange(oldValue, newValue);
        }


        // Change Management ****************************************************

        /**
         * Registers the given PropertyChangeListener with this model. 
         * The listener will be notified if the value has changed.<p>
         * 
         * The PropertyChangeEvents delivered to the listener have the name 
         * set to "value". In other words, the listeners won't get notified 
         * when a PropertyChangeEvent is fired that has a null object as 
         * the name to indicate an arbitrary set of the event source's 
         * properties have changed.<p>
         * 
         * In the rare case, where you want to notify a PropertyChangeListener
         * even with PropertyChangeEvents that have no property name set,
         * you can register the listener with #addPropertyChangeListener,
         * not #addValueChangeListener.
         *
         * @param listener the listener to add
         * 
         * @see ValueModel
         */
        public void addValueChangeListener(PropertyChangeListener listener) {
            if (listener == null) {
                return;
            }
            changeSupport.addPropertyChangeListener("value", listener);
        }
        

        /**
         * Removes the given PropertyChangeListener from the model.
         *
         * @param listener the listener to remove
         */
        public void removeValueChangeListener(PropertyChangeListener listener) {
            if (listener == null) {
                return;
            }
            changeSupport.removePropertyChangeListener("value", listener);
        }
        
        
        /**
         * Notifies all listeners that have registered interest for
         * notification on this event type.  The event instance 
         * is lazily created using the parameters passed into 
         * the fire method.
         *
         * @param oldValue   the value before the change
         * @param newValue   the value after the change
         * 
         * @see java.beans.PropertyChangeSupport
         */
        private void fireValueChange(Object oldValue, Object newValue) {
            changeSupport.firePropertyChange("value", oldValue, newValue);
        }
        

        // Triggering *************************************************************
        
        /**
         * Triggers a commit event in BufferedValueModels that share this Trigger.
         * Sets the value to <code>Boolean.TRUE</code> and ensures that dependents 
         * are notified about a value change to this new value. Only if necessary 
         * the value is temporarily set to <code>null</code>. This way it minimizes
         * the number of PropertyChangeEvents fired by this Trigger.
         */
        void triggerCommit() {
            if (Boolean.TRUE.equals(getValue()))
                setValue(null);
            setValue(Boolean.TRUE);
        }
        
    }
    
    
    /**
     * Differs from its superclass {@link PropertyChangeSupport} in that it 
     * uses WeakReferences for registering listeners. It wraps registered 
     * PropertyChangeListeners with instances of WeakPropertyChangeListener
     * and cleans up a list of stale references when firing an event.<p>
     * 
     * TODO: Merge this WeakPropertyChangeSupport with the
     * ExtendedPropertyChangeSupport.
     */
    private static final class WeakPropertyChangeSupport extends PropertyChangeSupport {
        
        
        // Instance Creation ******************************************************

        /**
         * Constructs a  WeakPropertyChangeSupport object.
         *
         * @param sourceBean  The bean to be given as the source for any events.
         */
        WeakPropertyChangeSupport(
            Object sourceBean) {
            super(sourceBean);
        }
        
        
        // Managing Property Change Listeners **********************************

        /** {@inheritDoc} */
        public synchronized void addPropertyChangeListener(PropertyChangeListener listener) {
            if (listener == null)
                return;
            if (listener instanceof PropertyChangeListenerProxy) {
                PropertyChangeListenerProxy proxy =
                           (PropertyChangeListenerProxy) listener;
                // Call two argument add method.
                addPropertyChangeListener(proxy.getPropertyName(),
                            (PropertyChangeListener) proxy.getListener());
            } else {
                super.addPropertyChangeListener(new WeakPropertyChangeListener(listener));
            }
        }


        /** {@inheritDoc} */
        public synchronized void addPropertyChangeListener(String propertyName,
                PropertyChangeListener listener) {
            if (listener == null)
                return;
            super.addPropertyChangeListener(propertyName,
                    new WeakPropertyChangeListener(propertyName, listener));
        }

        /** {@inheritDoc} */
        public synchronized void removePropertyChangeListener(PropertyChangeListener listener) {
            if (listener == null)
                return;
            if (listener instanceof PropertyChangeListenerProxy) {
                PropertyChangeListenerProxy proxy =
                            (PropertyChangeListenerProxy) listener;
                // Call two argument remove method.
                removePropertyChangeListener(proxy.getPropertyName(),
                           (PropertyChangeListener) proxy.getListener());
                return;
            }
            PropertyChangeListener[] listeners = getPropertyChangeListeners();
            WeakPropertyChangeListener wpcl;
            for (int i = listeners.length - 1; i >= 0; i--) {
                if (listeners[i] instanceof PropertyChangeListenerProxy)
                    continue;
                wpcl = (WeakPropertyChangeListener) listeners[i];
                if (wpcl.get() == listener) {
                    // TODO: Should we call here the #clear() method of wpcl???
                    super.removePropertyChangeListener(wpcl);
                    break;
                }
            }
        }

        /** {@inheritDoc} */
        public synchronized void removePropertyChangeListener(String propertyName,
                PropertyChangeListener listener) {
            if (listener == null)
                return;
            PropertyChangeListener[] listeners = getPropertyChangeListeners(propertyName);
            WeakPropertyChangeListener wpcl;
            for (int i = listeners.length - 1; i >= 0; i--) {
                wpcl = (WeakPropertyChangeListener) listeners[i];
                if (wpcl.get() == listener) {
                    // TODO: Should we call here the #clear() method of wpcl???
                    super.removePropertyChangeListener(propertyName, wpcl);
                    break;
                }
            }
        }


        // Firing Events **********************************************************

        /**
         * Fires the specified PropertyChangeEvent to any registered listeners.
         * 
         * @param evt  The PropertyChangeEvent object.
         * 
         * @see PropertyChangeSupport#firePropertyChange(PropertyChangeEvent)
         */
        public void firePropertyChange(PropertyChangeEvent evt) {
            cleanUp();
            super.firePropertyChange(evt);
        }
        

        /**
         * Reports a bound property update to any registered listeners.
         *
         * @param propertyName  The programmatic name of the property
         *      that was changed.
         * @param oldValue  The old value of the property.
         * @param newValue  The new value of the property.
         * 
         * @see PropertyChangeSupport#firePropertyChange(String, Object, Object)
         */
        public void firePropertyChange(
            String propertyName,
            Object oldValue,
            Object newValue) {
            cleanUp();
            super.firePropertyChange(propertyName, oldValue, newValue);
        }
        

        static final ReferenceQueue QUEUE = new ReferenceQueue();

        private static void cleanUp() {
            WeakPropertyChangeListener wpcl;
            while ((wpcl = (WeakPropertyChangeListener) QUEUE.poll()) != null) {
                wpcl.removeListener();
            }
        }

        void removeWeakPropertyChangeListener(WeakPropertyChangeListener l) {
            if (l.propertyName == null) {
                super.removePropertyChangeListener(l);
            } else {
                super.removePropertyChangeListener(l.propertyName, l);
            }
        }

        
        /**
         * Wraps a PropertyChangeListener to make it weak.
         */
        private final class WeakPropertyChangeListener extends WeakReference
                implements PropertyChangeListener {

            final String propertyName;

            private WeakPropertyChangeListener(PropertyChangeListener delegate) {
                this(null, delegate);
            }

            private WeakPropertyChangeListener(String propertyName,
                    PropertyChangeListener delegate) {
                super(delegate, QUEUE);
                this.propertyName = propertyName;
            }

            /** {@inheritDoc} */
            public void propertyChange(PropertyChangeEvent evt) {
                PropertyChangeListener delegate = (PropertyChangeListener) get();
                if (delegate != null) {
                    delegate.propertyChange(evt);
                }
            }

            void removeListener() {
                removeWeakPropertyChangeListener(this);
            }
        }
    }
    
    
}
