package co.edu.unicauca.productos.controllers;

import co.edu.unicauca.productos.services.DTO.ProductoDTO;
import co.edu.unicauca.productos.services.IProductoService;
import co.edu.unicauca.productos.services.ISubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductoRestController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDTO> index() {
        return productoService.findAll();
    }

    @GetMapping("/productos/{codigo}")
    public ProductoDTO show(@PathVariable Integer codigo) {
        ProductoDTO objProducto = null;
        objProducto = productoService.findById(codigo);
        return objProducto;
    }
    @PostMapping("/productos")
    public ProductoDTO create(@RequestBody ProductoDTO producto) {
        ProductoDTO objProducto = null;
        objProducto =  productoService.save(producto);
        return objProducto;
    }
    @PutMapping("/productos/{codigo}")
    public ProductoDTO update(@RequestBody ProductoDTO producto, @PathVariable Integer codigo) {
        ProductoDTO objProducto = null;
        ProductoDTO productoActual = productoService.findById(codigo);
        if(productoActual!=null)
        {
            objProducto = productoService.update(codigo,producto);
        }
        return objProducto;
    }
    @DeleteMapping("/productos/{codigo}")
    public void delete(@PathVariable Integer codigo) {
        Boolean bandera=false;
        ProductoDTO productoActual = productoService.findById(codigo);
        if(productoActual!=null)
        {
            productoService.delete(codigo);
        }
        //return bandera;
    }
    @GetMapping("productos/productosSubasta/{estado}")
    public List<ProductoDTO> productosSubasta(@PathVariable String estado) {
        return productoService.productosSubasta(estado);
    }

}
