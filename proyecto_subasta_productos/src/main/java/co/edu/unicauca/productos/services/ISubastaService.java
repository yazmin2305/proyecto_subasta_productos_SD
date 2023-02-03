package co.edu.unicauca.productos.services;

import co.edu.unicauca.productos.services.DTO.SubastaDTO;

import java.util.List;

public interface ISubastaService {
    public List<SubastaDTO> findAll();
    public SubastaDTO findById(Integer codigo);
    public SubastaDTO save(SubastaDTO subasta);
    public SubastaDTO update(Integer codigo, SubastaDTO subasta);
    public boolean delete(Integer codigo);
}
