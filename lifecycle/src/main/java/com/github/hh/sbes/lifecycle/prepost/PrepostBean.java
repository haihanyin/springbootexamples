package com.github.hh.sbes.lifecycle.prepost;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class PrepostBean {

    @PostConstruct
    public void init() {
        System.out.println("init");
    }

    @PreDestroy
    public void clean() {
        System.out.println("clean");
    }
}
