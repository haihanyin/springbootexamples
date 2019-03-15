package com.github.hh.sbes.rest.message.converter;

import com.github.jsontemplate.JsonTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PersonControllerTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.rest.message.converter")
    static class TestConfiguration {}

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test() throws Exception {
        String template = "{name:@s, age:@i, married:@b}";
        String json = new JsonTemplate(template).prettyString();
        System.out.println(json);
        this.mockMvc.perform(post("/addPerson")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(json)).andDo(print());

    }
}