package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.orders.OrdenVentaGanado;
import org.springframework.data.repository.CrudRepository;

public interface OrdenVentaGanadoRepository extends CrudRepository<OrdenVentaGanado, Integer> {
}