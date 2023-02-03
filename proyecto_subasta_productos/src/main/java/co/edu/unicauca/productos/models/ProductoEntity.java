package co.edu.unicauca.productos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ProductoEntity {
    private Integer codigo;
    private String nombre;
    private Float valor_inicial;
    public ProductoEntity(){

    }
}
