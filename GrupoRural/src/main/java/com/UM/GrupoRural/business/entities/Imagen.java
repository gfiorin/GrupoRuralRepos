package com.UM.GrupoRural.business.entities;


import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Usuario;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    public Imagen() {
    }

    public Imagen(byte[] imageData, OrdenVentaGanado ordenVentaGanadoPrimaria) {
        this.imageData = imageData;
        this.ordenVentaGanadoPrimaria = ordenVentaGanadoPrimaria;
    }
    public Imagen(OrdenVentaGanado ordenVentaGanadoSecundarias, byte[] imageData) {
        this.imageData = imageData;
        this.ordenVentaGanadoSecundarias = ordenVentaGanadoSecundarias;
    }

    public Imagen(byte[] imageData) {
        this.imageData = imageData;
    }

    public Imagen(byte[] imageData, Usuario user) {
        this.imageData = imageData;
        this.usuario = user;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public byte[] getImageData() {
        return imageData;
    }
}
