package com.pixelpear.perfulandia.servicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pixelpear.perfulandia.dto.usuario_DTO;
import com.pixelpear.perfulandia.modelo.usuario;
import com.pixelpear.perfulandia.repositorio.usuario_repositorio;
import com.pixelpear.perfulandia.servicio.usuario_servicio;

@ExtendWith(MockitoExtension.class)
public class usuario_servicioTest {

    @Mock
    private usuario_repositorio usuarioRepositorio;

    @InjectMocks
    private usuario_servicio usuarioServicio;

    @Test
    void testGuardarUsuarioDTO(){
        usuario_DTO dto = new usuario_DTO();

        usuario esperado = new usuario();
        esperado.setNombre(dto.getNombre());
        esperado.setCorreo(dto.getCorreo());
        esperado.setContrasena(dto.getContrasena());
        esperado.setRol(dto.getRol());

        when(usuarioRepositorio.save(any(usuario.class))).thenReturn(esperado);

        usuario resultado = usuarioServicio.guardarUsuarioDTO(dto);

        assertEquals("Josefina",resultado.getNombre());
        assertEquals("josefina@pixelpear.com",resultado.getCorreo());
        verify(usuarioRepositorio,times(1)).save(any(usuario.class));

    }

}
