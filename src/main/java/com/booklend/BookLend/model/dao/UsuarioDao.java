package com.booklend.BookLend.model.dao;

import com.booklend.BookLend.model.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuarios, Long> {
}
