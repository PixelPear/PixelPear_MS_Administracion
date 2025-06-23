package com.pixelpear.perfulandia.controladorTest;

//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.pixelpear.perfulandia.controlador.usuario_controlador;
import com.pixelpear.perfulandia.dto.usuario_DTO;
import com.pixelpear.perfulandia.modelo.usuario;
import com.pixelpear.perfulandia.servicio.usuario_servicio;

@WebMvcTest(usuario_controlador.class)
public class usuario_controladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private usuario_servicio usuarioServicio;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearUsuario() throws Exception {
        usuario_DTO dto = new usuario_DTO();
        usuario esperado = new usuario();
        esperado.setNombre(dto.getNombre());
        esperado.setCorreo(dto.getCorreo());
        esperado.setContrasena(dto.getContrasena());
        esperado.setRol(dto.getRol());

        when(usuarioServicio.guardarUsuarioDTO(any(usuario_DTO.class))).thenReturn(esperado);

        String json = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("/api/v1/usuario/crearusuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Josefina"))
            .andExpect(jsonPath("$.correo").value("josefina@pixelpear.com"));
    }

}
