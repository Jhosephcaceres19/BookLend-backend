package com.booklend.BookLend.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.booklend.BookLend.model.entity.Books;

public interface BookDao extends CrudRepository<Books, Long> {

}
