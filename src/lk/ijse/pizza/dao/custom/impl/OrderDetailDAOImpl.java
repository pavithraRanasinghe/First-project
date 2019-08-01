/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom.impl;

import lk.ijse.pizza.dao.CrudUtil;
import lk.ijse.pizza.dao.custom.OrderDetailDAO;
import lk.ijse.pizza.entity.OrderDetail;

/**
 *
 * @author PAVITHRA
 */
public class OrderDetailDAOImpl implements OrderDetailDAO{

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail)throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO order_detail VALUES(?,?,?,?,?)", 0,orderDetail.getItemID(),orderDetail.getOrderID(),orderDetail.getOrderQuantity(),orderDetail.getOrderPrice());
    }
 
}
