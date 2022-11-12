package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Comprador;
import com.UM.GrupoRural.persistence.CompradorRepository;
import com.UM.GrupoRural.persistence.GroupRepository;
import com.UM.GrupoRural.persistence.OfertaDeCompraRepository;
import com.UM.GrupoRural.persistence.OfertaDeVentaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OfertaMgr {

    private final OfertaDeCompraRepository ofertaDeCompraRepository;
    private final OfertaDeVentaRepository ofertaDeVentaRepository;
    private final CompradorRepository compradorRepository;
    private final GroupRepository groupRepository;


    public OfertaMgr(OfertaDeCompraRepository ofertaDeCompraRepository, CompradorRepository compradorRepository, GroupRepository groupRepository, OfertaDeVentaRepository ofertaDeVentaRepository) {
        this.ofertaDeCompraRepository = ofertaDeCompraRepository;
        this.compradorRepository = compradorRepository;
        this.groupRepository = groupRepository;
        this.ofertaDeVentaRepository = ofertaDeVentaRepository;
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

    @Transactional
    public void crearOfertaVenta(Integer grupo, OrdenCompraGanado ordenCompraGanado){
        OfertaDeVenta newOferta = new OfertaDeVenta();
        Grupo cliente = groupRepository.findOneByIdGrupo(grupo);
        newOferta.setGrupoOfertante(cliente);
        ordenCompraGanado.agregarOferta(newOferta);
        cliente.agregarOfertaDeVenta(newOferta);
        newOferta.setOrdenCompra(ordenCompraGanado);
        ofertaDeVentaRepository.save(newOferta);

    }

    @Transactional
    public void updateEstadoOfertaCompra(Integer id, String estado) throws Exception {
        OfertaDeCompra.Estado nuevoEstado = OfertaDeCompra.Estado.valueOf(estado);
        OfertaDeCompra oferta = ofertaDeCompraRepository.findByIdOfertaCompra(id);
        if (oferta==null){throw new Exception("ERROR: No se encontró la oferta");}
        oferta.setEstado(nuevoEstado);
        ofertaDeCompraRepository.save(oferta);
    }
}
