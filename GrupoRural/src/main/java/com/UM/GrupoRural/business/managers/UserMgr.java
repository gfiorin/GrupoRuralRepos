package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.persistence.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserMgr {

    private final UserRepository userRepository;

    public UserMgr(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //private final

    @Transactional
    public Usuario userLogIn(String emailOrUsername, String password) throws InvalidInformation {

        Usuario user = userRepository.findOneByUsuario("");
        return user;
    }





}
