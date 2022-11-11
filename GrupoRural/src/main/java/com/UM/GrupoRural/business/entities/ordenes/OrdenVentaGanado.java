package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.LoteGanado;
import com.UM.GrupoRural.business.entities.Ubicacion;
import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.users.Productor;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id_orden")
@Table(name = "ordenes_venta_ganado")
public class OrdenVentaGanado extends Orden {

    @ManyToOne(targetEntity = Grupo.class)
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    private Grupo grupoVendedor;

    @Column(name="peso_min")
    private Integer pesoMin;
    @Column(name="peso_max")
    private Integer pesoMax;
    @Column(name="peso_promedio")
    private Integer pesoPromedio;
    @Column(name="transporte")
    private Boolean transporte;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenVenta", fetch = FetchType.LAZY)
    private Collection<OfertaDeCompra> ofertasRecibidas;

    //Imagen principal
    @OneToOne(mappedBy = "ordenVentaGanadoPrimaria", cascade = CascadeType.ALL)
    private Imagen imagenPrincipal;

    public OrdenVentaGanado(String titulo, String descripcion, Integer valorInicial, Collection<Raza> razas, Grupo grupoVendedor, Integer pesoMin, Integer pesoMax, Integer pesoPromedio, Boolean transporte, String categoria) {
        super(titulo, descripcion, valorInicial, razas, categoria);
        this.grupoVendedor = grupoVendedor;
        this.pesoMin = pesoMin;
        this.pesoMax = pesoMax;
        this.pesoPromedio = pesoPromedio;
        this.transporte = transporte;
    }

    public OrdenVentaGanado() {
    }

    public Grupo getGrupoVendedor() {
        return grupoVendedor;
    }

    public void setGrupoVendedor(Grupo grupoVendedor) {
        this.grupoVendedor = grupoVendedor;
    }

    public Integer getPesoMin() {
        return pesoMin;
    }

    public void setPesoMin(Integer pesoMin) {
        this.pesoMin = pesoMin;
    }

    public Integer getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(Integer pesoMax) {
        this.pesoMax = pesoMax;
    }

    public Integer getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(Integer pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public Boolean getTransporte() {
        return transporte;
    }

    public void setTransporte(Boolean transporte) {
        this.transporte = transporte;
    }

    public Collection<OfertaDeCompra> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    public void setOfertasRecibidas(Collection<OfertaDeCompra> ofertasRecibidas) {
        this.ofertasRecibidas = ofertasRecibidas;
    }

    public Imagen getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(Imagen imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }

    public Collection<Imagen> getImagenesSecundarias() {
        return imagenesSecundarias;
    }

    public void setImagenesSecundarias(Collection<Imagen> imagenesSecundarias) {
        this.imagenesSecundarias = imagenesSecundarias;
    }

    //Imagenes secundarias
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenVentaGanadoSecundarias", fetch = FetchType.EAGER)
    private Collection<Imagen> imagenesSecundarias;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "ordenesVenta", targetEntity = Ubicacion.class)
    private List<Ubicacion> ubicaciones;

    public List<Ubicacion> getUbicaciones() {
        return ubicaciones;
    }

    public void setUbicaciones(List<Ubicacion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
}
