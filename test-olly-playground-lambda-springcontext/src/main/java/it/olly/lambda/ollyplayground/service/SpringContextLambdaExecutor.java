package it.olly.lambda.ollyplayground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

@Service
public class SpringContextLambdaExecutor implements RequestHandler<LambdaInput, String> {

    @Autowired
    private ServiceExample se;

    @Override
    public String handleRequest(LambdaInput input, Context lambdaContext) {
        System.out.println("on bean, got: " + input);
        return se.getRnd();
    }

}
