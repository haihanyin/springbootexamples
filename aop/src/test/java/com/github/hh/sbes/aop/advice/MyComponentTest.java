package com.github.hh.sbes.aop.advice;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyComponentTest.TestConfig.class)
public class MyComponentTest {

    @Configuration
    @ImportResource("classpath:com/github/hh/sbes/aop/advice/application.xml")
    static class TestConfig {}

    @Autowired
    private MyComponent myComponent;

    @Test
    public void test() {
        myComponent.sayHello();
    }

    @Test
    public void test2() {
        myComponent.sayHelloWithName("Haihan");
    }

    @Test
    public void test3() {
        myComponent.sayHelloWithName(null);
    }

    @Test
    public void test4() {
        myComponent.sayHelloWithAdvisor();
    }
}