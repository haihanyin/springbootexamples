package com.github.hh.sbes.jdbc.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class PersonDao {

    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addPerson(String name, int age) {
        String sql = "INSERT INTO people(name, age) values ('%s', %d)";
        jdbcTemplate.update(String.format(sql, name, age));
    }

    public List<Person> listPeople() {
        String sql = "SELECT * FROM people";
        return jdbcTemplate.query(sql, new PersonMapper());
    }
}
