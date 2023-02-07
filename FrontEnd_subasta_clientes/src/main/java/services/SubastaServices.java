package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import models.Producto;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author YazminG, ErikaC
 */
public class SubastaServices {
    private String endPoint;
    private Client objClientePeticiones;

    public SubastaServices() {
        this.endPoint = "http://localhost:5001/api/subastas";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Float consultarSubastaProducto(Integer codigo) {
        float valor_actual=0;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + "subastaProducto/"+ codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        valor_actual = objPeticion.get(Float.class);

        return valor_actual;
    }
    
}