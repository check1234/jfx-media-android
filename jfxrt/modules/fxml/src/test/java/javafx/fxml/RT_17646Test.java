/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.fxml;

import java.io.IOException;
import org.junit.Test;

import static org.junit.Assert.*;

public class RT_17646Test {
    @Test(expected=LoadException.class)
    public void testBidirectionalBinding() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("rt_17646.fxml"));

        Widget widget = (Widget)fxmlLoader.load();
        RT_17646Controller controller = (RT_17646Controller)fxmlLoader.getController();
        assertEquals(widget.getName(), controller.getName());

        String name1 = "efgh";
        controller.setName(name1);
        assertEquals(widget.getName(), name1);

        String name2 = "ijkl";
        widget.setName(name2);
        assertEquals(controller.getName(), name2);
    }
}
