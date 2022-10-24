package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
@Table(name = "productores")
public class Productor extends Usuario {

    @ManyToMany(targetEntity = Grupo.class, fetch = FetchType.LAZY)
    @JoinTable(name = "grupos_productores", joinColumns = @JoinColumn(name = "id_productor", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo"))
    private Collection<Grupo> grupo;

    public Productor(String nombre_completo, String mail, String telefono, String cedula, String usuario, String contrasena, LocalDate fecha_de_nacimiento) {
        super(nombre_completo, mail, telefono, cedula, usuario, contrasena, fecha_de_nacimiento);
    }

    public Productor() {

    }
}

