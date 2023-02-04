package view;

import java.util.List;
import java.util.Scanner;
import models.Cliente;
import services.ClienteServices;

/**
 *
 * @author YazminG, ErikaC
 */
public class VistaCliente {

    public static void main(String[] args) {
        ClienteServices objClienteServices = new ClienteServices();
//        Scanner objScanner = new Scanner (System.in);
//        
//        Cliente objCliente = new Cliente();
//        System.out.println("\n ingresar un nuevo cliente");
//        System.out.println("\n ingresar nombres");
//        objCliente.setNombres(objScanner.nextLine());
//        System.out.println("\n ingresar apellidos");
//        objCliente.setApellidos(objScanner.nextLine());
//        System.out.println("\n ingresar identificación");
//        objCliente.setId(objScanner.nextInt());
//        System.out.println("\n ingresar correo");
//        objScanner.nextLine();
//        objCliente.setCorreo(objScanner.nextLine());
//        System.out.println("\n ingresar telefono");
//        objCliente.setTelefono(objScanner.nextLine());
//        System.out.println("\n ingresar login");
//        objCliente.setLogin(objScanner.nextLine());
//        System.out.println("\n ingresar contraseña");
//        objCliente.setContrasenia(objScanner.nextLine());
        
//        objClienteServices.registrarCliente(objCliente);

        System.out.println("\n inicio sesion un cliente");
        Boolean bandera = objClienteServices.inicioSesionCli("er", "erikaaaaaa");
        System.out.println("bandera: "+bandera);

        System.out.println("\n listando clientes ");
        List<Cliente> listaDeClientes = objClienteServices.listarClientes();

        for (Cliente cliente : listaDeClientes) {
            imprimirCliente(cliente);
        }
    }

    private static void imprimirCliente(Cliente objCliente) {
        System.out.println(objCliente.getId());
        System.out.println(objCliente.getNombres());
        System.out.println(objCliente.getApellidos());
        System.out.println(objCliente.getCorreo());
        System.out.println(objCliente.getTelefono());
    }

}
