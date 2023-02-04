package co.edu.unicauca.productos.repositories;

import co.edu.unicauca.productos.models.SubastaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubastaRepository extends JpaRepository<SubastaEntity, Integer> {
}
