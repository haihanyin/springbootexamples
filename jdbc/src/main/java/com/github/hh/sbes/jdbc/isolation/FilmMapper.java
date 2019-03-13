package com.github.hh.sbes.jdbc.isolation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet resultSet, int i) throws SQLException {
        Film book = new Film();
        book.setName(resultSet.getString("name"));
        book.setPoint(resultSet.getInt("point"));
        return book;
    }
}
