package com.github.hh.sbes.properties.valuannotation;

import com.github.hh.sbes.properties.valueannotation.ValueAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ValueAnnotationTestPropertyTest.TestConfiguration.class})
@TestPropertySource("/application-test.properties")
public class ValueAnnotationTestPropertyTest {

    @Configuration
    @ComponentScan(basePackages = { "com.github.hh.sbes.properties.valueannotation" })
    static class TestConfiguration {}

    @Autowired
    private ValueAnnotation valueAnnotation;

    @Test
    public void test() {
        System.out.println(valueAnnotation.getEnvironment());
        System.out.println(valueAnnotation.getRandomValue());
    }
}