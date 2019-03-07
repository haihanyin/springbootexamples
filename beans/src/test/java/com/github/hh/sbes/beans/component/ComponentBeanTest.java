package com.github.hh.sbes.beans.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentBeanTest.TestConfiguration.class})
public class ComponentBeanTest {

    @Configuration
    @ComponentScan(basePackages = { "com.github.hh.sbes.beans.component" })
    static class TestConfiguration {}

    @Autowired
    private ComponentBean componentBean;

    @Test
    public void test() {
        Assert.assertNotNull(componentBean);
    }
}
