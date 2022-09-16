package com.UM.GrupoRural.entities.notificaciones;

import java.time.LocalDateTime;

public class Notificacion {

    private LocalDateTime fecha;
    private String estado;
    private enum Estado{ACEPTADA, PENDIENTE, CANCELADA, FINALIZADA}

}
