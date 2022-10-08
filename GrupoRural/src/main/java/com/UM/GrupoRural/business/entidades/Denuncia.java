package com.UM.GrupoRural.business.entidades;

import com.UM.GrupoRural.business.entidades.usuarios.Usuario;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_denuncia")
    private int idDenuncia;
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "id_denunciante", referencedColumnName = "id_usuario")
    private Usuario denunciante;

    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "id_denunciado", referencedColumnName = "id_usuario")
    private  Usuario denunciado;

}
