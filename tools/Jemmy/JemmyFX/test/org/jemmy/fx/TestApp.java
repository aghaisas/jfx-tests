/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package org.jemmy.fx;

import java.awt.AWTException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author shura
 */
public class TestApp extends Application {

    public void start(Stage s1) {
        Scene scene1 = new Scene(new Group());
        Group root = new Group();
        scene1.setRoot(root);
        Ellipse circle = new Ellipse(30, 30, 30, 30);
        root.getChildren().add(circle);
        s1.setWidth(100);
        s1.setHeight(100);
        s1.setX(50);
        s1.setY(50);
        s1.setScene(scene1);
        s1.show();
        s1.setTitle("title0");

        Scene scene2 = new Scene(new Group());
        Group root2 = new Group();
        scene2.setRoot(root2);
        Group g = new Group();
        g.setLayoutX(0);
        g.setLayoutY(0);
        Rectangle rect = new Rectangle(10, 20, 70, 40);
        rect.setId("rect1");
        g.getChildren().add(rect);
        root2.getChildren().add(g);

        Text text = new Text();
        text.setText("text1");
        text.setFont(new Font(Font.getDefault().getFamily(), 20F));

        g.getChildren().add(text);

        Stage s2 = new Stage();
        s2.setTitle("title1");
        s2.setWidth(200);
        s2.setHeight(200);
        s2.setX(200);
        s2.setY(200);
        s2.setScene(scene2);
        s2.show();
    }
    
    public static void main(String[] args) throws AWTException {
//        org.jemmy.client.Browser.runBrowser();
        Application.launch(TestApp.class, args);
    }
}
