package com.booklend.BookLend.service;

import com.booklend.BookLend.model.entity.Books;

import java.awt.print.Book;
import java.util.List;

public interface IBook {
    Books save(Books book);
    Books findById(Long id);
    void delete(Books book);
    List<Books>allBooks();
}
