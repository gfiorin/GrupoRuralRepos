package com.UM.GrupoRural.business.entities;

import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ubicacion", nullable = false)
    private Integer idUbicacion;

    @Column(name = "departamento", nullable = true)
    private String departamento;

    @Column(name = "ciudad", nullable = true)
    private String ciudad;

    @Column(name = "calle_y_numero", nullable = true)
    private String calle_y_numero;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name="usuario", referencedColumnName = "id_usuario", nullable = true)
    private Usuario usuario;


    @ManyToMany(targetEntity = LoteGanado.class, fetch = FetchType.LAZY)
    @JoinTable(name = "ubicaciones_lotes", joinColumns = @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion"), inverseJoinColumns = @JoinColumn(name = "id_lote_ganado", referencedColumnName = "id_ganado"))
    @JsonIgnore
    private Collection<LoteGanado> lotes;

    @ManyToMany(targetEntity = OrdenVentaGanado.class, fetch = FetchType.LAZY)
    @JoinTable(name = "ubicaciones_ordenes", joinColumns = @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion"), inverseJoinColumns = @JoinColumn(name = "id_orden", referencedColumnName = "id_orden"))
    @JsonIgnore
    private Collection<LoteGanado> ordenesVenta;

    public Ubicacion() {
    }

    public Ubicacion(String departamento, String ciudad, String calle_y_numero) {
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.calle_y_numero = calle_y_numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle_y_numero() {
        return calle_y_numero;
    }

    public void setCalle_y_numero(String calle_y_numero) {
        this.calle_y_numero = calle_y_numero;
    }

    public void asociarUsuario(Usuario usuario){
        this.usuario=usuario;
    }
}
