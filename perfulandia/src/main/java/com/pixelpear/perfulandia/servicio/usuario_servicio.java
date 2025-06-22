package com.pixelpear.perfulandia.servicio;

import com.pixelpear.perfulandia.dto.usuario_DTO;
import com.pixelpear.perfulandia.modelo.usuario;
import com.pixelpear.perfulandia.repositorio.usuario_repositorio;

import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class usuario_servicio {

        private final usuario_repositorio usuarioRepositorio;

        public usuario_servicio(usuario_repositorio usuarioRepositorio){
            this.usuarioRepositorio = usuarioRepositorio;
        }

        public List<usuario> listaUsuarios(){
            return usuarioRepositorio.findAll();
        }

        public usuario guardarUsuarioDTO(usuario_DTO dto){
            usuario usuario = new usuario();
            usuario.setNombre(dto.getNombre());
            usuario.setCorreo(dto.getCorreo());
            usuario.setRol(dto.getRol());
            usuario.setActivo(dto.getActivo());
            return usuarioRepositorio.save(usuario);
        }

        public usuario actualizarUsuario(Long id, usuario_DTO dto){
            return usuarioRepositorio.findById(id).map(usuario ->{
                usuario.setNombre(dto.getNombre());
                usuario.setCorreo(dto.getCorreo());
                usuario.setRol(dto.getRol());
                usuario.setActivo(dto.getActivo());
                return usuarioRepositorio.save(usuario);

            }).orElse(null);
        }

        public usuario obtenerPorId(Long id) {
            return usuarioRepositorio.findById(id).orElse(null);
        }


        public void eliminarUsuario(Long id){
            usuarioRepositorio.deleteById(id);
        }

}
