package co.edu.unicauca.ususarios.repositories;

import co.edu.unicauca.ususarios.models.ClienteEntity;
import co.edu.unicauca.ususarios.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    @Query(value = "select * from usuario where login =?1 and contrasenia=?2",nativeQuery = true)
    public abstract ClienteEntity inicioSesion(String login, String contrasenia);
}
