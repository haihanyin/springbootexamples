package com.github.hh.sbes.mvcxml.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class FilmService {

    @PostConstruct
    public void init() {
        System.out.println("FilmService is created.");
    }

    public String getFilmName() {
        return "X man1";
    }
}
