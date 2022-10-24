package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.users.Comprador;
import com.UM.GrupoRural.business.entities.users.Productor;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.exceptions.UserAlreadyExists;
import com.UM.GrupoRural.persistence.CompradorRepository;
import com.UM.GrupoRural.persistence.ProductorRepository;
import com.UM.GrupoRural.persistence.UserRepository;
import com.UM.GrupoRural.ui.messages.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class UserMgr {

    private final UserRepository userRepository;
    private final CompradorRepository compradorRepository;
    private final ProductorRepository productorRepository;

    public UserMgr(UserRepository userRepository, CompradorRepository compradorRepository, ProductorRepository productorRepository) {
        this.userRepository = userRepository;
        this.compradorRepository = compradorRepository;
        this.productorRepository = productorRepository;
    }

    public void agregarUsuario (String nombre_completo, String mail, String telefono, String cedula, String usuario, String contrasena, LocalDate fecha_de_nacimiento, Integer tipo_de_usuario) throws InvalidInformation, UserAlreadyExists {

        if (nombre_completo == null || nombre_completo.isBlank()){
            throw new InvalidInformation("Por favor, ingrese un nombre válido.");
        }

        if (mail == null || mail.isBlank()){
            throw new InvalidInformation("Por favor, ingrese un nombre de usuario válido.");
        }

        if (usuario == null || usuario.isBlank()){
            throw new InvalidInformation("Por favor, ingrese un email válido.");
        }

        if (contrasena == null || contrasena.isBlank() || contrasena.length() < 6){
            throw new InvalidInformation("La clave debe tener al menos 6 caracteres.");
        }

        if (cedula == null || cedula.isBlank()) {
            throw new InvalidInformation("Por favor, ingrese una cédula válido.");
        }

        if (fecha_de_nacimiento == null){
            throw new InvalidInformation("Por favor, ingrese una fecha de nacimiento válida.");
        }

        if (telefono == null || telefono.isBlank()){
            throw new InvalidInformation("Por favor, ingrese un telefono válido.");
        }

        if (tipo_de_usuario == null) {
            throw new InvalidInformation("Por favor, seleccione el tipo de perfil que desea crear.");
        }

        for (char ch: nombre_completo.toCharArray()) {
            if(Character.isDigit(ch)){
                throw new InvalidInformation("El nombre no puede contener números.");
            }
        }

        if (userRepository.existsByUsuario(usuario)) {
            throw new InvalidInformation("Error: El nombre de usuario ya esta en uso!");
        }

        if (userRepository.existsByMail(mail)) {
            throw new InvalidInformation("Error: El mail ya esta en uso!");
        }

        if (userRepository.findOneByMail(mail) != null) {
            throw new UserAlreadyExists("El email ya ha sido registrado en el sistema.");
        }

        if (userRepository.findOneByUsuario(usuario) != null) {
            throw new UserAlreadyExists("El nombre de usuario ya ha sido registrado en el sistema.");
        }

        if (tipo_de_usuario == 0) {
            Productor productor = new Productor(nombre_completo, mail, telefono, cedula, usuario, contrasena, fecha_de_nacimiento);
            productorRepository.save(productor);
        }
        else {
            Comprador comprador = new Comprador(nombre_completo, mail, telefono, cedula, usuario, contrasena, fecha_de_nacimiento);
            compradorRepository.save(comprador);
        }

    }

    @Transactional
    public Usuario userLogIn(String emailOrUsername, String password) throws InvalidInformation {

        Usuario usuario = userRepository.findOneByMail(emailOrUsername);

        System.out.println(emailOrUsername);
        System.out.println(password);

        if (usuario == null) {
            usuario = userRepository.findOneByUsuario(emailOrUsername);
            if (usuario == null) {
                throw new InvalidInformation("El usuario no esta registrado en el sistema");
            }
        }

        if (usuario.getContrasena().equals(password)) {
            return usuario;
        }
        else {
            throw new InvalidInformation("Contraseña incorrecta");
        }

    }

    public Boolean existsByUsuario(String usuario) {
        return userRepository.existsByUsuario(usuario);
    }

    public Boolean existsByMail(String mail) {
        return userRepository.existsByMail(mail);
    }

    public Usuario findOneByMail(String mail) {
        return userRepository.findOneByMail(mail);
    }

    public Usuario findOneByUsuario(String usuario) {
        return userRepository.findOneByUsuario(usuario);
    }

}
