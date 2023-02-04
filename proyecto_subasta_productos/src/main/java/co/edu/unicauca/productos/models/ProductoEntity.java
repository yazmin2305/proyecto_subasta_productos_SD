package co.edu.unicauca.productos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @AllArgsConstructor
@Entity
@Table(name="producto")
public class ProductoEntity {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String nombre;
    private Float valor_inicial;
    private String estado;

    public ProductoEntity(){

    }
}
