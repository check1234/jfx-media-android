/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.oracle.javafx.scenebuilder.kit.metadata.property.value.keycombination;

import com.oracle.javafx.scenebuilder.kit.fxom.FXOMInstance;
import com.oracle.javafx.scenebuilder.kit.metadata.property.value.ComplexPropertyMetadata;
import com.oracle.javafx.scenebuilder.kit.metadata.property.value.EnumerationPropertyMetadata;
import com.oracle.javafx.scenebuilder.kit.metadata.property.value.StringPropertyMetadata;
import com.oracle.javafx.scenebuilder.kit.metadata.util.InspectorPath;
import com.oracle.javafx.scenebuilder.kit.metadata.util.PropertyName;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyCombination;

/**
 *
 */
public class KeyCharacterCombinationPropertyMetadata extends ComplexPropertyMetadata<KeyCharacterCombination> {
    
    /*
     * NOTE : KeyCharacterCombination singularity
     * 
     * Same as KeyCodeCombination => see comments in KeyCodeCombination
     */
    private static final String DUMMY = "dummy"; //NOI18N

    private final EnumerationPropertyMetadata altMetadata
            = new EnumerationPropertyMetadata(new PropertyName("alt"), //NOI18N
            KeyCombination.ModifierValue.class, DUMMY, true, 
            InspectorPath.UNUSED);
    private final EnumerationPropertyMetadata controlMetadata
            = new EnumerationPropertyMetadata(new PropertyName("control"), //NOI18N
            KeyCombination.ModifierValue.class, DUMMY, true, 
            InspectorPath.UNUSED);
    private final EnumerationPropertyMetadata metaMetadata
            = new EnumerationPropertyMetadata(new PropertyName("meta"), //NOI18N
            KeyCombination.ModifierValue.class, DUMMY, true, 
            InspectorPath.UNUSED);
    private final EnumerationPropertyMetadata shiftMetadata
            = new EnumerationPropertyMetadata(new PropertyName("shift"), //NOI18N
            KeyCombination.ModifierValue.class, DUMMY, true, 
            InspectorPath.UNUSED);
    private final EnumerationPropertyMetadata shortcutMetadata
            = new EnumerationPropertyMetadata(new PropertyName("shortcut"), //NOI18N
            KeyCombination.ModifierValue.class, DUMMY, true, 
            InspectorPath.UNUSED);
    private final StringPropertyMetadata characterMetadata
            = new StringPropertyMetadata(new PropertyName("character"), //NOI18N
            true, null, InspectorPath.UNUSED);

    public KeyCharacterCombinationPropertyMetadata(PropertyName name, boolean readWrite, 
            KeyCharacterCombination defaultValue, InspectorPath inspectorPath) {
        super(name, KeyCharacterCombination.class, readWrite, defaultValue, inspectorPath);
    }

    @Override
    protected KeyCharacterCombination castValue(Object value) {
        return (KeyCharacterCombination) value;
    }
    
    @Override
    protected void updateFxomInstanceWithValue(FXOMInstance valueInstance, KeyCharacterCombination value) {
        altMetadata.setValue(valueInstance, value.getAlt().toString());
        controlMetadata.setValue(valueInstance, value.getControl().toString());
        metaMetadata.setValue(valueInstance, value.getMeta().toString());
        shiftMetadata.setValue(valueInstance, value.getShift().toString());
        shortcutMetadata.setValue(valueInstance, value.getShortcut().toString());
        characterMetadata.setValue(valueInstance, value.getCharacter());
    }
    
}
