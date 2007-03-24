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

package org.seasar.golf.uexample.util.factory;

import org.seasar.framework.container.factory.SingletonS2ContainerFactory;
import org.seasar.golf.uexample.logic.LoginLogic;

/**
 *
 * @author shimura
 */
public class UexampleFactory {
    
    /** Creates a new instance of UexampleFactory */
    private UexampleFactory() {
    }
    public static LoginLogic getLogin() {
        return (LoginLogic) SingletonS2ContainerFactory.getContainer().getComponent(LoginLogic.class);
    }

    
}
