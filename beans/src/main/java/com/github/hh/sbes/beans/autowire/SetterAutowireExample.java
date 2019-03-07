package com.github.hh.sbes.beans.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterAutowireExample {

    private BeanPerson person;

    @Autowired
    public void setPerson(BeanPerson person) {
        this.person = person;
    }

    public BeanPerson getPerson() {
        return person;
    }
}
