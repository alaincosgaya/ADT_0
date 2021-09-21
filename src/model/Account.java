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
public class Account implements java.io.Serializable{
    private int id;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    //private DatabaseDate beginBalanceTimestamp;
    private Date beginBalanceTimestamp;
    private AccountType type;
    
    public Account(){
        
    }

    public Account(int id, String description, float balance, float creditLine, float beginBalance, Date beginBalanceTimestamp, AccountType type) {
        this.id = id;
        this.description = description;
        this.balance = balance;
        this.creditLine = creditLine;
        this.beginBalance = beginBalance;
        this.beginBalanceTimestamp = beginBalanceTimestamp;
        this.type = type;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCreditLine() {
        return creditLine;
    }

    public void setCreditLine(float creditLine) {
        this.creditLine = creditLine;
    }

    public float getBeginBalance() {
        return beginBalance;
    }

    public void setBeginBalance(float beginBalance) {
        this.beginBalance = beginBalance;
    }

    public Date getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(Date beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", type=" + type + '}';
    }

    
    
}
