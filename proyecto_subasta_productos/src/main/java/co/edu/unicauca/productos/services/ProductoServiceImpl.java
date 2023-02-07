package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.models.ProductoEntity;
import co.edu.unicauca.productos.repositories.IProductoRepository;
import co.edu.unicauca.productos.services.DTO.ProductoDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository servicioAccesoBaseDatos;
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
        ProductoEntity objProductoEntity= this.servicioAccesoBaseDatos.findById(codigo).orElse(null);
        ProductoDTO productoDTO=this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public ProductoDTO save(ProductoDTO producto) {
        ProductoEntity productoEntity=this.modelMapper.map(producto, ProductoEntity.class);
        productoEntity.setEstado("En espera");
        ProductoEntity objProductoEntity= this.servicioAccesoBaseDatos.save(productoEntity);
        ProductoDTO productoDTO=this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public ProductoDTO update(Integer codigo, ProductoDTO producto) {
        ProductoEntity productoEntity=this.modelMapper.map(producto, ProductoEntity.class);
        ProductoDTO productoDTO1 = this.findById(codigo);
        ProductoEntity productoEntity1 =this.modelMapper.map(productoDTO1, ProductoEntity.class);
        productoEntity1.setCodigo(productoEntity.getCodigo());
        productoEntity1.setNombre(productoEntity.getNombre());
        productoEntity1.setValor_inicial(productoEntity.getValor_inicial());
        productoEntity1.setEstado(productoEntity.getEstado());
        ProductoEntity productoEntityActualizado= this.servicioAccesoBaseDatos.save(productoEntity1);
        ProductoDTO productoDTO=this.modelMapper.map(productoEntityActualizado, ProductoDTO.class);
        return productoDTO;
    }

    @Override
    public void delete(Integer codigo) {
        this.servicioAccesoBaseDatos.deleteById(codigo);
    }

    public List<ProductoDTO> productosSubasta(String estado){
        List<ProductoEntity> productosSubasta = this.servicioAccesoBaseDatos.productosSubasta(estado);
        List<ProductoDTO> productosSubastaDTO = this.modelMapper.map(productosSubasta, new TypeToken<List<ProductoDTO>>() {}.getType());
        return productosSubastaDTO;
    }

    @Override
    public ProductoDTO consultarProductoSubastado(String estado) {
        ProductoEntity objProductoEntity= this.servicioAccesoBaseDatos.consultarProductoSubastado(estado);
        ProductoDTO productoDTO=this.modelMapper.map(objProductoEntity, ProductoDTO.class);
        return productoDTO;
    }
}
