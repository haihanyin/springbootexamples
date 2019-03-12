package com.github.hh.sbes.properties.prefix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PrefixValueAnnotationTest.TestConfiguration.class)
public class PrefixValueAnnotationTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.properties.prefix")
    static class TestConfiguration {}

    @Autowired
    private PrefixValueAnnotation prefixValueAnnotation;

    @Test
    public void test() {
        System.out.println(prefixValueAnnotation.getInfo());
        System.out.println(prefixValueAnnotation.getName());
        System.out.println(prefixValueAnnotation.getVersion());
        System.out.println(prefixValueAnnotation.getUnknown());
        System.out.println(prefixValueAnnotation.getAnother());
    }
}
