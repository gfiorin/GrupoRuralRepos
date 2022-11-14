package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenVentaGanadoRepository extends CrudRepository<OrdenVentaGanado, Integer> {
    List<OrdenVentaGanado> findByIdOrdenNot(Integer idOrden);


}