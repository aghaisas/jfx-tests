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
package com.sun.fx.webnode.tests.css;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 *
 * @author Dmitry Zinkevich <dmitry.zinkevich@oracle.com>
 */
public class FontLauncher extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        
        StackPane container = new StackPane();

        Scene scene = new Scene(container, SIZE, SIZE);
        styleInfo = getParameters().getRaw().get(0);
        
        WebView view = new WebView();
        WebEngine web = view.getEngine();
        web.load(CSSLauncher.class.getResource("resources/textSample.html").toExternalForm());

        GridPane viewPane = new GridPane();
        viewPane.setMaxSize(SIZE, SIZE);
        viewPane.getChildren().add(view);

        container.getChildren().addAll(viewPane);

        stage.setTitle("Launcher");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }
    
    public static void run(final String url) {
        final String[] args = new String[] {url};        
        new Thread(new Runnable() {
            public void run() {
                Application.launch(FontLauncher.class, args);
            }
        }, "FXSQE app launch thread").start();
    }
    
    private final static int SIZE = 800;
    private String styleInfo;
}
