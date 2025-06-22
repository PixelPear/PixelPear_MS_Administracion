package com.pixelpear.perfulandia.controlador;

import com.pixelpear.perfulandia.modelo.usuario;
import com.pixelpear.perfulandia.servicio.usuario_servicio;
import com.pixelpear.perfulandia.dto.usuario_DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class usuario_controlador {

    @Autowired
    private final usuario_servicio usuarioService; //probando cambio

    public usuario_controlador(usuario_servicio usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/mostrarlista")
    public List<usuario> listar(){
        return usuarioService.listaUsuarios();
    }

    @PostMapping("/crearusuario")
    public usuario crear(@Valid @RequestBody usuario_DTO usuarioDTO){
        return usuarioService.guardarUsuarioDTO(usuarioDTO);
    }

    @PutMapping("/actualizar/{id}")
    public usuario actualizar(@PathVariable Long id,@Valid @RequestBody usuario_DTO usuarioDTO){
        return usuarioService.actualizarUsuario(id, usuarioDTO);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioService.eliminarUsuario(id);
    }


        @GetMapping("/{id}")
    public ResponseEntity<usuario> obtenerPorId(@PathVariable Long id) {
        usuario user = usuarioService.obtenerPorId(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    //para probar la conexion
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
