package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.entidades.usuarios.Comprador;
import com.UM.GrupoRural.business.entidades.usuarios.Productor;
import com.UM.GrupoRural.business.entidades.usuarios.Usuario;
import com.UM.GrupoRural.business.excepciones.InvalidInformation;
import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.stereotype.Controller;

@Controller // o @Component?
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
