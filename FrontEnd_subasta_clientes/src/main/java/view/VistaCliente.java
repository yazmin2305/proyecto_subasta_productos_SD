package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
import models.Cliente;
import models.Producto;
import services.ClienteServices;
import services.ProductoServices;

/**
 *
 * @author YazminG, ErikaC
 */
public class VistaCliente {

    public static void main(String[] args) {
       

//        FormCliente objFRMenu = new FormCliente(lstProductos);
//        objFRMenu.setVisible(true);

//        ClienteServices objClienteServices = new ClienteServices();
//        ProductoServices objProducto = new ProductoServices();
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
//        System.out.println("\n inicio sesion un cliente");
//        Boolean bandera = objClienteServices.inicioSesionCli("er", "erikaaaaaa");
//        System.out.println("bandera: "+bandera);
//
//        System.out.println("\n listando clientes ");
//        List<Cliente> listaDeClientes = objClienteServices.listarClientes();
//
//        for (Cliente cliente : listaDeClientes) {
//            imprimirCliente(cliente);
//        }
//        System.out.println("\n listando productos");
//        List<Producto> listaDeProductos = objProducto.ListarProductos("Subastando");
//
//        for (Producto producto : listaDeProductos) {
//            imprimirCliente(producto);
//        }
    }

    private static void imprimirCliente(Producto producto) {
        System.out.println(producto.getCodigo());
        System.out.println(producto.getNombre());
        System.out.println(producto.getValor_inicial());
        System.out.println(producto.getEstado());
    }

}
