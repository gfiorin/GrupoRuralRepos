package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.GroupMgr;
import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/GetOfertasCompra/{idgroup}")
@CrossOrigin("*")
public class GetRecievedOrdenesCompraController {
    @Autowired
    GroupMgr groupMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGrupos(@PathVariable("idgroup") Integer idGrupo) throws IOException {
        return ResponseEntity.ok(groupMgr.getOfertasCompra(idGrupo));
    }
}
