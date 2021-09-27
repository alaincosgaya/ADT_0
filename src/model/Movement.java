/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Real;
import java.sql.Date;

/**
 *
 * @author idoia
 */
public class Movement {
    private int Id;
    private int idAccount;
    //private DatabaseDate timestamp;
    private Date timestamp;
    private float amount;
    private float balance;
    private String description;
    
    public Movement(){
        
    }

    public Movement(int Id, int idAccount, Date timestamp, float amount, float balance, String description) {
        this.Id = Id;
        this.idAccount = idAccount;
        this.timestamp = timestamp;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
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

    @Override
    public String toString() {
        return "Movement{" + "Id=" + Id + ", idAccount=" + idAccount + ", timestamp=" + timestamp + ", amount=" + amount + ", balance=" + balance + ", description=" + description + '}';
    }
    
    
}