package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.LoteGanado;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ordenes")
public class Orden {

    public enum Estado{ACEPTADA, PENDIENTE, CANCELADA, FINALIZADA}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orden")
    private int idOrden;

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getValorInicial() {
        return valorInicial;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setValorInicial(Integer valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getNumeroDeCabezas() {
        return numeroDeCabezas;
    }

    public void setNumeroDeCabezas(Integer numeroDeCabezas) {
        this.numeroDeCabezas = numeroDeCabezas;
    }

    public Collection<Raza> getRazas() {
        return razas;
    }

    public void setRazas(Collection<Raza> razas) {
        this.razas = razas;
    }

    @Transient
    private String mainImg;

    @Transient
    private Collection<String> secondaryImgs;

    public String getMainImg() {
        return mainImg;
    }

    public void setMainImg(String mainImg) {
        this.mainImg = mainImg;
    }

    public Collection<String> getSecondaryImgs() {
        return secondaryImgs;
    }

    public void setSecondaryImgs(Collection<String> secondaryImgs) {
        this.secondaryImgs = secondaryImgs;
    }

    @Column(name = "fecha")
    @CreationTimestamp
    private LocalDateTime fecha;
    @Column(name = "titulo")
    private String titulo;
    @Column(name= "descipcion")
    private String descripcion;
    @Column(name="valor_inicial")
    private Integer valorInicial;
    @Column(name="motivo")
    private String motivo;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ACEPTADA','PENDIENTE', 'CANCELADA', 'FINALIZADA')")
    private Estado estado;
    @Column(name="cabezas")
    private Integer numeroDeCabezas;

    @Column(name="categoria")
    private String categoria;



    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Orden(String titulo, String descripcion, Integer valorInicial, Collection<Raza> razas, String categoria) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.valorInicial = valorInicial;
        this.razas = razas;
        this.categoria = categoria;
    }

    public Orden() {
    }

    @OneToMany(mappedBy = "ordenGanado", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "ordenGanado")
    private Collection<Raza> razas;


}
