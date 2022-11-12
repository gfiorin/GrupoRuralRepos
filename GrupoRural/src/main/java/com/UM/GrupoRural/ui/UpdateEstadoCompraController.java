package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.OfertaMgr;
import com.UM.GrupoRural.business.managers.UserMgr;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/ActualizarEstadoCompra/{idOfertaCompra}/{nuevoEstado}")
@CrossOrigin("*")
public class UpdateEstadoCompraController {
    @Autowired
    OfertaMgr ofertaMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGrupos(@PathVariable("idOfertaCompra") Integer id,@PathVariable("nuevoEstado") String estado) {
        try {
            ofertaMgr.updateEstadoOfertaCompra(id, estado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));
        }
        return ResponseEntity.ok("Estado actualizado exitosamente");

    }
}
