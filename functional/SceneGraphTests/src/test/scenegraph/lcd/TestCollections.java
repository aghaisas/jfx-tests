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
package test.scenegraph.lcd;


import javafx.scene.effect.*;
import javafx.scene.paint.Color;
import test.scenegraph.lcd.actions.EffectTestAction;
import test.scenegraph.lcd.actions.RotateTestAction;
import test.scenegraph.lcd.actions.SizeScaleTestAction;

/**
 *
 * @author Alexander Petrov
 */
public enum TestCollections {

    Size(SizeScaleTestAction.generateSizes(new double[]{
        8, 16, 38.3, 64, 80, 128, 64, 12.5
    })),
    SizeScale(SizeScaleTestAction.generate(new double[]{
        8, 16, 12.5
    }, new double[]{
        2, 4, 3.3
    }, SizeScaleTestAction.ScaleAxis.All)),
    ScaleX(SizeScaleTestAction.generateScales(new double[]{
        2, 2.5, 4, 5, 3.3
    }, SizeScaleTestAction.ScaleAxis.X)),
    ScaleY(SizeScaleTestAction.generateScales(new double[]{
        2, 2.5, 4, 8, 3.3
    }, SizeScaleTestAction.ScaleAxis.Y)),
    ScaleAll(SizeScaleTestAction.generateScales(new double[]{
        2, 2.5, 4, 8, 3.3
    }, SizeScaleTestAction.ScaleAxis.All)),
    Rotate(RotateTestAction.generate(new double[]{
        0, 45, 90, 180, 250, 360, 370
    })),
    Bloom(EffectTestAction.generate(new Bloom(), false)),
    BoxBlur(EffectTestAction.generate(new BoxBlur(), false)),
    ColorAdjust(EffectTestAction.generate(new ColorAdjust(), false)),
    //ColorInput(EffectTestAction.generate(new ColorInput(50, 50, 100, 100, Color.GREEN), false))
    DisplacementMap(EffectTestAction.generate(new DisplacementMap(), false)),
    DropShadow(EffectTestAction.generate(new DropShadow(BlurType.THREE_PASS_BOX, Color.BLACK, 10.0, 0.0, 0.0, 0.0), true)),
    GaussianBlur(EffectTestAction.generate(new GaussianBlur(), false)),
    Glow(EffectTestAction.generate(new Glow(), false)),
    InnerShadow(EffectTestAction.generate(new InnerShadow(), false)),
    Lighting(EffectTestAction.generate(new Lighting(), false)),
    MotionBlur(EffectTestAction.generate(new MotionBlur(), false)),
    PerspectiveTransform(EffectTestAction.generate(
            PerspectiveTransformBuilder.create()
            .ulx(10.0)
            .uly(10.0)
            .urx(100.0)
            .ury(40.0)
            .lrx(100.0)
            .lry(60.0)
            .llx(10.0)
            .lly(90.0)
            .build(), false)),
    Reflection(EffectTestAction.generate(new Reflection(), false)),
    SepiaTone(EffectTestAction.generate(new SepiaTone(), false)),
    Shadow(EffectTestAction.generate(new Shadow(), false))
    ;
    
    private TestAction[] actions;

    private TestCollections(TestAction[] actions) {
        this.actions = actions;
    }

    public TestAction[] getActions() {
        return actions;
    }
}