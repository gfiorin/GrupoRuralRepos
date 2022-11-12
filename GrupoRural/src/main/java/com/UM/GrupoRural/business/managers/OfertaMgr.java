package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Comprador;
import com.UM.GrupoRural.persistence.CompradorRepository;
import com.UM.GrupoRural.persistence.OfertaDeCompraRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OfertaMgr {

    private final OfertaDeCompraRepository ofertaDeCompraRepository;
    private final CompradorRepository compradorRepository;


    public OfertaMgr(OfertaDeCompraRepository ofertaDeCompraRepository, CompradorRepository compradorRepository) {
        this.ofertaDeCompraRepository = ofertaDeCompraRepository;
        this.compradorRepository = compradorRepository;
    }

    @Transactional
    public void crearOfertaCompra(String comprador, OrdenVentaGanado ordenVentaGanado){
        OfertaDeCompra newOferta = new OfertaDeCompra();
        Comprador cliente = compradorRepository.findOneByUsuario(comprador);
        newOferta.setCompradorOfertante(cliente);
        ordenVentaGanado.agregarOferta(newOferta);
        cliente.agregarOferta(newOferta);
        newOferta.setOrdenVenta(ordenVentaGanado);
        ofertaDeCompraRepository.save(newOferta);

    }
}
