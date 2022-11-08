package com.UM.GrupoRural.ui.messages;

public class LoginResponse {

    private String profilePic;

    private Boolean is_comprador;

    private String username;

    private String message;

    public LoginResponse(String message, String profilePic, String username, Boolean is_comprador) {
        this.message = message;
        this.is_comprador = is_comprador;
        this.profilePic = profilePic;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
