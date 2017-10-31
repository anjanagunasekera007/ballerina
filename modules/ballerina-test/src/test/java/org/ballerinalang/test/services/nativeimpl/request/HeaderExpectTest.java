package org.ballerinalang.test.services.nativeimpl.request;

import org.ballerinalang.launcher.util.BCompileUtil;
import org.ballerinalang.launcher.util.BRunUtil;
import org.ballerinalang.launcher.util.BServiceUtil;
import org.ballerinalang.launcher.util.CompileResult;
import org.ballerinalang.model.values.BBoolean;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.net.http.Constants;
import org.ballerinalang.net.http.HttpUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.transport.http.netty.message.HTTPCarbonMessage;

public class HeaderExpectTest {

    private CompileResult result, serviceResult;
    private final String requestStruct = Constants.REQUEST;
    private final String protocolPackageHttp = Constants.PROTOCOL_PACKAGE_HTTP;
    private String sourceFilePath = "test-src/statements/services/nativeimpl/request/requestNativeFunction.bal";

    @BeforeClass
    public void setup() {
        result = BCompileUtil.compile(sourceFilePath);
//        serviceResult = BServiceUtil.setupProgramFile(this, sourceFilePath);
    }

    @Test
    public void testAddHeader() {
        BStruct request = BCompileUtil.createAndGetStruct(result.getProgFile(), protocolPackageHttp, requestStruct);
        HTTPCarbonMessage cMsg = HttpUtil.createHttpCarbonMessage(true);
        String headerName = "Expect";
        String headerValue = "100-continue";
        cMsg.setHeader(headerName, headerValue);
        HttpUtil.addCarbonMsg(request, cMsg);

        BValue[] inputArg = {request};
        BValue[] returnVals = BRunUtil.invoke(result, "getExpectHeaderStatus", inputArg);
//        Assert.assertFalse(returnVals == null || returnVals.length == 0 || returnVals[0] == null,
//                "Invalid Return Values.");
//        Assert.assertTrue(returnVals[0] instanceof BBoolean);
//        HTTPCarbonMessage response = HttpUtil.getCarbonMsg((BBoolean) returnVals[0], null);
//        Assert.assertEquals(response.getHeader(headerName), headerValue);
        Assert.assertEquals(returnVals[0],new BBoolean(true));
    }

}
