/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Util;
import java.time.LocalDateTime;

/**
 *
 * @author idoia y Alejandro
 */
public class Account implements java.io.Serializable {

    public enum AccountType {

        standard, credit
    }

    private long id;
    private String description;
    private float balance;
    private float creditLine;
    private float beginBalance;
    private LocalDateTime beginBalanceTimestamp;
    private AccountType type;

    public Account() {

    }

    public Account(long id, String description, float balance, float creditLine, float beginBalance, LocalDateTime beginBalanceTimestamp, AccountType type) {
        this.id = id;
        this.description = description;
        this.balance = balance;
        this.creditLine = creditLine;
        this.beginBalance = beginBalance;
        this.beginBalanceTimestamp = beginBalanceTimestamp;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDateTime getBeginBalanceTimestamp() {
        return beginBalanceTimestamp;
    }

    public void setBeginBalanceTimestamp(LocalDateTime beginBalanceTimestamp) {
        this.beginBalanceTimestamp = beginBalanceTimestamp;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(String type) {
        this.type = AccountType.valueOf(type);
    }

    public void setData() {
        char decision;
        description = Util.introducirCadena("Introduce the description of the account");
        balance = Util.leerFloat("Introduce the balance of the account");
        creditLine = Util.leerFloat("Introduce teh credit line of the account");
        beginBalance = Util.leerFloat("Introduce the begin balance of the account");
        do {
            decision = Util.leerChar("The account is standard or credit? (standard=s/credit=c) ");
            if (decision != 's' && decision != 'c') {
                System.out.println("The account must be standard or credit");
            }
        } while (decision != 's' && decision != 'c');
        if (decision == 's') {
            this.type = AccountType.standard;
        } else {
            this.type = AccountType.credit;
        }

    }

    public void getData() {
        System.out.println("Information about the account");
        System.out.println("Id of the account: " + this.id);
        System.out.println("Description of the account: " + this.description);
        System.out.println("Balance of the account: " + this.balance);
        System.out.println("Credit line of the account: " + this.creditLine);
        System.out.println("Begin balance of the account: " + this.beginBalance);
        System.out.println("Begin balance time stamp of the account: " + LocalDateTime.now());
        if (this.type == AccountType.standard) {
            System.out.println("Standard: " + this.type);
        }
        if (this.type == AccountType.credit) {
            System.out.println("Credit: " + this.type);
        }
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", description=" + description + ", balance=" + balance + ", creditLine=" + creditLine + ", beginBalance=" + beginBalance + ", beginBalanceTimestamp=" + beginBalanceTimestamp + ", type=" + type + '}';
    }

}
