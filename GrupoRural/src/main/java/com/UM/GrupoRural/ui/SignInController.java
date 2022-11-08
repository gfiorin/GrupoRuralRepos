package com.UM.GrupoRural.ui;


import com.UM.GrupoRural.business.entities.users.Comprador;
import com.UM.GrupoRural.business.entities.users.Productor;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.exceptions.UserAlreadyExists;
import com.UM.GrupoRural.business.managers.UserMgr;
import com.UM.GrupoRural.ui.messages.LoginResponse;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/SignIn/{user}/{pwd}")
@CrossOrigin("http://localhost:3000")
public class SignInController {

    @Autowired
    UserMgr userMgr;

    Usuario usuario;

    Integer is_comprador;

    @GetMapping()
    public ResponseEntity<?> logInUser(@PathVariable("user") String nombre, @PathVariable("pwd") String contra) {

        try {
            usuario = userMgr.userLogIn(nombre, contra);
        } catch (InvalidInformation invalidInformation) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Error: ¡Usuario o contraseña incorrectos!"));
        }
        if (usuario instanceof Comprador) {
            is_comprador = 1;

        }
        else if (usuario instanceof Productor) {
            is_comprador = 0;
        }
        usuario.setTipo_de_usuario(is_comprador);

        return ResponseEntity.ok(usuario);

    }
}
