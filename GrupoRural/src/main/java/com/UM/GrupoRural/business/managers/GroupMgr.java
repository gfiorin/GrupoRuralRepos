package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.users.Productor;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.exceptions.UserAlreadyExists;
import com.UM.GrupoRural.persistence.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GroupMgr {

    private final UserMgr userMgr;
    private final GroupRepository groupRepository;

    public GroupMgr(UserMgr userMgr, GroupRepository groupRepository) {
        this.userMgr = userMgr;
        this.groupRepository = groupRepository;
    }

    public void crearGrupo (String nombre_grupo, String motivo_de_grupo, String departamento, String ciudad_pueblo, String raza_de_vacunos, Collection<Productor> productores) throws InvalidInformation, UserAlreadyExists {

        if (nombre_grupo == null || nombre_grupo.isBlank()){
            throw new InvalidInformation("Por favor, ingrese un nombre de grupo válido.");
        }

        if (productores == null || productores.isEmpty()){
            throw new InvalidInformation("Por favor, agregue al menos un invitado al grupo.");
        }

        if (motivo_de_grupo == null || motivo_de_grupo.isEmpty()){
            throw new InvalidInformation("Por favor, ingrese un motivo de grupo.");
        }

        if (motivo_de_grupo.equals("Cercanía geográfica") && (departamento == null || departamento.isBlank())) {
            throw new InvalidInformation("Por favor, ingrese el departamento de los miembros del grupo.");
        }

        if (motivo_de_grupo.equals("Misma raza de vacunos") && (raza_de_vacunos == null || raza_de_vacunos.isBlank())) {
            throw new InvalidInformation("Por favor, ingrese una raza de vacunos válida.");
        }

        for (Productor productor: productores) {
            Usuario userByMail = userMgr.findOneByMail(productor.getMail());
            Usuario userByUsuario = userMgr.findOneByUsuario(productor.getUsuario());
            if(userByMail == null || userByMail.getTipo_de_usuario() != 0){
                if(userByUsuario == null || userByUsuario.getTipo_de_usuario() != 0){
                    throw new InvalidInformation("El usuario" + "XXXXX" + "no se encuentra registrado en el sistema de productores");
                }
            }
        }

        Grupo groupToCreate = new Grupo(nombre_grupo, motivo_de_grupo, departamento, ciudad_pueblo, raza_de_vacunos);
        //fixme
        System.out.println(groupToCreate.getIdGrupo());

    }

}
