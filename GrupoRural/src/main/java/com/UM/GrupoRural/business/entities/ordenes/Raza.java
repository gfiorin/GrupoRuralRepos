package com.UM.GrupoRural.business.entities.ordenes;

import javax.persistence.*;

@Entity
@Table(name="razas")
public class Raza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name="raza")
    private String raza;

    @Column(name="cantidad")
    private Integer cantidad;

    @ManyToOne(targetEntity = Orden.class)
    @JoinColumn(name="id_orden", referencedColumnName = "id_orden")
    private Orden ordenGanado;
}
