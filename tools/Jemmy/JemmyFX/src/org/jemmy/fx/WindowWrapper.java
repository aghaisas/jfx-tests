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


import java.util.ArrayList;
import java.util.List;
import org.jemmy.control.DefaultWrapper;
import org.jemmy.control.Wrap;
import org.jemmy.env.Environment;
import org.jemmy.fx.control.ContextMenuWrap;

class WindowWrapper extends DefaultWrapper {

    private static final List<Class<? extends Wrap>> OPERATORS = new ArrayList<Class<? extends Wrap>>();
    
    static {
        OPERATORS.add(WindowWrap.class);
        OPERATORS.add(ContextMenuWrap.class);
    }

    WindowWrapper(Environment env) {
        super(env, OPERATORS.toArray(new Class[0]));
    }

    @Override
    public <T> Wrap<? extends T> wrap(Class<T> controlClass, T control) {
        return super.wrap(controlClass, control);
    }
}
