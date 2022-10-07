package com.UM.GrupoRural.business.entities.orders;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "id_notificacion")
@Table(name = "ordenes_venta_ganado")
public class OrdenVentaGanado extends Orden {
}
