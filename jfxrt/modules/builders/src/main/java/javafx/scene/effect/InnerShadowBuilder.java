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

package javafx.scene.effect;

/**
Builder class for javafx.scene.effect.InnerShadow
@see javafx.scene.effect.InnerShadow
@deprecated This class is deprecated and will be removed in the next version
* @since JavaFX 2.0
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class InnerShadowBuilder<B extends javafx.scene.effect.InnerShadowBuilder<B>> implements javafx.util.Builder<javafx.scene.effect.InnerShadow> {
    protected InnerShadowBuilder() {
    }
    
    /** Creates a new instance of InnerShadowBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.effect.InnerShadowBuilder<?> create() {
        return new javafx.scene.effect.InnerShadowBuilder();
    }
    
    private int __set;
    private void __set(int i) {
        __set |= 1 << i;
    }
    public void applyTo(javafx.scene.effect.InnerShadow x) {
        int set = __set;
        while (set != 0) {
            int i = Integer.numberOfTrailingZeros(set);
            set &= ~(1 << i);
            switch (i) {
                case 0: x.setBlurType(this.blurType); break;
                case 1: x.setChoke(this.choke); break;
                case 2: x.setColor(this.color); break;
                case 3: x.setHeight(this.height); break;
                case 4: x.setInput(this.input); break;
                case 5: x.setOffsetX(this.offsetX); break;
                case 6: x.setOffsetY(this.offsetY); break;
                case 7: x.setRadius(this.radius); break;
                case 8: x.setWidth(this.width); break;
            }
        }
    }
    
    private javafx.scene.effect.BlurType blurType;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getBlurType() blurType} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B blurType(javafx.scene.effect.BlurType x) {
        this.blurType = x;
        __set(0);
        return (B) this;
    }
    
    private double choke;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getChoke() choke} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B choke(double x) {
        this.choke = x;
        __set(1);
        return (B) this;
    }
    
    private javafx.scene.paint.Color color;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getColor() color} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B color(javafx.scene.paint.Color x) {
        this.color = x;
        __set(2);
        return (B) this;
    }
    
    private double height;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getHeight() height} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B height(double x) {
        this.height = x;
        __set(3);
        return (B) this;
    }
    
    private javafx.scene.effect.Effect input;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getInput() input} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B input(javafx.scene.effect.Effect x) {
        this.input = x;
        __set(4);
        return (B) this;
    }
    
    private double offsetX;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getOffsetX() offsetX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B offsetX(double x) {
        this.offsetX = x;
        __set(5);
        return (B) this;
    }
    
    private double offsetY;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getOffsetY() offsetY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B offsetY(double x) {
        this.offsetY = x;
        __set(6);
        return (B) this;
    }
    
    private double radius;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getRadius() radius} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B radius(double x) {
        this.radius = x;
        __set(7);
        return (B) this;
    }
    
    private double width;
    /**
    Set the value of the {@link javafx.scene.effect.InnerShadow#getWidth() width} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B width(double x) {
        this.width = x;
        __set(8);
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.effect.InnerShadow} based on the properties set on this builder.
    */
    public javafx.scene.effect.InnerShadow build() {
        javafx.scene.effect.InnerShadow x = new javafx.scene.effect.InnerShadow();
        applyTo(x);
        return x;
    }
}
