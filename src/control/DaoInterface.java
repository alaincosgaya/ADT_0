/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.Collection;
import java.util.Map;
import model.*;

/**
 *
 * @author Idoia Ormaetxea
 */
public interface DaoInterface {
   public void createCustomer(Customer cust)throws Exception;
   public Customer consultCustomer(int id)throws Exception;
   public Customer_account consultAccounts(int idCustom)throws Exception;
   public void createAccount(int id, Account account)throws Exception;
   public void createCustomerAccount(int id, Account account)throws Exception;
   public Account consultDataAccount(int id)throws Exception;
   public void createMovement(Movement move)throws Exception;
   public Movement consultMovement(int id)throws Exception;
}
