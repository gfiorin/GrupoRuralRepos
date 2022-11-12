package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.users.Comprador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<Grupo, Integer> {
    Grupo findByNombre(String nombre);
    Grupo findOneByIdGrupo(Integer grupo);

}
