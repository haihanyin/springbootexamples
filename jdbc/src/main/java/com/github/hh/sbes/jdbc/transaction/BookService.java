package com.github.hh.sbes.jdbc.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookDao bookDao;

    public void addBooks(List<Book> books) {
        books.forEach(book -> bookDao.addBook(book.getName(), book.getPage() ));
        throw new IllegalStateException();
    }

    public List<Book> listAllBooks() {
        return bookDao.findAllBook();
    }
}
