package com.UM.GrupoRural.ui;

import com.UM.GrupoRural.business.managers.UserMgr;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

    private final UserMgr userMgr;

    public MainController(UserMgr userMgr) {
        this.userMgr = userMgr;
    }

    void loginAction () throws Exception {

        /*
        if (falta alguno de los datos) {
            se tira la alerta
                    return;
        }
        */

        try {
            //Usuario user = userMgr.userLogIn();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
