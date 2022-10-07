package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.orders.OrdenCompraGanado;
import org.springframework.data.repository.CrudRepository;

public interface OrdenCompraGanadoRepository extends CrudRepository<OrdenCompraGanado, Integer> {
}