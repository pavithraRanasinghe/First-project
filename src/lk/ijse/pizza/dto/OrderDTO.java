/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dto;

import java.util.List;

/**
 *
 * @author PAVITHRA
 */
public class OrderDTO {

    private int orderID;
    private String orderDate;
    private double totalAmount;
    private CustomerDTO customerDTO;
    private List<ItemDTO> itemDTOs;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

   
    /**
     * @return the customerDTO
     */
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * @param customerDTO the customerDTO to set
     */
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    /**
     * @return the itemDTOs
     */
    public List<ItemDTO> getItemDTOs() {
        return itemDTOs;
    }

    /**
     * @param itemDTOs the itemDTOs to set
     */
    public void setItemDTOs(List<ItemDTO> itemDTOs) {
        this.itemDTOs = itemDTOs;
    }

}
