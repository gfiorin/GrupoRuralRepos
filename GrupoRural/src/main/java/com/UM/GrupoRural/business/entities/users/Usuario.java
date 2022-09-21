package com.UM.GrupoRural.business.entities.users;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario {

    @Id
    private String mail;
    @Column(name = "password", nullable = false)
    private String contraseña;
    @Column(name = "latitud", nullable = false)
    private long latitud;
    @Column(name = "longitud", nullable = false)
    private long longitud;
    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

}
