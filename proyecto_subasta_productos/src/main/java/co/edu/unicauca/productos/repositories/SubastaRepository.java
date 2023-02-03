package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.SubastaEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubastaRepository {
    private ArrayList<SubastaEntity> listaSubastas;

    public SubastaRepository(){
        this.listaSubastas = new ArrayList<SubastaEntity>();
    }
    public List<SubastaEntity> findAll(){
        System.out.println("Invocando listar subastas");
        return this.listaSubastas;
    }

    public SubastaEntity findById(Integer codigo){
        System.out.println("Invocando a consultar subasta");
        SubastaEntity objSubasta = null;
        for (SubastaEntity subasta: listaSubastas) {
            if(subasta.getCodigo() == codigo){
                objSubasta=subasta;
                break;
            }
        }
        return objSubasta;
    }
    public SubastaEntity save(SubastaEntity subasta){
        System.out.println("Invocando almacenar subasta");
        SubastaEntity objSubasta = null;
        if(this.listaSubastas.add(subasta)){
            objSubasta = subasta;
        }
        return objSubasta;
    }

    public SubastaEntity update(Integer codigo, SubastaEntity subasta){
        System.out.println("Invocando a actualizar suubasta");
        SubastaEntity objSubasta = null;

        for (int i = 0; i < this.listaSubastas.size(); i++) {
            if(this.listaSubastas.get(i).getCodigo()==codigo){
                this.listaSubastas.set(i, subasta);
                objSubasta = subasta;
                break;
            }
        }
        return objSubasta;
    }
    public boolean delete(Integer codigo){
        System.out.println("Invocando a eliminar un subasta");
        boolean bandera = false;

        for (int i = 0; i < this.listaSubastas.size(); i++) {
            if (this.listaSubastas.get(i).getCodigo() == codigo) {
                this.listaSubastas.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

}
