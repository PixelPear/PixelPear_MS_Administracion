package com.pixelpear.perfulandia.modelo;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data

public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;
    private String correo;
    private String contrasena;
    private String rol;
    private Boolean activo;

}
