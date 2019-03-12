package com.github.hh.sbes.lifecycle.aware;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AwareBeanTest.TestConfiguration.class)
public class AwareBeanTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.lifecycle.aware")
    static class TestConfiguration { }

    @Autowired
    private AwareBean interfaceImplBean;

    @Test
    public void test() {
        Assert.assertNotNull(interfaceImplBean);
    }
}
