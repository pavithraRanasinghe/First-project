/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pizza.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.pizza.business.custom.CustomerBO;
import lk.ijse.pizza.dao.DAOFactory;
import lk.ijse.pizza.dao.custom.CustomerDAO;
import lk.ijse.pizza.dto.CustomerDTO;
import lk.ijse.pizza.entity.Customer;

/**
 *
 * @author PAVITHRA
 */
public class CustomerBOImpl implements CustomerBO {

    private static final CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getinstance().getDAO(DAOFactory.DAOType.CUSTOMER);

    @Override
    public boolean add(CustomerDTO customerDTO) throws Exception {
        Customer customer = new Customer();
                customer.setName(customerDTO.getName());
                customer.setAddress(customerDTO.getAddress());
                customer.setContact(customerDTO.getContact());
                customer.setEmail(customerDTO.getEmail());
        
        return customerDAO.add(customer);
    }

    @Override
    public boolean update(CustomerDTO customerDTO) throws Exception {
        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact(),
                customerDTO.getEmail()
        );
        return customerDAO.update(customer);
    }

    @Override
    public boolean delete(Integer customerID) throws Exception {
        return customerDAO.delete(customerID);
    }

    @Override
    public List<CustomerDTO> getAll() throws Exception {
        List<Customer> allCustomers = customerDAO.getAll();
        List<CustomerDTO> allCustomerDTOs = new ArrayList<>();
        for (Customer customer : allCustomers) {
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setCustomerID(customer.getCustomerID());
            customerDTO.setName(customer.getName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setContact(customer.getContact());
            customerDTO.setEmail(customer.getEmail());
            allCustomerDTOs.add(customerDTO);
        }
        return allCustomerDTOs;
    }

    @Override
    public CustomerDTO searchByName(String name) throws Exception {
        Customer searchByName = customerDAO.searchByName(name);
        Customer customer = new Customer();
        customer.setName(name);
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerID(searchByName.getCustomerID());
        customerDTO.setName(searchByName.getName());
        customerDTO.setContact(searchByName.getContact());
        customerDTO.setAddress(searchByName.getAddress());
        customerDTO.setEmail(searchByName.getEmail());

        return customerDTO;
    }

}
