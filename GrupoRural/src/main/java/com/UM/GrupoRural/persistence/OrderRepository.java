package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entidades.ordenes.Orden;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orden, Integer> {
}