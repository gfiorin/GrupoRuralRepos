package com.UM.GrupoRural.business.entities.users;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "mail")
@Table(name = "comerciantes")
public class Comerciante extends Usuario {

    @Column(name = "razonSocial", nullable = false)
    private long razonSocial;

}
