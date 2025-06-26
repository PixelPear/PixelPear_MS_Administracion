package com.pixelpear.perfulandia.dto;
import org.springframework.hateoas.RepresentationModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class usuario_DTO extends RepresentationModel<usuario_DTO> {
    private Long id;

    @NotBlank(message = "Campo obligatorio, ingrese nombre por favor.")
    private String nombre;

    @NotBlank(message = "Campo obligatorio, favor ingresar correo.")
    @Email(message = "Debe ingresar correo valido (formato a@a.a)")
    private String correo;

    @NotBlank(message = "Campo obligatorio, favor ingresar contraseña")
    private String contrasena;

    @NotBlank(message = "Rol obligatorio")
    private String rol;

    @NotNull(message = "El estado debe ser activo/inactivo")
    private Boolean activo;
}
