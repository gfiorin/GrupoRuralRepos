package com.UM.GrupoRural.business.entities.ordenes;

import net.minidev.json.annotate.JsonIgnore;

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

    @ManyToOne(targetEntity = Orden.class, cascade = CascadeType.ALL)
    @JoinColumn(name="id_orden", referencedColumnName = "id_orden")
    @JsonIgnore
    private Orden ordenGanado;

    public Integer getId() {
        return id;
    }

    public String getRaza() {
        return raza;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Orden getOrdenGanado() {
        return ordenGanado;
    }

    public void setOrdenGanado(Orden ordenGanado) {
        this.ordenGanado = ordenGanado;
    }

    public Integer getCantidad() {
        return cantidad;
    }
}
