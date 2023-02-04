package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<ProductoEntity, Integer> {
}
