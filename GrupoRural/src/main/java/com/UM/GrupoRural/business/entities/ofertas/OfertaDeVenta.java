package com.UM.GrupoRural.business.entities.ofertas;

import com.UM.GrupoRural.business.entities.Grupo;
import com.UM.GrupoRural.business.entities.Transaccion;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;


import javax.persistence.*;

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


}
