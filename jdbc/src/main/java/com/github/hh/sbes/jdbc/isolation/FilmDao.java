package com.github.hh.sbes.jdbc.isolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FilmDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FilmDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addFilm(String name, int point) {
        String sql = String.format("insert into film(name, point) values('%s', %d)", name, point);
        jdbcTemplate.update(sql);
    }

    public List<Film> findAllFilms() {
        List<Film> result = jdbcTemplate.query("select * from film", new FilmMapper());
        return result;
    }
}
