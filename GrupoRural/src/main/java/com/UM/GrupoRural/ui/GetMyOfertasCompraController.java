package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/GetMyOfertasCompra/{user}")
@CrossOrigin("*")
public class GetMyOfertasCompraController {
    @Autowired
    UserMgr userMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGrupos(@PathVariable("user") String usuario) throws IOException {
        return ResponseEntity.ok(userMgr.findCompradorByUsuario(usuario).getOfertasDeCompra());
    }
}
