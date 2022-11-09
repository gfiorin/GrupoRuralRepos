package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.Denuncia;
import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.Transaccion;
import com.UM.GrupoRural.business.entities.Ubicacion;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Ubicacion> ubicaciones;

    @Column(name = "puntuacion", nullable = true)
    private Integer puntuacion;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Imagen foto_de_perfil;

    @Transient
    private String img;

    //Simplifico el envio de las ubicaciones con el registro
    @Transient
    private String departamentos;

    @Transient
    private String ciudad;

    @Transient
    private String direccion;

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
        this.ubicaciones = new ArrayList<>(5);
    }

    public Usuario(String usuario, Imagen foto_de_perfil, Integer tipo_de_usuario){
        this.usuario=usuario;
        this.foto_de_perfil=foto_de_perfil;
        this.tipo_de_usuario=tipo_de_usuario;
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

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getTipo_de_usuario() {
        return tipo_de_usuario;
    }

    public void setTipo_de_usuario(Integer tipo_de_usuario) {
        this.tipo_de_usuario = tipo_de_usuario;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Imagen getFoto_de_perfil() {
        return foto_de_perfil;
    }

    public void setFoto_de_perfil(Imagen foto_de_perfil) {
        this.foto_de_perfil = foto_de_perfil;
    }

    public String getDepartamentos() {
        return departamentos;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getDireccion() {
        return direccion;
    }

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }

    public void agregarUbicacion(Ubicacion ub){
        this.ubicaciones.add(ub);
    }
}
