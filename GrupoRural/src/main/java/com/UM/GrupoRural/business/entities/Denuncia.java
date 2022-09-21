package com.UM.GrupoRural.business.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    private int idDenuncia;
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

}
