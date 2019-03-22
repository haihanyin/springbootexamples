package com.github.hh.sbes.aop.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = com.github.hh.sbes.aop.annotation.CarAspectTest.TestConfig.class)
public class CarAspectTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.aop.annotation")
    @EnableAspectJAutoProxy
    //@ImportResource("classpath:com/github/hh/sbes/aop/annotation/application.xml")
    static class TestConfig {}

    @Autowired
    private Car car;

    @Test
    public void test() {
        car.run();
    }

}