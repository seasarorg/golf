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

package org.seasar.golf.validator;

import java.io.Serializable;

/**
 *
 * @author shimura
 */
public class HostTableFieldInfo implements Serializable{
    private String hostTtable;
    private int row;
    private String column;

    public  HostTableFieldInfo() {
    }
    public HostTableFieldInfo (
    String hostTtable,
    int row,
    String column)
    {
        this.hostTtable = hostTtable;
        this.row = row;
        this.column = column;
    }

    public String getHostTtable() {
        return hostTtable;
    }

    public void setHostTtable(String hostTtable) {
        this.hostTtable = hostTtable;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
   
}
