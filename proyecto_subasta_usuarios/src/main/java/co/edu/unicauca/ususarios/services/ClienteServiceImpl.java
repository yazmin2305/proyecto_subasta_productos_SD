package co.edu.unicauca.ususarios.services;

import co.edu.unicauca.ususarios.models.AdministradorEntity;
import co.edu.unicauca.ususarios.models.ClienteEntity;
import co.edu.unicauca.ususarios.repositories.ClienteRepository;
import co.edu.unicauca.ususarios.repositories.IClienteRepository;
import co.edu.unicauca.ususarios.services.DTO.AdministradorDTO;
import co.edu.unicauca.ususarios.services.DTO.ClienteDTO;
import co.edu.unicauca.ususarios.services.DTO.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Qualifier("cliente")
public class ClienteServiceImpl implements IUsuarioService {

    @Autowired
    private IClienteRepository servicioAccesoBaseDatos;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UsuarioDTO> findAll() {
        List<ClienteEntity> clientesEntity = this.servicioAccesoBaseDatos.findAll();
        List<UsuarioDTO> clientesDTO = this.modelMapper.map(clientesEntity, new TypeToken<List<ClienteDTO>>() {}.getType());
        return clientesDTO;
    }

    @Override
    public UsuarioDTO findById(Integer id) {
        ClienteEntity objClienteEntity= this.servicioAccesoBaseDatos.findById(id).orElse(null);
        ClienteDTO clienteDTO=this.modelMapper.map(objClienteEntity, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO cliente) {
        ClienteEntity clienteEntity=this.modelMapper.map(cliente, ClienteEntity.class);
        ClienteEntity objClienteEntity= this.servicioAccesoBaseDatos.save(clienteEntity);
        ClienteDTO clienteDTO=this.modelMapper.map(objClienteEntity, ClienteDTO.class);
        System.out.println("telefono,: "+ clienteDTO.getTelefono());
        return clienteDTO;
    }

    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO cliente) {
        ClienteEntity clienteEntity=this.modelMapper.map(cliente, ClienteEntity.class);
        UsuarioDTO clienteDTO = this.findById(id);
        ClienteEntity clienteEntity1 = this.modelMapper.map(clienteDTO, ClienteEntity.class);
        clienteEntity1.setId(clienteEntity.getId());
        clienteEntity1.setNombres(clienteEntity.getNombres());
        clienteEntity1.setApellidos(clienteEntity.getApellidos());
        clienteEntity1.setContrasenia(clienteEntity.getContrasenia());
        clienteEntity1.setLogin(clienteEntity.getLogin());
        clienteEntity1.setTelefono(clienteEntity.getTelefono());
        clienteEntity1.setCorreo(clienteEntity.getCorreo());
        ClienteEntity clienteEntityActualizado= this.servicioAccesoBaseDatos.save(clienteEntity1);
        ClienteDTO clientDTO=this.modelMapper.map(clienteEntityActualizado, ClienteDTO.class);
        return clientDTO;
    }

    @Override
    public void deleteById(Integer id) {
        servicioAccesoBaseDatos.deleteById(id);
    }

    public boolean iniciarSesion(String login, String contrasenia){
        Boolean bandera=false;
        ClienteEntity clienteActual = servicioAccesoBaseDatos.inicioSesion(login, contrasenia);
        if(clienteActual!=null){
            bandera = true;
        }
        return bandera;
    }
}
