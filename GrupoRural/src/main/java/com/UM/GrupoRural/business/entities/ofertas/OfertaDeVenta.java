package com.UM.GrupoRural.business.entities.ofertas;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.Transaccion;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ofertas_venta")
public class OfertaDeVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_oferta_venta")
    private Integer idOfertaVenta;

    //Tiene un grupo de productores que oferta
    @ManyToOne(targetEntity = Grupo.class)
    @JoinColumn(name="grupo_ofertante", referencedColumnName = "id_grupo", nullable = false)
    private Grupo grupoOfertante;

    //Tiene una orden de venta
    @ManyToOne(targetEntity = OrdenCompraGanado.class)
    @JoinColumn(name="orden_ofertada", referencedColumnName = "id_orden", nullable = false)
    private OrdenCompraGanado ordenCompra;

    // Puede tener o no una transaccion si su estado es consumada
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion")
    private Transaccion transaccion;

    @Column(name="fecha")
    @CreationTimestamp
    private LocalDate fecha;

    public Integer getIdOfertaVenta() {
        return idOfertaVenta;
    }

    public void setIdOfertaVenta(Integer idOfertaVenta) {
        this.idOfertaVenta = idOfertaVenta;
    }

    public Grupo getGrupoOfertante() {
        return grupoOfertante;
    }

    public void setGrupoOfertante(Grupo grupoOfertante) {
        this.grupoOfertante = grupoOfertante;
    }

    public OrdenCompraGanado getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompraGanado ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
