package co.edu.unicauca.productos.controllers;

import co.edu.unicauca.productos.services.DTO.SubastaDTO;
import co.edu.unicauca.productos.services.ISubastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubastaRestController {
    @Autowired
    private ISubastaService subastaService;

    @GetMapping("/subastas")
    public List<SubastaDTO> index() {
        return subastaService.findAll();
    }

    @GetMapping("/subastas/{id}")
    public SubastaDTO show(@PathVariable Integer codigo) {
        SubastaDTO objSubasta = null;
        objSubasta = subastaService.findById(codigo);
        return objSubasta;
    }
    @PostMapping("/subastas")
    public SubastaDTO create(@RequestBody SubastaDTO subasta) {
        SubastaDTO objSubasta = null;
        objSubasta =  subastaService.save(subasta);
        return objSubasta;
    }
    @PutMapping("/subastas/{codigo}")
    public SubastaDTO update(@RequestBody SubastaDTO subasta, @PathVariable Integer codigo) {
        SubastaDTO objSubasta = null;
        SubastaDTO subastaActual = subastaService.findById(codigo);
        if(subastaActual!=null)
        {
            objSubasta = subastaService.update(codigo, subasta);
        }
        return objSubasta;
    }
    @DeleteMapping("/subastas/{codigo}")
    public Boolean delete(@PathVariable Integer codigo) {
        Boolean bandera=false;
        SubastaDTO subastaActual = subastaService.findById(codigo);
        if(subastaActual!=null)
        {
            bandera = subastaService.delete(codigo);
        }
        return bandera;

    }
}
