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
import models.Administrador;

/**
 *
 * @author YazminG, ErikaC
 */
public class AdministradorServices {

    private String endPoint;
    private Client objClientePeticiones;

    public AdministradorServices() {
        this.endPoint = "http://localhost:5000/api/admin";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Administrador registrarAdministrador(Administrador objAdminRegistar) {
        Administrador objAdmin = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Entity<Administrador> data = Entity.entity(objAdminRegistar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdmin = objPeticion.post(data, Administrador.class);

        return objAdmin;
    }

    public boolean inicioSesionAdmin(String login, String contrasenia) {

        Boolean bandera = false;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/inicioSesionAdmin" + "/" + login + "/" + contrasenia);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        bandera = objPeticion.get(Boolean.class);

        return bandera;
    }

    public Administrador consultarAdmin(Integer id) {
        Administrador objAdmin = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + id);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdmin = objPeticion.get(Administrador.class);

        return objAdmin;
    }

    public Administrador actualizarAdmin(Administrador objAdminActualizar, Integer id) {
        Administrador objAdmin = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + id);

        Entity<Administrador> data = Entity.entity(objAdminActualizar, MediaType.APPLICATION_JSON_TYPE);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdmin = objPeticion.put(data, Administrador.class);

        return objAdmin;
    }

    public List<Administrador> listarClientes() {
        List<Administrador> listaAdministradores = null;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);

        Invocation.Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaAdministradores = objPeticion.get(new GenericType<List<Administrador>>() {});

        return listaAdministradores;
    }
}
