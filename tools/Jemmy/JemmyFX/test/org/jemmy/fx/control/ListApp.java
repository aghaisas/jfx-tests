/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jemmy.fx.control;

import java.awt.AWTException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author shura
 */
public class ListApp extends Application {

    public static void main(String[] args) throws AWTException {
//        org.jemmy.client.Browser.runBrowser();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        Scene scene = new Scene(box);



        ListView<String> lst = new ListView<String>();
        lst.getItems().add("one");
        lst.getItems().add("  1 ");
        lst.getItems().add("  2 ");
        lst.getItems().add("  3 ");
        lst.getItems().add("  4 ");
        lst.getItems().add("  5 ");
        lst.getItems().add("  6 ");
        lst.getItems().add("  7 ");
        lst.getItems().add("  8 ");
        lst.getItems().add("  9 ");
        lst.getItems().add("2");
        lst.getItems().add("  11 ");
        lst.getItems().add("  12 ");
        lst.getItems().add("  13 ");
        lst.getItems().add("  14 ");
        lst.getItems().add("  15 ");
        lst.getItems().add("  16 ");
        lst.getItems().add("  17 ");
        lst.getItems().add("  18 ");
        lst.getItems().add("  19 ");
        lst.getItems().add("  20 ");
        lst.getItems().add("three");
        lst.getItems().add("  21 ");
        lst.getItems().add("  33 ");
        lst.getItems().add("  22 ");
        lst.getItems().add("  24 ");
        lst.getItems().add("  25 ");
        lst.getItems().add("  26 ");
        lst.getItems().add("  27 ");
        lst.getItems().add("  28 ");
        lst.getItems().add("  29 ");
        lst.getItems().add("  30 ");
        lst.getItems().add("  31 ");
        lst.getItems().add("  32 ");
        lst.getItems().add("many");

        lst.setEditable(true);
        lst.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {

            public ListCell<String> call(ListView<String> p) {
                return new TextFieldListCell();
            }
        });
        lst.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        box.getChildren().add(lst);

        stage.setScene(scene);

        stage.setWidth(300);
        stage.setHeight(300);

        stage.show();
    }

    class TextFieldListCell extends ListCell<String> {

        private TextField textBox;

        public TextFieldListCell() {
            setEditable(true);
            textBox = new TextField();
            textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {

                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textBox.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }

        @Override
        public void startEdit() {
            super.startEdit();

            textBox.setText(getItem());

            setText(null);
            setGraphic(textBox);

//            Platform.runLater(new Runnable() {
//
//                public void run() {
//                    textBox.requestFocus();
//                    textBox.selectAll();
//                }
//            });
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText((String) getItem());
            setGraphic(null);
        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textBox != null) {
                        textBox.setText(item);
                    }
                    setText(null);
                    setGraphic(textBox);
                } else {
                    setText(item);
                    setGraphic(null);
                }
            }
        }
    }
}
