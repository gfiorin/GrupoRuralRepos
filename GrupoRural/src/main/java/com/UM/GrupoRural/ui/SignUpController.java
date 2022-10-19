package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.exceptions.UserAlreadyExists;
import com.UM.GrupoRural.business.managers.UserMgr;
import com.UM.GrupoRural.persistence.UserRepository;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/SignUp")
public class SignUpController {

    @Autowired
    UserMgr userMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody Usuario newUser) {

        /* Ya esta controlado en el User Mgr
        if (userMgr.existsByUsuario(newUser.getUsuario())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: El nombre de usuario ya esta en uso!"));
        }

        if (userMgr.existsByMail(newUser.getMail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: El mail ya esta en uso!"));
        }*/

        // Create new user's account
        try {
            userMgr.agregarUsuario(newUser.getNombre_completo(), newUser.getMail(), newUser.getTelefono(), newUser.getCedula(), newUser.getUsuario(), newUser.getContrasena(), newUser.getFecha_de_nacimiento(), newUser.getTipo_de_usuario());
        } catch (UserAlreadyExists userAlreadyExists) {
            userAlreadyExists.printStackTrace();
        } catch (InvalidInformation invalidInformation) {
            invalidInformation.printStackTrace();
        }

        return ResponseEntity.ok(new MessageResponse("Usuario registrado correctamente!"));

    }





}
