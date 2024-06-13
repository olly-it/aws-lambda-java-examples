package it.olly.lambda.ollyplayground;

import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagementClientBuilder;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersRequest;
import com.amazonaws.services.simplesystemsmanagement.model.GetParametersResult;
import com.amazonaws.services.simplesystemsmanagement.model.Parameter;

public class TestHandler implements RequestHandler<MyRecord, Integer> {
    private static AWSSimpleSystemsManagement ssmclient = null;
    static {
        System.out.println("----- init -----");
        // "SystemsManagerRegion" has to be set as "environment property" on the lambda
        ssmclient = AWSSimpleSystemsManagementClientBuilder.standard()
                .withRegion(System.getenv("SystemsManagerRegion"))
                .build();
        System.out.println("----- init done -----");
    }

    private List<Parameter> loadConfigParameters(String... parameterNames) {
        System.out.println("----- load config 1 -----");
        GetParametersRequest paramRequest = new GetParametersRequest().withNames(parameterNames);
        System.out.println("----- load config 2 -----");
        GetParametersResult parameters = ssmclient.getParameters(paramRequest);
        System.out.println("----- load config 3 -----");
        return parameters.getParameters();
    }

    @Override
    public Integer handleRequest(MyRecord event, Context context) {
        // LambdaLogger logger = context.getLogger();
        List<Parameter> configParameters = loadConfigParameters("/config/demo/message", "/test/hello");
        configParameters.forEach(p -> {
            System.out.println("PAMETER: " + p.getName() + " -> " + p.getValue());
        });

        System.out.println("String found: " + event.message());
        return event.x() + event.y();
    }
}

record MyRecord(int x, int y, String message) {
}