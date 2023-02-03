package co.edu.unicauca.ususarios.services;

import co.edu.unicauca.ususarios.models.ClienteEntity;
import co.edu.unicauca.ususarios.repositories.ClienteRepository;
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
    private ClienteRepository servicioAccesoBaseDatos;
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
        ClienteEntity objClienteEntity= this.servicioAccesoBaseDatos.findById(id);
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
        ClienteEntity clienteEntityActualizado= this.servicioAccesoBaseDatos.update(id, clienteEntity);
        ClienteDTO clienteDTO=this.modelMapper.map(clienteEntityActualizado, ClienteDTO.class);
        return clienteDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
