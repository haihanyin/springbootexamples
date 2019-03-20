package com.github.hh.sbes.aop.advice;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LogAspect {

    @Pointcut("execution(* MyComponent.sayHello())")
    public void interestingMethods() {}

    @Before("interestingMethods()")
    public void logBeore() {
        System.out.println("logBefore");
    }

    @Before("interestingMethods()")
    public void logAfter() {
        System.out.println("logAfter");
    }

    @Before("interestingMethods()")
    public void logAfterReturning() {
        System.out.println("logAfterReturning");
    }

    @Before("interestingMethods()")
    public void logAfterThrowing() {
        System.out.println("logAfterThrowing");
    }

    @Before("interestingMethods()")
    public void logAround() {
        System.out.println("logAround");
    }
}
