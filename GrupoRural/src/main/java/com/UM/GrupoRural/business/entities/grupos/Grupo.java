package com.UM.GrupoRural.business.entities.grupos;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Productor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    // cercania geografica, misma raza de vacunos, mismo grupo inversor, otro
    @Column(name = "motivo_de_grupo", nullable = false)
    private String motivo_de_grupo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "mensaje_invitacion")
    private String mensaje_invitacion;

    @OneToOne(mappedBy = "grupo", cascade = CascadeType.ALL)
    private Imagen icono;

    @Transient
    private String imgIcon;

    @Column(name="fecha_creacion")
    @CreationTimestamp
    private LocalDate fechaCreacion;

    @Transient
    private Float Rating;

    @Transient
    private List<String> nombresInvitados;

    @ManyToMany(mappedBy = "grupo", targetEntity = Productor.class, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("grupo")
    private List<Productor> productores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoVendedor", fetch = FetchType.LAZY)
    private Collection<OrdenVentaGanado> ordenesVenta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoOfertante", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<OfertaDeVenta> ofertasDeVenta;

    public void agregarOfertaDeVenta(OfertaDeVenta ofertaDeVenta){
        this.ofertasDeVenta.add(ofertaDeVenta);
    }

    public Grupo(String nombre, String motivo_de_grupo, String descripcion, String mensaje_invitacion) {
        this.nombre = nombre;
        this.motivo_de_grupo = motivo_de_grupo;
        this.descripcion = descripcion;
        this.mensaje_invitacion = mensaje_invitacion;
        this.fechaCreacion = LocalDate.now();
    }

    public Grupo() {
    }

    public String getMensaje_invitacion() {
        return mensaje_invitacion;
    }

    public void setMensaje_invitacion(String mensaje_invitacion) {
        this.mensaje_invitacion = mensaje_invitacion;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMotivo_de_grupo() {
        return motivo_de_grupo;
    }

    public List<Productor> getProductores() {
        return productores;
    }

    public void setProductores(List<Productor> productores) {
        this.productores = productores;
    }

    public Collection<OrdenVentaGanado> getOrdenesVenta() {
        return ordenesVenta;
    }

    public Collection<OfertaDeVenta> getOfertasDeVenta() {
        return ofertasDeVenta;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getRating(){
        int RatingSum = 0;
        int Ratings = 0;
        for (Productor p:this.productores) {
            if (p.getPuntuacion()!=null) {
                RatingSum+=p.getPuntuacion();
                Ratings++;
            }
        }
        return (Ratings==0) ? null : (float)RatingSum/Ratings;
    }

    public Imagen getIcono() {
        return icono;
    }

    public String getImgIcon() {
        return imgIcon;
    }

    public void setIcono(Imagen icono) {
        this.icono = icono;
    }

    public List<String> getNombresInvitados() {
        return nombresInvitados;
    }

    public void setNombresInvitados(List<String> nombresInvitados) {
        this.nombresInvitados = nombresInvitados;
    }
}
