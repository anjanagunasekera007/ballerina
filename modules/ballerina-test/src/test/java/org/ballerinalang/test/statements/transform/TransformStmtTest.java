/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.ballerinalang.test.statements.transform;

import org.ballerinalang.model.values.BInteger;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.test.utils.BTestUtils;
import org.ballerinalang.test.utils.CompileResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TransformStmtTest {

    CompileResult result;
    CompileResult resultNegative;

    @BeforeClass
    public void setup() {
        result = BTestUtils.compile("test-src/statements/transform/transform-stmt.bal");
        resultNegative = BTestUtils.compile("test-src/statements/transform/transform-stmt-negative.bal");
    }

    @Test(description = "Test one to one simple transformation")
    public void testOneToOneTransform() {
        BValue[] args = {};
        BValue[] returns = BTestUtils.invoke(result, "oneToOneTransform", args);

        Assert.assertEquals(returns.length, 3);

        Assert.assertTrue(returns[0] instanceof BString);
        Assert.assertEquals(returns[0].stringValue(), "John");

        Assert.assertTrue(returns[1] instanceof BInteger);
        Assert.assertEquals(((BInteger) returns[1]).intValue(), 30);

        Assert.assertTrue(returns[2] instanceof BString);
        Assert.assertEquals(returns[2].stringValue(), "London");
    }

    @Test(description = "Test one to one simple transformation")
    public void testFunctionsInTransform() {
        BValue[] args = {};
        BValue[] returns = BTestUtils.invoke(result, "functionsInTransform", args);

        Assert.assertEquals(returns.length, 3);

        Assert.assertTrue(returns[0] instanceof BString);
        Assert.assertEquals(returns[0].stringValue(), "Mr.John");

        Assert.assertTrue(returns[1] instanceof BInteger);
        Assert.assertEquals(((BInteger) returns[1]).intValue(), 30);

        Assert.assertTrue(returns[2] instanceof BString);
        Assert.assertEquals(returns[2].stringValue(), "London");
    }

    @Test(description = "Test one to one simple transformation with var for temporary variables")
    public void testVarInTransform() {
        BValue[] args = {};
        BValue[] returns = BTestUtils.invoke(result, "varInTransform", args);

        Assert.assertEquals(returns.length, 3);

        Assert.assertTrue(returns[0] instanceof BString);
        Assert.assertEquals(returns[0].stringValue(), "Mr.John");

        Assert.assertTrue(returns[1] instanceof BInteger);
        Assert.assertEquals(((BInteger) returns[1]).intValue(), 30);

        Assert.assertTrue(returns[2] instanceof BString);
        Assert.assertEquals(returns[2].stringValue(), "London");
    }

    @Test(description = "Test one to one simple transformation with new variable definitions")
    public void testVarDefInTransform() {
        BValue[] args = {};
        BValue[] returns = BTestUtils.invoke(result, "varDefInTransform", args);

        Assert.assertEquals(returns.length, 3);

        Assert.assertTrue(returns[0] instanceof BString);
        Assert.assertEquals(returns[0].stringValue(), "Ms.John");

        Assert.assertTrue(returns[1] instanceof BInteger);
        Assert.assertEquals(((BInteger) returns[1]).intValue(), 30);

        Assert.assertTrue(returns[2] instanceof BString);
        Assert.assertEquals(returns[2].stringValue(), "London");
    }

    @Test(description = "Test transform statement with errors")
    public void testTransformNegativeCases() {
        Assert.assertEquals(resultNegative.getErrorCount(), 3);
        //testIncompatibleTypeAssign
        BTestUtils.validateError(resultNegative, 0,
                "input and output variables cannot be interchanged in transform statement", 19, 8);
        BTestUtils.validateError(resultNegative, 1,
                "input and output variables cannot be interchanged in transform statement", 19, 22);
        BTestUtils.validateError(resultNegative, 2, "no statements found in the transform statement body", 28, 4);
    }
}