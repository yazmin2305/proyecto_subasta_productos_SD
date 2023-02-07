package co.edu.unicauca.productos.controllers;

import co.edu.unicauca.productos.services.DTO.ProductoDTO;
import co.edu.unicauca.productos.services.DTO.SubastaDTO;
import co.edu.unicauca.productos.services.IProductoService;
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

    @GetMapping("/subastas/{codigo}")
    public SubastaDTO show(@PathVariable Integer codigo) {
        SubastaDTO objSubasta = null;
        objSubasta = subastaService.findById(codigo);
        return objSubasta;
    }
    @PostMapping("/subastas/{codigoP}")
    public SubastaDTO create(@RequestBody SubastaDTO subasta, @PathVariable Integer codigoP) {
        SubastaDTO objSubasta = null;
        objSubasta =  subastaService.save(subasta, codigoP);
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
    public void delete(@PathVariable Integer codigo) {
        //Boolean bandera=false;
        SubastaDTO subastaActual = subastaService.findById(codigo);
        if(subastaActual!=null)
        {
            subastaService.delete(codigo);
        }
        //return bandera;
    }
    @PutMapping("/subastas/disabled/{codigo}")
    public SubastaDTO disabledByCodigo(@RequestBody SubastaDTO subasta, @PathVariable Integer codigo){
        return this.subastaService.disabledByCodigo(subasta, codigo);
    }
    @GetMapping("/subastas/consultarSubasta/{codigoP}")
    public SubastaDTO consultarSubastaActual(@PathVariable Integer codigoP) {
        return subastaService.consultarSubastaActual(codigoP);
    }

    @GetMapping("/subastas/valorActualSubasta/{codigo}")
    public Float valorActualSubasta(@PathVariable Integer codigo) {
        return subastaService.valorActualSubasta(codigo);
    }
}
