package com.UM.GrupoRural.persistence;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import org.springframework.data.repository.CrudRepository;

public interface OfertaDeVentaRepository extends CrudRepository<OfertaDeVenta, Integer> {
}
