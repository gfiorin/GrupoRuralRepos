package com.UM.GrupoRural.business.entities.grupos;

import com.UM.GrupoRural.business.entities.users.Productor;
import javax.persistence.*;

@Entity
@Table(name = "invitaciones")
public class InvitacionesAGrupos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_invitacion")
    private Integer idGrupo;

    @Column(name = "message")
    private String message;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="grupo", referencedColumnName = "id_grupo", nullable = false)
    private Grupo grupo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="productores", referencedColumnName = "id_usuario", nullable = false)
    private Productor productor;

}
