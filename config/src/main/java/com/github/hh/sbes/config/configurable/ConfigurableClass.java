package com.github.hh.sbes.config.configurable;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@EnableLoadTimeWeaving
@Configurable(autowire = Autowire.BY_TYPE)
public class ConfigurableClass {

    @Autowired
    private ComponentClass componentClass;

    public ComponentClass getComponentClass() {
        return componentClass;
    }
}
