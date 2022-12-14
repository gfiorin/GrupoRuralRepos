package com.UM.GrupoRural.business.entities.users;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "contraseña", nullable = false)
    private String contraseña;

    @Column(name = "latitud", nullable = false)
    private long latitud;

    @Column(name = "longitud", nullable = false)
    private long longitud;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

}
