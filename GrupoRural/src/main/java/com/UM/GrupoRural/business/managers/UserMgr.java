package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entidades.usuarios.Usuario;
import com.UM.GrupoRural.business.excepciones.InvalidInformation;
import com.UM.GrupoRural.persistence.CompradorRepository;
import com.UM.GrupoRural.persistence.ProductorRepository;
import com.UM.GrupoRural.persistence.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //public void agregarComprador (String nombre, String )






    @Transactional
    public Usuario userLogIn(String emailOrUsername, String password) throws InvalidInformation {

        Usuario usuario = userRepository.findOneByMail(emailOrUsername);

        if (usuario == null) {
            usuario = userRepository.findOneByUsuario(emailOrUsername);
            if (usuario == null) {
                throw new InvalidInformation("El usuario no existe");
            }
        }

        if (usuario.getContrasena().equals(password)) {
            return usuario;
        }
        else {
            throw new InvalidInformation("Contraseña incorrecta");
        }

    }

}
