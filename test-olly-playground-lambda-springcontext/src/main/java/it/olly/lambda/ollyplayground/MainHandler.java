package it.olly.lambda.ollyplayground;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import it.olly.lambda.ollyplayground.service.LambdaInput;
import it.olly.lambda.ollyplayground.service.SpringContextLambdaExecutor;

public class MainHandler implements RequestHandler<LambdaInput, String> {

    private static ApplicationContext applicationContext;

    static {
        applicationContext = SpringApplication.run(PlaygroundLambdaSpringContextApplication.class);
    }

    @Override
    public String handleRequest(LambdaInput event, Context context) {
        return applicationContext.getBean(SpringContextLambdaExecutor.class)
                .handleRequest(event, context);
    }
}
