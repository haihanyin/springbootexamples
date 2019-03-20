package com.github.hh.sbes.aop.advice;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public void sayHello() {
        System.out.println("Hello");
    }
}
