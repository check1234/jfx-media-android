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

package com.sun.scenario.effect.impl.sw.java;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.FloatMap;
import com.sun.scenario.effect.ImageData;
import com.sun.scenario.effect.Blend;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.HeapImage;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;

public class JSWBlend_ADDPeer extends JSWEffectPeer  {

    public JSWBlend_ADDPeer(FilterContext fctx, Renderer r, String uniqueName) {
        super(fctx, r, uniqueName);
    }

    @Override
    protected final Blend getEffect() {
        return (Blend)super.getEffect();
    }


    private float getOpacity() {
        return getEffect().getOpacity();
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
        HeapImage src1 = (HeapImage)inputs[1].getTransformedImage(dstBounds);
        int src1x = 0;
        int src1y = 0;
        int src1w = src1.getPhysicalWidth();
        int src1h = src1.getPhysicalHeight();
        int src1scan = src1.getScanlineStride();
        int[] topImg =
            src1.getPixelArray();
        Rectangle src1Bounds = new Rectangle(src1x, src1y, src1w, src1h);
        Rectangle src1InputBounds = inputs[1].getTransformedBounds(dstBounds);
        BaseTransform src1Transform = BaseTransform.IDENTITY_TRANSFORM;
        setInputBounds(1, src1InputBounds);
        setInputNativeBounds(1, src1Bounds);
        HeapImage src0 = (HeapImage)inputs[0].getTransformedImage(dstBounds);
        int src0x = 0;
        int src0y = 0;
        int src0w = src0.getPhysicalWidth();
        int src0h = src0.getPhysicalHeight();
        int src0scan = src0.getScanlineStride();
        int[] botImg =
            src0.getPixelArray();
        Rectangle src0Bounds = new Rectangle(src0x, src0y, src0w, src0h);
        Rectangle src0InputBounds = inputs[0].getTransformedBounds(dstBounds);
        BaseTransform src0Transform = BaseTransform.IDENTITY_TRANSFORM;
        setInputBounds(0, src0InputBounds);
        setInputNativeBounds(0, src0Bounds);


        float[] src1Rect = new float[4];
        getTextureCoordinates(1, src1Rect,
                              src1InputBounds.x, src1InputBounds.y,
                              src1w, src1h,
                              dstBounds, src1Transform);
        float[] src0Rect = new float[4];
        getTextureCoordinates(0, src0Rect,
                              src0InputBounds.x, src0InputBounds.y,
                              src0w, src0h,
                              dstBounds, src0Transform);


        final int dstx = 0;
        final int dsty = 0;
        final int dstw = dstBounds.width;
        final int dsth = dstBounds.height;

        HeapImage dst = (HeapImage)getRenderer().getCompatibleImage(dstw, dsth);
        setDestNativeBounds(dst.getPhysicalWidth(), dst.getPhysicalHeight());
        int dstscan = dst.getScanlineStride();
        int[] dstPixels = dst.getPixelArray();
        
        int dyi;
        float color_x, color_y, color_z, color_w;

        float opacity = getOpacity();


        float inc1_x = (src1Rect[2] - src1Rect[0]) / dstw;
        float inc1_y = (src1Rect[3] - src1Rect[1]) / dsth;
        float inc0_x = (src0Rect[2] - src0Rect[0]) / dstw;
        float inc0_y = (src0Rect[3] - src0Rect[1]) / dsth;


        float pos1_y = src1Rect[1] + inc1_y*0.5f;
        float pos0_y = src0Rect[1] + inc0_y*0.5f;

        for (int dy = dsty; dy < dsty+dsth; dy++) {
            float pixcoord_y = (float)dy;

            dyi = dy*dstscan;

            float pos1_x = src1Rect[0] + inc1_x*0.5f;
            float pos0_x = src0Rect[0] + inc0_x*0.5f;

            for (int dx = dstx; dx < dstx+dstw; dx++) {
                float pixcoord_x = (float)dx;


                {
                float sample_res_x, sample_res_y, sample_res_z, sample_res_w;
                {
                float loc_tmp_x = pos0_x;
                float loc_tmp_y = pos0_y;
                int botImg_tmp;
                if (loc_tmp_x >= 0 && loc_tmp_y >= 0) {
                    int iloc_tmp_x = (int)(loc_tmp_x*src0w);
                    int iloc_tmp_y = (int)(loc_tmp_y*src0h);
                    boolean out =
                        iloc_tmp_x >= src0w ||
                        iloc_tmp_y >= src0h;
                    botImg_tmp = out ? 0 :
                        botImg[iloc_tmp_y*src0scan + iloc_tmp_x];
                } else {
                    botImg_tmp = 0;
                }
                sample_res_x = (((botImg_tmp >>  16) & 0xff) / 255f);
                sample_res_y = (((botImg_tmp >>   8) & 0xff) / 255f);
                sample_res_z = (((botImg_tmp       ) & 0xff) / 255f);
                sample_res_w = (((botImg_tmp >>> 24)       ) / 255f);

                }
                float bot_x = sample_res_x;
                float bot_y = sample_res_y;
                float bot_z = sample_res_z;
                float bot_w = sample_res_w;
                {
                float loc_tmp_x = pos1_x;
                float loc_tmp_y = pos1_y;
                int topImg_tmp;
                if (loc_tmp_x >= 0 && loc_tmp_y >= 0) {
                    int iloc_tmp_x = (int)(loc_tmp_x*src1w);
                    int iloc_tmp_y = (int)(loc_tmp_y*src1h);
                    boolean out =
                        iloc_tmp_x >= src1w ||
                        iloc_tmp_y >= src1h;
                    topImg_tmp = out ? 0 :
                        topImg[iloc_tmp_y*src1scan + iloc_tmp_x];
                } else {
                    topImg_tmp = 0;
                }
                sample_res_x = (((topImg_tmp >>  16) & 0xff) / 255f);
                sample_res_y = (((topImg_tmp >>   8) & 0xff) / 255f);
                sample_res_z = (((topImg_tmp       ) & 0xff) / 255f);
                sample_res_w = (((topImg_tmp >>> 24)       ) / 255f);

                }
                float top_x = sample_res_x * opacity;
                float top_y = sample_res_y * opacity;
                float top_z = sample_res_z * opacity;
                float top_w = sample_res_w * opacity;
                float blend_add_res_x, blend_add_res_y, blend_add_res_z, blend_add_res_w;
                {
                float bot_tmp_x = bot_x;
                float bot_tmp_y = bot_y;
                float bot_tmp_z = bot_z;
                float bot_tmp_w = bot_w;
                float top_tmp_x = top_x;
                float top_tmp_y = top_y;
                float top_tmp_z = top_z;
                float top_tmp_w = top_w;
                {
                float max_res_x, max_res_y, max_res_z, max_res_w;
                {
                float x_tmp_x = bot_tmp_x * top_tmp_w + top_tmp_x * bot_tmp_w - top_tmp_w * bot_tmp_w;
                float x_tmp_y = bot_tmp_y * top_tmp_w + top_tmp_y * bot_tmp_w - top_tmp_w * bot_tmp_w;
                float x_tmp_z = bot_tmp_z * top_tmp_w + top_tmp_z * bot_tmp_w - top_tmp_w * bot_tmp_w;
                float x_tmp_w = bot_tmp_w * top_tmp_w + top_tmp_w * bot_tmp_w - top_tmp_w * bot_tmp_w;
                float y_tmp = 0.0f;
                max_res_x = (x_tmp_x > y_tmp) ? x_tmp_x : y_tmp;
                max_res_y = (x_tmp_y > y_tmp) ? x_tmp_y : y_tmp;
                max_res_z = (x_tmp_z > y_tmp) ? x_tmp_z : y_tmp;
                max_res_w = (x_tmp_w > y_tmp) ? x_tmp_w : y_tmp;

                }
                float mix_x = max_res_x;
                float mix_y = max_res_y;
                float mix_z = max_res_z;
                float mix_w = max_res_w;
                blend_add_res_x = bot_tmp_x + top_tmp_x - mix_x;
                blend_add_res_y = bot_tmp_y + top_tmp_y - mix_y;
                blend_add_res_z = bot_tmp_z + top_tmp_z - mix_z;
                blend_add_res_w = bot_tmp_w + top_tmp_w - mix_w;
                }

                }
                color_x = blend_add_res_x;
                color_y = blend_add_res_y;
                color_z = blend_add_res_z;
                color_w = blend_add_res_w;
                }


                if (color_w < 0f) color_w = 0f; else if (color_w > 1f) color_w = 1f;
                if (color_x < 0f) color_x = 0f; else if (color_x > color_w) color_x = color_w;
                if (color_y < 0f) color_y = 0f; else if (color_y > color_w) color_y = color_w;
                if (color_z < 0f) color_z = 0f; else if (color_z > color_w) color_z = color_w;
                dstPixels[dyi+dx] =
                    ((int)(color_x * 0xff) << 16) |
                    ((int)(color_y * 0xff) <<  8) |
                    ((int)(color_z * 0xff) <<  0) |
                    ((int)(color_w * 0xff) << 24);

                pos1_x += inc1_x;
                pos0_x += inc0_x;

            }

            pos1_y += inc1_y;
            pos0_y += inc0_y;

        }

        inputs[1].releaseTransformedImage(src1);
        inputs[0].releaseTransformedImage(src0);


        return new ImageData(getFilterContext(), dst, dstBounds);
    }
}
