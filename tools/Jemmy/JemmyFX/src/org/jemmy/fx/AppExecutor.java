/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package org.jemmy.fx;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import javafx.application.Application;
import org.jemmy.JemmyException;
import org.jemmy.env.Environment;

/**
 * Runs an FX application
 * @author shura
 */
public class AppExecutor {
    private Class mainClass;

    /**
     * @deprecated Use static void execute(Class<? extends Application> program, String... parameters)
     * @param mainClassName Name of the application main class
     */
    public AppExecutor(String mainClassName) throws ClassNotFoundException {
        this(Class.forName(mainClassName));
    }

    /**
     * @deprecated Use static void execute(Class<? extends Application> program, String... parameters)
     * @param mainClass the application main class
     */
    public AppExecutor(Class mainClass) {
        this.mainClass = mainClass;
    }

    /**
     * Runs the app with parameters
     * @deprecated Use static void execute(Class<? extends Application> program, String... parameters)
     * @param parameters
     */
    public void execute(final String... parameters) {
        execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Class[] argTypes = new Class[] { String[].class };
                    Method main = mainClass.getMethod("main", argTypes);
                    //String[] mainArgs = Arrays.copyOfRange(parameters, 1, parameters.length);
                    main.invoke(null, (Object)parameters);
                } catch (IllegalAccessException ex) {
                    throw new JemmyException("Unable to execute " + mainClass.getName(), ex);
                } catch (IllegalArgumentException ex) {
                    throw new JemmyException("Unable to execute " + mainClass.getName(), ex);
                } catch (InvocationTargetException ex) {
                    throw new JemmyException("Unable to execute " + mainClass.getName(), ex);
                } catch (NoSuchMethodException ex) {
                    throw new JemmyException("Unable to execute " + mainClass.getName(), ex);
                } catch (SecurityException ex) {
                    throw new JemmyException("Unable to execute " + mainClass.getName(), ex);
                }
            }
        });
    }

    /**
     * @deprecated Use static void execute(Class<? extends Application> program, String... parameters)
     * @param program
     */
    public static void execute(Runnable program) {
        Environment.getEnvironment().getOutput().printerr("It is recommended not to use " +
                AppExecutor.class.getName() + ".execute(Runnable)");
        Environment.getEnvironment().getOutput().printerr("use " +
                AppExecutor.class.getName() + ".execute(Class<? extends " + Application.class.getName() + ">) instead");
        // com.sun.javafx.application.PlatformImpl.startup(program); JJCBrowser is for work with FX app
        //                                                           which starts FX platform in the main()
        new Thread(program).start();
    }

    public static void execute(Class<? extends Application> program) {
        execute(program, new String[0]);
    }

    public static void execute(Class<? extends Application> program, String... parameters) {
        Application.launch(program, parameters);
    }

    public static void executeNoBlock(Class<? extends Application> program) {
        executeNoBlock(program, new String[0]);
    }

    public static void executeNoBlock(final Class<? extends Application> program, final String... parameters) {
        new Thread(new Runnable() {

            public void run() {
                execute(program, parameters);
            }
        }).start();
    }

    public static void executeReflect(String... argv) throws ClassNotFoundException {
        if (argv.length == 0) {
            throw new ClassNotFoundException("No class name to execute - empty parameters");
        }
        Class mainClass = Class.forName(argv[0]);

        String[] parameters = Arrays.copyOfRange(argv, 1, argv.length);

        if (Application.class.isAssignableFrom(mainClass)) {
            Class<? extends Application> app = mainClass;
            AppExecutor.execute(app, parameters);
            return;
        }
        // throw new ClassNotFoundException("Class doesn't extends " + 
        //                                   Application.class.getName() + ". Old way to start FX app isn't supported");
        // then use old deprecated method to start.
        new AppExecutor(mainClass).execute(parameters);
    }
}
