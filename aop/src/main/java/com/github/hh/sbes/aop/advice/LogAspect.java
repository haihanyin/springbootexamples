package com.github.hh.sbes.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class LogAspect {

    public void logBeore(JoinPoint joinPoint) {
        System.out.println("logBefore");
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println("logBefore ends");
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("logAfter");
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSourceLocation());
        System.out.println("logAfter ends");
    }

    public void logAfterReturning(JoinPoint joinPoint, Object returnValue) {
        System.out.println("logAfterReturning");
        Arrays.stream(joinPoint.getArgs()).forEach(System.out::println);
        System.out.println("Return value: " + returnValue);
    }

    public void logAfterThrowing(Exception e) {
        System.out.println("logAfterThrowing");
        System.out.println(e.getClass());
    }

    public void logAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("logAround");
        System.out.println(pjp.getSignature());
        System.out.println(pjp.getSourceLocation());
        pjp.proceed();
        System.out.println("logAround ends");
    }
}
