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
package test.scenegraph.functional.controls.events;

import javafx.geometry.Bounds;
import org.jemmy.Point;
import org.jemmy.fx.control.ControlDock;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import test.scenegraph.app.ControlEventsApp;
import test.scenegraph.app.ControlEventsApp.Controls;

/**
 *
 * @author Aleksandr Sakharuk
 */
public class ColorPickerEventsTest extends EventTestHidingPopup<ControlDock>
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
        setControl(Controls.COLOR_PICKER);
    }
    
    @Override
    protected ControlDock findPrimeDock()
    {
        return new ControlDock(getActiveTabDock().asParent(), 
                ControlEventsApp.CONTROL_ID);
    }
    
    @Override
    @Test(timeout = 30000)
    public void onAction()
    {
        test(ControlEventsApp.EventTypes.ACTION, new Command() {

            public void invoke() {
                getPrimeNodeDock().mouse().click();
                //
                try { Thread.sleep(300);} catch(Exception e) {}
                Bounds bounds = getPrimeNodeDock().getBoundsInLocal();
                double x = bounds.getWidth() / 2;
                double y = bounds.getHeight() * 2;
                getPrimeNodeDock().mouse().click(1,new Point(x, y));
            }
        });
    }
    
}
