package com.github.hh.sbes.beans.lazy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Lazy
@Configuration
public class LazyConfiguration {

    public LazyConfiguration() {
        System.out.println("lazyConfiguration is created.");
    }

    @Bean
    public DummyBean getDummyBean() {
        System.out.println("getDummyBean");
        return new DummyBean();
    }
}
