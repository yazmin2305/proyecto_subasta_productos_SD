package co.edu.unicauca.ususarios.controllers;

import co.edu.unicauca.ususarios.models.ClienteEntity;
import co.edu.unicauca.ususarios.services.DTO.ClienteDTO;
import co.edu.unicauca.ususarios.services.DTO.UsuarioDTO;
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
public class ClienteRestController {
    @Autowired
    @Qualifier("cliente")
    private IUsuarioService clienteService;

    @GetMapping("/clientes")
    public List<UsuarioDTO> index(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{id}")
    public UsuarioDTO show(@PathVariable Integer id) {
        UsuarioDTO objCliente = null;
        objCliente = clienteService.findById(id);
        return objCliente;
    }
    @PostMapping("/clientes")
    public UsuarioDTO create(@Valid @RequestBody ClienteDTO cliente) {
        UsuarioDTO objCliente = null;
        objCliente =  clienteService.save(cliente);
        return objCliente;
    }
    @PutMapping("/clientes/{id}")
    public UsuarioDTO update(@Valid @RequestBody ClienteDTO cliente, @PathVariable Integer id) {
        UsuarioDTO objCliente = null;
        UsuarioDTO clienteActual = clienteService.findById(id);
        if(clienteActual!=null){
            objCliente = clienteService.update(id,cliente);
        }
        return objCliente;
    }
    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable Integer id) {
        UsuarioDTO clienteActual = clienteService.findById(id);
        if(clienteActual!=null){
            clienteService.deleteById(id);
        }

    }
    @GetMapping("/clientes/inicioSesionCli/{login}/{contrasenia}")
    public boolean iniciarSesion(@PathVariable String login,@PathVariable String contrasenia) {
        boolean existeCliente = clienteService.iniciarSesion(login, contrasenia);
        return existeCliente;
    }
}
