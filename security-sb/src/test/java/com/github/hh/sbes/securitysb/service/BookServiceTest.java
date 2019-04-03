package com.github.hh.sbes.securitysb.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BookServiceTest.Config.class)
public class BookServiceTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.securitysb.service")
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public static class Config {}

    @Autowired
    private BookService bookService;

    @Test
    @WithMockUser(username = "Haihan", roles = "U")
    public void testCallUserMethod() {
        bookService.bookServiceForUser();
    }
}