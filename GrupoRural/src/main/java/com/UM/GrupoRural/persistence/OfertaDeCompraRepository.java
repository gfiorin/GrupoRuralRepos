package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import org.springframework.data.repository.CrudRepository;

public interface OfertaDeCompraRepository extends CrudRepository<OfertaDeCompra, Integer> {
    OfertaDeCompra findByIdOfertaCompra(Integer idOfertaCompra);

}