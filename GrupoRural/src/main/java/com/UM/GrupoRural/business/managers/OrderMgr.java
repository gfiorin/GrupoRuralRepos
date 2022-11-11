package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.Ubicacion;
import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.entities.ordenes.Raza;
import com.UM.GrupoRural.persistence.OrdenVentaGanadoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Service
public class OrderMgr {


    private final OrdenVentaGanadoRepository ordenVentaGanadoRepository;


    public OrderMgr(OrdenVentaGanadoRepository ordenVentaGanadoRepository) {
        this.ordenVentaGanadoRepository = ordenVentaGanadoRepository;
    }

    public List<OrdenVentaGanado> getAllOrdenesVenta(){
        return (List<OrdenVentaGanado>) ordenVentaGanadoRepository.findAll();
    }

    @Transactional
    public void agregarOrdenVenta(String titulo, String categoria, Collection<Raza> razas, Integer precio,
                                  Integer pesoPromedio, Integer pesoMin, Integer pesoMax, Boolean transporte,
                                  String descripcion, String imagenPrincipal, Collection<String> imagenesSecundarias, Grupo grupo, List<Ubicacion> ubicaciones){
        OrdenVentaGanado ordenVentaGanado = new OrdenVentaGanado(titulo,descripcion,
                precio,razas,grupo,pesoMin,pesoMax,pesoPromedio,transporte, categoria);
        ordenVentaGanado.setUbicaciones(ubicaciones);
        if (imagenPrincipal!=null){
            imagenPrincipal = imagenPrincipal.split(",")[1];
            Imagen imagenPrincipalEntity = new Imagen(Base64.getDecoder().decode(imagenPrincipal.getBytes(StandardCharsets.UTF_8)),ordenVentaGanado);
            ordenVentaGanado.setImagenPrincipal(imagenPrincipalEntity);
        }
        if (imagenesSecundarias!=null){
            ArrayList<Imagen> listaImagenesSecundarias=new ArrayList<>();
            for (String img: imagenesSecundarias) {
                img = img.split(",")[1];
                listaImagenesSecundarias.add(new Imagen(ordenVentaGanado,Base64.getDecoder().decode(img.getBytes(StandardCharsets.UTF_8))));
            }
            ordenVentaGanado.setImagenesSecundarias(listaImagenesSecundarias);
        }
        ordenVentaGanadoRepository.save(ordenVentaGanado);



    }

}
