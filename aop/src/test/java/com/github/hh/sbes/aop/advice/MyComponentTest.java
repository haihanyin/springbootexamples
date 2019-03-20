package com.github.hh.sbes.aop.advice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyComponentTest.TestConfig.class)
public class MyComponentTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.aop.advice")
    static class TestConfig {}

    @Test
    public void test() {}

}