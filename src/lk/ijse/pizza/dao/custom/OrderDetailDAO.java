/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom;

import lk.ijse.pizza.dao.SuperDAO;
import lk.ijse.pizza.entity.OrderDetail;

/**
 *
 * @author PAVITHRA
 */
public interface OrderDetailDAO extends SuperDAO{
    boolean addOrderDetail(OrderDetail orderDetail)throws Exception;
}
