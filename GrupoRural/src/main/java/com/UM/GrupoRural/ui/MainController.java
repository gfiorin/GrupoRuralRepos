package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entities.users.Comprador;
import com.UM.GrupoRural.business.entities.users.Productor;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class MainController {

    private final UserMgr userMgr;

    public MainController(UserMgr userMgr) {
        this.userMgr = userMgr;
    }

    void loginAction () {

        /*
        if (falta alguno de los datos) {
            se tira la alerta
                    return;
        }
        */

        try {

            Usuario user = userMgr.userLogIn("","");
            if (user instanceof Comprador) {

            }
            else if (user instanceof Productor) {

            }

        } catch (InvalidInformation invalidInformation) {

        }

    }

}
