package co.edu.unicauca.ususarios.repositories;

import co.edu.unicauca.ususarios.models.AdministradorEntity;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AdminRepository {
    private ArrayList<AdministradorEntity> listaDeAdministradores;
    private Connection conn;
    public AdminRepository(){
        this.listaDeAdministradores= new ArrayList<AdministradorEntity>();
    }
    public List<AdministradorEntity> findAll(){
        System.out.println("Invocando a listar Administradores");
        return this.listaDeAdministradores;
    }
    public AdministradorEntity findById(Integer id){
        System.out.println("Invocando a consultar un administrador");
        AdministradorEntity objAdmin=null;

        for (AdministradorEntity administrador : listaDeAdministradores) {
            if(administrador.getId() == id){
                objAdmin=administrador;
                break;
            }
        }
        return objAdmin;
    }
    public AdministradorEntity save(AdministradorEntity administrador){
        System.out.println("Invocando a guardar administrador");
        AdministradorEntity objAdmin = null;
        if(this.listaDeAdministradores.add(administrador)){
            objAdmin = administrador;
        }
        return objAdmin;
    }
    public AdministradorEntity update(Integer id, AdministradorEntity administrador){
        System.out.println("Invocando a actualizar un administrador");
        AdministradorEntity objAdmin = null;

        for (int i = 0; i < this.listaDeAdministradores.size(); i++) {
            if(this.listaDeAdministradores.get(i).getId() == id){
                this.listaDeAdministradores.set(i,administrador);
                objAdmin=administrador;
                break;
            }
        }
        return objAdmin;
    }
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un administrador");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeAdministradores.size(); i++) {
            if(this.listaDeAdministradores.get(i).getId() == id){
                this.listaDeAdministradores.remove(i);
                bandera=true;
                break;
            }
        }
        return bandera;
    }


}
