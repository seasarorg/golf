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

package org.seasar.golf.data;

import java.util.HashMap;

/**
 *
 * @author shimura
 */
public class DataUtil {
    
    /** Creates a new instance of DataUtil */
    private DataUtil() {
    }
    public static void copyParam(HashMap from, HashMap to, String key) {
        to.put(key, from.get(key));
        
    }
}
