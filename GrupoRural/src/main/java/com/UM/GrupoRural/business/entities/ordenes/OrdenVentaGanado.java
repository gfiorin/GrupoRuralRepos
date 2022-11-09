package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.users.Productor;

import javax.persistence.*;
import java.util.Collection;

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
    @OneToOne(mappedBy = "ordenVentaGanadoPrimaria")
    private Imagen imagenPrincipal;


    //Imagenes secundarias
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenVentaGanadoSecundarias", fetch = FetchType.EAGER)
    private Collection<Imagen> imagenesSecundarias;


}
