package com.github.hh.sbes.beans.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BeanConfigurationTest.TestConfiguration.class)
public class BeanConfigurationTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.beans.configuration")
    static class TestConfiguration {}

    @Qualifier("firstBean")
    @Autowired
    private DummyClass firstBean;

    @Qualifier("secondBean")
    @Autowired
    private DummyClass secondBean;

    @Test
    public void test() {
        Assert.assertNotNull(firstBean);
        Assert.assertNotNull(secondBean);
    }
}
