/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

    /**
     *
     * @author Jonathan, Alain
     */
public class Application {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Menu en el cual el usuario podrá elegir la opción que desee
         *
         * @see menuPrincipal();
         */
        menuPrincipal();
    }

    private static void menuPrincipal() {

        int opcMenu;

        do {
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

            switch (opcMenu) {
                case 1:
                    /**
                     * Metodo destinado a la creacion de un nuevo cliente
                     *
                     * @see createCustomer();
                     */
                    createCustomer();
                    break;
                case 2:
                    /**
                     * Metodo destinado a la consulta de la informacion de un
                     * cliente
                     *
                     * @see consultCustomerData();
                     */
                    consultCustomerData();
                    break;
                case 3:
                    /**
                     * Metodo que permite consultar las cuentas de un cliente en
                     * cuestion
                     *
                     * @see ConsultClientAccounts();
                     */
                    ConsultClientAccounts();
                    break;
                case 4:
                    /**
                     * Metodo que permite Crear una cuenta a un cliente
                     *
                     * @see createCustomerAccount();
                     */
                    createCustomerAccount();
                    break;
                case 5:
                    /**
                     * Metodo que permite añadir a un cliente a una cuenta
                     *
                     * @see AddCustomerToAccount();
                     */
                    AddCustomerToAccount();
                    break;
                case 6:
                    /**
                     * Metodo el cual permite consultar los detalles de una
                     * cuenta en cuestion
                     *
                     * @see consultAccountDetails();
                     */
                    consultAccountDetails();
                    break;
                case 7:
                    /**
                     * Metodo que permite hacer un movimiento sobre una cuenta
                     *
                     * @see makeMovement();
                     */
                    makeMovement();
                    break;
                case 8:
                    /**
                     * Metodo que permite consultar los movimientos sobre una
                     * cuenta
                     *
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
        } while (opcMenu != 9);
    }

    private static void createCustomer() {

    }

    private static void consultCustomerData() {

    }

    private static void ConsultClientAccounts() {

    }

    private static void createCustomerAccount() {

    }

    private static void AddCustomerToAccount() {

    }

    private static void consultAccountDetails() {

    }

    private static void makeMovement() {

    }

    private static void consultAccountMovements() {

    }
    
}
