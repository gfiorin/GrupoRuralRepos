package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entidades.usuarios.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Usuario, Integer> {

    Usuario findOneByMail(String mail);

    Usuario findOneByUsuario(String usuario);

}
