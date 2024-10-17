package com.booklend.BookLend.controller;

import com.booklend.BookLend.model.entity.Books;
import com.booklend.BookLend.service.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BooksController {
    @Autowired
    private IBook bookService;

    @PostMapping("book")
    public Books createBook(@RequestBody Books book) {
        return bookService.save(book);
    }
    @PutMapping("book")
    public Books updateBook(@RequestBody Books book) {
        return bookService.save(book);
    }
    @DeleteMapping("book/{id}")
    public void deleteBook(@PathVariable Long id) {
        Books bookDelete = bookService.findById(id);
        bookService.delete(bookDelete);
    }

    @GetMapping("book/{id}")
    public Books showBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @GetMapping("book")
    public List<Books> getAllBooks() {
        return bookService.allBooks();
    }
}
