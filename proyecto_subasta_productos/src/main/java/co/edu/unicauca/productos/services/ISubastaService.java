package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.models.ProductoEntity;
import co.edu.unicauca.productos.services.DTO.SubastaDTO;

import java.util.List;

public interface ISubastaService {
    public List<SubastaDTO> findAll();
    public SubastaDTO findById(Integer codigo);
    public SubastaDTO save(SubastaDTO subasta, Integer codigo);
    public SubastaDTO update(Integer codigo, SubastaDTO subasta);
    public void delete(Integer codigo);
    public SubastaDTO disabledByCodigo(SubastaDTO subasta, Integer codigo);
    public SubastaDTO consultarSubastaActual(Integer codigoP);
    public Float valorActualSubasta(Integer codigoP);
}
