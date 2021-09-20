/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Customer;

/**
 *
 * @author 2dam
 */
public interface DaoInterface {
   public void createCustomer(Customer cust,int Id,String firstName,
    String lastName,String middleInitial,String street,String city,
    String state,int zip,int phone,String email)throws Exception;
}
