package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.users.Comprador;
import org.springframework.data.repository.CrudRepository;

public interface CompradorRepository extends CrudRepository<Comprador, Integer> {
}