package com.UM.GrupoRural.business.entities.ordenes;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ordenes")
public class Orden {

    public enum Estado{ACEPTADA, PENDIENTE, CANCELADA, FINALIZADA}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_orden")
    private int idOrden;
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Column(name = "titulo")
    private String titulo;
    @Column(name= "descipcion")
    private String descripcion;
    @Column(name="valor_inicial")
    private String valorInicial;
    @Column(name="motivo")
    private String motivo;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ACEPTADA','PENDIENTE', 'CANCELADA', 'FINALIZADA')")
    private Estado estado;
    @Column(name="cabezas")
    private Integer numeroDeCabezas;



    @OneToMany(mappedBy = "ordenGanado")
    private Collection<Raza> razas;




}
