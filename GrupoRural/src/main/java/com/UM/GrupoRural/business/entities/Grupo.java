package com.UM.GrupoRural.business.entities;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Productor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    //private String chat;

    @Column(name = "area", nullable = false)
    private String area;
    //private String historialVentas;

    @Column(name = "numero_participantes", nullable = false)
    private int numeroparticipantes;

    @ManyToMany(mappedBy = "grupos",
            targetEntity = Productor.class)
    private Collection<Productor> productores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoVendedor", fetch = FetchType.LAZY)
    private Collection<OrdenVentaGanado> ordenesVenta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoOfertante", fetch = FetchType.LAZY)
    private Collection<OfertaDeVenta> ofertasDeVenta;

}
