package co.edu.unicauca.ususarios.services;

import co.edu.unicauca.ususarios.services.DTO.ClienteDTO;
import co.edu.unicauca.ususarios.services.DTO.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    public List<UsuarioDTO> findAll();
    public UsuarioDTO findById(Integer id);
    public UsuarioDTO save(UsuarioDTO cliente);
    public UsuarioDTO update(Integer id, UsuarioDTO cliente);
    public void deleteById(Integer id);
    public boolean iniciarSesion(String login, String contrasenia);
}
