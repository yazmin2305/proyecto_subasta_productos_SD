package co.edu.unicauca.productos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubastaEntity {
    private Integer codigo;
    private Float valor_actual;
    private String estado;
    private ProductoEntity objProducto;

    public  SubastaEntity(){}
}
