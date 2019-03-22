package com.github.hh.sbes.aop.advice;


public class MyComponent {

    public MyComponent() {
        System.out.println("MyComponent is created.");
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void sayHelloWithAdvisor() {
        System.out.println("Hello");
    }

    public String sayHelloWithName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        return "hello " + name;
    }
}
