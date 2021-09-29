/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Util;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author idoia
 */
public class Movement {
    private long id;
    private long idAccount;
    //private DatabaseDate timestamp;
    private LocalDateTime timestamp;
    private float amount;
    private float balance;
    private String description;

    
    public Movement(){
        
    }

    public Movement(long id, long idAccount, LocalDateTime timestamp, float amount, float balance, String description) {
        this.id = id;
        this.idAccount = idAccount;
        this.timestamp = timestamp;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    


    public void setData(Long id) {
        idAccount = id;
        amount = Util.leerFloat("Itroduce the amount of the movement");
        balance = Util.leerFloat("Introduce the balance of the movement");
        description = Util.introducirCadena("Introduce the description of the movement");
    }

    public void getData() {
        System.out.println("Information about the movement");
        System.out.println("Id of the movement:" + this.id);
        System.out.println("Id of the account:" + this.idAccount);
        System.out.println("Time stamp of the movement:" + this.timestamp);
        System.out.println("Amount of the movement: " + this.amount);
        System.out.println("Balance of the movement:" + this.balance);
        System.out.println("Description of the movement:" + this.description);
    }


    

  
    
}
