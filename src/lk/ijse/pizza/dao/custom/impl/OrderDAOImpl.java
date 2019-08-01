/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import lk.ijse.pizza.configuration.DBConnection;
import lk.ijse.pizza.dao.CrudUtil;
import lk.ijse.pizza.dao.custom.OrderDAO;
import lk.ijse.pizza.entity.Order;

/**
 *
 * @author Acer
 */
public class OrderDAOImpl implements OrderDAO {

    @Override
    public int getOrderID() throws Exception {
        String sql = "select orderID from orders order by orderID desc limit 1;";
        Connection connection = DBConnection.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        int orderID = 0;
        if (rst.next()) {
            orderID = rst.getInt(1);
            orderID++;

            return orderID;

        } else {
            return 1;
        }
    }

    @Override
    public boolean addOrder(Order order) throws Exception {
        return CrudUtil.executeUpdate("INSERT INTO orders VALUES(?,?,?,?)", order.getOrderID(), order.getCustomerID(), order.getOrderDate(), order.getTotalAmount());
    }
}
