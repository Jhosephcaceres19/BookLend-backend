package com.booklend.BookLend.controller;

import com.booklend.BookLend.model.entity.Books;
import com.booklend.BookLend.service.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BooksController {
    @Autowired
    private IBook bookService;

    public Books createBook(Books book) {
        return bookService.save(book);
    }
    public Books updateBook(Books book) {
        return bookService.save(book);
    }
    public void deleteBook(@PathVariable Long id) {
        Books bookDelete = bookService.findById(id);
        bookService.delete(bookDelete);
    }
    public Books showBook(@PathVariable Long id) {
        return bookService.findById(id);
    }
    public List<Books> getAllBooks() {
        return bookService.allBooks();
    }
}
