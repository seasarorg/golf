/*
 * FrameCreator.java
 *
 * Created on 2007/02/10, 9:53
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.seasar.golf.creator;

import org.seasar.framework.container.ComponentCustomizer;
import org.seasar.framework.container.creator.ComponentCreatorImpl;
import org.seasar.framework.container.deployer.InstanceDefFactory;
import org.seasar.framework.convention.NamingConvention;

/**
 *
 * @author shimura
 */
public class DialogCreator extends ComponentCreatorImpl {

    /**
     * Page\u7528\u306E\u30AF\u30EA\u30A8\u30FC\u30BF\u3092\u8FD4\u3057\u307E\u3059\u3002
     * 
     * @param namingConvention
     */
    public DialogCreator(NamingConvention namingConvention) {
        super(namingConvention);
        setNameSuffix("Dialog");
        setInstanceDef(InstanceDefFactory.PROTOTYPE);
       // setExternalBinding(true);
    }

    /**
     * Page\u7528\u306E\u30AB\u30B9\u30BF\u30DE\u30A4\u30B6\u3092\u8FD4\u3057\u307E\u3059\u3002
     * 
     * @return
     */
    public ComponentCustomizer getFrameCustomizer() {
        return getCustomizer();
    }

    /**
     * Page\u7528\u306E\u30AB\u30B9\u30BF\u30DE\u30A4\u30B6\u3092\u8A2D\u5B9A\u3057\u307E\u3059\u3002
     * 
     * @param customizer
     */
    public void setFrameCustomizer(ComponentCustomizer customizer) {
        setCustomizer(customizer);
    }
}
