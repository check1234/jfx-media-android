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

package javafx.animation;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class RateTestBack_Test extends RateTestBase {

    public RateTestBack_Test() {
        super("Test behavior of Timeline.rate (except toggling) in backward direction");
    }

    @Before public void setUp() {
    }

    @Ignore // TODO: Activate once this was fixed
    @Test public void test() {
        doTest();
    }

    @Override protected void startTimeline() {
        set.timeline.playBackward();
    }

    @Override protected void checkHalf() {
        // Should be just past halfway through
        set.check(2, 3, true);
    }

    @Override protected void checkDone(boolean infinite) {
        // TL should be finished
        if (infinite) {
            set.check(5, 4, true);
        } else {
            set.check(4, 4, false, 0, 0);
        }
    }


    @After public void cleanUp() {
        set.timeline.stop();
    }
}
