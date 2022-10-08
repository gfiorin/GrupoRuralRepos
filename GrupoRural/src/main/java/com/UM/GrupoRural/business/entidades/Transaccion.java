package com.UM.GrupoRural.business.entidades;

import com.UM.GrupoRural.business.entidades.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entidades.ofertas.OfertaDeVenta;

import javax.persistence.*;

@Entity
@Table(name = "transacciones")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaccion")
    private Integer idTransaccion;

    @ManyToOne(targetEntity = MetodoDePago.class)
    @JoinColumn(name="metodo_pago", referencedColumnName = "id_metodo", nullable = false)
    private MetodoDePago metodoDePago;

    @OneToOne(mappedBy = "transaccion")
    private OfertaDeCompra ofertaDeCompra;

    @OneToOne(mappedBy = "transaccion")
    private OfertaDeVenta ofertaDeVenta;
}
