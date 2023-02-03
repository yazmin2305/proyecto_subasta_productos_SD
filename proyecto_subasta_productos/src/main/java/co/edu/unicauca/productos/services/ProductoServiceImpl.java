package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.models.ProductoEntity;
import co.edu.unicauca.productos.repositories.ProductoRepository;
import co.edu.unicauca.productos.services.DTO.ProductoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private ProductoRepository servicioAccesoBaseDatos;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductoDTO> findAll() {
        List<ProductoEntity> productoEntity= this.servicioAccesoBaseDatos.findAll();
        List<ProductoDTO> productoDTO=this.modelMapper.map(productoEntity, new TypeToken<List<ProductoDTO>>() {}.getType());
        return productoDTO;
    }

    @Override
    public ProductoDTO findById(Integer codigo) {
        ProductoEntity objProductoEntity= this.servicioAccesoBaseDatos.findById(codigo);
        ProductoDTO productoDTO=this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public ProductoDTO save(ProductoDTO producto) {
        ProductoEntity productoEntity=this.modelMapper.map(producto, ProductoEntity.class);
        ProductoEntity objCLienteEntity= this.servicioAccesoBaseDatos.save(productoEntity);
        ProductoDTO productoDTO=this.modelMapper.map(objCLienteEntity, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public ProductoDTO update(Integer codigo, ProductoDTO producto) {
        ProductoEntity productoEntity=this.modelMapper.map(producto, ProductoEntity.class);
        ProductoEntity productoEntityActualizado= this.servicioAccesoBaseDatos.update(codigo, productoEntity);
        ProductoDTO productoDTO=this.modelMapper.map(productoEntityActualizado, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public boolean delete(Integer codigo) {
        return this.servicioAccesoBaseDatos.delete(codigo);
    }
}
