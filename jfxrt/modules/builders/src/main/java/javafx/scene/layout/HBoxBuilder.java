/* 
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package javafx.scene.layout;

/**
Builder class for javafx.scene.layout.HBox
@see javafx.scene.layout.HBox
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class HBoxBuilder<B extends javafx.scene.layout.HBoxBuilder<B>> extends javafx.scene.layout.PaneBuilder<B> {
    protected HBoxBuilder() {
    }
    
    /** Creates a new instance of HBoxBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.layout.HBoxBuilder<?> create() {
        return new javafx.scene.layout.HBoxBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.layout.HBox x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setAlignment(this.alignment);
        if ((set & (1 << 1)) != 0) x.setFillHeight(this.fillHeight);
        if ((set & (1 << 2)) != 0) x.setSpacing(this.spacing);
    }
    
    private javafx.geometry.Pos alignment;
    /**
    Set the value of the {@link javafx.scene.layout.HBox#getAlignment() alignment} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B alignment(javafx.geometry.Pos x) {
        this.alignment = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private boolean fillHeight;
    /**
    Set the value of the {@link javafx.scene.layout.HBox#isFillHeight() fillHeight} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B fillHeight(boolean x) {
        this.fillHeight = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private double spacing;
    /**
    Set the value of the {@link javafx.scene.layout.HBox#getSpacing() spacing} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B spacing(double x) {
        this.spacing = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.layout.HBox} based on the properties set on this builder.
    */
    public javafx.scene.layout.HBox build() {
        javafx.scene.layout.HBox x = new javafx.scene.layout.HBox();
        applyTo(x);
        return x;
    }
}
