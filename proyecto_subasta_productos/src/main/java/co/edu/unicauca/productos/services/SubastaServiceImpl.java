package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.models.ProductoEntity;
import co.edu.unicauca.productos.models.SubastaEntity;
import co.edu.unicauca.productos.repositories.IProductoRepository;
import co.edu.unicauca.productos.repositories.ISubastaRepository;
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
    private ISubastaRepository servicioAccesoBaseDatos;
    @Autowired
    private IProductoRepository servicioAccesoBaseDatosProducto;

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
        SubastaEntity objSubastaEntity= this.servicioAccesoBaseDatos.findById(codigo).orElse(null);
        SubastaDTO subastaDTO=this.modelMapper.map(objSubastaEntity, SubastaDTO.class);
        return subastaDTO;
    }

    @Override
    public SubastaDTO save(SubastaDTO subasta, Integer codigoP) {
        SubastaEntity subastaEntity=this.modelMapper.map(subasta, SubastaEntity.class);
        ProductoEntity objP = servicioAccesoBaseDatosProducto.findById(codigoP).orElse(null);
        subastaEntity.setObjProducto(objP);
        SubastaEntity objSubastaEntity= this.servicioAccesoBaseDatos.save(subastaEntity);
        SubastaDTO subastaDTO=this.modelMapper.map(objSubastaEntity, SubastaDTO.class);
        return subastaDTO;
    }

    @Override
    public SubastaDTO update(Integer codigo, SubastaDTO subasta) {
        SubastaEntity subastaEntity=this.modelMapper.map(subasta, SubastaEntity.class);
        SubastaDTO subastaDTO1 = this.findById(codigo);
        SubastaEntity subastaEntity1 =this.modelMapper.map(subastaDTO1, SubastaEntity.class);
        subastaEntity1.setCodigo(subastaEntity.getCodigo());
        subastaEntity1.setEstado(subastaEntity.getEstado());
        subastaEntity1.setValor_actual(subastaEntity.getValor_actual());
        subastaEntity1.setObjProducto(subastaEntity.getObjProducto());
        SubastaEntity subastaEntityActualizado= this.servicioAccesoBaseDatos.save(subastaEntity);
        SubastaDTO subastaDTO=this.modelMapper.map(subastaEntityActualizado, SubastaDTO.class);
        return subastaDTO;
    }

    @Override
    public void delete(Integer codigo) {
        this.servicioAccesoBaseDatos.deleteById(codigo);
    }

    @Override
    public SubastaDTO disabledByCodigo(Integer codigo) {
        SubastaDTO objS = this.findById(codigo);
        objS.setEstado("Cerrada");
        SubastaEntity objSubastaEntModificado = this.modelMapper.map(objS, SubastaEntity.class);
        SubastaEntity objSubastaEntRetornado = servicioAccesoBaseDatos.save(objSubastaEntModificado);
        SubastaDTO objSubastaDTOModificado = this.modelMapper.map(objSubastaEntRetornado, SubastaDTO.class);
        return objSubastaDTOModificado;
    }
}
