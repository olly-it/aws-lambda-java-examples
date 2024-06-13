package it.olly.lambda.ollyplayground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.olly.lambda.ollyplayground.service.LambdaInput;
import it.olly.lambda.ollyplayground.service.SpringContextLambdaExecutor;

@SpringBootTest
public class PlaygroundLambdaSpringContextApplicationTest {

    @Autowired
    SpringContextLambdaExecutor lambdaInTheContext;

    @Test
    void doInvokeLambdaTest() {
        System.out.println("----- doInvokeLambdaTest -----");
        LambdaInput in = new LambdaInput(1, 2, "ciao");
        String out = lambdaInTheContext.handleRequest(in, null);
        System.out.println("TESTED: " + out);
        System.out.println("----- doInvokeLambdaTest DONE -----");
    }
}
