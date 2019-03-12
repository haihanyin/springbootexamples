package com.github.hh.sbes.jdbc.transaction;

import com.github.hh.sbes.jdbc.jdbctemplate.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setName(resultSet.getString("name"));
        book.setPage(resultSet.getInt("page"));
        return book;
    }
}
