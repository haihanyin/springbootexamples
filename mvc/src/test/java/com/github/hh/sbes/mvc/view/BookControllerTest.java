package com.github.hh.sbes.mvc.view;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BookControllerTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.mvc.view")
    static class TestConfiguration {}

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        this.mockMvc.perform(get("/showBookWithModel")).andDo(print());
    }

    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(get("/showBookWithModelView")).andDo(print());
    }

    @Test
    public void test2() throws Exception {
        this.mockMvc.perform(get("/showBookWithMap")).andDo(print());
    }
}