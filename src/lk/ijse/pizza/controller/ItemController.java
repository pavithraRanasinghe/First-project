/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.controller;

import java.util.List;
import lk.ijse.pizza.business.BOFactory;
import lk.ijse.pizza.business.custom.ItemBO;
import lk.ijse.pizza.dto.ItemDTO;

/**
 *
 * @author PAVITHRA
 */
public class ItemController {

    private static final ItemBO itemBO = (ItemBO)BOFactory.getInstance().getBO(BOFactory.BOType.ITEM);
    
    public static boolean addItem(ItemDTO itemDTO) throws Exception {
        return itemBO.add(itemDTO);
    }
    
    public static List<ItemDTO> getAll() throws Exception{
        return itemBO.getAll();
    }
    
    public static boolean updateItem(ItemDTO itemDTO) throws Exception{
        return itemBO.update(itemDTO);
    }
    
    public static boolean deleteItem(int itemID) throws Exception{
       return itemBO.delete(itemID);
    }
    public static ItemDTO findByName(String name)throws Exception{
        return itemBO.findByName(name);
    }    
}   
