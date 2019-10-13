/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author student
 */
public class Customer implements Serializable{
   private String customerId;
   private String name;
   private String email;
   private String phone;
   private String city;

    public Customer(String customerId, String name, String email, String phone, String city) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }

    @Override
    public String toString() {
        return "{\"customerId\":\""+ customerId +"\",\"name\":\""+name+"\",\"email\":\""+email+"\",\"phone\":\""+phone+"\",\"city\":\""+city+"\" }";
    }
    
    


    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }   
}
