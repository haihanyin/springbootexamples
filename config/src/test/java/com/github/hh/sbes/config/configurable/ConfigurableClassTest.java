package com.github.hh.sbes.config.configurable;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConfigurableClassTest.TestConfiguration.class})
public class ConfigurableClassTest {

    @Configuration
    @ComponentScan(basePackages = { "com.github.hh.sbes.config.configurable" })
    static class TestConfiguration {}

    @Test
    public void test() {
        ConfigurableClass configurableClass = new ConfigurableClass();
        Assert.assertNotNull(configurableClass.getComponentClass());
    }
}
