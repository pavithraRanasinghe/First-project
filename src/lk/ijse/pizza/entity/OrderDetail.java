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
public class OrderDetail {

    private int detailID;
    private int itemID;
    private int orderID;
    private int orderQuantity;
    private double orderPrice;

    public OrderDetail() {
    }

    public OrderDetail(int detailID, int itemID, int orderID, int orderQuantity, double orderPrice) {
        this.detailID = detailID;
        this.itemID = itemID;
        this.orderID = orderID;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }
    

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "detailID=" + detailID + ", itemID=" + itemID + ", orderID=" + orderID + ", orderQuantity=" + orderQuantity + ", orderPrice=" + orderPrice + '}';
    }
    
    
}
