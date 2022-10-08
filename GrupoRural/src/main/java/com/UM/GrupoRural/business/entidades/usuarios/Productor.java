package com.UM.GrupoRural.business.entidades.usuarios;

import com.UM.GrupoRural.business.entidades.Denuncia;
import com.UM.GrupoRural.business.entidades.Grupo;

import javax.persistence.*;
import java.util.Collection;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
@Table(name = "productores")
public class Productor extends Usuario {

    @ManyToMany(targetEntity = Grupo.class, fetch = FetchType.LAZY)
    @JoinTable(name = "grupos_productores", joinColumns = @JoinColumn(name = "id_productor", referencedColumnName = "id_usuario"), inverseJoinColumns = @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo"))
    private Collection<Grupo> grupos;

}

