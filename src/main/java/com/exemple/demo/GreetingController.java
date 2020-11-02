package com.exemple.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("api/user")
    public Greeting greeting(@RequestParam(defaultValue = "World") String name, @RequestParam(value = "nom", defaultValue = "aaa") String nom, @RequestParam(value = "mdp", defaultValue = "esiea") String mdp, @RequestParam(value = "mdp", defaultValue = "a@esiea.fr") String mail)  {
        return new Greeting(counter.incrementAndGet(), String.format(template, name), String.format(nom), String.format(mdp), String.format(mail));
    }
}
