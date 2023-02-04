package co.edu.unicauca.ususarios.controllers;

import co.edu.unicauca.ususarios.services.DTO.UsuarioDTO;
import co.edu.unicauca.ususarios.services.DTO.AdministradorDTO;
import co.edu.unicauca.ususarios.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class AdminRestController {
    @Autowired
    @Qualifier("admin")
    private IUsuarioService administradorService;

    @GetMapping("/admin")
    public List<UsuarioDTO> index(){
        return administradorService.findAll();
    }

    @GetMapping("/admin/{id}")
    public UsuarioDTO show(@PathVariable Integer id) {
        UsuarioDTO objAdmin = null;
        objAdmin = administradorService.findById(id);
        return objAdmin;
    }
    @PostMapping("/admin")
    public UsuarioDTO create(@Valid @RequestBody AdministradorDTO administrador) {
        UsuarioDTO objAdmin = null;
        objAdmin =  administradorService.save(administrador);
        return objAdmin;
    }
    @PutMapping("/admin/{id}")
    public UsuarioDTO update(@Valid @RequestBody UsuarioDTO administrador, @PathVariable Integer id) {
        UsuarioDTO objAdmin = null;
        UsuarioDTO administradorActual = administradorService.findById(id);
        if(administradorActual!=null){
            objAdmin = administradorService.update(id,administrador);
        }
        return objAdmin;
    }
    @DeleteMapping("/admin/{id}")
    public void delete(@PathVariable Integer id) {
        UsuarioDTO administradorActual = administradorService.findById(id);
        if(administradorActual!=null){
            administradorService.deleteById(id);
        }
    }

    @GetMapping("admin/inicioSesionAdmin/{login}/{contrasenia}")
    public boolean iniciarSesion(@PathVariable String login,@PathVariable String contrasenia) {
        boolean existeAdmin = administradorService.iniciarSesion(login, contrasenia);
        return existeAdmin;
    }
}
