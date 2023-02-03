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
public class ClienteDTO extends UsuarioDTO{

    @NotNull
    @Email
    private String correo;

    @Pattern(regexp = "[5][0-9]{9}", message = "El telefono debe empezar con 5 y debe contener 10 caracteres")
    private String telefono;

    public ClienteDTO(){}
}
