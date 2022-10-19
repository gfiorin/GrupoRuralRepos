package com.UM.GrupoRural.ui.messages;


import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SignIn")
public class SignInController {

    @Autowired
    UserMgr userMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> logInUser(@RequestBody Usuario newUser) {

        /* Ya esta controlado en UserMgr
        if (!userMgr.existsByUsuario(newUser.getUsuario())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: El  nombre de usuario y/o la contraseña ingresados no es correcta"));
        }*/

        try {
            userMgr.userLogIn(newUser.getMail(), newUser.getContrasena());
        } catch (InvalidInformation invalidInformation) {
            invalidInformation.printStackTrace();
        }

        return ResponseEntity.ok(new MessageResponse("Ingresando correctamente!")); //FIXME

    }
}
