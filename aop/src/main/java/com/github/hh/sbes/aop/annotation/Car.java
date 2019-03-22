package com.github.hh.sbes.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public void run() {
        System.out.println("A car is running.");
    }

}
