package com.enginius.lambda.ollyplayground;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TestHandler implements RequestHandler<MyRecord, Integer> {

    @Override
    public Integer handleRequest(MyRecord event, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("String found: " + event.message());
        return event.x() + event.y();
    }
}

record MyRecord(int x, int y, String message) {
}