package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.ProductoEntity;
import co.edu.unicauca.productos.models.SubastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISubastaRepository extends JpaRepository<SubastaEntity, Integer> {
<<<<<<< HEAD
    @Query(value = "select s.codigo, s.valor_actual, s.estado from producto as p inner join subasta as s on p.codigo = s.codigoP",nativeQuery = true)
    public abstract List<String> subastaAtributos(Integer codigo);

=======
    @Query(value = "select * from subasta where codigop =?1",nativeQuery = true)
    public abstract SubastaEntity consultarValorActualSubasta(Integer codigoP);
>>>>>>> 37ce88eb326ada1ef2e2600fa17eb8d2839eb22d
}
