package services;

import java.util.List;
import org.glassfish.jersey.jackson.JacksonFeature;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import models.Cliente;

/**
 *
 * @author YazminG, ErikaC
 */
public class ClienteServices {

    private String endPoint;
    private Client objClientePeticiones;

    public ClienteServices() {
        this.endPoint = "http://localhost:5000/api/clientes";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Cliente registrarCliente(Cliente objClienteRegistar) {
        Cliente objCliente = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Entity<Cliente> data = Entity.entity(objClienteRegistar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.post(data, Cliente.class);

        return objCliente;
    }

    public boolean inicioSesionCli(String login, String contrasenia) {
        
        Boolean bandera = false;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/inicioSesionCli" + "/" + login + "/" + contrasenia);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        bandera = objPeticion.get(Boolean.class);

        return bandera;
    }

    public Cliente consultarCliente(Integer id) {
        Cliente objCliente = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + id);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.get(Cliente.class);

        return objCliente;
    }

    public Cliente actualizarCliente(Cliente objClienteActualizar, Integer id) {
        Cliente objCliente = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + id);

        Entity<Cliente> data = Entity.entity(objClienteActualizar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.put(data, Cliente.class);

        return objCliente;
    }

    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaClientes = objPeticion.get(new GenericType<List<Cliente>>() {});

        return listaClientes;
    }
}
