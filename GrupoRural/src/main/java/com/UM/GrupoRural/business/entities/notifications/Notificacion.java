package com.UM.GrupoRural.business.entities.notifications;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "natificaciones")
public class Notificacion {

    public enum Estado{ACEPTADA, PENDIENTE, CANCELADA, FINALIZADA};
    @Id
    @Column(name = "id_notificacion")
    private int idNotificacion;
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;

}
