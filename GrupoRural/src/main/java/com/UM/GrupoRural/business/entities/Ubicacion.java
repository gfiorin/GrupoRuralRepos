package com.UM.GrupoRural.business.entities;

import com.UM.GrupoRural.business.entities.users.Usuario;

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
    @JoinColumn(name="usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToMany(targetEntity = LoteGanado.class, fetch = FetchType.LAZY)
    @JoinTable(name = "ubicaciones_lotes", joinColumns = @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion"), inverseJoinColumns = @JoinColumn(name = "id_lote_ganado", referencedColumnName = "id_ganado"))
    private Collection<LoteGanado> lotes;


}
