/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

/*
 * This file was generated by JSLC -- DO NOT EDIT MANUALLY!
 */

package com.sun.scenario.effect.impl.sw.sse;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.FloatMap;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.PhongLighting;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.HeapImage;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;

public class SSEPhongLighting_SPOTPeer extends SSEEffectPeer  {

    public SSEPhongLighting_SPOTPeer(FilterContext fctx, Renderer r, String uniqueName) {
        super(fctx, r, uniqueName);
    }

    @Override
    protected final PhongLighting getEffect() {
        return (PhongLighting)super.getEffect();
    }


    private FloatBuffer kvals;

    private float getSurfaceScale() {
        return getEffect().getSurfaceScale();
    }

    private float getDiffuseConstant() {
        return getEffect().getDiffuseConstant();
    }

    private float getSpecularConstant() {
        return getEffect().getSpecularConstant();
    }

    private float getSpecularExponent() {
        return getEffect().getSpecularExponent();
    }

    private float[] getNormalizedLightPosition() {
        return getEffect().getLight().getNormalizedLightPosition();
    }

    private float[] getLightPosition() {
        com.sun.scenario.effect.light.PointLight plight =
            (com.sun.scenario.effect.light.PointLight)getEffect().getLight();
        return new float[] { plight.getX(), plight.getY(), plight.getZ() };
    }

    private float[] getLightColor() {
        return getEffect().getLight().getColor().getPremultipliedRGBComponents();
    }

    private float getLightSpecularExponent() {
        return ((com.sun.scenario.effect.light.SpotLight)getEffect().getLight()).getSpecularExponent();
    }

    private float[] getNormalizedLightDirection() {
        return ((com.sun.scenario.effect.light.SpotLight)getEffect().getLight()).getNormalizedLightDirection();
    }

