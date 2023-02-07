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
@Table(name = "Administrador")
public class AdministradorEntity extends UsuarioEntity{
//Prueba
}
