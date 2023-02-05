package view;

import java.util.List;
import java.util.Scanner;
import models.Administrador;
import models.Producto;
import models.Subasta;
import services.AdministradorServices;
import services.ProductoServices;

/**
 *
 * @author YazminG, ErikaC
 */
public class VistaAdministrador {

    public static void main(String[] args) {
        AdministradorServices objAdminServices = new AdministradorServices();
        Scanner objScanner = new Scanner(System.in);
        
        ProductoServices objProdServices = new ProductoServices();
        Subasta objS = new Subasta();
        Producto objP = new Producto();
        objP.setCodigo(6);
        objP.setNombre("Tv Samsung");
        objP.setValor_inicial(800000f);
        //objP.setEstado("En espera");
        objProdServices.registrarProducto(objP);
        objS.setCodigo(444);
        objS.setEstado("Abierta");
        objS.setValor_actual(50000f);
//        objProdServices.abrirSubasta(objS, 4);
        //objProdServices.cerrarSubasta(objS, 444);
//        boolean rest = objProdServices.ofrecerOferta(480000f, 2);
//        System.out.println("Respuesta: "+rest);

        System.out.println("\n listando productos ");
        List<Producto> listaDeProductos = objProdServices.listarProductos();

        for (Producto producto : listaDeProductos) {
            imprimirProductos(producto);
        }

//        Administrador objAdmin = new Administrador();
//        System.out.println("\n ingresar un nuevo administrador");
//        System.out.println("\n ingresar nombres");
//        objAdmin.setNombres(objScanner.nextLine());
//        System.out.println("\n ingresar apellidos");
//        objAdmin.setApellidos(objScanner.nextLine());
//        System.out.println("\n ingresar identificación");
//        objAdmin.setId(objScanner.nextInt());
//        System.out.println("\n ingresar login");
//        objScanner.nextLine();
//        objAdmin.setLogin(objScanner.nextLine());
//        System.out.println("\n ingresar contraseña");
//        objAdmin.setContrasenia(objScanner.nextLine());
//
//        objAdminServices.registrarAdministrador(objAdmin);
//        System.out.println("\n inicio sesion un cliente");
//        Boolean bandera = objAdminServices.inicioSesionAdmin("er", "erikaaaaaa");
//        System.out.println("bandera: " + bandera);
//
//        System.out.println("\n listando clientes ");
//        List<Administrador> listaDeClientes = objAdminServices.listarClientes();
//
//        for (Administrador cliente : listaDeClientes) {
//            imprimirCliente(cliente);
//        }
    }

    private static void imprimirCliente(Administrador objCliente) {
        System.out.println(objCliente.getId());
        System.out.println(objCliente.getNombres());
        System.out.println(objCliente.getApellidos());
    }
    
    private static void imprimirProductos(Producto objProd){
        System.out.println("Codigo: "+objProd.getCodigo());
        System.out.println("Nombre: "+objProd.getNombre());
        System.out.println("Valor inicial: "+objProd.getValor_inicial());
        System.out.println("Estado: "+objProd.getEstado());
    }
}
