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
package test.fxmltests.app;

import com.sun.javafx.fxml.LoadListener;
import com.sun.javafx.runtime.VersionInfo;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import test.javaclient.shared.BasicButtonChooserApp;
import test.javaclient.shared.PageWithSlots;
import test.javaclient.shared.TestNode;

public class LineNumberApp extends BasicButtonChooserApp {

    private static String FXML_MAIN_RESOURCE = "/test/fxmltests/resources/line_number.fxml";
    private static String FXML_TYPE_RESOURCE = "/test/fxmltests/resources/line_number_type.fxml";
    private static String FXML_PROPERTY_RESOURCE = "/test/fxmltests/resources/line_number_property.fxml";
    public static List<Integer> importProcessingInstruction = new ArrayList<Integer>();
    final public static Integer[] importProcessingInstructionMatrix = new Integer[]{3, 4, 5, 6, 7};
    public static List<Integer> languageProcessingInstruction = new ArrayList<Integer>();
    final public static Integer[] languageProcessingInstructionMatrix = new Integer[]{9};
    public static List<Integer> comment = new ArrayList<Integer>();
    final public static Integer[] commentMatrix = new Integer[]{12, 15};
    public static List<Integer> instanceDeclarationElement = new ArrayList<Integer>();
    final public static Integer[] instanceDeclarationElementMatrix = new Integer[]{25, 26, 27, 31, 32, 34, 37};
    public static List<Integer> includeElement = new ArrayList<Integer>();
    final public static Integer[] includeElementMatrix = new Integer[]{35};
    public static List<Integer> referenceElement = new ArrayList<Integer>();
    final public static Integer[] referenceElementMatrix = new Integer[]{38};
    public static int rootElement = 0;
    final public static int rootElementLine = 11;
    public static List<Integer> readUnknownStaticProperty = new ArrayList<Integer>();
    final public static Integer[] readUnknownStaticPropertyMatrix = new Integer[]{5};
    public static List<Integer> beginUnknowStaticElement = new ArrayList<Integer>();
    final public static Integer[] beginUnknowStaticElementMatrix = new Integer[]{5};
    public static List<Integer> beginUnknowStaticPropertyElement = new ArrayList<Integer>();
    final public static Integer[] beginUnknowStaticPropertyElementMatrix = new Integer[]{6};
    public static List<Integer> propertyElement = new ArrayList<Integer>();
    final public static Integer[] propertyElementMatrix = new Integer[]{28};
    public static List<Integer> scriptElement = new ArrayList<Integer>();
    final public static Integer[] scriptElementMatrix = new Integer[]{19};
    public static List<Integer> defineElement = new ArrayList<Integer>();
    final public static Integer[] defineElementMatrix = new Integer[]{16, 41};
    public static List<Integer> readPropertyAttribute = new ArrayList<Integer>();
    final public static Integer[] readPropertyAttributeMatrix = new Integer[]{11, 11, 26, 27, 27, 27, 27, 32};
    public static List<Integer> readInternalAttribute = new ArrayList<Integer>();
    final public static Integer[] readInternalAttributeMatrix = new Integer[]{11, 27, 35, 38};
    public static List<Integer> readEventHandlerAttribute = new ArrayList<Integer>();
    final public static Integer[] readEventHandlerAttributeMatrix = new Integer[]{32};
    public static List<Integer> endElement = new ArrayList<Integer>();
    final public static Integer[] endElementMatrix = new Integer[]{18, 24, 28, 29, 30, 32, 33, 35, 36, 38, 39, 40, 43, 44};
    public static List<Integer> copyElement = new ArrayList<Integer>();
    final public static Integer[] copyElementMatrix = new Integer[]{};
    private static int WIDTH = 300;
    private static int HEIGHT = 300;

    public enum Pages {

        mainPage, unknownTypePage, unknownPropertyPage
    }

    public LineNumberApp() {
        super(WIDTH, HEIGHT, VersionInfo.getRuntimeVersion(), false);
    }

