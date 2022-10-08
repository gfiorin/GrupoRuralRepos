package com.UM.GrupoRural.business.entidades.usuarios;

import com.UM.GrupoRural.business.entidades.Denuncia;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "usuario", nullable = false)
    private String usuario;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    @Column(name = "latitud", nullable = false)
    private long latitud;

    @Column(name = "longitud", nullable = false)
    private long longitud;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denunciante", fetch = FetchType.LAZY)
    private Collection<Denuncia> denunciasRealizadas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denunciado", fetch = FetchType.LAZY)
    private Collection<Denuncia> denunciasRecibidas;



    public Usuario(String mail, String usuario, String contrasena) {
        this.mail = mail;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Usuario() {
    }

}
