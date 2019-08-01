/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business.custom.impl;

import java.sql.Connection;
import java.util.List;
import lk.ijse.pizza.business.custom.PlaceOrderBO;
import lk.ijse.pizza.configuration.DBConnection;
import lk.ijse.pizza.dao.DAOFactory;
import lk.ijse.pizza.dao.custom.CustomerDAO;
import lk.ijse.pizza.dao.custom.ItemDAO;
import lk.ijse.pizza.dao.custom.OrderDAO;
import lk.ijse.pizza.dao.custom.OrderDetailDAO;
import lk.ijse.pizza.dao.custom.PaymentDAO;
import lk.ijse.pizza.dto.ItemDTO;
import lk.ijse.pizza.dto.OrderDTO;
import lk.ijse.pizza.entity.Customer;
import lk.ijse.pizza.entity.Item;
import lk.ijse.pizza.entity.Order;
import lk.ijse.pizza.entity.OrderDetail;

/**
 *
 * @author Acer
 */
public class PlaceOrderBOImpl implements PlaceOrderBO {

    private static final OrderDAO orderDAO = (OrderDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.ORDER);
    private static final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.CUSTOMER);
    private static final ItemDAO itemDAO = (ItemDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.ITEM);
    private static final OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.ORDER_DETAIL);
    private static final PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.PAYMENT);

    public PlaceOrderBOImpl() {
    }

    @Override
    public int getOrderID() throws Exception {
        return orderDAO.getOrderID();
    }

    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
      

        try {
            connection.setAutoCommit(false);
            Customer customer = new Customer();
            customer.setName(orderDTO.getCustomerDTO().getName());
            customer.setAddress(orderDTO.getCustomerDTO().getAddress());
            customer.setContact(orderDTO.getCustomerDTO().getContact());
            customer.setEmail(orderDTO.getCustomerDTO().getEmail());
            boolean add = customerDAO.add(customer);

            if (add) {
                Order order = new Order();
                order.setOrderDate(orderDTO.getOrderDate());
                order.setOrderID(orderDTO.getOrderID());
                order.setTotalAmount(orderDTO.getTotalAmount());

                Customer searchByName = customerDAO.searchByName(orderDTO.getCustomerDTO().getName());
                if (searchByName.getName() != null) {
                    order.setCustomerID(searchByName.getCustomerID());
                }
                boolean addOrder = orderDAO.addOrder(order);

                if (addOrder) {
                    List<ItemDTO> itemDTOs = orderDTO.getItemDTOs();
                    for (ItemDTO itemDTO : itemDTOs) {
                        OrderDetail detail = new OrderDetail();
                        detail.setOrderID(order.getOrderID());
                        detail.setItemID(itemDTO.getItemID());
                        detail.setOrderQuantity(itemDTO.getOrderQty());
                        detail.setOrderPrice(itemDTO.getOrderPrice());
                        boolean addOrderDetail = orderDetailDAO.addOrderDetail(detail);

                        Item item = itemDAO.findByID(itemDTO.getItemID());
                        int quantity = item.getQuantity() - itemDTO.getOrderQty();
                        item.setQuantity(quantity);
                        boolean updateQty = itemDAO.updateQty(item);

                        if (updateQty) {
                            connection.commit();
                            return true;
                        }
                    }

                }

            }else{
                connection.rollback();
                return false;
            }

        }catch(Exception e){
        e.printStackTrace();
        } finally {
//            connection.rollback();
            connection.setAutoCommit(true);
            return true;
        }
    }
}
