package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entidades.usuarios.Productor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductorRepository extends CrudRepository<Productor, Integer> {
}