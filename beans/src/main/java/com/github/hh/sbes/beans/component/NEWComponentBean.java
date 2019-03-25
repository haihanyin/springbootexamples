package com.github.hh.sbes.beans.component;

import org.springframework.stereotype.Component;

@Component
public class NEWComponentBean {

    public NEWComponentBean() {
        System.out.println(this.getClass() + " is created.");
    }

    public void method() {
        throw new NullPointerException();
    }
}
