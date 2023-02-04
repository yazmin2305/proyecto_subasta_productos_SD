package co.edu.unicauca.ususarios.services;

import co.edu.unicauca.ususarios.models.AdministradorEntity;
import co.edu.unicauca.ususarios.models.ClienteEntity;
import co.edu.unicauca.ususarios.repositories.AdminRepository;
import co.edu.unicauca.ususarios.repositories.ClienteRepository;
import co.edu.unicauca.ususarios.repositories.IAdminRepository;
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
@Qualifier("admin")
public class AdminServiceImpl implements IUsuarioService{
    @Autowired
    private IAdminRepository servicioAccesoBaseDatos;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UsuarioDTO> findAll() {
        List<AdministradorEntity> administradorEntity = this.servicioAccesoBaseDatos.findAll();
        List<UsuarioDTO> clientesDTO = this.modelMapper.map(administradorEntity, new TypeToken<List<ClienteDTO>>() {}.getType());
        return clientesDTO;
    }

    @Override
    public UsuarioDTO findById(Integer id) {
        AdministradorEntity objAdministradorEntity= this.servicioAccesoBaseDatos.findById(id).orElse(null);
        AdministradorDTO administradorDTO=this.modelMapper.map(objAdministradorEntity, AdministradorDTO.class);
        return administradorDTO;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO admin) {
        AdministradorEntity adminEntity=this.modelMapper.map(admin, AdministradorEntity.class);
        AdministradorEntity objAdminEntity= this.servicioAccesoBaseDatos.save(adminEntity);
        AdministradorDTO administradorDTO=this.modelMapper.map(objAdminEntity, AdministradorDTO.class);
        return administradorDTO;
    }

    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO administrador) {
        AdministradorEntity adminEntity = this.modelMapper.map(administrador, AdministradorEntity.class);
        UsuarioDTO adminDTO = this.findById(id);
        AdministradorEntity adminEntity1 = this.modelMapper.map(adminDTO, AdministradorEntity.class);
        adminEntity1.setId(adminEntity.getId());
        adminEntity1.setNombres(adminEntity.getNombres());
        adminEntity1.setApellidos(adminEntity.getApellidos());
        adminEntity1.setContrasenia(adminEntity.getContrasenia());
        adminEntity1.setLogin(adminEntity.getLogin());
        AdministradorEntity adminEntityActualizado= this.servicioAccesoBaseDatos.save(adminEntity1);
        AdministradorDTO administradorDTO=this.modelMapper.map(adminEntityActualizado, AdministradorDTO.class);
        return administradorDTO;
    }

    @Override
    public void deleteById(Integer id) {
        servicioAccesoBaseDatos.deleteById(id);
    }

    @Override
    public boolean iniciarSesion(String login, String contrasenia) {
        Boolean bandera=false;
        AdministradorEntity cadminActual = servicioAccesoBaseDatos.inicioSesion(login, contrasenia);
        if(cadminActual!=null){
            bandera = true;
        }
        return bandera;
    }
}
