package co.edu.unicauca.productos.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductoDTO {
    private Integer codigo;
    private String nombre;
    private Float valor_inicial;
    public ProductoDTO(){}
}
