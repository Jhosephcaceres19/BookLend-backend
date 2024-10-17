package com.booklend.BookLend.controller;

import com.booklend.BookLend.model.entity.Usuarios;
import com.booklend.BookLend.service.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UsuariosController {

    @Autowired
    private IUsuario usuarioService;

    @PostMapping("user")
    public Usuarios createUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("user")
    public Usuarios updateUsuario(@RequestBody Usuarios usuario) {
        return usuarioService.save(usuario);
    }

    @DeleteMapping("user/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        Usuarios usuariosDelete = usuarioService.findById(id);
        usuarioService.delete(usuariosDelete);
    }

    @GetMapping("user/{id}")
    public Usuarios showUsuario(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

}
