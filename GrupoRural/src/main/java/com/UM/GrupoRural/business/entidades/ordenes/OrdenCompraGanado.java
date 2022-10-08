package com.UM.GrupoRural.business.entidades.ordenes;

import com.UM.GrupoRural.business.entidades.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entidades.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entidades.usuarios.Comprador;
import com.UM.GrupoRural.business.entidades.usuarios.Usuario;

import javax.persistence.*;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_orden")
@Table(name = "ordenes_compra_ganado")
public class OrdenCompraGanado extends Orden {

    @ManyToOne(targetEntity = Comprador.class)
    @JoinColumn(name = "id_comprador", referencedColumnName = "id_usuario")
    private Comprador compradorGanado;

    //Una orden de compra tiene ofertas de venta por parte de los productores
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private Collection<OfertaDeVenta> ofertasRecibidas;
}
