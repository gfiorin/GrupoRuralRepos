package com.UM.GrupoRural.business.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ganado")
public class Ganado {

    @Id
    private int idGanado;
    @Column(name = "fecha", nullable = false)
    private double precioVenta;
    @Column(name = "fecha", nullable = false)
    private String especie;
    @Column(name = "fecha", nullable = false)
    private String tipo; //Si es ternero, ovino, etc
    @Column(name = "fecha", nullable = false)
    private String raza; //Que raza de ternero es

}
