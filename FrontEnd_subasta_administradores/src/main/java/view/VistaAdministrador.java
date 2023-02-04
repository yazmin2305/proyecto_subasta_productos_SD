package view;

import java.util.List;
import java.util.Scanner;
import models.Administrador;
import services.AdministradorServices;

/**
 *
 * @author YazminG, ErikaC
 */
public class VistaAdministrador {

    public static void main(String[] args) {
        AdministradorServices objAdminServices = new AdministradorServices();
        Scanner objScanner = new Scanner(System.in);

        Administrador objAdmin = new Administrador();
        System.out.println("\n ingresar un nuevo administrador");
        System.out.println("\n ingresar nombres");
        objAdmin.setNombres(objScanner.nextLine());
        System.out.println("\n ingresar apellidos");
        objAdmin.setApellidos(objScanner.nextLine());
        System.out.println("\n ingresar identificación");
        objAdmin.setId(objScanner.nextInt());
        System.out.println("\n ingresar login");
        objScanner.nextLine();
        objAdmin.setLogin(objScanner.nextLine());
        System.out.println("\n ingresar contraseña");
        objAdmin.setContrasenia(objScanner.nextLine());

        objAdminServices.registrarAdministrador(objAdmin);
        System.out.println("\n inicio sesion un cliente");
        Boolean bandera = objAdminServices.inicioSesionAdmin("er", "erikaaaaaa");
        System.out.println("bandera: " + bandera);

        System.out.println("\n listando clientes ");
        List<Administrador> listaDeClientes = objAdminServices.listarClientes();

        for (Administrador cliente : listaDeClientes) {
            imprimirCliente(cliente);
        }
    }

    private static void imprimirCliente(Administrador objCliente) {
        System.out.println(objCliente.getId());
        System.out.println(objCliente.getNombres());
        System.out.println(objCliente.getApellidos());
    }
}
