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

package com.sun.scenario.effect.impl.prism.ps;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import com.sun.prism.ps.Shader;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;

public class PPSLinearConvolveShadowPeer extends PPSOneSamplerPeer implements LinearConvolvePeer {

    public PPSLinearConvolveShadowPeer(FilterContext fctx, Renderer r, String shaderName) {
        super(fctx, r, shaderName);
    }

    @Override
    protected final Effect getEffect() {
        return (Effect)super.getEffect();
    }


    private LinearConvolveKernel getKernel() {
        return (LinearConvolveKernel) AccessHelper.getState(getEffect());
    }

    public int getPow2ScaleX(LinearConvolveKernel kernel) {
        return kernel.getPow2ScaleX();
    }

    public int getPow2ScaleY(LinearConvolveKernel kernel) {
        return kernel.getPow2ScaleY();
    }

    public Rectangle getResultBounds(com.sun.javafx.geom.transform.BaseTransform transform,
                                     com.sun.javafx.geom.Rectangle outputClip,
                                     com.sun.scenario.effect.ImageData... inputDatas)
    {
        return getKernel().getScaledResultBounds(inputDatas[0].getTransformedBounds(outputClip), getPass());
    }

    private int getCount() {
        return (getKernel().getScaledKernelSize(getPass()) + 3) / 4;
    }

    private float[] getOffset() {
        return getKernel().getVector(getInputNativeBounds(0), getInputTransform(0), getPass());
    }

    private FloatBuffer getWeights() {
        return getKernel().getWeights(getPass());
    }

    private int getWeightsArrayLength() {
        return getKernel().getWeightsArrayLength(getPass());
    }

    private float[] getShadowColor() {
        return getKernel().getShadowColorComponents(getPass());
    }

     
    @Override
    protected boolean isSamplerLinear(int i) {
        switch (i) {
        default:
            return false;
        }
    }

    @Override
    protected Shader createShader() {
        HashMap<String, Integer> samplers = new HashMap<String, Integer>();
        samplers.put("img", 0);

        HashMap<String, Integer> params = new HashMap<String, Integer>();
        params.put("count", 0);
        params.put("weights", 3);
        params.put("offset", 1);
        params.put("shadowColor", 2);

        return getRenderer().createShader(getShaderName(), samplers, params,
                                          false);
    }

    @Override
    protected void updateShader(Shader shader) {
        shader.setConstant("count", getCount());
        shader.setConstants("weights", getWeights(), 0, getWeightsArrayLength());
        float[] offset_tmp = getOffset();
        shader.setConstant("offset", offset_tmp[0], offset_tmp[1], offset_tmp[2], offset_tmp[3]);
        float[] shadowColor_tmp = getShadowColor();
        shader.setConstant("shadowColor", shadowColor_tmp[0], shadowColor_tmp[1], shadowColor_tmp[2], shadowColor_tmp[3]);

    }
}
