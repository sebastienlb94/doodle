package com.exemple.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();
    private List<Customer> strings = new ArrayList<Customer>();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "prenom", defaultValue = "aaa") String prenom, @RequestParam(value = "nom", defaultValue = "bbb") String nom, @RequestParam(value = "mdp", defaultValue = "esiea") String mdp, @RequestParam(value = "mail", defaultValue = "a@esiea.fr") String mail)  {
        return new Greeting(counter.incrementAndGet(), prenom, nom, mdp, mail);
    }
}