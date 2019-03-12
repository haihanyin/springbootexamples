package com.github.hh.sbes.jdbc.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addBook(String name, int page) {
        String sql = String.format("insert into book(name, page) values('%s', %d)", name, page);
        jdbcTemplate.update(sql);
    }

    public List<Book> findAllBook() {
        List<Book> result = jdbcTemplate.query("select * from book", new BookMapper());
        return result;
    }
}
