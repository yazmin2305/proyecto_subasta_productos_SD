package co.edu.unicauca.ususarios.repositories;

import co.edu.unicauca.ususarios.models.ClienteEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ClienteRepository{
    private ArrayList<ClienteEntity> listaDeClientes;
    public ClienteRepository(){
        this.listaDeClientes= new ArrayList<ClienteEntity>();
    }
    public List<ClienteEntity> findAll(){
        System.out.println("Invocando a listarClientes");
        return this.listaDeClientes;
    }
    public ClienteEntity findById(Integer id){
        System.out.println("Invocando a consultar un cliente");
        ClienteEntity objCliente=null;

        for (ClienteEntity cliente : listaDeClientes) {
            if(cliente.getId() == id){
                objCliente=cliente;
                break;
            }
        }
        return objCliente;
    }
    public ClienteEntity save(ClienteEntity cliente){
        System.out.println("Invocando a guardar cliente");
        ClienteEntity objCliente = null;
        if(this.listaDeClientes.add(cliente)){
            objCliente = cliente;
        }
        return objCliente;
    }
    public ClienteEntity update(Integer id, ClienteEntity cliente){
        System.out.println("Invocando a actualizar un cliente");
        ClienteEntity objCliente = null;

        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if(this.listaDeClientes.get(i).getId() == id){
                this.listaDeClientes.set(i,cliente);
                objCliente=cliente;
                break;
            }
        }
        return objCliente;
    }
    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un cliente");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeClientes.size(); i++) {
            if(this.listaDeClientes.get(i).getId() == id){
                this.listaDeClientes.remove(i);
                bandera=true;
                break;
            }
        }
        return bandera;
    }
}
