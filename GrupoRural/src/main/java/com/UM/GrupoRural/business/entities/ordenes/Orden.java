package com.UM.GrupoRural.business.entities.ordenes;

import javax.persistence.*;
import java.time.LocalDateTime;

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
