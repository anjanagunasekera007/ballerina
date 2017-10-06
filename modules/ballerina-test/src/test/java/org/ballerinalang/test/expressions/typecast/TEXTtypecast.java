package org.ballerinalang.test.expressions.typecast;

import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.test.utils.BTestUtils;
import org.ballerinalang.test.utils.CompileResult;
import org.ballerinalang.util.codegen.ProgramFile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by anjana on 10/6/17.
 */
public class TEXTtypecast {
    private static final double DELTA = 0.01;
    private ProgramFile bLangProgram;
    private CompileResult result;


    @BeforeClass
    public void setup() {
        result = BTestUtils.compile("test-src/expressions/typecast/texttypecast.bal");
    }


    @Test(description = "Test casting a JSON integer to a string")
    public void testJsonIntToString() {
        BValue[] returns = BTestUtils.invoke(result, "testJsonIntToString", new BValue[]{});
        Assert.assertTrue(returns[0] instanceof BString);
        Assert.assertEquals(returns[0].stringValue(), "5");
    }
}
