package com.github.hh.sbes.beans.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorAutowireExample {

    private BeanPerson person;

    @Autowired
    public ConstructorAutowireExample(BeanPerson person) {
        this.person = person;
    }

    public BeanPerson getPerson() {
        return person;
    }
}
