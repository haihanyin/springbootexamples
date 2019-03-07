package com.github.hh.sbes.beans.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean("firstBean")
    public DummyClass FirstDummyBean() {
        return new DummyClass();
    }

    @Bean("secondBean")
    public DummyClass SecondDummyBean() {
        return new DummyClass();
    }

}
