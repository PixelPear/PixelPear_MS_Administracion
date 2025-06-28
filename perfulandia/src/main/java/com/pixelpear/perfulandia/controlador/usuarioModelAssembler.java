package com.pixelpear.perfulandia.controlador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.pixelpear.perfulandia.controlador.usuario_controlador;
import com.pixelpear.perfulandia.dto.usuario_DTO;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class usuarioModelAssembler implements RepresentationModelAssembler<usuario_DTO, EntityModel<usuario_DTO>> {

    @Override
    public EntityModel<usuario_DTO> toModel(usuario_DTO usuario) {
        return EntityModel.of(usuario,
            linkTo(methodOn(usuario_controlador.class).obtenerPorId(usuario.getId())).withSelfRel(),
            linkTo(methodOn(usuario_controlador.class).obtenerTodos()).withRel("usuarios")
        );
    }
}
