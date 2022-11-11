package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
@Table(name = "productores")
public class Productor extends Usuario {

    @ManyToMany(targetEntity = Grupo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "grupos_productores", joinColumns = @JoinColumn(name = "id_productor", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo"))
    private List<Grupo> grupo;

    public List<Grupo> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<Grupo> grupo) {
        this.grupo = grupo;
    }

    public void addGrupo(Grupo grupo){
        if (this.grupo == null) this.grupo=new ArrayList<>();
        this.grupo.add(grupo);
    }

    public Productor(String nombre_completo, String mail, String telefono, String cedula, String usuario, String contrasena, LocalDate fecha_de_nacimiento) {
        super(nombre_completo, mail, telefono, cedula, usuario, contrasena, fecha_de_nacimiento);
    }

    public Productor() {

    }
}

