package services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import models.Subasta;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 * @author YazminG, ErikaC
 */
public class SubastaServices {
    private String endPoint;
    private Client objClientePeticiones;
    
    public SubastaServices(){
        this.endPoint = "http://localhost:5001/api/subastas";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }
    public Subasta consultarSubasta(Integer codigo){
        Subasta objSubasta = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objSubasta = objPeticion.get(Subasta.class);

        return objSubasta;
    }
        public Subasta consultarSubastaActual(Integer codigo){
        Subasta objSubasta = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/consultarSubasta/" + codigo);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objSubasta = objPeticion.get(Subasta.class);

        return objSubasta;
    }
    
    public Subasta abrirSubasta(Subasta objS, Integer codigo){
        Subasta objSubasta = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + codigo);

        Entity<Subasta> data = Entity.entity(objS, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objSubasta = objPeticion.post(data, Subasta.class);

        return objSubasta;
    }
    public Subasta cerrarSubasta(Subasta subastaAct, Integer id){
        Subasta objSubasta = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/disabled/" + id);

        Entity<Subasta> data = Entity.entity(subastaAct, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objSubasta = objPeticion.put(data, Subasta.class);        

        return objSubasta;
    }
}
