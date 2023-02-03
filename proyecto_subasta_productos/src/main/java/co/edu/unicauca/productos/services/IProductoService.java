package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.services.DTO.ProductoDTO;

import java.util.List;

public interface IProductoService {
    public List<ProductoDTO> findAll();
    public ProductoDTO findById(Integer codigo);
    public ProductoDTO save(ProductoDTO producto);
    public ProductoDTO update(Integer codigo, ProductoDTO producto);
    public boolean delete(Integer codigo);
}
