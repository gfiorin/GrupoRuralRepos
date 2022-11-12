package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ordenes.OrdenCompraGanado;
import com.UM.GrupoRural.business.managers.OfertaMgr;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/CrearOfertaCompra")
@RestController
public class SendOfertaCompraController {
    @Autowired
    OfertaMgr ofertaMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerOrder(@RequestBody OfertaDeCompra newOferta) {
        try {
            ofertaMgr.crearOfertaCompra(newOferta.getNombreComprador(), newOferta.getOrdenVenta());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
        return ResponseEntity.ok(new MessageResponse("¡Orden registrada correctamente!"));


    }
}

