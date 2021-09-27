/*
 * Esta clase esta destinada a mostrar un menu al usuario
 */
package application;

import control.Util;
import java.util.Collection;
import model.*;


/**
 *
 * @author Jonathan
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
        menuPrincipal();
    }
    

    private static void menuPrincipal() {
        
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
                    createCustomer();
                    break;
                case 2:
                    /**
                     * Metodo destinado a la consulta de la informacion de un cliente
                     * @see consultCustomerData();
                     */
                    consultCustomerData();
                    break;
                case 3:
                    /**
                     * Metodo que permite consultar las cuentas de un cliente en cuestion
                     * @see ConsultClientAccounts();
                     */
                    ConsultClientAccounts();
                    break;
                case 4:
                    /**
                     * Metodo que permite Crear una cuenta a un cliente
                     * @see createCustomerAccount();
                     */
                    createCustomerAccount();
                    break;
                case 5:
                    /**
                     * Metodo que permite añadir a un cliente a una cuenta
                     * @see AddCustomerToAccount();
                     */
                    AddCustomerToAccount();
                    break;
                case 6:
                    /**
                     * Metodo el cual permite consultar los detalles de una cuenta en cuestion
                     * @see consultAccountDetails();
                     */
                    consultAccountDetails();
                    break;
                case 7:
                    /**
                     * Metodo que permite hacer un movimiento sobre una cuenta
                     * @see makeMovement();
                     */
                    makeMovement();
                    break;
                case 8:
                    /**
                     * Metodo que permite consultar los movimientos sobre una cuenta
                     * @see consultAccountMovements();
                     */
                    consultAccountMovements();
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

    private static void createCustomer() {
        Customer cus;
        int id_cus;
        id_cus=Util.leerInt("Introduce la id del cliente: ");
        cus = consultCustomer(id_cus);
        if(cus == null){
            cus = new Customer();
            cus.setData(id_cus);
            createCustomer(cus);
        }else{
            System.out.println("La id introducida corresponde ya a un cliente");
        }
    }

    private static void consultCustomerData() {
        Customer cus;
        int id_cus;
        id_cus=Util.leerInt("Introduce la id del cliente: ");
        cus = consultCustomer(id_cus);
        if(cus != null){
            cus.getData();
        }else{
            
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void ConsultClientAccounts() {
        Customer cus;
        Collection<Account> accounts;
        int id_cus;
        id_cus=Util.leerInt("Introduce la id del cliente: ");
        cus = consultCustomer(id_cus);
        
        if(cus != null){
            accounts = consultAccounts(id_cus);
            for(Account acc : accounts){
                acc.getData();
            }
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void createCustomerAccount() {
        Customer cus;
        Account acc;
        int id_cus,id_acc;
        id_cus=Util.leerInt("Introduce la id del cliente: ");
        cus = consultCustomer(id_cus);
        if(cus != null){
            acc = new Account();
            id_acc = Util.leerInt("Introduce la id de la cuenta:");
            acc = consultAccount(id_acc);
            if(acc == null){
                acc.setData(id_acc);
                createAccount(id_cus,acc);
            }else{
                System.out.println("La id introducida corresponde ya a una cuenta existente");
            }
           
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void AddCustomerToAccount() {
        Customer cus;
        Account acc;
        int id_cus,id_acc;
        id_cus=Util.leerInt("Introduce la id del cliente: ");
        cus = consultCustomer(id_cus);
        if(cus != null){
            id_acc=Util.leerInt("Introduce la id de la cuenta:");
            acc = consultAccount(id_acc);
            if(acc != null){
                createCustomerAccount(id_cus,acc);
                System.out.println("Se agrego el cliente a la cuenta");
            }else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
        }else{
            System.out.println("La id introducida no corresponde a ningun cliente");
        }
    }

    private static void consultAccountDetails() {
        Account acc;
        int id_acc;
        id_acc = Util.leerInt("Introduce la id de la cuenta:");
          acc = consultAccount(id_acc);
           if(acc != null){
               acc.getData();
           } else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
    }

    private static void makeMovement() {
        Movement mov;
        int id_mov;
    }

    private static void consultAccountMovements() {
        int id_acc;
        Collection<Movement> movements;
        id_acc = Util.leerInt("Introduce la id de la cuenta:");
            acc = consultAccount(id_acc);
            if(acc != null){
                movements = consultMovements(id_acc);
                for(Movement mov : movements){
                    mov.getData();
                }
           } else{
                System.out.println("La id introducida no corresponde a ninguna cuenta");
            }
    }
    
}
