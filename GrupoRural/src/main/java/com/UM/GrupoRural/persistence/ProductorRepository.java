package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.users.Productor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductorRepository extends CrudRepository<Productor, Integer> {
    Productor findOneByUsuario(String usuario);
    Boolean existsProductorByUsuario(String usuario_mail);
    Boolean existsProductorByMail(String usuario_mail);
}