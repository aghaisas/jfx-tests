/*
 * Copyright (c) 2016 Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
package com.oracle.appbundlers.tests.functionality.jdk9test;

import static com.oracle.appbundlers.utils.installers.AbstractBundlerUtils.CHECK_EXECUTABLES_AVAILABLE_IN_BIN;

import java.util.HashMap;
import java.util.Map;

import com.oracle.appbundlers.tests.functionality.functionalinterface.AdditionalParams;
import com.oracle.appbundlers.tests.functionality.functionalinterface.VerifiedOptions;
import com.oracle.appbundlers.utils.ExtensionType;

/**
 * @author Ramesh BG
 *         aim of this testcase is to check for executables available
 *         in bin directory when "-stripexecutables false" is passed to
 *         javapackager.
 */
public class CheckExecutablesAvailableTest extends ModuleTestBase {

    public AdditionalParams getAdditionalParams() {
        return () -> {
            Map<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put(STRIP_NATIVE_COMMANDS, false);
            return hashMap;
        };
    }

    public VerifiedOptions getVerifiedOptions() {
        return () -> {
            Map<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put(CHECK_EXECUTABLES_AVAILABLE_IN_BIN, null);
            return hashMap;
        };
    }

    @Override
    public void overrideParameters(ExtensionType intermediate) {
        if (intermediate != ExtensionType.NormalJar) {
            this.currentParameter.setAdditionalParams(getAdditionalParams());
            this.currentParameter.setVerifiedOptions(getVerifiedOptions());
        }
    }
}