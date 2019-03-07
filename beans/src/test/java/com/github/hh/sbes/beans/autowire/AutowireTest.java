package com.github.hh.sbes.beans.autowire;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AutowireTest.TestConfiguration.class)
public class AutowireTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.beans.autowire")
    static class TestConfiguration {}

    @Autowired
    private ConstructorAutowireExample constructorAutowireExample;
    @Autowired
    private FieldAutowireExample fieldAutowireExample;
    @Autowired
    private SetterAutowireExample setterAutowireExample;
    @Autowired
    private UnrequiredAutowireExample unrequiredAutowireExample;

    @Test
    public void test() {
        Assert.assertNotNull(constructorAutowireExample.getPerson());
        Assert.assertNotNull(fieldAutowireExample.getPerson());
        Assert.assertNotNull(setterAutowireExample.getPerson());
        Assert.assertNull(unrequiredAutowireExample.getCompany());
    }
}
