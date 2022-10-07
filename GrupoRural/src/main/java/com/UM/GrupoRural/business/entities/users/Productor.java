package com.UM.GrupoRural.business.entities.users;

import com.UM.GrupoRural.business.entities.users.Usuario;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "mail")
@Table(name = "productores")
public class Productor extends Usuario {


}

