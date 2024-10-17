package com.booklend.BookLend.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class Usuarios {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name ="apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
}
