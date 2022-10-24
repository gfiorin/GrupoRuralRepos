package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.Imagen;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ordenes")
public class Orden {

    public enum Estado{ACEPTADA, PENDIENTE, CANCELADA, FINALIZADA}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orden")
    private int idOrden;
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ACEPTADA','PENDIENTE', 'CANCELADA', 'FINALIZADA')")
    private Estado estado;


}
