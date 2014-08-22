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
package test.scenegraph.fx3d.picking.perspective;

import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import test.javaclient.shared.Utils;
import test.scenegraph.fx3d.picking.ShapesPickingAbstractApp;

/**
 *
 * @author Andrew Glushchenko
 */
public class ShapesPerspectivePickingTestApp extends ShapesPickingAbstractApp {

    @Override
    protected ShapesPickingAbstractTestCase buildShapesTestCase() {
        return new ShapesPerspectivePickingTestCase();
    }

    public class ShapesPerspectivePickingTestCase extends ShapesPickingAbstractTestCase {

        @Override
        protected Camera buildCamera() {
            return new PerspectiveCamera();
        }

        @Override
        public double getXTranslation() {
            return WIDTH / 2;
        }

        @Override
        public double getYTranslation() {
            return HEIGHT / 2;
        }

        @Override
        public double getZTranslation() {
            return 9.7 * SCALE;
        }
    }
     public static void main(String[] args) {
        Utils.launch(ShapesPerspectivePickingTestApp.class, args);
    }
}
