/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom.impl;

import lk.ijse.pizza.dao.CrudUtil;
import lk.ijse.pizza.dao.custom.PaymentDAO;
import lk.ijse.pizza.entity.Payment;

/**
 *
 * @author PAVITHRA
 */
public class PaymentDAOImpl implements PaymentDAO{

    @Override
    public boolean setPayment(Payment payment)throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO payment VALUES (?,?,?)",0,payment.getOrderID(),payment.getTotal());
    }
    
}
