package com.github.hh.sbes.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CarAspect {

    @Pointcut("execution(void Car.run())")
    public void carPointcut() {}

    @Before("carPointcut()")
    public void logBefore() {
        System.out.println("logBefore");
    }
}
