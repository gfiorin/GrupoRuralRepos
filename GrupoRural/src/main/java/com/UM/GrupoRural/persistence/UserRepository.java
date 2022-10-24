package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.users.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer> {

    Usuario findOneByMail(String mail);

    Boolean existsByMail(String mail);

    Boolean existsByUsuario(String usuario);

    Usuario findOneByUsuario(String usuario);


}
