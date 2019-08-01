/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom.impl;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.pizza.dao.CrudUtil;
import lk.ijse.pizza.dao.custom.QuaryDAO;

/**
 *
 * @author PAVITHRA
 */
public class QuaryDAOImpl implements QuaryDAO {

    @Override
    public int countCustomer() {
        int countCustomer = 0;
        try {
            ResultSet rst = CrudUtil.executeQuery("select count(*) from customer");
            while (rst.next()) {
                countCustomer = rst.getInt("count(*)");
            }

        } catch (Exception ex) {
            Logger.getLogger(QuaryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countCustomer;
    }

    @Override
    public int countItem() {
        int itemCount = 0;
        try {
            ResultSet rst = CrudUtil.executeQuery("select count(*) from item");
            while (rst.next()) {
                itemCount = rst.getInt("count(*)");
            }
        } catch (Exception ex) {
            Logger.getLogger(QuaryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemCount;
    }

    @Override
    public int countOrder() {
        int itemCount = 0;
        try {
            ResultSet rst = CrudUtil.executeQuery("select count(*) from orders");
            while (rst.next()) {
                itemCount = rst.getInt("count(*)");
            }
        } catch (Exception ex) {
            Logger.getLogger(QuaryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemCount;
    }
}
