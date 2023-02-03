package co.edu.unicauca.ususarios.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteEntity  extends UsuarioEntity{
    private String correo;
    private String telefono;

    public ClienteEntity(){}
}
