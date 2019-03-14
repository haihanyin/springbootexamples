package com.github.hh.sbes.jdbc.isolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Semaphore;

@Service
public class FilmReadService {

    @Autowired
    private FilmDao filmDao;

    @Autowired
    private Semaphore semaphore;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void listAllFilmsReadUncommitted() {
        doubleReadFilms();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void listAllFilmsReadcommitted() {
        doubleReadFilms();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void listAllFilmsRepeatableRead() {
        doubleReadFilms();
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void listAllFilmsSerializable() {
        doubleReadFilms();
    }

    public List<Film> listAllFilms() {
        return filmDao.findAllFilms();
    }

    private void printAllFilms() {
        List<Film> allFilms = filmDao.findFilm("xman");
        System.out.println("films:");
        allFilms.forEach(System.out::println);
    }

    private void doubleReadFilms() {
        try {
            Thread.sleep(1000);
            System.out.println("first read");
            printAllFilms();
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("second read");
            printAllFilms();
            semaphore.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
