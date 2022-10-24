package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;

import javax.persistence.*;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_orden")
@Table(name = "ordenes_venta_ganado")
public class OrdenVentaGanado extends Orden {

    @ManyToOne(targetEntity = Grupo.class)
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    private Grupo grupoVendedor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenVenta", fetch = FetchType.LAZY)
    private Collection<OfertaDeCompra> ofertasRecibidas;


}
