/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.util.codegen;

import org.ballerinalang.model.types.BType;
import org.ballerinalang.util.codegen.attributes.AttributeInfo;
import org.ballerinalang.util.codegen.attributes.AttributeInfoPool;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a struct field in the compiled Ballerina program.
 *
 * @since 0.90
 */
public class StructFieldInfo implements AttributeInfoPool {
    private int nameCPIndex;
    private String name;

    private int signatureCPIndex;
    private String typeSignature;

    private BType fieldType;

    private Map<AttributeInfo.Kind, AttributeInfo> attributeInfoMap = new HashMap<>();

    public StructFieldInfo(int nameCPIndex, String name, int signatureCPIndex, String typeSignature) {
        this.nameCPIndex = nameCPIndex;
        this.name = name;
        this.signatureCPIndex = signatureCPIndex;
        this.typeSignature = typeSignature;
    }

    public int getNameCPIndex() {
        return nameCPIndex;
    }

    public String getName() {
        return name;
    }

    public int getSignatureCPIndex() {
        return signatureCPIndex;
    }

    public String getTypeDescriptor() {
        return typeSignature;
    }

    public BType getFieldType() {
        return fieldType;
    }

    public void setFieldType(BType fieldType) {
        this.fieldType = fieldType;
    }

    @Override
    public AttributeInfo getAttributeInfo(AttributeInfo.Kind attributeKind) {
        return attributeInfoMap.get(attributeKind);
    }

    @Override
    public void addAttributeInfo(AttributeInfo.Kind attributeKind, AttributeInfo attributeInfo) {
        attributeInfoMap.put(attributeKind, attributeInfo);
    }

    @Override
    public AttributeInfo[] getAttributeInfoEntries() {
        return attributeInfoMap.values().toArray(new AttributeInfo[0]);
    }
}
