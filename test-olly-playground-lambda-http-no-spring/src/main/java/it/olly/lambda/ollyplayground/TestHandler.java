package it.olly.lambda.ollyplayground;

import java.time.ZonedDateTime;

import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.model.HttpApiV2ProxyRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

// it.olly.lambda.ollyplayground.TestHandler
public class TestHandler implements RequestHandler<HttpApiV2ProxyRequest, AwsProxyResponse> {
    static {
        System.out.println("----- init done -----");
    }

    @Override
    public AwsProxyResponse handleRequest(HttpApiV2ProxyRequest input, Context context) {
        System.out.println("--> BODY: " + input.getBody());
        System.out.println("--> QS: " + input.getQueryStringParameters());
        System.out.println("--> PATH: " + input.getRawPath());
        System.out.println("--> HEADERS: " + input.getHeaders());
        System.out.println("--> REQUESTCONTEXT.HTTP.METHOD: " + input.getRequestContext()
                .getHttp()
                .getMethod());

        AwsProxyResponse output = new AwsProxyResponse(200);
        output.setBody("ciao " + ZonedDateTime.now());
        System.out.println("<-- output - " + output.getStatusCode() + ": '" + output.getBody() + "'");
        return output;
    }
}
