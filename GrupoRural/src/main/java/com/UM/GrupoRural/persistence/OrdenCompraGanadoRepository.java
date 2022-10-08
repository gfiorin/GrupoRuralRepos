package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entidades.ordenes.OrdenCompraGanado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraGanadoRepository extends CrudRepository<OrdenCompraGanado, Integer> {
}