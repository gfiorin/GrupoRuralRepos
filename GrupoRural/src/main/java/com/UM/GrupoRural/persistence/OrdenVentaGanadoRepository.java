package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entidades.ordenes.OrdenVentaGanado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenVentaGanadoRepository extends CrudRepository<OrdenVentaGanado, Integer> {
}