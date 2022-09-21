package com.UM.GrupoRural.business.entities.notifications;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id_notificacion")
@Table(name = "notificaciones_venta_ganado")
public class NotificacionVentaGanado extends Notificacion {
}
