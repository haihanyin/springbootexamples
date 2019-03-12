package com.github.hh.sbes.properties.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ValueAnnotation {

    @Value("${environment}")
    private String environment;

    @Value("${prop.anothervalue}")
    private String randomValue;


    public String getEnvironment() {
        return environment;
    }

    public String getRandomValue() {
        return randomValue;
    }
}
