package com.UM.GrupoRural.business.entities.notifications;

import java.time.LocalDateTime;

public class Notificacion {

    private LocalDateTime fecha;
    private String estado;
    private enum Estado{ACEPTADA, PENDIENTE, CANCELADA, FINALIZADA}

}
