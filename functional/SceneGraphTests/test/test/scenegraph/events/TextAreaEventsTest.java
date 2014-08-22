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
 */
package test.scenegraph.events;

import org.jemmy.fx.control.TextInputControlDock;
import org.junit.Before;
import org.junit.BeforeClass;
import test.scenegraph.app.ControlEventsApp;
import test.scenegraph.app.ControlEventsApp.Controls;

/**
 *
 * @author Aleksandr Sakharuk
 */
public class TextAreaEventsTest extends EventTestCommon<TextInputControlDock> 
     //   EventTestTextInput
{
    
    @BeforeClass
    public static void rinUI()
    
    {
        ControlEventsApp.main(null);
    }
    
    
    @Override
    @Before
    public void before()
    {
        super.before();
        setControl(Controls.TEXT_AREA);
    }
    
@Override
    protected TextInputControlDock findPrimeDock()
    {
        return new TextInputControlDock(getActiveTabDock().asParent(), 
                ControlEventsApp.CONTROL_ID);
    }
    
    /*
    @Test(timeout = 60000)
    public void onInputMethodTextChanged()
    {
        test(ControlEventsApp.EventTypes.INPUT_METHOD_TEXT_CHANGED, new Command() {

            public void invoke() {
                getPrimeNodeDock().mouse().click();
                getPrimeNodeDock().keyboard().typeChar('i');
                new TextInputControlDock(getActiveTabDock().asParent(), 
                        ControlEventsApp.DRAG_FIELD_ID).mouse().click();
            }
        });
        
    }
    */    
}
