package com.github.hh.sbes.jdbc.isolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Semaphore;

@Service
@Transactional
public class FilmWriteService {

    @Autowired
    private FilmDao bookDao;

    @Autowired
    private Semaphore semaphore;

    public void updateFilm(String filmName, int point) {
        try {
            Thread.sleep(1000);
            System.out.println("FilmWriteService update film");
            bookDao.updateFilm(filmName, point);
            semaphore.release();
            System.out.println("update film ends");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Film> listAllFilms() {
        return bookDao.findAllFilms();
    }
}
