package com.github.hh.sbes.jdbc.isolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmSlowService {

    @Autowired
    private FilmDao filmDao;

    public void addFilms(List<Film> films) {
        films.forEach(book -> filmDao.addFilm(book.getName(), book.getPoint() ));
    }

    public List<Film> listAllFilms() {
        return filmDao.findAllFilms();
    }
}
