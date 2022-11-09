package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.ordenes.OrdenVentaGanado;
import com.UM.GrupoRural.business.managers.OrderMgr;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RequestMapping("/OrderCreation")
@RestController
public class OrderVentaCreationController {
    @Autowired
    OrderMgr orderMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerOrder(@RequestBody OrdenVentaGanado newOrden) {
        orderMgr.agregarOrdenVenta(newOrden.getTitulo(), newOrden.getCategoria(), newOrden.getRazas(), newOrden.getValorInicial(),
                newOrden.getPesoPromedio(), newOrden.getPesoMin(), newOrden.getPesoMax(), newOrden.getTransporte(), newOrden.getDescripcion(),
                newOrden.getMainImg(), newOrden.getSecondaryImgs(),newOrden.getGrupoVendedor());
        return ResponseEntity.ok(new MessageResponse("¡Orden registrada correctamente!"));


    }
}

