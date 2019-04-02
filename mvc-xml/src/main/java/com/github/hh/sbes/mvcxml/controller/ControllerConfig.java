package com.github.hh.sbes.mvcxml.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class ControllerConfig {

    @Bean
    public FreeMarkerConfig freeMarkerConfig() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/template");
        return freeMarkerConfigurer;
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver bean = new FreeMarkerViewResolver();
        bean.setPrefix("");
        bean.setSuffix(".ftl");
        return bean;
    }
}
