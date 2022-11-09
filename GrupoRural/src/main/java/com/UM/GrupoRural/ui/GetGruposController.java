package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.managers.UserMgr;
import net.minidev.json.JSONArray;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/GetGrupos/{user}")
@CrossOrigin("*")
public class GetGruposController {
    @Autowired
    UserMgr userMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGrupos(@PathVariable("user") String usuario) throws IOException {
        return ResponseEntity.ok(userMgr.findProductorByUsuario(usuario).getGrupo());
    }
}
