/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business.custom;

import lk.ijse.pizza.business.SuperBO;
import lk.ijse.pizza.dto.OrderDTO;

/**
 *
 * @author Acer
 */
public interface PlaceOrderBO extends SuperBO {

    int getOrderID() throws Exception;

    boolean placeOrder(OrderDTO orderDTO) throws Exception;

}
