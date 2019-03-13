package com.github.hh.sbes.jdbc.isolation;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.github.hh.sbes.jdbc.isolation.FilmServiceTest.TestConfiguration.class)
public class FilmServiceTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.jdbc.isolation")
    static class TestConfiguration { }

    @Autowired
    private FilmWriteService filmWriteService;

    @Autowired
    private FilmReadService filmReadService;

    @Autowired
    private FilmDao filmDao;

    @After
    public void checkDataBase() {
        System.out.println("Database status:");
        filmDao.findAllFilms().forEach(System.out::println);
    }

    @Test
    public void addReadUncommitted() {
        new Thread(() -> filmWriteService.updateFilm("xman", 99)).start();
        filmReadService.listAllFilmsReadUncommitted();

    }

    @Test
    public void addReadCommitted() {
        new Thread(() -> filmWriteService.updateFilm("xman", 99)).start();
        filmReadService.listAllFilmsReadcommitted();
    }

    @Test
    public void addReadRepeatableRead() {
        new Thread(() -> filmWriteService.updateFilm("xman", 99)).start();
        filmReadService.listAllFilmsRepeatableRead();
    }

    @Test
    public void addReadSerializable() {
        new Thread(() -> filmWriteService.updateFilm("xman", 99)).start();
        filmReadService.listAllFilmsSerializable();
    }
}