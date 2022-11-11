package com.UM.GrupoRural.ui;
import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.managers.GroupMgr;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/GroupCreation")
@CrossOrigin("http://localhost:3000")
public class GroupCreationController {

    @Autowired
    GroupMgr groupMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerGroup(@RequestBody Grupo newGroup) {
        // Create new group
        try {
            groupMgr.crearGrupo(newGroup.getNombre(), newGroup.getMotivo_de_grupo(), newGroup.getDescripcion(), newGroup.getNombresInvitados(), newGroup.getMensaje_invitacion(), newGroup.getImgIcon());
        }catch (InvalidInformation invalidInformation) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(invalidInformation.getMessage()));
        }
        return ResponseEntity.ok(new MessageResponse("¡Grupo creado correctamente!"));
    }

}
