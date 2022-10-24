package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.Denuncia;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "nombre_completo", nullable = false)
    private String nombre_completo;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "telefono", nullable = false, unique = true)
    private String telefono;

    @Column(name = "cedula", nullable = false, unique = true)
    private String cedula;

    @Column(name = "usuario", nullable = false, unique = true)
    private String usuario;

    @Column(name = "contraseña", nullable = false)
    private String contrasena;

    @Column(name = "fecha_de_nacimiento", nullable = false)
    private LocalDate fecha_de_nacimiento;

    @Column(name = "departamento", nullable = false, unique = true)
    private String departamento;

    @Column(name = "ciudad", nullable = false, unique = true)
    private String ciudad;

    @Column(name = "calle_y_numero", nullable = false)
    private String calle_y_numero;

    @Transient
    private Integer tipo_de_usuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denunciante", fetch = FetchType.LAZY)
    private Collection<Denuncia> denunciasRealizadas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "denunciado", fetch = FetchType.LAZY)
    private Collection<Denuncia> denunciasRecibidas;

    public Usuario(String nombre_completo, String mail, String telefono, String cedula, String usuario, String contrasena, LocalDate fecha_de_nacimiento) {
        this.nombre_completo = nombre_completo;
        this.mail = mail;
        this.telefono = telefono;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public Usuario() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public String getMail() {
        return mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCalle_y_numero() {
        return calle_y_numero;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public LocalDate getFecha_de_nacimiento() {
        return fecha_de_nacimiento;
    }

    public Collection<Denuncia> getDenunciasRealizadas() {
        return denunciasRealizadas;
    }

    public Collection<Denuncia> getDenunciasRecibidas() {
        return denunciasRecibidas;
    }

    public Integer getTipo_de_usuario() {
        return tipo_de_usuario;
    }

    public void setTipo_de_usuario(Integer tipo_de_usuario) {
        this.tipo_de_usuario = tipo_de_usuario;
    }

}
