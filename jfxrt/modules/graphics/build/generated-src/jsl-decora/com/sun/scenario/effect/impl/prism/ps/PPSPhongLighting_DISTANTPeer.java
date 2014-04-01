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
import com.sun.scenario.effect.PhongLighting;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;

public class PPSPhongLighting_DISTANTPeer extends PPSTwoSamplerPeer  {

    public PPSPhongLighting_DISTANTPeer(FilterContext fctx, Renderer r, String shaderName) {
        super(fctx, r, shaderName);
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
    protected boolean isSamplerLinear(int i) {
        switch (i) {
        default:
            return false;
        }
    }

    @Override
    protected Shader createShader() {
        HashMap<String, Integer> samplers = new HashMap<String, Integer>();
        samplers.put("bumpImg", 0);
        samplers.put("origImg", 1);

        HashMap<String, Integer> params = new HashMap<String, Integer>();
        params.put("normalizedLightPosition", 12);
        params.put("diffuseConstant", 0);
        params.put("lightColor", 3);
        params.put("kvals", 4);
        params.put("specularConstant", 1);
        params.put("specularExponent", 2);

        return getRenderer().createShader(getShaderName(), samplers, params,
                                          false);
    }

    @Override
    protected void updateShader(Shader shader) {
        float[] normalizedLightPosition_tmp = getNormalizedLightPosition();
        shader.setConstant("normalizedLightPosition", normalizedLightPosition_tmp[0], normalizedLightPosition_tmp[1], normalizedLightPosition_tmp[2]);
        shader.setConstant("diffuseConstant", getDiffuseConstant());
        float[] lightColor_tmp = getLightColor();
        shader.setConstant("lightColor", lightColor_tmp[0], lightColor_tmp[1], lightColor_tmp[2]);
        shader.setConstants("kvals", getKvals(), 0, getKvalsArrayLength());
        shader.setConstant("specularConstant", getSpecularConstant());
        shader.setConstant("specularExponent", getSpecularExponent());

    }
}