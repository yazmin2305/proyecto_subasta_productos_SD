package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import models.Producto;
import models.Subasta;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author YazminG, ErikaC
 */
public class SubastaServices extends Thread {
    private String endPoint;
    private Client objClientePeticiones;

    public SubastaServices() {
        this.endPoint = "http://localhost:5001/api/subastas";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    
    public Float valorActualSubasta(Integer codigo) {
        float valor_actual=0;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + "valorActualSubasta/"+ codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        valor_actual = objPeticion.get(Float.class);

        return valor_actual;
    }
    public Subasta consultarSubastaActual(Integer codigo){
        Subasta objSubasta = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/consultarSubasta/" + codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objSubasta = objPeticion.get(Subasta.class);

        return objSubasta;
    }
    public Subasta actualizarSubasta(Subasta subastaActualizar, Integer codigo){
        Subasta objSubasta = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + codigo);

        Entity<Subasta> data = Entity.entity(subastaActualizar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objSubasta = objPeticion.put(data, Subasta.class);

        return objSubasta;
    }
    
}
