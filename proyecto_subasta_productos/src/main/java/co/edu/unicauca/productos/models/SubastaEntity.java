package co.edu.unicauca.productos.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="subasta")
public class SubastaEntity {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private Float valor_actual;
    private String estado;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "codigoP")
    private ProductoEntity objProducto;

    public  SubastaEntity(){}
}
