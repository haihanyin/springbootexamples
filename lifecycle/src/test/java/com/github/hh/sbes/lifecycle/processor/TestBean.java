package com.github.hh.sbes.lifecycle.processor;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestBean {

    public TestBean() {
        System.out.println("TestBean is created.");
    }

    @PostConstruct
    public void init() {
        System.out.println("TestBean is initialized.");
    }
}
