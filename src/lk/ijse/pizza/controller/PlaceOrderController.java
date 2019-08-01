/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.controller;

import java.util.List;
import lk.ijse.pizza.business.BOFactory;
import lk.ijse.pizza.business.custom.ItemBO;
import lk.ijse.pizza.business.custom.PlaceOrderBO;
import lk.ijse.pizza.business.custom.impl.PlaceOrderBOImpl;
import lk.ijse.pizza.dto.CustomerDTO;
import lk.ijse.pizza.dto.ItemDTO;
import lk.ijse.pizza.dto.OrderDTO;

/**
 *
 * @author PAVITHRA
 */
public class PlaceOrderController {
    
    private static final ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOType.ITEM);
    private static final PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getInstance().getBO(BOFactory.BOType.PLACE_ORDER);
    
    public static List<ItemDTO> getAllItems () throws Exception{
        return itemBO.getAll();
    }
    public static int getOrderID() throws Exception{
        return placeOrderBO.getOrderID();
    }
   
    public static boolean addOrder(OrderDTO orderDTO)throws Exception{
        return placeOrderBO.placeOrder(orderDTO);
    }
    
}
