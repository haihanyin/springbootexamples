package com.github.hh.sbes.rest.exceptionhandling.controlleradvice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoExpHandlingBookController {

    @GetMapping(value = "/book/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getProduct(@PathVariable int id) {
        if (id > 10) {
            throw new IllegalArgumentException("id cannot be greater than 10");
        }
        if (id < 0) {
            throw new IllegalStateException("id cannot be negative");
        }
        return String.format("{id : %d}", id);
    }

}
