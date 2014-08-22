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
package test.fxmltests.functional;

import junit.framework.Assert;
import org.jemmy.env.Timeout;
import org.jemmy.timing.State;
import org.jemmy.timing.Waiter;
import org.junit.BeforeClass;
import org.junit.Test;
import test.fxmltests.app.LineNumberApp;
import test.javaclient.shared.TestBase;
import test.javaclient.shared.Utils;

public class LineNumberTest extends TestBase {

    private static final long WAITER_TIMEOUT = 5000;

    @BeforeClass
    public static void runUI() {
        Utils.launch(LineNumberApp.class, null);
    }

    /**
     * testing LoadListener#readImportProcessingInstruction
     */
    @Test
    public void testImportProcessingInstruction() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.importProcessingInstructionMatrix.length == LineNumberApp.importProcessingInstruction.size();
            }
        });
        for (int i = 0; i < LineNumberApp.importProcessingInstructionMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.importProcessingInstructionMatrix[i], LineNumberApp.importProcessingInstruction.get(i));
        }
    }

    /**
     * testing LoadListener#readLanguageProcessingInstruction
     */
    @Test
    public void testLanguageProcessingInstruction() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.languageProcessingInstructionMatrix.length == LineNumberApp.languageProcessingInstruction.size();
            }
        });
        for (int i = 0; i < LineNumberApp.languageProcessingInstructionMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.languageProcessingInstructionMatrix[i], LineNumberApp.languageProcessingInstruction.get(i));
        }
    }

    /**
     * testing LoadListener#readComment
     */
    @Test
    public void testComment() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.commentMatrix.length == LineNumberApp.comment.size();
            }
        });
        for (int i = 0; i < LineNumberApp.commentMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.commentMatrix[i], LineNumberApp.comment.get(i));
        }
    }

    /**
     * testing LoadListener#beginInstanceDeclarationElement
     */
    @Test
    public void testBeginInstanceDeclarationElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.instanceDeclarationElementMatrix.length == LineNumberApp.instanceDeclarationElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.instanceDeclarationElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.instanceDeclarationElementMatrix[i], LineNumberApp.instanceDeclarationElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginUnknownTypeElement
     */
    @Test
    public void testUnknownTypeElement() {
        testCommon(LineNumberApp.Pages.unknownTypePage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.beginUnknowStaticElementMatrix.length == LineNumberApp.beginUnknowStaticElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.beginUnknowStaticElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.beginUnknowStaticElementMatrix[i], LineNumberApp.beginUnknowStaticElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginIncludeElement
     */
    @Test
    public void testIncludeElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.includeElementMatrix.length == LineNumberApp.includeElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.includeElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.includeElementMatrix[i], LineNumberApp.includeElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginReferenceElement
     */
    @Test
    public void testReferenceElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.referenceElementMatrix.length == LineNumberApp.referenceElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.referenceElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.referenceElementMatrix[i], LineNumberApp.referenceElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginCopyElement
     */
    @Test
    public void testCopyElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.copyElementMatrix.length == LineNumberApp.copyElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.copyElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.copyElementMatrix[i], LineNumberApp.copyElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginRootElement
     */
    @Test
    public void testRootElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.rootElement > 0;
            }
        });
        Assert.assertEquals(LineNumberApp.rootElementLine, LineNumberApp.rootElement);
    }

    /**
     * testing LoadListener#beginPropertyElement
     */
    @Test
    public void testPropertyElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.propertyElementMatrix.length == LineNumberApp.propertyElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.propertyElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.propertyElementMatrix[i], LineNumberApp.propertyElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginUnknownStaticPropertyElement
     */
    @Test
    public void testBeginUnknownStaticPropertyElement() {
        testCommon(LineNumberApp.Pages.unknownPropertyPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.beginUnknowStaticPropertyElementMatrix.length == LineNumberApp.beginUnknowStaticPropertyElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.beginUnknowStaticPropertyElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.beginUnknowStaticPropertyElementMatrix[i], LineNumberApp.beginUnknowStaticPropertyElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginScriptElement
     */
    @Test
    public void testScriptElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.propertyElementMatrix.length == LineNumberApp.propertyElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.propertyElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.propertyElementMatrix[i], LineNumberApp.propertyElement.get(i));
        }
    }

    /**
     * testing LoadListener#beginDefineElement
     */
    @Test
    public void testDefineElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.defineElementMatrix.length == LineNumberApp.defineElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.defineElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.defineElementMatrix[i], LineNumberApp.defineElement.get(i));
        }
    }

    /**
     * testing LoadListener#readInternalAttribute
     */
    @Test
    public void testReadInternalProperty() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.readInternalAttributeMatrix.length == LineNumberApp.readInternalAttribute.size();
            }
        });
        for (int i = 0; i < LineNumberApp.readInternalAttributeMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.readInternalAttributeMatrix[i], LineNumberApp.readInternalAttribute.get(i));
        }
    }

    /**
     * testing LoadListener#readPropertyAttribute
     */
    @Test
    public void testReadPropertyAttribute() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.readPropertyAttributeMatrix.length == LineNumberApp.readPropertyAttribute.size();
            }
        });
        for (int i = 0; i < LineNumberApp.readPropertyAttributeMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.readPropertyAttributeMatrix[i], LineNumberApp.readPropertyAttribute.get(i));
        }
    }

    /**
     * testing LoadListener#readUnknownStaticPropertyAttribute
     */
    @Test
    public void testReadUnknownStaticPropertyAttribute() {
        testCommon(LineNumberApp.Pages.unknownPropertyPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.readUnknownStaticPropertyMatrix.length == LineNumberApp.readUnknownStaticProperty.size();
            }
        });
        for (int i = 0; i < LineNumberApp.readUnknownStaticPropertyMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.readUnknownStaticPropertyMatrix[i], LineNumberApp.readUnknownStaticProperty.get(i));
        }
    }

    /**
     * testing LoadListener#readEventHandlerAttribute
     */
    @Test
    public void testReadEventHandlerAttribute() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.readEventHandlerAttributeMatrix.length == LineNumberApp.readEventHandlerAttribute.size();
            }
        });
        for (int i = 0; i < LineNumberApp.readEventHandlerAttributeMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.readEventHandlerAttributeMatrix[i], LineNumberApp.readEventHandlerAttribute.get(i));
        }
    }

    /**
     * testing LoadListener#endElement
     */
    @Test
    public void testEndElement() {
        testCommon(LineNumberApp.Pages.mainPage.name(), null, false, false);
        new Waiter(new Timeout("", WAITER_TIMEOUT)).ensureValue(true, new State<Boolean>() {
            @Override
            public Boolean reached() {
                return LineNumberApp.endElementMatrix.length == LineNumberApp.endElement.size();
            }
        });
        for (int i = 0; i < LineNumberApp.endElementMatrix.length; i++) {
            Assert.assertEquals(LineNumberApp.endElementMatrix[i], LineNumberApp.endElement.get(i));
        }
    }
}
