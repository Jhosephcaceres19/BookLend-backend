package com.booklend.BookLend.service.impl;

import com.booklend.BookLend.model.dao.BookDao;
import com.booklend.BookLend.model.entity.Books;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.awt.print.Book;

import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BookImplTest {

    @Mock
    private BookDao bookDao;  // Simulamos la dependencia de BookDao

    @InjectMocks
    private BookImpl bookService;  // Inyectamos la dependencia simulada en el servicio

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializamos los mocks antes de cada prueba
    }

    @Test
    void testSaveBook() {
        // Dado (arrange): Creamos un libro y simulamos el comportamiento del DAO
        Books book = new Books(1L, "Mockito in Action", "Author", "www.image.jpg");
        Books esperado = new Books(2L,"Mockito in Action","Author","www.image.jpg");
        Mockito.when(bookDao.save(book)).thenReturn(book);  // Simulamos la respuesta de save()

        // Cuando (act): Llamamos al método save() del servicio
        Books savedBook = bookService.save(book);

        // Entonces (assert): Verificamos que el libro guardado sea el esperado
        assertEquals(book.getIdBook(), savedBook.getIdBook());
        assertEquals(esperado.getTitle(), savedBook.getTitle());
        assertEquals(book.getAuthor(), savedBook.getAuthor());
        assertEquals(book.getImage(), savedBook.getImage());
    }


    @Test
    void delete() {
        Books delete = new Books(1L, "Mockito in Action", "Author", "www.image.jpg");

        // Simular la llamada al método void
        Mockito.doNothing().when(bookDao).delete(delete);

        // Llamar al método delete del servicio
        bookService.delete(delete);

        // Verificar que el método del DAO fue llamado con el libro correcto
        Mockito.verify(bookDao, Mockito.times(1)).delete(delete);
    }

    @Test
    void findById(){
        Books book = new Books(1L, "Mockito in Action", "Author", "www.image.jpg");

    }

}