package com.github.hh.sbes.jdbc.isolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmFastService {

    @Autowired
    private FilmDao bookDao;

    public void addFilm(Film film) {
        bookDao.addFilm(film.getName(), film.getPoint() );
    }

    public List<Film> listAllFilms() {
        return bookDao.findAllFilms();
    }
}
