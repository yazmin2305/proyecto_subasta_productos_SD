package services;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Producto;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author YazminG, ErikaC
 */
public class ProductoServices {
    private String endPoint;
    private Client objClientePeticiones;
    
    public ProductoServices(){
        this.endPoint = "http://localhost:5001/api/productos";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Producto registrarProducto(Producto producto){
        Producto objProducto = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Entity<Producto> data = Entity.entity(producto, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProducto = objPeticion.post(data, Producto.class);

        return objProducto;
    }
    
    public List<Producto> listarProductos(){
        List<Producto> listaProductos = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaProductos = objPeticion.get(new GenericType<List<Producto>>() {});

        return listaProductos;
    }
    public Producto consultarProducto(Integer codigo){
        Producto objProducto = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/"+ codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProducto = objPeticion.get(Producto.class);

        return objProducto;
    }
//    public boolean ofrecerOferta(Float oferta, Integer codigoP){
//        Boolean bandera = false;
//        Subasta objSubasta = null;
//
//        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/ofrecerOferta" + "/" + oferta + "/" + codigoP);
//
//        Entity<Subasta> data = Entity.entity(subastaAct, MediaType.APPLICATION_JSON_TYPE);
//        
//        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);
//        
//        objSubasta = objPeticion.put(data, Subasta.class);   
//        //bandera = objPeticion.get(Boolean.class);
//
//        return bandera;
//    }
    
}
