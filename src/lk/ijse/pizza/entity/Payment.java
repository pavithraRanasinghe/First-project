/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.entity;


/**
 *
 * @author PAVITHRA
 */
public class Payment {
    private int paymentID;
    private int orderID;
    private double total;

    public Payment() {
    }

    public Payment(int paymentID, int orderID, double total) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.total = total;
    }
    

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", orderID=" + orderID + ", total=" + total + '}';
    }

    
    
    
}
