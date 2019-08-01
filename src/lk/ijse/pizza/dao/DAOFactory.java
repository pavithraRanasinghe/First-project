/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao;

import lk.ijse.pizza.dao.custom.CustomerDAO;
import lk.ijse.pizza.dao.custom.ItemDAO;
import lk.ijse.pizza.dao.custom.OrderDAO;
import lk.ijse.pizza.dao.custom.OrderDetailDAO;
import lk.ijse.pizza.dao.custom.PaymentDAO;
import lk.ijse.pizza.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pizza.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pizza.dao.custom.impl.OrderDAOImpl;
import lk.ijse.pizza.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.pizza.dao.custom.impl.PaymentDAOImpl;

/**
 *
 * @author PAVITHRA
 */
public class DAOFactory {

    private static DAOFactory daoFactory;

    private final CustomerDAO customerDAO;
    private final ItemDAO itemDAO;
    private final OrderDAO orderDAO;
    private final OrderDetailDAO orderDetailDAO;
    private final PaymentDAO paymentDAO;

    public enum DAOType {
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, PAYMENT;
    }

    private DAOFactory() {
        customerDAO = new CustomerDAOImpl();
        itemDAO = new ItemDAOImpl();
        orderDAO = new OrderDAOImpl();
        orderDetailDAO = new OrderDetailDAOImpl();
        paymentDAO = new PaymentDAOImpl();
    }

    public static DAOFactory getinstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public SuperDAO getDAO(DAOType daoType) {
        switch (daoType) {
            case CUSTOMER:
                return customerDAO;
            case ITEM:
                return itemDAO;
            case ORDER:
                return orderDAO;
            case ORDER_DETAIL:
                return orderDetailDAO;
            case PAYMENT:
                return paymentDAO;
            default:
                return null;
        }
    }
}
