/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.pizza.dao.CrudUtil;
import lk.ijse.pizza.dao.custom.CustomerDAO;
import lk.ijse.pizza.entity.Customer;

/**
 *
 * @author PAVITHRA
 */
public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean add(Customer customer) throws Exception {
           
        return CrudUtil.executeUpdate("insert into customer values (?,?,?,?,?) ", 0,customer.getName(),customer.getAddress(),customer.getContact(),customer.getEmail());
        
    }

    @Override
    public boolean update(Customer customer) throws Exception {
        return CrudUtil.executeUpdate("UPDATE customer set name=?,address=?,contact=?,email=? where customerID=?", customer.getName(),customer.getAddress(),customer.getContact(),customer.getEmail(),customer.getCustomerID());

    }

    @Override
    public boolean delete(Integer customerID) throws Exception {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE customerID = ?", customerID);
    }

    @Override
    public List<Customer> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("Select * From Customer");
        List<Customer> customers = new ArrayList<>();
        while (rst.next()) {
            Customer customer = new Customer();
            customer.setCustomerID(rst.getInt(1));
            customer.setName(rst.getString(2));
            customer.setAddress(rst.getString(3));
            customer.setContact(rst.getString(4));
            customer.setEmail(rst.getString(5));

            customers.add(customer);
        }
        return customers;
    }

    @Override
    public Customer searchByName(String name)throws Exception{
        ResultSet rst = CrudUtil.executeQuery("select * from customer where name = ? ", name);
        Customer customer = new Customer();
        if (rst.next()) {
            customer = new Customer(
                rst.getInt(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5)
        );
        }
        return customer;
    } 
}
