package com.UM.GrupoRural.business.entities.grupos;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Productor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_grupo")
    private Integer idGrupo;

    @Column(name = "nombre", nullable = false)
    private String nombre;
    // cercania geografica, misma raza de vacunos, mismo grupo inversor, otro
    @Column(name = "motivo_de_grupo", nullable = false)
    private String motivo_de_grupo;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "ciudad_pueblo")
    private String ciudad_pueblo;

    @Column(name = "raza_de_vacunos")
    private String raza_de_vacunos;

    @ManyToMany(mappedBy = "grupo", targetEntity = Productor.class)
    private Collection<Productor> productores;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoVendedor", fetch = FetchType.LAZY)
    private Collection<OrdenVentaGanado> ordenesVenta;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoOfertante", fetch = FetchType.LAZY)
    private Collection<OfertaDeVenta> ofertasDeVenta;

    public Grupo(String nombre, String motivo_de_grupo, String departamento, String ciudad_pueblo, String raza_de_vacunos) {
        this.nombre = nombre;
        this.motivo_de_grupo = motivo_de_grupo;
        this.departamento = departamento;
        this.ciudad_pueblo = ciudad_pueblo;
        this.raza_de_vacunos = raza_de_vacunos;
    }

    public Grupo() {}

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMotivo_de_grupo() {
        return motivo_de_grupo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getCiudad_pueblo() {
        return ciudad_pueblo;
    }

    public String getRaza_de_vacunos() {
        return raza_de_vacunos;
    }

    public Collection<Productor> getProductores() {
        return productores;
    }

    public Collection<OrdenVentaGanado> getOrdenesVenta() {
        return ordenesVenta;
    }

    public Collection<OfertaDeVenta> getOfertasDeVenta() {
        return ofertasDeVenta;
    }
}