package com.UM.GrupoRural.business.entities;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "ganado")
public class LoteGanado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ganado", nullable = false)
    private int idGanado;

    @Column(name = "cat_ganado", nullable = false)
    private String catGanado;

    @Column(name = "raza", nullable = false)
    private String raza;

    @Column(name = "cabezas", nullable = false)
    private Integer cabezas;

    @Column(name = "peso_max", nullable = false)
    private Integer pesoMax;

    @Column(name = "peso_min", nullable = false)
    private Integer pesoMin;

    @Column(name = "peso_prom", nullable = false)
    private Integer pesoProm;

    @Column(name = "edad_prom", nullable = false)
    private Integer edadProm;

    //Habria que sacar un cartel que diga que no se puede vender ganado enfermo cuando le das a cargar orden

    @Column(name = "precio_venta", nullable = false)
    private double precioVenta;

    @Column(name = "observaciones", nullable = true)
    private String observaciones;

    @ManyToMany(mappedBy = "lotes", targetEntity = Ubicacion.class)
    private Collection<Ubicacion> ubicaciones;

}
