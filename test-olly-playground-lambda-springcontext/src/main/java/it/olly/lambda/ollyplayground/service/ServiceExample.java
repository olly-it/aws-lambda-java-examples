package it.olly.lambda.ollyplayground.service;

import org.springframework.stereotype.Component;

@Component
public class ServiceExample {

    String getRnd() {
        System.out.println("SE!");
        return "--" + ((int) (Math.random() * 10000)) + "--";
    }
}
