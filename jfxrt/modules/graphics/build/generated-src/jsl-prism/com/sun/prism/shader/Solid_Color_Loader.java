/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
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
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/*
 * This file was generated by JSLC -- DO NOT EDIT MANUALLY!
 */

package com.sun.prism.shader;

import java.io.InputStream;
import java.util.HashMap;
import com.sun.prism.ps.Shader;
import com.sun.prism.ps.ShaderFactory;

public class Solid_Color_Loader {

    private Solid_Color_Loader() {
    }

    public static Shader loadShader(ShaderFactory factory,
                                    InputStream pixelShaderCode)
    {
        HashMap<String, Integer> samplers = new HashMap<String, Integer>();
        HashMap<String, Integer> params = new HashMap<String, Integer>();
        return factory.createShader(pixelShaderCode, samplers, params,
                                    -1,
                                    false, true);
    }
}
