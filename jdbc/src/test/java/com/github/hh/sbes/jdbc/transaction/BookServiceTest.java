package com.github.hh.sbes.jdbc.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BookServiceTest.TestConfiguration.class)
public class BookServiceTest {

    @Configuration
    @ComponentScan(basePackages = "com.github.hh.sbes.jdbc.transaction")
    static class TestConfiguration { }

    @Autowired
    private BookService bookService;

    @Test
    public void addBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("SanGuoYanYi", 654));
        books.add(new Book("HongLouMeng", 987));
        try {
            bookService.addBooks(books);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

        List<Book> savedBooks = bookService.listAllBooks();

        savedBooks.forEach(System.out::println);
    }
}