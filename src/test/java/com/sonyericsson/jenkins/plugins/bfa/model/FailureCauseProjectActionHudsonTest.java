/*
 * The MIT License
 *
 * Copyright (c) 2014 Red Hat, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sonyericsson.jenkins.plugins.bfa.model;

import hudson.Functions;
import hudson.model.FreeStyleProject;
import hudson.tasks.Shell;

import org.junit.Test;
import org.jvnet.hudson.test.HudsonTestCase;

import static org.junit.Assume.assumeFalse;
/**
 * Test Failure Cause project action.
 */
public class FailureCauseProjectActionHudsonTest extends HudsonTestCase {

    /**
     * Should show failures of last completed build.
     *
     * @throws Exception in some cases.
     */
    @Test
    public void testShowLastFailureOnProjectPage() throws Exception {
        assumeFalse(Functions.isWindows());
        FreeStyleProject project = createFreeStyleProject();
        project.getBuildersList().add(new Shell("test $BUILD_NUMBER -eq 2"));
        project.scheduleBuild2(0).get();

        FailureCauseProjectAction action = project.getAction(FailureCauseProjectAction.class);
        assertNotNull(action.getAction());
        assertEquals(project.getLastBuild().getAction(FailureCauseBuildAction.class), action.getAction());

        project.scheduleBuild2(0).get();
        assertNull(project.getAction(FailureCauseProjectAction.class).getAction());
    }
}
