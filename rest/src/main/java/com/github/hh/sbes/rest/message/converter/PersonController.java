package com.github.hh.sbes.rest.message.converter;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @PostMapping(value = "/addPerson", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person addPerson(@RequestBody Person person) {
        System.out.println("Received:");
        System.out.println(person);
        return person;
    }
}
