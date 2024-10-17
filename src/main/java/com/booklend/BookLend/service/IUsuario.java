package com.booklend.BookLend.service;

import com.booklend.BookLend.model.entity.Usuarios;

public interface IUsuario {
    Usuarios save(Usuarios usuario);
    Usuarios findById(Long id);
    void delete(Usuarios usuario);
}
