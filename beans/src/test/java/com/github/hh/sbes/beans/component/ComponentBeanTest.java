package com.github.hh.sbes.beans.component;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ComponentBeanTest.TestConfiguration.class})
public class ComponentBeanTest {

    @Configuration
    @ComponentScan(basePackages = { "com.github.hh.sbes.beans.component" })
    static class TestConfiguration {
        @Bean
        public String GetMyName() {
            return "hh";
        }

        @Bean("get-my-name")
        public String getMyName2() {
            return "hh";
        }

        @Bean
        public String GET_MY_NAME() {
            return "hh";
        }
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ComponentBean componentBean;

    @Test
    public void test() {
        Assert.assertNotNull(applicationContext);
        Assert.assertNotNull(componentBean);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
