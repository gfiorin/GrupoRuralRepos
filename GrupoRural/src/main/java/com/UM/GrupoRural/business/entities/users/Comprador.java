package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
@Table(name = "compradores")
public class Comprador extends Usuario {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorGanado", fetch = FetchType.LAZY)
    private Collection<OrdenCompraGanado> odenesDeCompra;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorOfertante", fetch = FetchType.LAZY)
    private Collection<OfertaDeCompra> ofertasDeCompra;

    public Comprador(String nombre_completo, String mail, String telefono, String cedula, String usuario, String contrasena, LocalDate fecha_de_nacimiento) {
        super(nombre_completo, mail, telefono, cedula, usuario, contrasena, fecha_de_nacimiento);
    }

    public Comprador() {

    }
}
