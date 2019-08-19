package com.github.hh.sbes.exceptionhandling.controlleradvice;

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
public class TextControllerTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.exceptionhandling.controlleradvice")
    public static class Config {

    }

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void show() throws Exception {
        this.mockMvc.perform(get("/showText")).andDo(print());
    }

    /**
     * HandlerExceptionResolverComposite loops throught 3 resolvers
     * ExceptionHandlerExceptionResolver, ResponseStatusExceptionResolver, DefaultExceptionResolver
     * if the previous one exists, following ones won't be executed.
     *
     * In ExceptionHandlerExceptionResolver, the class ExceptionHandler has higher priority than the
     * ControllerAdvice ExceptionHandler
     *
     * ControllerAdvices will be converted to ControllerAdviceBean which implements Ordered interface.
     * This sorts the priority between different ControllderAdvices.
     */
}