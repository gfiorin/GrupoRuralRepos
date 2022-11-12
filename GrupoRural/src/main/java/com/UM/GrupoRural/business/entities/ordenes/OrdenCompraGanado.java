package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.Ubicacion;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.users.Comprador;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_orden")
@Table(name = "ordenes_compra_ganado")
public class OrdenCompraGanado extends Orden {

    @Transient
    private String nombreComprador;

    @Column(name="peso_min")
    private Integer pesoMin;
    @Column(name="peso_max")
    private Integer pesoMax;
    @Column(name="peso_promedio")
    private Integer pesoPromedio;

    @Column(name="transporte")
    private Boolean transporte;

    public OrdenCompraGanado(String titulo, String descripcion, Collection<Raza> razas, Integer pesoMin, Integer pesoMax, Integer pesoPromedio, Boolean transporte, String categoria, Integer valorInicial) {
        super(titulo, descripcion, valorInicial, razas, categoria);
        this.pesoMin=pesoMin;
        this.pesoMax=pesoMax;
        this.pesoPromedio=pesoPromedio;
        this.transporte=transporte;
    }

    public Integer getPesoMin() {
        return pesoMin;
    }

    public Integer getPesoMax() {
        return pesoMax;
    }

    public Integer getPesoPromedio() {
        return pesoPromedio;
    }

    public Boolean getTransporte() {
        return transporte;
    }

    public OrdenCompraGanado() {
    }

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Ubicacion.class)
    @JoinColumn(name="id_ubicacion", referencedColumnName = "id_ubicacion")
    private Ubicacion ubicacion;

    public Ubicacion getUbicacion() {
        return ubicacion;
    }


    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @ManyToOne(targetEntity = Comprador.class)
    @JoinColumn(name = "id_comprador", referencedColumnName = "id_usuario")
    @JsonIgnore
    private Comprador compradorGanado;

    //Una orden de compra tiene ofertas de venta por parte de los productores
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private Collection<OfertaDeVenta> ofertasRecibidas;

    public void agregarOferta(OfertaDeVenta ofertaDeVenta){
        if (this.ofertasRecibidas==null) this.ofertasRecibidas = new ArrayList<>();
        this.ofertasRecibidas.add(ofertaDeVenta);
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public Comprador getCompradorGanado() {
        return compradorGanado;
    }

    public void setCompradorGanado(Comprador compradorGanado) {
        this.compradorGanado = compradorGanado;
    }
}
