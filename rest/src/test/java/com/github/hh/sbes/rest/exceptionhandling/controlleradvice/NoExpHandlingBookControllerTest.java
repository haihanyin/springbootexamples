package com.github.hh.sbes.rest.exceptionhandling.controlleradvice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest
public class NoExpHandlingBookControllerTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.rest.exceptionhandling.controlleradvice")
    static class TestConfiguration {}

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHappy() throws Exception {
        this.mockMvc.perform(get("/book/1")).andDo(print());
    }

    @Test
    public void testNegativeId() throws Exception {
        this.mockMvc.perform(get("/book/-1")).andDo(print());
    }

    @Test
    public void testBigId() throws Exception {
        this.mockMvc.perform(get("/book/11")).andDo(print());
    }

}