package com.UM.GrupoRural.business.excepciones;

public class UserAlreadyExists extends Exception{

    public UserAlreadyExists (String message) {
        super(message);
    }

}
