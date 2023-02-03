package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.ProductoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {
    private ArrayList<ProductoEntity> listaProductos;

    public ProductoRepository(){
        this.listaProductos = new ArrayList<ProductoEntity>();
        //Cargar productos
    }

    public List<ProductoEntity> findAll(){
        System.out.println("Invocando listar productos");
        return this.listaProductos;
    }

    public ProductoEntity findById(Integer codigo){
        System.out.println("Invocando a consultar producto");
        ProductoEntity objProducto = null;
        for (ProductoEntity producto: listaProductos) {
            if(producto.getCodigo() == codigo){
                objProducto=producto;
                break;
            }
        }
        return objProducto;
    }

    public ProductoEntity save(ProductoEntity producto){
        System.out.println("Invocando almacenar producto");
        ProductoEntity objProducto = null;
        if(this.listaProductos.add(producto)){
            objProducto = producto;
        }
        return objProducto;
    }

    public ProductoEntity update(Integer codigo, ProductoEntity producto){
        System.out.println("Invocando a actualizar producto");
        ProductoEntity objProducto = null;

        for (int i = 0; i < this.listaProductos.size(); i++) {
            if(this.listaProductos.get(i).getCodigo()==codigo){
                this.listaProductos.set(i, producto);
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

    public boolean delete(Integer codigo){
        System.out.println("Invocando a eliminar un producto");
        boolean bandera = false;

        for (int i = 0; i < this.listaProductos.size(); i++) {
            if (this.listaProductos.get(i).getCodigo() == codigo) {
                this.listaProductos.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }
}
