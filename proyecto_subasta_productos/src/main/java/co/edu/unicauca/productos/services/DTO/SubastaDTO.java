package co.edu.unicauca.productos.services.DTO;

import co.edu.unicauca.productos.models.ProductoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubastaDTO {
    private Integer codigo;
    private Float valor_actual;
    private String estado;
    private ProductoEntity objProducto;

    public  SubastaDTO(){}
}
