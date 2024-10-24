package com.booklend.BookLend.service.impl;

import com.booklend.BookLend.model.dao.BookDao;
import com.booklend.BookLend.model.entity.Books;
import com.booklend.BookLend.service.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;


@Service
public class BookImpl implements IBook {
    @Autowired
    private BookDao bookDao;

/**guardar libros*/
    @Override
    @Transactional
    public Books save(Books book) {
        try {
            if (book == null || book.getTitle() == null || book.getTitle().isEmpty()) {
                throw new IllegalArgumentException("El libro o el título no puede ser nulo o vacío.");
            }
            return bookDao.save(book);
        } catch (DataIntegrityViolationException e) {
            // Manejar error por restricción de base de datos (ej. campos obligatorios no cumplidos)
            throw new RuntimeException("Error al guardar el libro: " + e.getMessage(), e);
        }
    }
/**buscar libro por id**/
    @Override
    @Transactional
    public Books findById(Long id) {
        try {
            if (id == null || id <= 0) {
                throw new IllegalArgumentException("El ID proporcionado no es válido.");
            }
            return bookDao.findById(id).orElseThrow(() ->
                    new RuntimeException("Libro no encontrado con el ID: " + id)
            );
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al buscar el libro: " + e.getMessage(), e);
        }
    }
/**eliminar libro**/
    @Override
    @Transactional
    public void delete(Books book) {
        try {
            if (book == null || book.getIdBook() == null) {
                throw new IllegalArgumentException("El libro o su ID no puede ser nulo.");
            }
            bookDao.delete(book);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("No se encontró el libro a eliminar: " + e.getMessage(), e);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al eliminar el libro: " + e.getMessage(), e);
        }
    }
/**traer todos los libros**/
    @Override
    @Transactional(readOnly = true)
    public List<Books> allBooks() {
        try {
            List<Books> books = (List<Books>) bookDao.findAll();
            if (books.isEmpty()) {
                throw new RuntimeException("No se encontraron libros.");
            }
            return books;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error al traer los libros: " + e.getMessage(), e);
        }
    }
}

