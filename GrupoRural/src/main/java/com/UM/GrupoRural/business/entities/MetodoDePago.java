package com.UM.GrupoRural.business.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "metodos_pago")
public class MetodoDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_metodo")
    private int idMetodo;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodoDePago", fetch = FetchType.LAZY)
    private Collection<Transaccion> transacciones;

}
