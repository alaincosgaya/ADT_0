/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 2dam
 */
public class Customer_account {
    private long idCustom;
    private long idAccount;
    
    public Customer_account(){
        
    }

    public Customer_account(int idCustom, int idAccount) {
        this.idCustom = idCustom;
        this.idAccount = idAccount;
    }

    public long getIdCustom() {
        return idCustom;
    }

    public void setIdCustom(int idCustom) {
        this.idCustom = idCustom;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public String toString() {
        return "Customer_account{" + "idCustom=" + idCustom + ", idAccount=" + idAccount + '}';
    }
    
    
}
