package com.booklend.BookLend.service.impl;

import com.booklend.BookLend.model.dao.UsuarioDao;
import com.booklend.BookLend.model.entity.Usuarios;
import com.booklend.BookLend.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional
    public Usuarios save(Usuarios usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public Usuarios findById(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Usuarios usuario) {
        usuarioDao.delete(usuario);
    }
}
