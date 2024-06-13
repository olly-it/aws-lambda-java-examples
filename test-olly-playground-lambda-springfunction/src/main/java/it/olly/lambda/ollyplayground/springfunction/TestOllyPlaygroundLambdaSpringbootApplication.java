package it.olly.lambda.ollyplayground.springfunction;

import java.util.function.Function;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestOllyPlaygroundLambdaSpringbootApplication {

    /*
     * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
     * in the POM to ensure boot plug-in makes the correct entry
     */
    public static void main(String[] args) {
        // empty unless using Custom runtime at which point it should include
        // SpringApplication.run(FunctionConfiguration.class, args);
    }

    @Bean
    public Function<MyRecord, Integer> myFunction() {
        return value -> {
            System.out.println("String found: " + value.message());
            return value.x() + value.y();
        };
    }
}

record MyRecord(int x, int y, String message) {
}