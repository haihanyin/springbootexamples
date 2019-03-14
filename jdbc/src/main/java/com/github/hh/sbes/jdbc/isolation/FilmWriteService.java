package com.github.hh.sbes.jdbc.isolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Semaphore;

@Service

public class FilmWriteService {

    @Autowired
    private FilmDao bookDao;

    @Autowired
    private Semaphore semaphore;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void updateFilm(String filmName, int point) {
        try {

            System.out.println("FilmWriteService update film");
            bookDao.updateFilm(filmName, point);
            semaphore.release();
            System.out.println("update film ends");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Film> listAllFilms() {
        return bookDao.findAllFilms();
    }
}
