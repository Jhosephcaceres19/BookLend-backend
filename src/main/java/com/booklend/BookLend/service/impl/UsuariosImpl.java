package com.booklend.BookLend.service.impl;

import com.booklend.BookLend.model.dao.UsuarioDao;
import com.booklend.BookLend.model.entity.Usuarios;
import com.booklend.BookLend.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuariosImpl implements IUsuario {

    @Autowired
    private UsuarioDao usuarioDao;
/**Agregando un usuario**/
    @Override
    @Transactional
    public Usuarios save(Usuarios usuario) {
        try {
            if (usuario == null || usuario.getNombre() == null || usuario.getNombre() == null){
                throw new IllegalStateException("El nombre del usuario es obligatorio");
            }
            return  usuarioDao.save(usuario);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Error al agregar el usuario");
        }
    }
/**Buscar usuario por id**/
    @Override
    @Transactional
    public Usuarios findById(Long id) {
        try{
            if(id == null || id == 0){
                throw new IllegalStateException("El id del usuario es obligatorio");
            }
            return usuarioDao.findById(id).orElse(null);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al buscar el usuario");
        }
    }
/**Eliminar un usuario**/
    @Override
    @Transactional
    public void delete(Usuarios usuario) {
        try {
            if (usuario == null || usuario.getNombre() == null || usuario.getNombre() == null){
                throw new IllegalStateException("El nombre del usuario es obligatorio");
            }
            usuarioDao.delete(usuario);
        }catch (Exception e){
            throw new RuntimeException("Error al eliminar el usuario");
        }
    }
}
