package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.EmailAlreadyExists;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.exceptions.UserAlreadyExists;
import com.UM.GrupoRural.business.managers.UserMgr;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SignUp")
@CrossOrigin("http://localhost:3000")
public class SignUpController {

    @Autowired
    UserMgr userMgr;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody Usuario newUser) {
       // Create new user's account
        try {
            userMgr.agregarUsuario(newUser.getNombre_completo(), newUser.getMail(), newUser.getTelefono(), newUser.getCedula(), newUser.getUsuario(), newUser.getContrasena(), newUser.getFecha_de_nacimiento(), newUser.getTipo_de_usuario(), newUser.getImg(), newUser.getDepartamentos(), newUser.getCiudad(), newUser.getDireccion());
        } catch (UserAlreadyExists userAlreadyExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Error: ¡El nombre de usuario ya esta en uso!"));
        } catch (InvalidInformation invalidInformation) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Error: ¡La información enviada no es válida!")); //FIXME el erro esta aca
        } catch (EmailAlreadyExists emailAlreadyExists) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("Error: ¡El correo de usuario ya esta en uso!"));
        }
        return ResponseEntity.ok(new MessageResponse("¡Usuario registrado correctamente!"));
    }





}
