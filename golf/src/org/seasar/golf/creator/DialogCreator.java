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
