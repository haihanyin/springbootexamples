package com.github.hh.sbes.properties.valueannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueAnnotation {

    @Value("${environment}")
    private String countryName;

    public String getCountryName() {
        return countryName;
    }
}
