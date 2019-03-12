package com.github.hh.sbes.lifecycle.initializing;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InitBeanTest.TestConfiguration.class)
public class InitBeanTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.lifecycle.initializing")
    static class TestConfiguration { }

    @Autowired
    private InitBean initBean;

    @Test
    public void test() {
        Assert.assertNotNull(initBean);
    }
}