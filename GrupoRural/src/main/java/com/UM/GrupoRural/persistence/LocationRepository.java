package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.Ubicacion;
import com.UM.GrupoRural.business.entities.users.Comprador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends CrudRepository<Ubicacion,Integer >{


}


