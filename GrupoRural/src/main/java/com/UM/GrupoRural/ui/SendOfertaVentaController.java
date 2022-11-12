package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.ofertas.OfertaDeCompra;
import com.UM.GrupoRural.business.entities.ofertas.OfertaDeVenta;
import com.UM.GrupoRural.business.managers.OfertaMgr;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RequestMapping("/CrearOfertaVenta")
@RestController
public class SendOfertaVentaController {

    @Autowired
    OfertaMgr ofertaMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerOrder(@RequestBody OfertaDeVenta newOferta) {
        try {
            ofertaMgr.crearOfertaVenta(newOferta.getGrupoOfertante().getIdGrupo(), newOferta.getOrdenCompra());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
        return ResponseEntity.ok(new MessageResponse("¡Oferta registrada correctamente!"));


    }
}
