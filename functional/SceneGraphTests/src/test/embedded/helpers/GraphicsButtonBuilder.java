/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package test.embedded.helpers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author akulyakh
 */
class GraphicsButtonBuilder implements ButtonBuilder {
    private String caption;
    private String id;
    private OnClickHandler handler;

    public GraphicsButtonBuilder() {
    }

    @Override
    public ButtonBuilder text(String text) {
        this.caption = text;
        return this;
    }

    @Override
    public ButtonBuilder id(String id) {
        this.id = id;
        return this;
    }

    @Override
    public AbstractButton build() {
        Text text = new Text(caption);
        text.setId(id);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                handler.onClick();
            }
            
        });
        return new GraphicsButton(text);
    }

    @Override
    public ButtonBuilder setOnClickHandler(OnClickHandler handler) {
       this.handler = handler;
       return this;
    }
    
}
