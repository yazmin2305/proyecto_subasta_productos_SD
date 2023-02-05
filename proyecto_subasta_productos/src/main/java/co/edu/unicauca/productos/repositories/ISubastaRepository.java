package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.ProductoEntity;
import co.edu.unicauca.productos.models.SubastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISubastaRepository extends JpaRepository<SubastaEntity, Integer> {
    @Query(value = "select * from subasta where codigop =?1",nativeQuery = true)
    public abstract SubastaEntity consultarValorActualSubasta(Integer codigoP);
}
