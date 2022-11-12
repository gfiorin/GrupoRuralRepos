package com.UM.GrupoRural.business.entities.ofertas;

import com.UM.GrupoRural.business.entities.Transaccion;
import com.UM.GrupoRural.business.entities.ordenes.Orden;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Comprador;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ofertas_compra")
public class OfertaDeCompra {

    public enum Estado{PENDIENTE, ACEPTADA, ENCAMINO, CANCELADA, ENCTREGADA}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_oferta_compra")
    private Integer idOfertaCompra;

    @Transient
    private String nombreComprador;

    @Column(name="fecha")
    @CreationTimestamp
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('PENDIENTE','ACEPTADA','ENCAMINO', 'CANCELADA', 'ENTREGADA') default 'PENDIENTE'")
    private Orden.Estado estado;

    //Tiene un comprador que oferta
    @ManyToOne(targetEntity = Comprador.class, cascade = CascadeType.ALL)
    @JoinColumn(name="comprador_ofertante", referencedColumnName = "id_usuario", nullable = false)
    @JsonIgnoreProperties("ofertasDeCompra")
    private Comprador compradorOfertante;

    //Tiene una orden de venta
    @ManyToOne(targetEntity = OrdenVentaGanado.class, cascade = CascadeType.MERGE)
    @JoinColumn(name="orden_ofertada", referencedColumnName = "id_orden", nullable = false)
    @JsonIgnoreProperties("ofertasRecibidas")
    private OrdenVentaGanado ordenVenta;

    // Puede tener o no una transaccion si su estado es consumada
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion")
    private Transaccion transaccion;

    public Orden.Estado getEstado() {
        return estado;
    }

    public void setEstado(Orden.Estado estado) {
        this.estado = estado;
    }

    public Integer getIdOfertaCompra() {
        return idOfertaCompra;
    }

    public void setIdOfertaCompra(Integer idOfertaCompra) {
        this.idOfertaCompra = idOfertaCompra;
    }

    public String getNombreComprador() {
        return nombreComprador;
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;
    }

    public Comprador getCompradorOfertante() {
        return compradorOfertante;
    }

    public void setCompradorOfertante(Comprador compradorOfertante) {
        this.compradorOfertante = compradorOfertante;
    }

    public OrdenVentaGanado getOrdenVenta() {
        return ordenVenta;
    }

    public void setOrdenVenta(OrdenVentaGanado ordenVenta) {
        this.ordenVenta = ordenVenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public OfertaDeCompra(Comprador compradorOfertante, OrdenVentaGanado ordenVenta) {
        this.compradorOfertante = compradorOfertante;
        this.ordenVenta = ordenVenta;
    }

    public OfertaDeCompra() {
    }
}
