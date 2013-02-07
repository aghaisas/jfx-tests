/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package test.scenegraph.modality;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import org.jemmy.Point;
import org.jemmy.control.Wrap;
import org.jemmy.fx.Lookups;
import org.jemmy.interfaces.Parent;
import org.junit.Before;
import org.junit.Test;
import test.scenegraph.modality.ModalityWindow.WindowsRenderType;

/**
 * @author Alexander Kirov
 */
public class ModalityZOrderAndFocusWithFileChooser3Test extends ModalityBase{

    @Before
    public void setUp() throws Exception {
        setUpTyped(WindowsRenderType.HIERARHICAL);
    }

    @Test
    public void case1Test() throws InterruptedException, Throwable {
        createSubstage("stage0", ModalityWindow.TestCase.APP, true);
        createSubstage("stage1", ModalityWindow.TestCase.NONE, false);
        createSubstage("stage2", ModalityWindow.TestCase.WIN, true);
        createSubstage("stage3", ModalityWindow.TestCase.FILECH, true);

        Thread.sleep(sleepConst);

        tryToCloseByButton("stage0", "stage1", "stage2");

        tryToClickAndWaitForClicks("stage2", 0, 0);
  
        //Try to click in the corner
        Wrap<? extends Scene> sceneWrap = getSceneWrap("stage3");
        Parent<Node> parent = sceneWrap.as(Parent.class, Node.class);
        Wrap<? extends Label> labelWrap = Lookups.byID(parent, "stage3" + ModalityWindow.MOUSE_COUNTER_ID, Label.class);
        int tempCounter = Integer.parseInt(labelWrap.getControl().getText());
        sceneWrap.mouse().click(1, new Point(sceneWrap.getScreenBounds().getWidth() - 2,
                                             sceneWrap.getScreenBounds().getHeight() - 2));
        Thread.sleep(sleepConst);
        labelWrap.waitProperty(Wrap.TEXT_PROP_NAME, ((Integer)(tempCounter)).toString());

        Thread.sleep(sleepConst);

        negativeScreenshotCheck("ModalityGreen100100", "stage3");

        throwScreenshotError();
    }
}
