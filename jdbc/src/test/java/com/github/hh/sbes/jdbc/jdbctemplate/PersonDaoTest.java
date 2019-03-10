package com.github.hh.sbes.jdbc.jdbctemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersonDaoTest.TestConfiguration.class)
public class PersonDaoTest {

    @Configuration
    @ComponentScan(basePackages = { "com.github.hh.sbes.jdbc.jdbctemplate" })
    static class TestConfiguration {}

    @Autowired
    private PersonDao personDao;

    @Test
    public void test() {
        personDao.addPerson("John", 23);
        List<Person> people = personDao.listPeople();
        people.forEach(System.out::println);
    }
}