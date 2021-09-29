/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.*;
import model.*;

/**
 *
 * @author Idoia Ormaetxea
 */
public interface DaoInterface {
   public Long createCustomer(Customer cust)throws Exception;
   public Customer consultCustomer(Long id)throws Exception;
   public Collection<Account> consultAccounts(Long idCustom)throws Exception;
   public Long createAccount(Long id, Account account)throws Exception;
   public void createCustomerAccount(Long id, Long id_acc)throws Exception;
   public Account consultDataAccount(Long id)throws Exception;
   public void createMovement(Movement move)throws Exception;
   public Collection<Movement> consultMovements(Long id)throws Exception;
}
