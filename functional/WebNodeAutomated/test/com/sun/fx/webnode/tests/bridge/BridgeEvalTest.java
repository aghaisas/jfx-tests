/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation. Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
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

package com.sun.fx.webnode.tests.bridge;

import com.sun.fx.webnode.tests.commonUtils.BridgeTestClass;
import com.sun.fx.webnode.tests.commonUtils.ToolkitInitializer;
import javafx.application.Platform;
import netscape.javascript.JSObject;
import netscape.javascript.JSException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for JSObject.eval method.
 * @author Irina Latysheva
 */
public class BridgeEvalTest extends BridgeTestClass {

    @BeforeClass
    public static void init(){
        test.javaclient.shared.Utils.launch(ToolkitInitializer.class, new String[0]);
    }

    /**
     * Test for simple JSObject.eval call.
     */
    @Test(timeout=10000)
    public void testEval(){
        Platform.runLater(new Runnable() {
            public void run() {
                initWebEngine();
                JSObject winO = getWindow(engine);
                resultObject = winO.eval("(2 + 3) < 7");
                System.out.println(resultObject);
            }
        });
        doWait(new Tester() {
            public boolean isPassed() {
                return (resultObject != null);
            }
        });
        Assert.assertTrue((Boolean)resultObject);
    }

    /**
     * Test for JSObject.eval call with an argument which cannot be evaluated.
     */
    @Test(timeout=10000)
    public void testEvalWrongCode(){
        Platform.runLater(new Runnable() {
            public void run() {
                initWebEngine();
                JSObject winO = getWindow(engine);
                try {
                    winO.eval("asdf");
                } catch (JSException e) {
                    resultObject = Boolean.TRUE;
                }
            }
        });
        doWait(new Tester() {
            public boolean isPassed() {
                return (resultObject != null);
            }
        });
    }
}
