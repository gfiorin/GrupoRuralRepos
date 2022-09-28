package com.UM.GrupoRural;

import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

@Component
public class DBLoader implements CommandLineRunner {

    private final UserRepository repository;

    @Autowired
    public DBLoader (UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Usuario("A", "B", "C"));
    }

}
