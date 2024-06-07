package com.enginius.lambda.ollyplayground.http.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olly")
public class OllyController {

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Olly> getAll() {
        return List.of(new Olly(1, "Doe"), new Olly(2, "John"));
    }
}

record Olly(Integer id, String name) {
}