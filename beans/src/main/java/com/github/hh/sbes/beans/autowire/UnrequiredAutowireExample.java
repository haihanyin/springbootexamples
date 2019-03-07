package com.github.hh.sbes.beans.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UnrequiredAutowireExample {

    @Autowired(required = false)
    private NotBeanCompany company;

    public NotBeanCompany getCompany() {
        return company;
    }
}
