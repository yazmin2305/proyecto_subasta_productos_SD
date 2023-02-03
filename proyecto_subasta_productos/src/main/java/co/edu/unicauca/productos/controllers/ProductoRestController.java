package co.edu.unicauca.productos.controllers;

import co.edu.unicauca.productos.services.DTO.ProductoDTO;
import co.edu.unicauca.productos.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductoRestController {
    @Autowired
    private IProductoService productoService;

    @GetMapping("/productos")
    public List<ProductoDTO> index() {
        return productoService.findAll();
    }

    @GetMapping("/productos/{id}")
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
    public Boolean delete(@PathVariable Integer codigo) {
        Boolean bandera=false;
        ProductoDTO productoActual = productoService.findById(codigo);
        if(productoActual!=null)
        {
            bandera = productoService.delete(codigo);
        }
        return bandera;

    }
}
