/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dto;

/**
 *
 * @author PAVITHRA
 */
public class CustomerDTO {

    /**
     * CustomerDTO 
     * USING Packages : view,controller,buss(BO)
     */
    private int customerID;
    private String name;
    private String address;
    private String contact;
    String email;

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;

    }

    public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        return "CustomerDTO{" + "customerID=" + customerID + ", name=" + name + ", address=" + address + ", contact=" + contact + ", email=" + email + '}';
    }
}
