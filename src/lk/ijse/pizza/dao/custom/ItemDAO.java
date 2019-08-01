/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom;

import lk.ijse.pizza.dao.CrudDAO;
import lk.ijse.pizza.entity.Item;
import lk.ijse.pizza.entity.OrderDetail;

/**
 *
 * @author PAVITHRA
 */
public interface ItemDAO extends CrudDAO<Item, Integer>{
    Item findByName(String name)throws Exception;
    
    boolean updateQty(Item item)throws Exception;
    
    Item findByID(int id)throws Exception;
}
