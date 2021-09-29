/*
 * Esta clase esta destinada a mostrar un menu al usuario
 */
package application;

import control.*;
import java.util.Collection;
import model.*;


/**
 *
 * @author Alain, Jonathan
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * Menu en el cual el usuario podrá elegir la opción que desee
         * @see menuPrincipal();
         */
       DaoInterface data = new DaoImplementation();
        menuPrincipal(data);
    }
    

    private static void menuPrincipal(DaoInterface data) {
        
        int opcMenu;
        
        do{
            System.out.println("***Menu Principal****");
            System.out.println("\t1. Crear cliente");
            System.out.println("\t2. Consultar datos de un cliente");
            System.out.println("\t3. Consultar cuentas de un cliente");
            System.out.println("\t4. Crear cuenta para cliente");
            System.out.println("\t5. Agregar cliente a cuenta");
            System.out.println("\t6. Consultar datos de una cuenta");
            System.out.println("\t7. Realizar un movimiento");
            System.out.println("\t8. Consultar los movimientos de una cuenta");
            System.out.println("\t9. Salir");
            opcMenu = control.Util.leerInt();
            
            
            switch (opcMenu){
                case 1:
                    /**
                     * Metodo destinado a la creacion de un nuevo cliente
                     * @see createCustomer();
                     */
                    createCustomer(data);
                    break;
                case 2:
                    /**
                     * Metodo destinado a la consulta de la informacion de un cliente
                     * @see consultCustomerData();
                     */
                    consultCustomerData(data);
                    break;
                case 3:
                    /**
                     * Metodo que permite consultar las cuentas de un cliente en cuestion
                     * @see ConsultClientAccounts();
                     */
                    ConsultClientAccounts(data);
                    break;
                case 4:
                    /**
                     * Metodo que permite Crear una cuenta a un cliente
                     * @see createCustomerAccount();
                     */
                    createCustomerAccount(data);
                    break;
                case 5:
                    /**
                     * Metodo que permite añadir a un cliente a una cuenta
                     * @see AddCustomerToAccount();
                     */

                    AddCustomerToAccount(data);
                    break;
                case 6:
                    /**
                     * Metodo el cual permite consultar los detalles de una cuenta en cuestion
                     * @see consultAccountDetails();
                     */
                    consultAccountDetails(data);
                    break;
                case 7:
                    /**
                     * Metodo que permite hacer un movimiento sobre una cuenta
                     * @see makeMovement();
                     */
                    makeMovement(data);
                    break;
                case 8:
                    /**
                     * Metodo que permite consultar los movimientos sobre una cuenta
                     * @see consultAccountMovements();
                     */
                    consultAccountMovements(data);
                    break;
                case 9:
                    System.out.println("Fin de la ejecucion");
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
                    break;
            }
        }while (opcMenu != 9);
    }

    private static void createCustomer(DaoInterface data) {
        Customer cus;
        Long id_cus;
        cus = new Customer();
        cus.setData();
        id_cus = data.createCustomer(cus);
        System.out.println("La id de cliente que se te ha asignado es: "+id_cus);
    }

    private static void consultCustomerData(DaoInterface data) {
        Customer cus;
        Long id_cus;
        id_cus=Util.leerLong("Introduce la id del cliente: ");
        cus = data.consultCustomer(id_cus);
        if(cus != null){
            cus.getData();
        }else{
            
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void ConsultClientAccounts(DaoInterface data) {
        Customer cus;
        Collection<Account> accounts;
        Long id_cus;
        id_cus=Util.leerLong("Introduce la id del cliente: ");
        cus = data.consultCustomer(id_cus);
        
        if(cus != null){
            accounts = data.consultAccounts(id_cus);
            for(Account acc : accounts){
                acc.getData();
            }
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void createCustomerAccount(DaoInterface data) {
        Customer cus;
        Account acc;
        Long id_cus,id_acc;
        id_cus=Util.leerLong("Introduce la id del cliente: ");
        cus = data.consultCustomer(id_cus);
        if(cus != null){
            acc = new Account();
            acc.setData();
            id_acc = data.createAccount(id_cus,acc);
            System.out.println("La id de la cuenta creada es: "+id_acc);
            
           
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void AddCustomerToAccount(DaoInterface data) {
        Customer cus;
        Account acc;
        Long id_cus,id_acc;
        id_cus=Util.leerLong("Introduce la id del cliente:");
        cus = data.consultCustomer(id_cus);
        if(cus != null){
            id_acc=Util.leerLong("Introduce la id de la cuenta:");
            acc = data.consultDataAccount(id_acc);
            if(acc != null){
                data.createCustomerAccount(id_cus,id_acc);
                System.out.println("Se agrego el cliente a la cuenta");
            }else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void consultAccountDetails(DaoInterface data) {
        Account acc;
        Long id_acc;
        id_acc = Util.leerLong("Introduce la id de la cuenta:");
          acc = data.consultDataAccount(id_acc);
           if(acc != null){
               acc.getData();
           } else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
    }

    private static void makeMovement(DaoInterface data) {
        Movement mov;
        Long id_mov;
    }

    private static void consultAccountMovements(DaoInterface data) {
        Long id_acc;
        Account acc;
        Collection<Movement> movements;
        id_acc = Util.leerLong("Introduce la id de la cuenta:");
            acc = data.consultDataAccount(id_acc);
            if(acc != null){
                movements = data.consultMovements(id_acc);
                for(Movement mov : movements){
                    mov.getData();
                }
           } else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
    }
    
}
