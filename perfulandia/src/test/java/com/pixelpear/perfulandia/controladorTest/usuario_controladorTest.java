package com.pixelpear.perfulandia.controladorTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @Test
    void testCrearUsuario() throws Exception {
        usuario_DTO dto = new usuario_DTO();
        usuario esperado = new usuario();
        esperado.setNombre(dto.getNombre());
        esperado.setCorreo(dto.getCorreo());
        esperado.setContrasena(dto.getContrasena());
        esperado.setRol(dto.getRol());

        when(usuarioServicio.guardarUsuarioDTO(any(usuario_DTO.class))).thenReturn(esperado);

        mockMvc.perform(post("/api/v1/usuario/crearusuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                {
                  "nombre": "Josefina",
                  "correo": "josefina@pixelpear.com",
                  "contrasena": "clave123",
                  "rol": "empleado"
                }
                """))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Ana"))
            .andExpect(jsonPath("$.correo").value("ana@mail.com"));
    }

}
