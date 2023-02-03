package co.edu.unicauca.ususarios.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioDTO {
    @NotNull
    private Integer id;
    @NotNull
    @Size(min = 5, max = 50, message = "la cantidad de caracteres del nombre debe estar entre 5 y 45")
    private String nombres;
    @NotNull
    @Size(min = 5, max = 50, message = "la cantidad de caracteres del apellido debe estar entre 5 y 45")
    private String apellidos;

    @NotNull
    @Size(min = 10, max = 20, message = "la cantidad de caracteres debe estar entre 10 y 20")
    private String login;
    @NotNull
    @Size(min = 10, max = 20, message = "la cantidad de caracteres debe estar entre 10 y 20")
    private String contrasenia;

    public UsuarioDTO(){}
}
