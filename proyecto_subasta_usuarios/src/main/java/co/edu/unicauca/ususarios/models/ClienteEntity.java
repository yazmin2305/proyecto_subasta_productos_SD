package co.edu.unicauca.ususarios.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteEntity  extends UsuarioEntity{
    private String correo;
    private String telefono;

    public ClienteEntity(){}
}
