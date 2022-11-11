package com.UM.GrupoRural.business.managers;

import com.UM.GrupoRural.business.entities.Imagen;
import com.UM.GrupoRural.business.entities.grupos.Grupo;
import com.UM.GrupoRural.business.entities.users.Productor;
import com.UM.GrupoRural.business.entities.users.Usuario;
import com.UM.GrupoRural.business.exceptions.InvalidInformation;
import com.UM.GrupoRural.business.exceptions.UserAlreadyExists;
import com.UM.GrupoRural.persistence.GroupRepository;
import com.UM.GrupoRural.persistence.ProductorRepository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Service
public class GroupMgr {

    private final UserMgr userMgr;
    private final GroupRepository groupRepository;

    private final ProductorRepository productorRepository;


    public GroupMgr(UserMgr userMgr, GroupRepository groupRepository, ProductorRepository productorRepository) {
        this.userMgr = userMgr;
        this.groupRepository = groupRepository;
        this.productorRepository = productorRepository;
    }

    public void crearGrupo(String nombre_grupo, String motivo_de_grupo, String descripcion, List<String> productores, String mensaje_invitacion, String icono) throws InvalidInformation {

        if (nombre_grupo == null || nombre_grupo.isBlank()){
            throw new InvalidInformation("Por favor, ingrese un nombre de grupo válido.");
        }

        if (productores == null || productores.isEmpty()){
            throw new InvalidInformation("Por favor, agregue al menos un invitado al grupo.");
        }

        if (motivo_de_grupo == null || motivo_de_grupo.isEmpty()){
            throw new InvalidInformation("Por favor, ingrese un motivo de grupo.");
        }

        if (descripcion == null || descripcion.isBlank()) {
            throw new InvalidInformation("Por favor, ingrese una descripción del grupo.");
        }

        if (mensaje_invitacion == null || mensaje_invitacion.isBlank()) {
            throw new InvalidInformation("Por favor, ingrese un mensaje de invitacion para notificar a los productores.");
        }

        List<Productor> invitados = new ArrayList<>(10);

        for (String productor: productores) {

            //Empiezo fijandome que sea productor
            if((!productorRepository.existsProductorByUsuario(productor)) && (!productorRepository.existsProductorByMail(productor))){
                throw new InvalidInformation(("El usuario " + productor + "no se encuentra registrado en el sistema de productores"));
            }

            Usuario userByMail = userMgr.findOneByMail(productor);
            Usuario userByUsuario = userMgr.findOneByUsuario(productor);
            if(userByMail == null){
                if(userByUsuario == null){
                    throw new InvalidInformation("El usuario " + productor + "no se encuentra registrado en el sistema de productores");
                }else{
                    invitados.add( (Productor) userByUsuario);
                }
            } else {
                invitados.add((Productor) userByMail);
            }

        }

        Grupo groupToCreate = new Grupo(nombre_grupo, motivo_de_grupo, descripcion, invitados, mensaje_invitacion);
        if (icono!=null){
            icono = icono.split(",")[1];
            groupToCreate.setIcono(new Imagen(Base64.getDecoder().decode(icono.getBytes(StandardCharsets.UTF_8)), groupToCreate));
        }
        groupRepository.save(groupToCreate);


    }

    public Grupo getGrupoByName(String name){
        return groupRepository.findByNombre(name);
    }

}
