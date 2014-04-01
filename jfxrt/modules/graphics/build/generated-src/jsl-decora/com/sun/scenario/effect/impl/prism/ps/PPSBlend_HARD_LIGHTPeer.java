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
import com.sun.scenario.effect.Blend;
import com.sun.scenario.effect.Effect;
import com.sun.scenario.effect.FilterContext;
import com.sun.scenario.effect.impl.BufferUtil;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.*;
import com.sun.javafx.geom.Rectangle;

public class PPSBlend_HARD_LIGHTPeer extends PPSTwoSamplerPeer  {

    public PPSBlend_HARD_LIGHTPeer(FilterContext fctx, Renderer r, String shaderName) {
        super(fctx, r, shaderName);
    }

    @Override
    protected final Blend getEffect() {
        return (Blend)super.getEffect();
    }


    private float getOpacity() {
        return getEffect().getOpacity();
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
        samplers.put("topImg", 1);
        samplers.put("botImg", 0);

        HashMap<String, Integer> params = new HashMap<String, Integer>();
        params.put("opacity", 0);

        return getRenderer().createShader(getShaderName(), samplers, params,
                                          false);
    }

    @Override
    protected void updateShader(Shader shader) {
        shader.setConstant("opacity", getOpacity());

    }
}
