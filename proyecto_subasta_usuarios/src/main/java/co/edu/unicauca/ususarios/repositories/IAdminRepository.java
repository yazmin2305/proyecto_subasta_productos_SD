package co.edu.unicauca.ususarios.repositories;

import co.edu.unicauca.ususarios.models.AdministradorEntity;
import co.edu.unicauca.ususarios.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IAdminRepository extends JpaRepository<AdministradorEntity, Integer> {
    @Query(value = "select * from usuario where login =?1 and contrasenia=?2",nativeQuery = true)
    public abstract AdministradorEntity inicioSesion(String login, String contrasenia);
}
