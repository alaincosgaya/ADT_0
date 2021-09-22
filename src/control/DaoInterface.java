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
 * @author 2dam
 */
public interface DaoInterface {
   public void createCustomer(Customer cust)throws Exception;
   public Customer consultCustomer(int id)throws Exception;
   public Customer_account consultAccounts(int idCustom)throws Exception;
   public void createAccount(int id, Account accoun)throws Exception;
}
