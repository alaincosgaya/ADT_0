/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import control.Util;

/**
 *
 * @author idoia
 */
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String street;
    private String city;
    private String state;
    private int zip;
    private int phone;
    private String email;
    
    public Customer(){
        
    }

    public Customer(long id, String firstName, String lastName, String middleInitial, String street, String city, String state, int zip, int phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setData(){
        firstName = Util.introducirCadena("Introduce your first name");
        lastName = Util.introducirCadena("Introduce your last name");
        middleInitial = Util.introducirCadena("Introduce your middle initial (ex: S.)");
        street = Util.introducirCadena("Introduce your street");
        city = Util.introducirCadena("Introduce your city");
        state = Util.introducirCadena("Introduce teh state");
        zip = Util.leerInt("Introduce the zip");
        phone = Util.leerInt("Introduce your phone number");
        email = Util.introducirCadena("Introduce your email");
    }
    
        public void getData(){
        
            System.out.println("Id: "+this.id);
            System.out.println("First name: "+this.firstName);
            System.out.println("Last Name: "+this.lastName);
            System.out.println("Middle Initial: "+this.middleInitial);
            System.out.println("Street: "+this.street);
            System.out.println("City: "+this.city);
            System.out.println("State: "+this.state);
            System.out.println("Zip: "+this.zip);
            System.out.println("Phone: "+this.phone);
            System.out.println("Email: "+this.email);
    }

    

    @Override
    public String toString() {
        return "Customer{" + "Id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleInitial=" + middleInitial + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email + '}';
    }
    
    
    
}