    @Override
    protected TestNode setup() {
        TestNode root = new TestNode();

        PageWithSlots pageMain = new PageWithSlots(LineNumberApp.Pages.mainPage.name(), HEIGHT - 15, WIDTH - 10);
        pageMain.add(new FxmlLoadPage(FXML_MAIN_RESOURCE), LineNumberApp.Pages.mainPage.name());

        PageWithSlots pageType = new PageWithSlots(LineNumberApp.Pages.unknownTypePage.name(), HEIGHT - 15, WIDTH - 10);
        pageType.add(new FxmlLoadPage(FXML_TYPE_RESOURCE), LineNumberApp.Pages.mainPage.name());

        PageWithSlots pageProperty = new PageWithSlots(LineNumberApp.Pages.unknownPropertyPage.name(), HEIGHT - 15, WIDTH - 10);
        pageProperty.add(new FxmlLoadPage(FXML_PROPERTY_RESOURCE), LineNumberApp.Pages.mainPage.name());

        root.add(pageMain);
        root.add(pageType);
        root.add(pageProperty);

        return root;
    }

    private class FxmlLoadPage extends TestNode {

        private String resource;

        public FxmlLoadPage(String resource) {
            this.resource = resource;
        }

        @Override
        public Node drawNode() {
            LineNumberApp.reset();
            final FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            loader.impl_setStaticLoad(true);
            loader.impl_setLoadListener(new LoadListener() {

                @Override
                public void readImportProcessingInstruction(String string) {
                    importProcessingInstruction.add(loader.impl_getLineNumber());
                }

                @Override
                public void readLanguageProcessingInstruction(String string) {
                    languageProcessingInstruction.add(loader.impl_getLineNumber());
                }

                @Override
                public void readComment(String string) {
                    comment.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginInstanceDeclarationElement(Class<?> tye) {
                    instanceDeclarationElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginUnknownTypeElement(String string) {
                    beginUnknowStaticElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginIncludeElement() {
                    includeElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginReferenceElement() {
                    referenceElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginCopyElement() {
                    copyElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginRootElement() {
                    rootElement = loader.impl_getLineNumber();
                }

                @Override
                public void beginPropertyElement(String string, Class<?> type) {
                    propertyElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginUnknownStaticPropertyElement(String string) {
                    beginUnknowStaticPropertyElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginScriptElement() {
                    scriptElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void beginDefineElement() {
                    defineElement.add(loader.impl_getLineNumber());
                }

                @Override
                public void readInternalAttribute(String string, String string1) {
                    readInternalAttribute.add(loader.impl_getLineNumber());
                }

                @Override
                public void readPropertyAttribute(String string, Class<?> type, String string1) {
                    readPropertyAttribute.add(loader.impl_getLineNumber());
                }

                @Override
                public void readUnknownStaticPropertyAttribute(String string, String string1) {
                    readUnknownStaticProperty.add(loader.impl_getLineNumber());
                }

                @Override
                public void readEventHandlerAttribute(String string, String string1) {
                    readEventHandlerAttribute.add(loader.impl_getLineNumber());
                }

                @Override
                public void endElement(Object o) {
                    endElement.add(loader.impl_getLineNumber());
                }
            });
            try {
                loader.setRoot(VBoxBuilder.create().prefHeight(200).prefWidth(200).build());
                return (Node) loader.load();
            } catch (Exception exc) {
                exc.printStackTrace();
                return new Rectangle(10, 10) {

                    {
                        setFill(Color.RED);
                    }
                };
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void reset() {
        importProcessingInstruction.clear();
        languageProcessingInstruction.clear();
        comment.clear();
        instanceDeclarationElement.clear();
        beginUnknowStaticElement.clear();
        includeElement.clear();
        referenceElement.clear();
        copyElement.clear();
        rootElement = 0;
        propertyElement.clear();
        beginUnknowStaticPropertyElement.clear();
        scriptElement.clear();
        defineElement.clear();
        readInternalAttribute.clear();
        readPropertyAttribute.clear();
        readUnknownStaticProperty.clear();
        readEventHandlerAttribute.clear();
        endElement.clear();
    }
}
