package com.UM.GrupoRural.business.entities;


import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;

import javax.persistence.*;

@Entity
@Table(name = "imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "imagen", columnDefinition = "MEDIUMBLOB", nullable = false)
    byte [] imageData;

    @ManyToOne(targetEntity = OrdenVentaGanado.class)
    @JoinColumn(name="id_orden_venta_secundaria", referencedColumnName = "id_orden")
    private OrdenVentaGanado ordenVentaGanadoSecundarias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_orden_venta_primaria", referencedColumnName = "id_orden")
    private OrdenVentaGanado ordenVentaGanadoPrimaria;

    public Imagen() {
    }

    public Imagen(Integer id, byte[] imageData) {
        this.id = id;
        this.imageData = imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getImageData() {
        return imageData;
    }
}