    private FloatBuffer getKvals() {
        Rectangle bumpImgBounds = getInputNativeBounds(0);
        float xoff = 1f / bumpImgBounds.width;
        float yoff = 1f / bumpImgBounds.height;

        float[] kx = {
            -1, 0, 1,
            -2, 0, 2,
            -1, 0, 1,
        };
        float[] ky = {
            -1, -2, -1,
             0,  0,  0,
             1,  2,  1,
        };
        if (kvals == null) {
            kvals = BufferUtil.newFloatBuffer(8*4);
        }
        kvals.clear();
        int kidx = 0;
        float factor = -getSurfaceScale() * 0.25f;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i != 0 || j != 0) {
                    kvals.put(j*xoff);
                    kvals.put(i*yoff);
                    kvals.put(kx[kidx] * factor);
                    kvals.put(ky[kidx] * factor);
                }
                kidx++;
            }
        }
        kvals.rewind();
        return kvals;
    }

    private int getKvalsArrayLength() {
        return 8;
    }


    @Override
    public ImageData filter(Effect effect,
                            BaseTransform transform,
                            Rectangle outputClip,
                            ImageData... inputs)
    {
        setEffect(effect);
        Rectangle dstBounds = getResultBounds(transform, outputClip, inputs);
        setDestBounds(dstBounds);

        // TODO: for now, all input images must be TYPE_INT_ARGB_PRE
        HeapImage src0 = (HeapImage)inputs[0].getTransformedImage(dstBounds);
        int src0x = 0;
        int src0y = 0;
        int src0w = src0.getPhysicalWidth();
        int src0h = src0.getPhysicalHeight();
        int src0scan = src0.getScanlineStride();
        int[] bumpImg =
            src0.getPixelArray();
        Rectangle src0Bounds = new Rectangle(src0x, src0y, src0w, src0h);
        Rectangle src0InputBounds = inputs[0].getTransformedBounds(dstBounds);
        BaseTransform src0Transform = BaseTransform.IDENTITY_TRANSFORM;
        setInputBounds(0, src0InputBounds);
        setInputNativeBounds(0, src0Bounds);
        HeapImage src1 = (HeapImage)inputs[1].getTransformedImage(dstBounds);
        int src1x = 0;
        int src1y = 0;
        int src1w = src1.getPhysicalWidth();
        int src1h = src1.getPhysicalHeight();
        int src1scan = src1.getScanlineStride();
        int[] origImg =
            src1.getPixelArray();
        Rectangle src1Bounds = new Rectangle(src1x, src1y, src1w, src1h);
        Rectangle src1InputBounds = inputs[1].getTransformedBounds(dstBounds);
        BaseTransform src1Transform = BaseTransform.IDENTITY_TRANSFORM;
        setInputBounds(1, src1InputBounds);
        setInputNativeBounds(1, src1Bounds);


        float[] src0Rect = new float[4];
        getTextureCoordinates(0, src0Rect,
                              src0InputBounds.x, src0InputBounds.y,
                              src0w, src0h,
                              dstBounds, src0Transform);
        float[] src1Rect = new float[4];
        getTextureCoordinates(1, src1Rect,
                              src1InputBounds.x, src1InputBounds.y,
                              src1w, src1h,
                              dstBounds, src1Transform);


        final int dstx = 0;
        final int dsty = 0;
        final int dstw = dstBounds.width;
        final int dsth = dstBounds.height;

        HeapImage dst = (HeapImage)getRenderer().getCompatibleImage(dstw, dsth);
        setDestNativeBounds(dst.getPhysicalWidth(), dst.getPhysicalHeight());
        int dstscan = dst.getScanlineStride();
        int[] dstPixels = dst.getPixelArray();
        
        float diffuseConstant = getDiffuseConstant();
        FloatBuffer kvals_buf = getKvals();
        float[] kvals_arr = new float[kvals_buf.capacity()];
        kvals_buf.get(kvals_arr);
        float[] lightColor_arr = getLightColor();
        float[] lightPosition_arr = getLightPosition();
        float lightSpecularExponent = getLightSpecularExponent();
        float[] normalizedLightDirection_arr = getNormalizedLightDirection();
        float specularConstant = getSpecularConstant();
        float specularExponent = getSpecularExponent();
        float surfaceScale = getSurfaceScale();


        filter(dstPixels, dstx, dsty, dstw, dsth, dstscan,
bumpImg,
src0Rect[0], src0Rect[1],
src0Rect[2], src0Rect[3],
src0w, src0h, src0scan,
diffuseConstant,
kvals_arr,
lightColor_arr[0], lightColor_arr[1], lightColor_arr[2],
lightPosition_arr[0], lightPosition_arr[1], lightPosition_arr[2],
lightSpecularExponent,
normalizedLightDirection_arr[0], normalizedLightDirection_arr[1], normalizedLightDirection_arr[2],
origImg,
src1Rect[0], src1Rect[1],
src1Rect[2], src1Rect[3],
src1w, src1h, src1scan,
specularConstant,
specularExponent,
surfaceScale);

        inputs[0].releaseTransformedImage(src0);
        inputs[1].releaseTransformedImage(src1);


        return new ImageData(getFilterContext(), dst, dstBounds);
    }

    private static native void filter(int[] dstPixels,
                                      int dstx, int dsty,
                                      int dstw, int dsth,
                                      int dstscan,
int[] bumpImg_arr,
float src0Rect_x1, float src0Rect_y1,
float src0Rect_x2, float src0Rect_y2,
int src0w, int src0h, int src0scan,
float diffuseConstant,
float[] kvals,
float lightColor_x, float lightColor_y, float lightColor_z,
float lightPosition_x, float lightPosition_y, float lightPosition_z,
float lightSpecularExponent,
float normalizedLightDirection_x, float normalizedLightDirection_y, float normalizedLightDirection_z,
int[] origImg_arr,
float src1Rect_x1, float src1Rect_y1,
float src1Rect_x2, float src1Rect_y2,
int src1w, int src1h, int src1scan,
float specularConstant,
float specularExponent,
float surfaceScale);
}
