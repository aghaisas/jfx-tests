/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.jemmy.samples.lookup;

import org.jemmy.control.Wrap;
import org.jemmy.fx.AppExecutor;
import org.jemmy.fx.Root;
import org.jemmy.timing.State;
import org.junit.After;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author shura
 */
public class LookupSampleBase {
    @BeforeClass
    public static void setUpClass() throws Exception {
        AppExecutor.executeNoBlock(LookupApp.class);
    }
    
    @After
    public void after() throws Exception {
        //this sleep is just for a demo purposes - to see what's on the screen
        Thread.sleep(1000);
    }
    
    public void before() {
        
    }
    
    /**
     * This code *waits* for LookupApp.mouseOverText value to be equal to an
     * expected result. Everything must be waited in UI test and not just 
     * verified. More in synchronization samples.
     * @param text 
     */
    protected void assureMouseOver(String text) {
        Root.ROOT.getEnvironment().getWaiter(Wrap.WAIT_STATE_TIMEOUT).
                ensureValue(text, new State<String>() {

            public String reached() {
                return LookupApp.mouseOverText;
            }
        });
    }
}
