package com.github.hh.sbes.beans.lazy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = LazyConfigurationTest.TestConfiguration.class)
public class LazyConfigurationTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.beans.lazy")
    static class TestConfiguration {}

    @Test
    public void test() {
        // run and check log, dummybean is not initiated
        // when "@Lazy" is removed, this bean is initiated when applicationcontext is loaded
    }
}