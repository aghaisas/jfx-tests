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
package test.css.controls.styles;

import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sergey Lugovoy <sergey.lugovoy@oracle.com>
 */
public class BackgroundCssStyle extends CssStyle {

    public BackgroundCssStyle(String name, String style) {
        super(name, style);
    }

    public BackgroundCssStyle(String name, String style, StyleSetter setter) {
        super(name, style, setter);
    }

    @Override
    public void decorate(Node control,  Pane container) {
        control.getStyleClass().add("with-background");
        control.setStyle(control.getStyle() + "-fx-border-color: red;");
        if (control instanceof Control) {
            ((Control) control).setMinWidth(container.getMinWidth());
            ((Control) control).setMinHeight(container.getMinHeight());
            ((Control) control).setPrefWidth(container.getPrefWidth());
            ((Control) control).setPrefHeight(container.getPrefHeight());
        }
    }
}
