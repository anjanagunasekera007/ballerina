package org.ballerinalang.net.http.nativeimpl.request;

import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import org.ballerinalang.bre.Context;
import org.ballerinalang.connector.api.BallerinaConnectorException;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BStruct;
import org.ballerinalang.model.values.BValue;
import org.ballerinalang.natives.AbstractNativeFunction;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.Receiver;
import org.ballerinalang.natives.annotations.ReturnType;
import org.ballerinalang.net.http.Constants;
import org.ballerinalang.net.http.CorsHeaderGenerator;
import org.ballerinalang.net.http.HttpUtil;
import org.ballerinalang.net.uri.DispatcherUtil;
import org.wso2.carbon.transport.http.netty.message.HTTPCarbonMessage;

@BallerinaFunction(
        packageName = "ballerina.net.http",
        functionName = "send100Continue",
        receiver = @Receiver(type = TypeKind.STRUCT, structType = "Request",
                structPackage = "ballerina.net.http"),
        isPublic = true
)
public class Send100Continue extends AbstractNativeFunction {

    @Override
    public BValue[] execute(Context context) {

        HTTPCarbonMessage response = HttpUtil.createHttpCarbonMessage(false);
        if (cMsg.getHeader(Constants.ALLOW) != null) {
//            response.setHeader(Constants.ALLOW, cMsg.getHeader(Constants.ALLOW));
            response.setProperty(Constants.HTTP_STATUS_CODE, 100);
            response.setAlreadyRead(true);
            response.setEndOfMsgAdded(true);


        }
    }
}
