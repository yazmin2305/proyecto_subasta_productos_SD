package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer> {
    @Query(value = "select * from producto where estado =?1",nativeQuery = true)
    public abstract List<ProductoEntity> productosSubasta(String estado);
<<<<<<< HEAD

=======
    @Query(value = "select estado from producto where codigo =?1", nativeQuery = true)
    public abstract String consultarEstadoProducto(Integer codigoP);
>>>>>>> 37ce88eb326ada1ef2e2600fa17eb8d2839eb22d
}
