package com.github.hh.sbes.aop.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = com.github.hh.sbes.aop.proxy.AnimalTest.TestConfig.class)
public class AnimalTest {

    @Configuration
    @ImportResource("classpath:com/github/hh/sbes/aop/proxy/application.xml")
    static class TestConfig {}

    @Autowired
    private Cat cat;

    @Test
    public void test() {
        cat.speak();
    }

    /**
     *  use jdk dynamic proxy
     *  1. not specify <aop:aspectj-autoproxy proxy-target-class="true" />
     *  2. Change above "Cat cat" to "Animal cat"
     *  3. Suspend the program in logBefore
     *
     *  use cglib dynamic proxy
     *  Revert the above points
     */
}