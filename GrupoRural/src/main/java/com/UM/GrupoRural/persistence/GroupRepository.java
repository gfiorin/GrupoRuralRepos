package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Integer, Grupo> {
}
