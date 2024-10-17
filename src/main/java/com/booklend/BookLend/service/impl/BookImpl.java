package com.booklend.BookLend.service.impl;

import com.booklend.BookLend.model.dao.BookDao;
import com.booklend.BookLend.model.entity.Books;
import com.booklend.BookLend.service.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;


@Service
public class BookImpl implements IBook {
    @Autowired
    private BookDao bookDao;


    @Override
    @Transactional
    public Books save(Books book) {
        return bookDao.save(book);
    }

    @Override
    @Transactional
    public Books findById(Long id) {
        return bookDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Books book) {
        bookDao.delete(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Books> allBooks() {
        return (List<Books>) bookDao.findAll();
    }
}

