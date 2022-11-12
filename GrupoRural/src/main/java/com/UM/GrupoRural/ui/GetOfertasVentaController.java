package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.GroupMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/GetOfertasVenta/{idgroup}")
@CrossOrigin("*")
public class GetOfertasVentaController {
    @Autowired
    GroupMgr groupMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGrupos(@PathVariable("idgroup") Integer idGrupo) throws IOException {
        return ResponseEntity.ok(groupMgr.getOfertasVenta(idGrupo));
    }
}
