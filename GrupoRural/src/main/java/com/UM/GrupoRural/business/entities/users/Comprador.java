package com.UM.GrupoRural.business.entities.users;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "mail")
@Table(name = "compradores")
public class Comprador extends Usuario {


}
