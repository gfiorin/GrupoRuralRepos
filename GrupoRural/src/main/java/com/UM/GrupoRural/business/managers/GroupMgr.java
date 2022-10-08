package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.persistence.GroupRepository;
import com.UM.GrupoRural.persistence.ProductorRepository;
import com.UM.GrupoRural.persistence.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupMgr {

    private final UserRepository userRepository;
    private final GroupRepository compradorRepository;
    private final ProductorRepository productorRepository;

    public GroupMgr(UserRepository userRepository, GroupRepository compradorRepository, ProductorRepository productorRepository) {
        this.userRepository = userRepository;
        this.compradorRepository = compradorRepository;
        this.productorRepository = productorRepository;
    }

}
