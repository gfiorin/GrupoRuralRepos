package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.Ubicacion;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ordenes.Orden;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
@Table(name = "compradores")
public class Comprador extends Usuario {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorGanado", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrdenCompraGanado> odenesDeCompra;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compradorOfertante", fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<OfertaDeCompra> ofertasDeCompra;

    public Comprador(String nombre_completo, String mail, String telefono, String cedula, String usuario, String contrasena, LocalDate fecha_de_nacimiento) {
        super(nombre_completo, mail, telefono, cedula, usuario, contrasena, fecha_de_nacimiento);
    }

    public Comprador() {

    }


    public List<OrdenCompraGanado> getOdenesDeCompra() {
        return odenesDeCompra;
    }

    public void setOdenesDeCompra(List<OrdenCompraGanado> odenesDeCompra) {
        this.odenesDeCompra = odenesDeCompra;
    }

    public void agregarOrden(OrdenCompraGanado orden){
        this.odenesDeCompra.add(orden);
    }
}
