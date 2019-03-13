package com.github.hh.sbes.jdbc.isolation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.github.hh.sbes.jdbc.isolation.FilmServiceTest.TestConfiguration.class)
public class FilmServiceTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.jdbc.isolation")
    static class TestConfiguration { }

    @Autowired
    private FilmFastService filmFastService;

    @Autowired
    private FilmSlowService filmSlowService;

    @Test
    public void addFilm() {
        filmFastService.addFilm(new Film("X Man111", 100));
        List<Film> films = filmFastService.listAllFilms();
        films.forEach(System.out::println);
    }
}