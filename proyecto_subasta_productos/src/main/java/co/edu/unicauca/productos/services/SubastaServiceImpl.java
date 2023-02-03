package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.models.SubastaEntity;
import co.edu.unicauca.productos.repositories.SubastaRepository;
import co.edu.unicauca.productos.services.DTO.SubastaDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubastaServiceImpl implements ISubastaService {

    @Autowired
    private SubastaRepository servicioAccesoBaseDatos;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<SubastaDTO> findAll() {
        List<SubastaEntity> subastaEntity= this.servicioAccesoBaseDatos.findAll();
        List<SubastaDTO> subastaDTO=this.modelMapper.map(subastaEntity, new TypeToken<List<SubastaDTO>>() {}.getType());
        return subastaDTO;
    }

    @Override
    public SubastaDTO findById(Integer codigo) {
        SubastaEntity objSubastaEntity= this.servicioAccesoBaseDatos.findById(codigo);
        SubastaDTO subastaDTO=this.modelMapper.map(objSubastaEntity, SubastaDTO.class);
        return subastaDTO;
    }

    @Override
    public SubastaDTO save(SubastaDTO subasta) {
        SubastaEntity subastaEntity=this.modelMapper.map(subasta, SubastaEntity.class);
        SubastaEntity objSubastaEntity= this.servicioAccesoBaseDatos.save(subastaEntity);
        SubastaDTO subastaDTO=this.modelMapper.map(objSubastaEntity, SubastaDTO.class);
        return subastaDTO;
    }

    @Override
    public SubastaDTO update(Integer codigo, SubastaDTO subasta) {
        SubastaEntity subastaEntity=this.modelMapper.map(subasta, SubastaEntity.class);
        SubastaEntity subastaEntityActualizado= this.servicioAccesoBaseDatos.update(codigo, subastaEntity);
        SubastaDTO subastaDTO=this.modelMapper.map(subastaEntityActualizado, SubastaDTO.class);
        return subastaDTO;
    }

    @Override
    public boolean delete(Integer codigo) {
        return this.servicioAccesoBaseDatos.delete(codigo);
    }
}
