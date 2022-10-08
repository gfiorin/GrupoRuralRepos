package com.UM.GrupoRural.business.entidades;

import javax.persistence.*;

@Entity
@Table(name = "ganado")
public class Ganado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ganado", nullable = false)
    private int idGanado;
    @Column(name = "precio_venta", nullable = false)
    private double precioVenta;
    @Column(name = "especie", nullable = false)
    private String especie;
    @Column(name = "tipo", nullable = false)
    private String tipo; //Si es ternero, ovino, etc
    @Column(name = "raza", nullable = false)
    private String raza; //Que raza de ternero es

}
