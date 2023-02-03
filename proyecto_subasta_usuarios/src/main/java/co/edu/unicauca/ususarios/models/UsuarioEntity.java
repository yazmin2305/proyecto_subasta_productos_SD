package co.edu.unicauca.ususarios.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class UsuarioEntity {
    private Integer id;
    private String nombres;
    private String apellidos;
    private String login;
    private String contrasenia;

    public UsuarioEntity(){}
}
