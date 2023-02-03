package co.edu.unicauca.ususarios.services;

import co.edu.unicauca.ususarios.models.AdministradorEntity;
import co.edu.unicauca.ususarios.repositories.AdminRepository;
import co.edu.unicauca.ususarios.repositories.ClienteRepository;
import co.edu.unicauca.ususarios.services.DTO.AdministradorDTO;
import co.edu.unicauca.ususarios.services.DTO.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Qualifier("admin")
public class AdminServiceImpl implements IUsuarioService{
    @Autowired
    private AdminRepository servicioAccesoBaseDatos;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UsuarioDTO> findAll() {
        return null;
    }

    @Override
    public UsuarioDTO findById(Integer id) {
        AdministradorEntity objAdministradorEntity= this.servicioAccesoBaseDatos.findById(id);
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
    public UsuarioDTO update(Integer id, UsuarioDTO cliente) {
        AdministradorEntity adminEntity=this.modelMapper.map(cliente, AdministradorEntity.class);
        AdministradorEntity adminEntityActualizado= this.servicioAccesoBaseDatos.update(id, adminEntity);
        AdministradorDTO administradorDTO=this.modelMapper.map(adminEntityActualizado, AdministradorDTO.class);
        return administradorDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
