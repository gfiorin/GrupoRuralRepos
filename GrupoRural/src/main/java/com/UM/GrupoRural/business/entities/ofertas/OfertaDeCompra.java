package com.UM.GrupoRural.business.entities.ofertas;

import com.UM.GrupoRural.business.entities.Transaccion;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Comprador;

import javax.persistence.*;

@Entity
@Table(name = "ofertas_compra")
public class OfertaDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_oferta_compra")
    private Integer idOfertaCompra;

    //Tiene un comprador que oferta
    @ManyToOne(targetEntity = Comprador.class)
    @JoinColumn(name="comprador_ofertante", referencedColumnName = "id_usuario", nullable = false)
    private Comprador compradorOfertante;

    //Tiene una orden de venta
    @ManyToOne(targetEntity = OrdenVentaGanado.class)
    @JoinColumn(name="orden_ofertada", referencedColumnName = "id_orden", nullable = false)
    private OrdenVentaGanado ordenVenta;

    // Puede tener o no una transaccion si su estado es consumada
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaccion", referencedColumnName = "id_transaccion")
    private Transaccion transaccion;

}
