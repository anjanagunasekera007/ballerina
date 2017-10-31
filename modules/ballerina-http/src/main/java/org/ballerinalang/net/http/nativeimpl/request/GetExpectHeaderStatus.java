package org.ballerinalang.net.http.nativeimpl.request;

import org.ballerinalang.bre.Context;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BBoolean;
import org.ballerinalang.model.values.BMap;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.Receiver;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.net.http.Constants;
import org.ballerinalang.net.http.HttpUtil;
import org.ballerinalang.util.exceptions.BallerinaException;
import org.wso2.carbon.transport.http.netty.message.HTTPCarbonMessage;

/**
 * Get the Expect Header's status of the Message.
 */
@BallerinaFunction(
        packageName = "ballerina.net.http",
        functionName = "getExpectHeaderStatus",
        receiver = @Receiver(type = TypeKind.STRUCT, structType = "Request",
                structPackage = "ballerina.net.http"),
        returnType = {@ReturnType(type = TypeKind.BOOLEAN)},
        isPublic = true
)
public class GetExpectHeaderStatus extends AbstractNativeFunction  {
    @Override
    public BValue[] execute(Context context) {
        try {
            BStruct requestStruct = ((BStruct) getRefArgument(context, 0));
            HTTPCarbonMessage httpCarbonMessage = (HTTPCarbonMessage) requestStruct
                    .getNativeData(Constants.TRANSPORT_MESSAGE);

//            if (httpCarbonMessage.getProperty(Constants.QUERY_STR) != null) {
//                String queryString = (String) httpCarbonMessage.getProperty(Constants.QUERY_STR);
//                return getBValues(HttpUtil.getParamMap(queryString));
//            } else {
//                return getBValues(new BMap<>());
//            }
            if (httpCarbonMessage.getHeader("Expect") != null) {
                if (httpCarbonMessage.getHeader("Expect") == "100-continue") {
                    return getBValues(new BBoolean(true));
                }
                else {
                    return getBValues(new BBoolean(false));
                }
            }
            else {
                return getBValues(new BBoolean(false));
            }
        } catch (Throwable e) {
            throw new BallerinaException("Error while trying to find header 'Expect' from request: " + e.getMessage());
        }

    }
}
