package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.users.Productor;
import org.springframework.data.repository.CrudRepository;

public interface ProductorRepository extends CrudRepository<Productor, Integer> {
}