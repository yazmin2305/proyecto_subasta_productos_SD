package services;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Cliente;
import models.Producto;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author YazminG, ErikaC
 */
public class ProductoServices {

    private String endPoint;
    private Client objClientePeticiones;

    public ProductoServices() {
        this.endPoint = "http://localhost:5001/api/productos";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Producto consultarProducto(Integer codigo) {
        Producto objProducto = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProducto = objPeticion.get(Producto.class);

        return objProducto;
    }

    public List<Producto> ListarProductos(String estado) {
        List<Producto> listaProductos = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + "productosSubasta/" + estado);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        listaProductos = objPeticion.get(new GenericType<List<Producto>>() {
        });

        return listaProductos;
    }

    public Producto consultarProductoSubastado(String estado) {
        Producto objProducto = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + "productoSubastado/"+ estado);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProducto = objPeticion.get(Producto.class);

        return objProducto;
    }

}
