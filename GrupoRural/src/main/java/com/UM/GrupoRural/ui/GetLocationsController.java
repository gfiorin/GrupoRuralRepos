package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.Ubicacion;
import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.managers.GroupMgr;
import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("/GetLocations/{name}/{isgroup}")
@CrossOrigin("*")
public class GetLocationsController {
    @Autowired
    UserMgr userMgr;

    @Autowired
    GroupMgr groupMgr;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getLocations(@PathVariable("name") String name,
                                                              @PathVariable("isgroup") int isGrupo) throws IOException {
        if (isGrupo!=0){
            Grupo grupo  = groupMgr.getGrupoByName(name);
            ArrayList<Ubicacion> ubicaciones = new ArrayList<>();
            for (Usuario usuario: grupo.getProductores()){
                ubicaciones.addAll(usuario.getUbicaciones());
            }
            return ResponseEntity.ok(ubicaciones);
        }
        List<Ubicacion> ubicacionList= userMgr.findProductorByUsuario(name).getUbicaciones();
        return ResponseEntity.ok(ubicacionList);
    }
}
